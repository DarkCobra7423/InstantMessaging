/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectar;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.*;
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
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            //conect = DriverManager.getConnection("jdbc:mysql://" + "localhost:" + "/" + bd, "root", "");
            //////conect = DriverManager.getConnection("jdbc:mysql://localhost:3608/instantmessaging", "root", "root");
            //conect = DriverManager.getConnection("jdbc:mysql://" + "192.168.43.130:3306" + "/" + bd, "root", "");
            conect = DriverManager.getConnection("jdbc:mysql://" + url + "/" + bd, usu, pass);
            System.out.println("Connection established!");
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Por favor revise su conexion a internet\n\n"+ex);
            ex.printStackTrace();//ESTE MENSAJE NO SE MUESTRA EN EL FROM
        }
        return conect;
    }
    
    public void CerrarConexion() {
	  	try {
		   conect.close();
                   System.out.println("Servicios de la base de datos desconectados");
		}catch (Exception ex) {
			//throw new ConnectionException("Ha ocurrido un error al intentar cerrar la conexion con Oracle. Error:" + sqle.getMessage());                                   
                        System.out.println("Error al desconectar la base de datos "+ex);
		}
	}
    
}