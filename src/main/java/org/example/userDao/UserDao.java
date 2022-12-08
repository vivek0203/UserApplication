package org.example.userDao;

import org.example.DbUtil.DbUtil;
import org.example.Entity.User;
import org.example.connection.Connect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {

   public static final Logger log = LoggerFactory.getLogger(UserDao.class);

    public static User insertUserIntoTable(User user) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = Connect.createConnection();

            String query = "Insert into user (id,username,password)values(?,?,?)";
            log.debug("Executing insertUser Query : {} ", query);

            ps = conn.prepareStatement(query);
            ps.setInt(1,user.getId());
            ps.setString(2,user.getUsername());
            ps.setString(3,user.getPassword());
            ps.executeUpdate();

        }finally {
            DbUtil.close(ps,conn);
        }
        return user;
    }
    public static boolean getAllUsers() throws SQLException {
           boolean f= false;
           Connection conn = null;
           Statement st = null;
        {
            try {
                conn = Connect.createConnection();// to connect db
                st = conn.createStatement();
                String query = "Select * from user";
                log.debug("Executing getAllUser Query : {} ", query);
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    f = true;
                    log.info("Id : " + rs.getInt("id"));
                    log.info("UserName : " + rs.getString("username"));
                    log.info("Password : " + rs.getString("password"));
                    log.info("==========================");
                }

            } finally {
                DbUtil.close(st, conn);
            }
            return f;
        }
    }
    public static boolean getUser(Integer id)throws SQLException{
        boolean f= false;
        Connection conn = null;
        PreparedStatement ps  = null;
        try{
            conn = Connect.createConnection();// to connect db
            String query = "Select * from user where id = ?  ";
            log.debug("Executing getUser Query : {} ", query);
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                log.info("Id : "+rs.getInt("id"));
                log.info("UserName : "+rs.getString("username"));
                log.info("Password : "+rs.getString("password"));}
            f = true;

        } finally {
            DbUtil.close(ps,conn);

        }
        return f;
    }
    public static boolean deleteUserById(Integer id)throws  SQLException{
        boolean f= false;
        Connection conn = null;
        PreparedStatement ps  = null;
        try{
            conn = Connect.createConnection();
            String query = "Delete from user where id = ? ";
            log.debug("Executing deleteUser Query : {} ", query);
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);
            ps.executeUpdate();
            f=true;
        } finally {
            DbUtil.close(ps,conn);
        }
        return f;
    }
    public static boolean updateUserNameByPassword(String NewUsername,String password)throws SQLException{
        boolean f =false;
        Connection conn = null;
        PreparedStatement ps  = null;
        try{
            conn = Connect.createConnection();
            String query = "Update user set username = ? where password = ?";
            log.debug("Executing updateUser Query : {} ", query);
            ps =conn.prepareStatement(query);
            ps.setString(2,password);
            ps.setString(1,NewUsername);
            ps.executeUpdate();
            f= true;
    }finally {
            DbUtil.close(ps,conn);
    }
        return f;
    }
    public static boolean fetchUser(String username, String password)throws SQLException {
        boolean f = false;
        Connection conn = null;
        PreparedStatement ps  = null;
        try {
            conn = Connect.createConnection();

            String query = "SELECT * FROM user where username = ? and password = ?";
            log.debug("Executing getUer Query : {} ", query);
            ps = conn.prepareStatement(query);
            ps.setString(2, password);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                f = true;
                log.info("Id : "+rs.getInt("id"));
                log.info("UserName : " + rs.getString("username"));
                log.info("Password : " + rs.getString("password"));}
        } finally {
            DbUtil.close(ps,conn);
        }
        return f;
    }
    public static boolean isUserNameIsRegistered(String username)throws SQLException{
        boolean f = false;
        Connection conn = null;
        PreparedStatement ps  = null;
        try
    {
        conn = Connect.createConnection();

        String query = "select username from user where username = ?";
        log.debug("Executing isUserNameIsRegistered Query : {} ", query);
        ps = conn.prepareStatement(query);
        ps.setString(1,username);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            f = true;
            log.info("Username : " +rs.getString("username"));
    }
    }finally {
            DbUtil.close(ps,conn);

        }
        return f;
    }
    

}
