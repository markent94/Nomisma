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
        MySQLAccess dao = new MySQLAccess();
        dao.readDataBase();
    }
    
}
