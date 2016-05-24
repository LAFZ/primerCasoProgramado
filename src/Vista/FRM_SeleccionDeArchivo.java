
package Vista;

import Controlador.Controlador_FRM_MenuPrincipal;
import Controlador.Controlador_FRM_SeleccionDeArchivo;
import Modelo.ConexionBD;
import Modelo.Metodos_Login;
import Modelo.Metodos_XML_Usuario;
import javax.swing.ButtonGroup;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;


public class FRM_SeleccionDeArchivo extends javax.swing.JFrame {
    public Controlador_FRM_SeleccionDeArchivo controlador;

   private FRM_Login login;
   private FRM_MenuPrincipal frm_MenuPrincipal;
   private ButtonGroup bg1;
   private String buttonSelected = "gufwhuefef";
  
    
    public FRM_SeleccionDeArchivo(Controlador_FRM_MenuPrincipal controlador_FRM_MenuPrincipal, FRM_MenuPrincipal menuPrincipal, Metodos_Login metodosLogin, ConexionBD conexion, FRM_Login
             login, Metodos_XML_Usuario metodos_XML_Usuario) {
        initComponents();
        this.login = login;
        this.setLocation(330,200);
        this.setVisible(false);
        this.controlador = new Controlador_FRM_SeleccionDeArchivo( this, login, controlador_FRM_MenuPrincipal, menuPrincipal,   metodosLogin,  conexion, metodos_XML_Usuario);
        this. agregarEventos();
        this.groupButton( );
        this.estadoInicial();
        
    }
    public void agregarEventos(){
        this.jr_ArchivosPlanos.addActionListener(controlador);
        this.jr_BaseDeDatos.addActionListener(controlador);
        this.jr_Xml.addActionListener(controlador);
        this.jb_Continuar.addActionListener(controlador);
    }
    public void habilitarContinuar(){
       
                    this.jb_Continuar.setEnabled(false);
        if(this.jr_ArchivosPlanos.isSelected()==true){
           
            this.jb_Continuar.setEnabled(true);
        }else
        if(this.jr_BaseDeDatos.isSelected()==true){
           this.jb_Continuar.setEnabled(true);
        }else
        if(this.jr_Xml.isSelected()==true){
           this.jb_Continuar.setEnabled(true);
        }
    }
    public void estadoInicial(){
       this.jb_Continuar.setEnabled(false);
    }
    
public void groupButton( ) {
  bg1 = new ButtonGroup( );

bg1.add(jr_ArchivosPlanos);
bg1.add(jr_BaseDeDatos);
bg1.add(jr_Xml);
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jr_ArchivosPlanos = new javax.swing.JRadioButton();
        jr_BaseDeDatos = new javax.swing.JRadioButton();
        jr_Xml = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jb_Continuar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jr_ArchivosPlanos.setActionCommand("ArchivosPlanos");
        getContentPane().add(jr_ArchivosPlanos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));

        jr_BaseDeDatos.setActionCommand("BaseDeDatos");
        getContentPane().add(jr_BaseDeDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        jr_Xml.setActionCommand("XML");
        jr_Xml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jr_XmlActionPerformed(evt);
            }
        });
        getContentPane().add(jr_Xml, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, -1, -1));

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setText("Archivos Planos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel3.setText("Bases de datos");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel4.setText("Archivo XML");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel5.setText("Seleccione el archivo de trabajo");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jb_Continuar.setText("Continuar");
        jb_Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_ContinuarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_Continuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo 2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ContinuarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_ContinuarActionPerformed

    private void jr_XmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jr_XmlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jr_XmlActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jb_Continuar;
    private javax.swing.JRadioButton jr_ArchivosPlanos;
    private javax.swing.JRadioButton jr_BaseDeDatos;
    private javax.swing.JRadioButton jr_Xml;
    // End of variables declaration//GEN-END:variables
}
