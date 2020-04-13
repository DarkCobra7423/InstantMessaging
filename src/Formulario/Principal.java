/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import Conectar.Conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author TAMY-IA
 */
public class Principal extends javax.swing.JFrame {
    DefaultListModel listModel;
    
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        CargarContactos();
    }
    
    void CargarContactos(){
        Conectar cc=new Conectar();
        Connection cn=cc.conexion();
        
        try{
            //String lista="SELECT `idUsuario`, `nombres`, `apellido_paterno`, `apellido_materno` FROM usuario";    //si se quiere obneter nombres completos de usuarios
            String lista="SELECT `usuario` FROM usuario";   //para obtener solo nombres de usuario
            String [] contactos= new String[1];
            Vector vector=new Vector();
            
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(lista);
            
            while(rs.next()==true){
                //contactos[0]=rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4);     //si se quiere obneter nombres completos de usuarios
                contactos[0]=rs.getString(1);   //para obneter solo nmbres de usuario
                vector.addElement(contactos[0]);
                jList.setListData(vector);
            }
            
            cc.CerrarConexion();
        }catch(Exception ex){
            System.out.println("Error al cargar los contactos \n"+ex);
        }
        
    }
    
    public void DetenerHilo(String estado){
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmEdit = new javax.swing.JMenu();
        jmUsuario = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jList.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 380, 390));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/wallpers_1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 430));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jmEdit.setText("Edit");
        jMenuBar1.add(jmEdit);

        jmUsuario.setText("Usuario");
        jMenuBar1.add(jmUsuario);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListMouseClicked
        // TODO add your handling code here:
        String chat=jList.getSelectedValue();
        String id="", IdEmisor=jmUsuario.getText();
                
        try{
            Conectar cc=new Conectar();
            Connection cn=cc.conexion();
            
            String sql="SELECT `idUsuario` FROM usuario WHERE `usuario`='"+chat+"'";
            
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            if(rs.next()){              
                 id=rs.getString(1);
            }
            
            if(id==null){
                JOptionPane.showMessageDialog(null, "Error debe selecionar un usuario");
            }
                        
            cc.CerrarConexion();
        }catch(Exception ex){
            System.out.println("Error al obtener el id del chat\n" +ex);
        }
        
        //ABRIR LA VENTANA DE HISTORIAL DE CHAT
        //////////////////////////////////////////
        Thread hilo=new Thread(new Principal1());
        //hilo.start();
        /////////////////////////////////////////
        Principal1 pc=new Principal1();
        pc.setVisible(true);
        Principal1.jmUsuario1.setText(jmUsuario.getText());
        Principal1.jlNick.setText(chat);
        pc.CargarMensajes(id, IdEmisor);
        pc.ObtenerNombre();
        hilo.start();
        this.setVisible(false);
        //JOptionPane.showMessageDialog(null, "funciona -->"+este+"<--");
    }//GEN-LAST:event_jListMouseClicked

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu jmEdit;
    public static javax.swing.JMenu jmUsuario;
    // End of variables declaration//GEN-END:variables
    
}
