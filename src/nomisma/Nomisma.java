/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nomisma;

import de.vogella.mysql.first.MySQLAccess;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author marke_000
 */
public class Nomisma {

    private static MySQLAccess dao;
    private static int uid;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        
        NomismaLogin loginDialog = new NomismaLogin();
        loginDialog.setVisible(true);
        
        //System.out.println("Username: " + x.fetchUsername());
        //System.out.println("Password: " + x.fetchPassword());

        //create new account option
        String username = loginDialog.fetchUsername(); //placeholder - test
        String password = loginDialog.fetchPassword(); //placeholder - testpw
        dao = new MySQLAccess();    
        uid = dao.authUser(username, password);
        if (uid == 0) {
            System.out.println("Username/Password combination is incorrect");
        } else {
            NomismaMenu mainWindow = new NomismaMenu("username");
            
            //IMPORTANT FOR GUI - the following methods return the current
            //balance of each category as a double
            //1) checkBalance(); 
            //2) logEntertainment(0); 
            //3) logFood(0); 
            //4) logTransport(0); 
            //5) logRoom(0); 
            //6) logEmergency(0); 
            dao.readUserTransactions(uid);
        }
    }
        
    private double checkBalance() {
        double balance = 0;
        try {
            balance = dao.reduceBalance(0.00, uid);
            return balance;
        } catch (Exception ex) {
            Logger.getLogger(Nomisma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return balance;
    }
    
    private double logEntertainment(double cost) {
        double balance = 0;
        try {
            balance = dao.incEntertainment(cost, uid);
            return balance;
        } catch (Exception ex) {
            Logger.getLogger(Nomisma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return balance;
    }
    
    private double logFood(double cost) {
        double balance = 0;
        try {
            balance = dao.incFood(cost, uid);
            return balance;
        } catch (Exception ex) {
            Logger.getLogger(Nomisma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return balance;
    }
    
    private double logTransport(double cost) {
        double balance = 0;
        try {
            balance = dao.incTransport(cost, uid);
            return balance;
        } catch (Exception ex) {
            Logger.getLogger(Nomisma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return balance;
    }
    
    private double logRoom(double cost) {
        double balance = 0;
        try {
            balance = dao.incRoom(cost, uid);
            return balance;
        } catch (Exception ex) {
            Logger.getLogger(Nomisma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return balance;
    }
    
    private double logEmergency(double cost) {
        double balance = 0;
        try {
            balance = dao.incEmergency(cost, uid);
            return balance;
        } catch (Exception ex) {
            Logger.getLogger(Nomisma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return balance;
    }
    
}
