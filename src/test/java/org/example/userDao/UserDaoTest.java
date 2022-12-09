package org.example.userDao;

import org.example.Entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class UserDaoTest {
    UserDao userDao;

    private static final Logger log = LoggerFactory.getLogger(UserDaoTest.class);
    @Test
    public void testInsertUserIntoTable()  {
        log.info("Executing testInsertUserIntoTable()...");

        User user1 = new User(8,"Ninad","Ng457");
        User addUser = null;
        try {
            addUser = userDao.insertUserIntoTable(user1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        assertEquals(addUser.getUsername(),"Ninad");
        assertEquals(addUser.getPassword(),"Ng457");
        assertNotNull(addUser);
    }
    @Test
    public void testInsertUserIntoTableusernameNull()  {
        log.info("Executing testInsertUserIntoTable()...");

        User user1 = new User(8,"Ninad","null");
        User addUser = null;
        try {
            addUser = userDao.insertUserIntoTable(user1);
        } catch (SQLException e) {
            assert true;
        }


    }

    @Test
    public void testGetAllUsers() {

        boolean listUser = false;
        try {
            listUser = userDao.getAllUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        assertNotNull(listUser);
        assertEquals(listUser,true);
    }

    @Test
    public void testGetUser()  {
        log.info("Executing testGetUser()...");
        boolean user;
        try {
            user = userDao.getUser(4);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertNotNull(user);
        assertEquals(user,true);
        assertTrue(user);
    }

    @Test
    public void testDeleteUserById() {
        log.info("Executing testDeleteUserById()...");
        boolean userDelete = false;
        try {
            userDelete = userDao.deleteUserById(2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertNotNull(userDelete);
        assertEquals(userDelete,true);
    }
    @Test
    public void testDeleteUserByNullId() {
        log.info("Executing testDeleteUserByNullId()...");
        boolean userDelete = false;
        try {
            userDelete = userDao.deleteUserById(null);
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    public void testUpdateUserNameByPassword()  {
        log.info("Executing testUpdateUserNameByPassword()...");
        boolean updatedUser = false;
        try {
            updatedUser = userDao.updateUserNameByPassword("Vishal","Ss1234#");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(updatedUser,true);
        assertTrue(updatedUser);
        assertNotNull(updatedUser);
    }
    @Test
    public void testUpdateNullUserName()  {
        log.info("Executing testUpdateUserNameByPassword()...");
        boolean updatedUser = false;
        try {
            updatedUser = userDao.updateUserNameByPassword(null,"Ss1234#");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        assertEquals(updatedUser,true);
        assertTrue(updatedUser);
        assertNotNull(updatedUser);
    }

    @Test
    public void testUpdateNullPassword()  {
        log.info("Executing testUpdateUserNameByPassword()...");
        boolean updatedUser = false;
        try {
            updatedUser = userDao.updateUserNameByPassword("Vishal",null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        assertEquals(updatedUser,true);
        assertTrue(updatedUser);
        assertNotNull(updatedUser);
    }

    @Test
    public void testFetchUser()  {
        log.info("Executing testFetchUser()...");
        boolean fetchUser = false;
        try {
            fetchUser = userDao.fetchUser("Samyak","SK123@");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        assertNotNull(fetchUser);
        assertEquals(fetchUser,true);
        assertTrue(fetchUser);


    }

    @Test
    public void testIsUserNameIsRegistered() throws SQLException {
        log.info("Executing testIsUserNameIsRegistered()...");
        boolean isUserRegistered = userDao.isUserNameIsRegistered("Harsh");

        assertFalse(isUserRegistered);
        assertNotNull(isUserRegistered);
        assertEquals(isUserRegistered,false);
    }
}