/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import Conectar.Conectar;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author TAMY-IA
 */
public class TAMY extends javax.swing.JFrame {
    
    //VARIABLES GLOBALES
    public static String a;
    //////////////////////

    /**
     * Creates new form TAMY
     */
    public TAMY() {
        initComponents();
        this.getContentPane().setBackground(Color.BLACK);//PARA CAMBIAR EL COLOR DEL FONDO DEL JTEXTAREA
        this.setLocationRelativeTo(null);
        jlEmisor_id.setVisible(false);
        jtaTAMY.setLineWrap(true);//PARA QUE LAS CADENAS NO SE PASEN DEL CAMPO VISIBLE EN EL JTAXTAREA
        
        ///////////////////
        Reloj rj=new Reloj(jlHora);
        rj.start();
        
        jlFecha.setText(fecha());
        ///////////////////
        TAMY();
    }
    
    void Ejecutar(){
        String comando=txtDato.getText();
        
        jtaTAMY.append("-> "+comando+" "+jlHora.getText()+"\n");
        txtDato.setText("");
        //TAMY();
        /*
        String sql=txtConsulta.getText();
        String Tipo_Select = sql.split(" ")[0].trim();//OBTENGO EL DATO DE TIPO DE CONSULTA EN LA POSICION 0
        String Nom_Tabla = sql.split(" ")[3].trim();//OBTENGO EL DATO DEL NOMBRE DE TABLA EN LA POSICION 3
        */
        String numero=comando.split(" ")[0].trim();
                
        /*
        Palabras que debera recibir 
        numero ya sea cualquiera
        s-S
        n-N
        Exit-exit-EXIT
        */
        Comunes Comunes=new Comunes();
        
        if (numero.equals("S")){//contactar a soporte
            String soporte="S000002";
            
            Principal1 pc=new Principal1();
            pc.CargarMensajes(soporte, jlEmisor_id.getText());//AQUI VA EL METODO QUE CONTACTA AL SOPORTE
            pc.setVisible(true);
        }else if(Comunes.isNumeric(numero)==true){//llamar el metdo tamy1
            TAMY1(numero);
        }else if(numero.equals("Exit") || numero.equals("exit") || numero.equals("EXIT")){//para salir
            this.dispose();
        }else{
            jtaTAMY.append("\n\n\nX X X X X X X X X X X X X X X X X\n\nComando Desconocido\n Intentelo De Nuevo...\n\n\n");
        }
    }
    
    private static boolean isNumeric(String cadena){
        try{
            Integer.parseInt(cadena);
            return true;
        }catch(NumberFormatException nfe){
            return false;
        }
    }
    
