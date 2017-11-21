/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.UserDao;
import java.util.List;
import model.User;

/**
 *
 * @author admin
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      //  UserGroupDao dao  = new UserGroupDao();
      //  List<UserGroup> list =         dao.all();
      
        UserDao dao = new UserDao();
        List<User> list =         dao.all();
        
    }
    
}
