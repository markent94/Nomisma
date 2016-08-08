/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nomisma;

import nomisma.mysql.first.MySQLAccess;

/**
 *
 * @author marke_000
 */
public class Nomisma {

    private static MySQLAccess dao;
    private static int uid;
    /**
     * @param args the command line arguments
     * 
     * Calls first the login GUI which is connected to the user DB and 
     * then calls the transaction GUI which is connected to the transaction DB 
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
            NomismaMenu mainWindow = new NomismaMenu(username, dao, uid);
            mainWindow.setVisible(true);
            
            
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
        
    
}
