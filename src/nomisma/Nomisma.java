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
            
            //user menu
            //1) checkBalance(); check transaction balance
            //2) logEntertainment(); log transaction entertainment
            //3) logFood(); log transaction food
            //4) logTransport(); log transcation transport
            //5) logRoom(); log transaction room
            //6) logEmergency(); log transcation emergency
            //7) logout/exit
            dao.readUserTransactions(uid);
        }
    }
        
    private void checkBalance() {
        try {
            dao.readUserTransactions(uid);
        } catch (Exception ex) {
            Logger.getLogger(Nomisma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void logEntertainment() {
        try {
            //cost = user input - cost
            
            //dao.reduceBalance(cost,uid);
            //dao.incEntertainment(cost, uid);
        } catch (Exception ex) {
            Logger.getLogger(Nomisma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void logFood() {
        try {
            //cost = user input - cost
            
            //dao.reduceBalance(cost,uid);
            //dao.incFood(cost, uid);
        } catch (Exception ex) {
            Logger.getLogger(Nomisma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void logTransport() {
        try {
            //cost = user input - cost
            
            //dao.reduceBalance(cost,uid);
            //dao.incTransport(cost, uid);
        } catch (Exception ex) {
            Logger.getLogger(Nomisma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void logRoom() {
        try {
            //cost = user input - cost
            
            //dao.reduceBalance(cost,uid);
            //dao.incRoom(cost, uid);
        } catch (Exception ex) {
            Logger.getLogger(Nomisma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void logEmergency() {
        try {
            //cost = user input - cost
            
            //dao.reduceBalance(cost,uid);
            //dao.incEmergency(cost, uid);
        } catch (Exception ex) {
            Logger.getLogger(Nomisma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
