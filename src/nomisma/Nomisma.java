/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nomisma;

import de.vogella.mysql.first.MySQLAccess;
/**
 *
 * @author marke_000
 */
public class Nomisma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        
        NomismaLogin loginDialog = new NomismaLogin();
        loginDialog.setVisible(true);
        
        //System.out.println("Username: " + x.fetchUsername());
        //System.out.println("Password: " + x.fetchPassword());

        //call NomismaLogin here - insert username and password into username and password
        String username = loginDialog.fetchUsername(); //placeholder - user input
        String password = loginDialog.fetchPassword(); //placeholder - user input
        MySQLAccess dao = new MySQLAccess();
        int uid = dao.authUser(username, password);
        dao.readUserTransactions(uid);
        
        //call login
        //if valid
    }
    
}
