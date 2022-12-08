package org.example;

import org.example.Entity.User;
import org.example.userDao.UserDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
        log.info("Press 1 to insert user ");
        log.info("Press 2 to get List of User ");
        log.info("Press 3 to getUser ");
        log.info("Press 4 to delete user ");
        log.info("Press 5 to update username by password ");
        log.info("Press 6 to fetchUser ");
        log.info("Press 7 to check user is present or not ");
        log.info("Pres  8 to exit ");
        int a = Integer.parseInt(br.readLine());

       if (a == 1)
       {
           try {
               log.info("Enter id : ");
               int id = Integer.parseInt(br.readLine());

               log.info("Enter username : ");
               String username = br.readLine();

               log.info("Enter password : ");
               String password = br.readLine();

               User user = new User(id,username,password);
               User saveUser = UserDao.insertUserIntoTable(user);
               log.info(" User added successfully.. "+user);

           }catch (Exception e){
               log.info("Error Occurred "+e);
           }
       } else if (a == 2)
        {
            try {


                boolean listUser = UserDao.getAllUsers();

                if (listUser) {
                    log.info("List of users displayed successfully ");
                } else {
                    log.info("Something went wrong");
                }
            }catch (Exception e){
                log.info("Error Occurred "+e);
            }
        }else if (a == 3)
        {
            try {
                log.info("Enter id to get user : ");
                int id = Integer.parseInt(br.readLine());

                boolean getUser = UserDao.getUser(id);

                if (getUser) {
                    log.info("User displayed with id " + id);
                } else {
                    log.info("Something went wrong...");
                }
            }catch (Exception e){
                log.info("Error Occurred "+e);
            }

        } else if (a == 4)
        {
            try{
               log.info("Enter id to delete user : ");
               int id = Integer.parseInt(br.readLine());

               boolean deletedUser = UserDao.deleteUserById(id);

               if (deletedUser){
                  log.info("User deleted with id "+id);

               }else {
                  log.info("Something went wrong");
           }
            }catch (Exception e){
                log.info("Error Occurred "+e);
            }

        }else if (a == 5) {
           try {
               log.info("Enter new username : ");
               String NewUsername = br.readLine();

               log.info("Enter password : ");
               String password = br.readLine();

               boolean updateUser = UserDao.updateUserNameByPassword(NewUsername, password);

               if (updateUser) {
                   log.info("An  user is  updated successfully with password ...." + password);
               } else {
                   log.info("Something Went wrong ");
               }
           }catch (Exception e){
               log.info("Error Occurred "+e);
           }
       } else if ((a == 6))   {
           try {
               log.info("Enter  username : ");
               String username = br.readLine();

               log.info("Enter  password : ");
               String password = br.readLine();

               boolean user = UserDao.fetchUser(username, password);

               if (user) {
                   log.info("User is Login successfully ");
               } else {
                   log.info("Username or password is wrong please try again ");
               }
           }catch (Exception e ){
               log.info("Error Occurred "+e);
           }

       }
       else if (a == 7) {
           try {
               log.info("Enter  username : ");
               String username = br.readLine();

               boolean checkuser = UserDao.isUserNameIsRegistered(username);

               if (checkuser == true) {
                   log.info("User is registered with username " + username);
               } else {
                   log.info("user is not registered with username " + username);
               }
           }catch (Exception e){
               log.info("Error Occurred "+e);
           }

       }
       else if (a == 8)
        {
            break;
        } else {

       }

    }
}
}