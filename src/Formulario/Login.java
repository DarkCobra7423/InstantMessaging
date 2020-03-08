/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import Conectar.Conectar;
import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Jessi
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        btnConsola.setMnemonic(KeyEvent.VK_X);
        this.setLocationRelativeTo(null);
    }
    
    void ValidarUsuario(){
        int resultado=0;
        String usuario=txtUsuario.getText();
        String pass=String.valueOf(txtPass.getPassword());
        
        String credencial="SELECT * FROM Usuario WHERE usuario='"+usuario+"' AND contrasena= '"+pass+"'";
        
        
        try{
           
            Statement st = cn.createStatement();
            ResultSet rs=st.executeQuery(credencial);
            
            if(rs.next()){
                resultado=1;
                if(resultado==1){
                    Principal1 pc=new Principal1();
                    pc.setVisible(true);
                    pc.pack();
                    this.dispose();
                }
            }else{
                jlError.setText("Usuario O Contraseña Incorrectos");
            }
            
        }catch(Exception ex){
            System.out.println("Error Clase Login Metodo ValidarCredencial \n"+ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPass = new javax.swing.JPasswordField();
        jlError = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_IniciarSesion = new javax.swing.JButton();
        Btn_Registrarse = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Btn_Cerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnConsola = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 190, -1));

        jlError.setForeground(new java.awt.Color(204, 204, 204));
        getContentPane().add(jlError, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 190, 20));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 190, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("USUARIO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CONTRASEÑA");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        btn_IniciarSesion.setText("INCICAR SESIÓN");
        btn_IniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_IniciarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(btn_IniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, -1));

        Btn_Registrarse.setText("REGISTRARSE");
        Btn_Registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_RegistrarseActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Registrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mini_iconos(1).png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 160, 150));

        Btn_Cerrar.setBackground(new java.awt.Color(0, 0, 0));
        Btn_Cerrar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Btn_Cerrar.setForeground(new java.awt.Color(204, 0, 0));
        Btn_Cerrar.setText("X");
        Btn_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CerrarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, -1, 30));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Wallpers_FondoRojo_1_1.jpg"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 410));

        btnConsola.setText("Consola");
        btnConsola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsolaActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsola, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_Btn_CerrarActionPerformed

    private void btn_IniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_IniciarSesionActionPerformed
        Principal print = new Principal();
        print.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_IniciarSesionActionPerformed

    private void Btn_RegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_RegistrarseActionPerformed
        // TODO add your handling code here:
       Registro reg = new Registro();
               reg.setVisible(true);
               this.setVisible(false);
    }//GEN-LAST:event_Btn_RegistrarseActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
        ValidarUsuario();
    }//GEN-LAST:event_txtPassActionPerformed

    private void btnConsolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsolaActionPerformed
        // TODO add your handling code here:
        Consola cs=new Consola();
        cs.setVisible(true);
        cs.pack();
    }//GEN-LAST:event_btnConsolaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Cerrar;
    private javax.swing.JButton Btn_Registrarse;
    private javax.swing.JButton btnConsola;
    private javax.swing.JButton btn_IniciarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jlError;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
    Conectar cc = new Conectar();
    Connection cn=cc.conexion();
}
