/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import Conectar.Conectar;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 *
 * @author TAMY-IA
 */
public class Principal1 extends javax.swing.JFrame implements Runnable {
 
    /**
     * Creates new form Principal1
     */
    public Principal1() {
        initComponents();
        this.setLocationRelativeTo(null);
        Reloj hora = new Reloj(jlHora);
        hora.start();
        jlFecha.setText(fecha());
        jtHistorial.setLineWrap(true);//PARA QUE LAS CADENAS NO SE PASEN DEL CAMPO VISIBLE EN EL JTAXTAREA
        jtHistorial.setEditable(false);
    }
    
    public void run(){
        int i=0;
        while(true){
            try{
            System.out.println("Funciona el hilo "+i);
            jtHistorial.setText("");
            CargarMensajes(jmPara.getText(), jmUsuario1.getText());
            i++;
            sleep(1000);
        }catch(Exception ex){
            
        }
        }
    }
    
    public void CargarMensajes(String id, String emisor){
        //                                                   para=id             de=emisor               de=emisor        para=id      leido por ahora sera 0
        String chat="SELECT * FROM mensaje WHERE (`para`='"+id+"' OR `para`='"+emisor+"') AND (`de`='"+emisor+"' OR `de`='"+id+"') AND `leido`='0'";
        //SELECT * FROM mensaje WHERE (`para`='00000001' OR `para`='00000002') AND (`de`='00000002' OR `de`='00000001') AND `leido`='1'     CARGA EL HISTORIAL DE DOS PERSONAS
        //System.out.println("SELECT * FROM mensaje WHERE (`para`='"+id+"' OR `para`='"+emisor+"') AND (`de`='"+emisor+"' OR `de`='"+id+"') AND `leido`='0'");
        String datos="";
        
        try{
            Conectar cc=new Conectar();
            Connection cn=cc.conexion();
            
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(chat);
            //System.out.println("este es el chat--->"+chat);
            while(rs.next()==true){
                datos=rs.getString(5)+" - "+rs.getString(6)+": "+rs.getString(7);
                jtHistorial.append(datos+"\n");
                System.out.println("\nEste es el metodo y cadena del jtarea -->"+datos);
            }
            //System.out.println("\nEste es el metodo y cadena del jtarea 2 fuera del ciclo-->"+datos);
            cc.CerrarConexion();
        }catch(Exception ex){
            System.out.println("Error al cargar el historial \n"+ex);
        }
    }
    
    void EnviarMensajes(){
        Conectar cc=new Conectar();
        Connection cn=cc.conexion();
        
        String id="0";
        String enviarmsj="INSERT INTO mensaje (`idMensaje`, `para`, `de`, `leido`, `hora_fecha`, `enviadopor`, `mensaje`)VALUES(?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement pst  = cn.prepareStatement(enviarmsj);
            pst.setString(1, id);
            pst.setString(2, jmPara.getText());
            pst.setString(3, jmUsuario1.getText());
            pst.setString(4, id);
            pst.setString(5, jlFecha.getText()+" "+jlHora.getText());
            pst.setString(6, jmEnviadopor.getText());
            pst.setString(7, txtMensaje.getText()); 
           
            pst.executeUpdate();
            jtHistorial.setText("");
            CargarMensajes(jmPara.getText(), jmUsuario1.getText());
            txtMensaje.setText("");
            cc.CerrarConexion();
        }catch(Exception ex){
            System.out.println("Error al enviar el msj\n"+ex);
            jtHistorial.append("Error al enviar el msj:\n"+ex);
        }
    }
    
    void ObtenerNombre(){
        Conectar cc=new Conectar();
        Connection cn=cc.conexion();
        String sql="SELECT `nombres` FROM usuario WHERE `idUsuario`='"+jmUsuario1.getText()+"'";//CAMBOAR NOMBRES POR USUARIO
        String nickName="";
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()){              
                 nickName=rs.getString(1);
            }
            jmEnviadopor.setText(nickName);
            this.setTitle(nickName);
            cc.CerrarConexion();
        }catch(Exception ex){
            System.out.println("Error al obtener nombre\n"+ex);
        }
    }
    
    public void getDatos(String a, String b){
        jmPara.setText(a);
        jmUsuario1.setText(b);
    }
    
    public static String fecha(){
        java.util.Date fecha = new java.util.Date();
        SimpleDateFormat formatofecha= new SimpleDateFormat("yyyy-MM-dd");
                                                       //   "YYYY/MM/dd"    dd-MM-yyyy
        return formatofecha.format(fecha);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtHistorial = new javax.swing.JTextArea();
        txtMensaje = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        btnEnviar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jlFecha = new javax.swing.JLabel();
        jlHora = new javax.swing.JLabel();
        jlNick = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmDe = new javax.swing.JMenu();
        jmUsuario1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jmPara = new javax.swing.JMenu();
        jmEnviadopor = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mini_itvh.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 210, 290));

        jtHistorial.setColumns(20);
        jtHistorial.setFont(new java.awt.Font("MV Boli", 0, 13)); // NOI18N
        jtHistorial.setRows(5);
        jScrollPane1.setViewportView(jtHistorial);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 70, 580, 470));

        txtMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMensajeActionPerformed(evt);
            }
        });
        getContentPane().add(txtMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 550, 500, 30));

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 550, -1, -1));

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 550, 70, 30));

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, -1, -1));

        jlFecha.setForeground(new java.awt.Color(255, 255, 255));
        jlFecha.setText("dd/mm/aaaa");
        getContentPane().add(jlFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 65, -1));

        jlHora.setForeground(new java.awt.Color(255, 255, 255));
        jlHora.setText("hh:mm:ss");
        getContentPane().add(jlHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 40, -1, -1));

        jlNick.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlNick.setForeground(new java.awt.Color(255, 255, 255));
        jlNick.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNick.setText("NickName");
        getContentPane().add(jlNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 360, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/wallpers_1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 590));

        jMenu1.setText("Archivo");

        jMenuItem2.setText("Tabla De Errores");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Ayuda");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem1.setText("Cerrar Sesion");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jmDe.setText("De:");
        jMenuBar1.add(jmDe);

        jmUsuario1.setText("Usuario");
        jMenuBar1.add(jmUsuario1);

        jMenu2.setText("Para:");
        jMenuBar1.add(jMenu2);

        jmPara.setText("Para");
        jMenuBar1.add(jmPara);

        jmEnviadopor.setText("Mi nombre");
        jMenuBar1.add(jmEnviadopor);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
        EnviarMensajes();
        
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
                Login lg=new Login();
                lg.setVisible(true);
                lg.pack();
                this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Principal pc=new Principal();
        pc.setVisible(true);
        Principal.jmUsuario.setText(jmUsuario1.getText());
        this.setVisible(false);
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMensajeActionPerformed
        // TODO add your handling code here:
        EnviarMensajes();
    }//GEN-LAST:event_txtMensajeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jtHistorial.setText("");
        CargarMensajes(jmPara.getText(), jmUsuario1.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Reconocimiento rc=new Reconocimiento();
        rc.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        TAMY tm=new TAMY();
        tm.jlEmisor_id.setText(jmUsuario1.getText());
        tm.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlFecha;
    private javax.swing.JLabel jlHora;
    public static javax.swing.JLabel jlNick;
    private javax.swing.JMenu jmDe;
    private javax.swing.JMenu jmEnviadopor;
    private static javax.swing.JMenu jmPara;
    public static javax.swing.JMenu jmUsuario1;
    private javax.swing.JTextArea jtHistorial;
    private javax.swing.JTextField txtMensaje;
    // End of variables declaration//GEN-END:variables
}
