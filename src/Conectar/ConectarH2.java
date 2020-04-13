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
        System.out.println("Error de conexion a la Base De Datos H2\n"+ex);
        }
        return conect;
    }
    
    public void CerrarConexion() {
	  	try {
		   conect.close();
                   System.out.println("Servicios de la base de datos H2 desconectados");
		}catch (Exception ex) {
			//throw new ConnectionException("Ha ocurrido un error al intentar cerrar la conexion con Oracle. Error:" + sqle.getMessage());                                   
                        System.out.println("Error al desconectar la base de datos H2\n"+ex);
		}
	}
    
}
