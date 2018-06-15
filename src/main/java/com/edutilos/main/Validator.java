package com.edutilos.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by edutilos on 15.06.18.
 */
public class Validator {
    private Map<String,String> users ;
    private Map<String, String> fileUsers;
    private Map<String,String> mysqlUsers;
    public Validator(boolean includeMysql) {
        users = new HashMap<>();
        users.putIfAbsent("foo", "bar");
        users.putIfAbsent("edu", "tilos");
        users.putIfAbsent("leonel", "messi");
        users.putIfAbsent("cristiano", "ronaldo");
        fileUsers = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(Validator.class.getResourceAsStream("Users.txt")))) {
            String line = reader.readLine();
            String [] splitted = line.split("=");
            if(splitted.length == 2) {
                fileUsers.putIfAbsent(splitted[0], splitted[1]);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        if(includeMysql) {
            UserDAO dao = new UserDAO();
            mysqlUsers = dao.getAllUsers();
            dao.disconnect();
        }
    }

    public boolean validateInMemory(String username, String password) {
        boolean valideUser[] = {false};
        users.forEach((u,p)-> {
            if(u.equals(username) && p.equals(password))  {
                valideUser[0] = true;
            }
        });

        return valideUser[0];
    }


    public boolean validateFile(String username, String password) {
        for(Map.Entry<String,String> user: fileUsers.entrySet()) {
            if(user.getKey().equals(username) && user.getValue().equals(password))
                return true;
        }
        return false;
    }

    public boolean validateMySQL(String username, String password) {
        for(Map.Entry<String,String> user: mysqlUsers.entrySet()) {
            if(user.getKey().equals(username) && user.getValue().equals(password))
                return true;
        }
        return false;
    }



    private static class UserDAO {
        private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
        private static final String MYSQL_URL = "jdbc:mysql://localhost/test3?useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin&useSSL=false";
        private static final String USER = "root";
        private static final String PASSWORD = "root";
        private Connection conn;
        private Statement stmt;
        private PreparedStatement pstmt;
        private ResultSet rs;


        public UserDAO() {
            connect();
            dropTable();
            createTable();
            addUser("foo", "bar");
            addUser("edu", "tilos");
            addUser("cristiano", "ronaldo");
            addUser("leonel", "messi");
        }


        public void connect() {
            try {
                Class.forName(MYSQL_DRIVER);
                conn = DriverManager.getConnection(MYSQL_URL, USER, PASSWORD);
                stmt = conn.createStatement();
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }

        public void disconnect() {
            try {
                if(rs != null && !rs.isClosed()) rs.close();
                if(pstmt != null && !pstmt.isClosed()) pstmt.close();
                if(stmt != null && !stmt.isClosed()) stmt.close();
                if(conn != null && !conn.isClosed()) conn.close();
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }


        public void createTable() {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("CREATE TABLE IF NOT EXISTS USERS(")
                        .append("username VARCHAR(50) NOT NULL, ")
                        .append("password VARCHAR(50) NOT NULL, ")
                        .append("UNIQUE KEY unique_user(`username`, `password`)")
                        .append(")");
                stmt.execute(sb.toString());
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }

        public void dropTable() {
            try {
                String sql = "DROP TABLE IF EXISTS USERS";
                stmt.execute(sql);
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }


        public void addUser(String username, String password){
            try {
                String sql = "INSERT INTO USERS VALUES(?,?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                pstmt.execute();
                pstmt.close();
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }



        public Map<String,String> getAllUsers() {
            try {
                String sql = "SELECT * FROM USERS";
                rs = stmt.executeQuery(sql);
                Map<String, String> res = new HashMap<>();
                while(rs.next()) {
                    res.putIfAbsent(rs.getString(1), rs.getString(2));
                }

                return res;
            } catch(Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if(rs != null && !rs.isClosed()) {
                        try {
                            rs.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