    void TAMY(){
        Conectar cc=new Conectar();
        Connection cn=cc.conexion();
        
        jtaTAMY.setText("Bienvenido mi nombre es TAMY \n\n");
        
        /////////////////AQUI INICIAN LAS PREGUNTAS/////////////////////////////////
        try{
            String sql="SELECT * FROM reconocimiento";
            String [] falla= new String[1];
            
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()==true){
                jtaTAMY.append(rs.getString(1)+").- "+rs.getString(2)+" _ "+rs.getString(3)+"\n\n");
                
            }
            jtaTAMY.append("De igual forma en caso de no poder corregir su problema puedo contactar con nuestro soporte tecnico");
            jtaTAMY.append("\n\n Para Contactar A Soporte Dirijase A Su Lista de Contactos y Busque ->Soporte<-");
            
        }catch(Exception ex){
            System.out.println("Error metodo TAMY\n"+ex);
        }
        /////////////////AQUI TERMINAN LAS PREGUNTAS/////////////////////////////////
        cc.CerrarConexion();
    }
    
    void TAMY1(String valor){
        String[] falla=new String[2];
        
        Conectar cc=new Conectar();
        Connection cn=cc.conexion();
        
        String consulta="SELECT * FROM `reconocimiento` WHERE `idReconocimiento`='"+valor+"'";
        
        try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(consulta);
            /*TAMY uno debera tomar el id de los errores y mostrar la falla y la posible soluccion
            
            */
            if(rs.next()){
                falla[0]=rs.getString(4);
                falla[1]=rs.getString(5);
            }
            
            jtaTAMY.setText("==>La posibles causas de la falla son las siguiente:\n\n"+falla[0]+"\n\n");
            jtaTAMY.append("==>La falla podria corregirse de la siguiente manera:\n\n"+falla[1]+"\n\n");
            jtaTAMY.append("Escriba Exit para salir...");
            //System.out.println(falla[0]+"\n\n\n"+falla[1]);
            
            
        }catch(Exception ex){
            
        }
    }
    
    void TAMY2(String valor){   //Recibe el id del error y lo muestra en el textarea
        Conectar cc=new Conectar();
        Connection cn=cc.conexion();
        
        //jtaTAMY.setText("Bienvenido mi nombre es TAMY \n\n");
        
        /////////////////AQUI INICIAN LAS PREGUNTAS/////////////////////////////////
        try{
            String sql="SELECT * FROM `reconocimiento` WHERE `idReconocimiento`='"+valor+"'";
            //String [] falla= new String[1];
            
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()==true){
                jtaTAMY.append(rs.getString(3)+"...\n\nPosibles Causas...\n\n"+rs.getString(4)+"\n\nSolucion... \n\n "+rs.getString(5)+"\n\n");
                
            }
            jtaTAMY.append("Escriba Exit para salir...");
            //jtaTAMY.append("\n\n ¿Desea Contactar A Soporte Tecnico? S/N");
            
        }catch(Exception ex){
            System.out.println("Error metodo TAMY\n"+ex);
        }
        /////////////////AQUI TERMINAN LAS PREGUNTAS/////////////////////////////////
        cc.CerrarConexion();
    }
    
    public static String fecha(){
        java.util.Date fecha = new java.util.Date();
        SimpleDateFormat formatofecha= new SimpleDateFormat("dd/MM/YYYY");
        
        return formatofecha.format(fecha);
    }
    
    void fecha2(){
        Date objDate = new Date(); // Sistema actual La fecha y la hora se asignan a objDate 
 
        System.out.println(objDate); 
        String strDateFormat = "hh: mm: ss a dd-MMM-aaaa"; // El formato de fecha está especificado  
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un argumento al objeto 
        //de formato de fecha  
        System.out.println(objSDF.format(objDate)); // El formato de fecha se aplica a la fecha actual
    }
    //////////Protocolos de seguridad//////////////////////////////////////////
    public static String id;
    
    void ProtocoloNivelAcceso(){
        
    }
    
    ///////////Fin de protocoloes de seguridad///////////////////////////

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jlFecha = new javax.swing.JLabel();
        jlHora = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlTAMY = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaTAMY = new javax.swing.JTextArea();
        txtDato = new javax.swing.JTextField();
        jlEmisor_id = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TAMY Soporte");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlFecha.setForeground(new java.awt.Color(0, 204, 0));
        jlFecha.setText("DD/MM/AAAA");
        jPanel2.add(jlFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 80, 20));

        jlHora.setForeground(new java.awt.Color(0, 204, 0));
        jlHora.setText("HH:MM:SS");
        jPanel2.add(jlHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 60, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Instant Messaging Soporte");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jlTAMY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TAMY/Interfaz_1.gif"))); // NOI18N
        jPanel2.add(jlTAMY, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, 286));

        jtaTAMY.setEditable(false);
        jtaTAMY.setBackground(new java.awt.Color(0, 0, 0));
        jtaTAMY.setColumns(20);
        jtaTAMY.setForeground(new java.awt.Color(0, 255, 0));
        jtaTAMY.setRows(5);
        jScrollPane1.setViewportView(jtaTAMY);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 360, 148));

        txtDato.setBackground(new java.awt.Color(0, 0, 0));
        txtDato.setForeground(new java.awt.Color(0, 51, 153));
        txtDato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatoActionPerformed(evt);
            }
        });
        jPanel2.add(txtDato, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 360, 30));

        jlEmisor_id.setForeground(new java.awt.Color(255, 255, 0));
        jlEmisor_id.setText("jLabel2");
        jPanel2.add(jlEmisor_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 60, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatoActionPerformed
        // TODO add your handling code here:
        Ejecutar();
    }//GEN-LAST:event_txtDatoActionPerformed

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
            java.util.logging.Logger.getLogger(TAMY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TAMY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TAMY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TAMY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TAMY().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel jlEmisor_id;
    private javax.swing.JLabel jlFecha;
    private javax.swing.JLabel jlHora;
    private javax.swing.JLabel jlTAMY;
    private javax.swing.JTextArea jtaTAMY;
    private javax.swing.JTextField txtDato;
    // End of variables declaration//GEN-END:variables
}
