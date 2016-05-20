
package Vista;

import Controlador.Controlador_FRM_MantenimientoCursos;
import Modelo.ConexionBD;
import javax.swing.JOptionPane;

public class FRM_MantenimientoCursos extends javax.swing.JFrame {

   public Controlador_FRM_MantenimientoCursos controlador_FRM_MantenimientoCursos;
    public FRM_MantenimientoCursos(ConexionBD conexion) {
        initComponents();
        setVisible(false);
        this.setLocation(410,275);
        controlador_FRM_MantenimientoCursos=new Controlador_FRM_MantenimientoCursos(this, conexion);
        this.gUI_Botones1.agregarEventos(controlador_FRM_MantenimientoCursos);
        this.gUI_InformacionCursos1.agregarEventos(controlador_FRM_MantenimientoCursos);
        estadoInicial();
    }
    
    public String[] devolverInformacion(){
        return this.gUI_InformacionCursos1.devolverInformacion();
    }
    public String devolverSigla()
    {
        return this.gUI_InformacionCursos1.devolverSigla();
    }
    public String devolverNombre()
    {
        return this.gUI_InformacionCursos1.devolverNombre();
    }
    public String devolverCreditos()
    {
        return this.gUI_InformacionCursos1.devolverCreditos();
    }
    public String devolverHorario(){
        return this.gUI_InformacionCursos1.devolverHorario();
    }
    public void mostrarInformacion(String[] arreglo)
    {
        this.gUI_InformacionCursos1.mostrarInformacion(arreglo);
    }
    public void limpiar()
    {
        this.gUI_InformacionCursos1.limpiar();
    }
    public void estadoInicial(){
        this.gUI_Botones1.estadoInicial();
        this.gUI_InformacionCursos1.estadoInicial();
    }
    public void deshabilitarSigla(){
        this.gUI_InformacionCursos1.deshabilitarSigla();
    }
    public void habilitarOpciones(){
        this.gUI_Botones1.habilitarOpciones();
        this.gUI_InformacionCursos1.habilitarOpciones();
    }
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    public void habilitarAgregar(){
        this.gUI_Botones1.habilitarAgregar();
        this.gUI_InformacionCursos1.habilitarAgregar();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gUI_Botones1 = new Vista.GUI_Botones();
        gUI_InformacionCursos1 = new Vista.GUI_InformacionCursos();
        jLabel1 = new javax.swing.JLabel();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(gUI_Botones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 350, 90));
        getContentPane().add(gUI_InformacionCursos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 180));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo 2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden

    }//GEN-LAST:event_formComponentHidden

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.GUI_Botones gUI_Botones1;
    private Vista.GUI_InformacionCursos gUI_InformacionCursos1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
