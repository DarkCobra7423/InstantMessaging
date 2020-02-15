/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectar;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author TAMY
 */
public class Conectar {
    
    Connection conect = null;
    
    public Connection conexion(){
        try{
            
            String url="www.db4free.net:3306";
            String bd="instantmessaging";
            String usu="carlosdaniel1234";
            String pass="QWERTY12345c";
                                            //  jdbc:mysql://85.10.205.173/instantmessaging:3306
            //Class.forName("com.mysql.jdbc.Driver");//                jdbc:mysql://https://www.db4free.net/phpMyAdmin/instantmessaging:3306
            //conect = DriverManager.getConnection(url, usu, pass);
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://" + url + "/" + bd, usu, pass);
            System.out.println("Connection established!");
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Por favor revise su conexion a internet\n"+ex);
            ex.printStackTrace();
        }
        return conect;
    }
    
}