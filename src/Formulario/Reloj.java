/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author TAMY-IA
 */
public class Reloj extends Thread {
    
    private JLabel hora;
    
    public Reloj(JLabel hora){
        this.hora=hora;
    }
    
    public void run(){
        while(true){
            Date hoy = new Date();
            SimpleDateFormat s= new SimpleDateFormat("hh:mm:ss");
            hora.setText(s.format(hoy));
            
            try{
                sleep(1000);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Falla Horaria \n"+ex);
            }
        }
    }///FIN DE RUN
    
}
