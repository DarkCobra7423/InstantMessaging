/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectar;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author TAMY
 */
public class ConectarH2 {
    Connection conect = null;
    
    public Connection conexion(){
        try{
            Class.forName("org.h2.Driver");
            conect=DriverManager.getConnection("jdbc:h2:~/test", "sa","");
            System.out.println("Connection established!");
        }catch(Exception ex){
        System.out.println("Error en la BD H2\n"+ex);
        }
        return conect;
    }
    
}
