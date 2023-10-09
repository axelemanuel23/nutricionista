package vistas;

import accesoADatos.PacienteData;
import entidades.Paciente;
import javax.swing.JOptionPane;

public class PacienteFormulario extends javax.swing.JInternalFrame {
    
static PacienteData pD = new PacienteData();
    /**
     * Creates new form PacienteFormulario
     */
    public PacienteFormulario() {
        initComponents();
        coloresBotones();
        cargarCombo();
    }

    private void limpiarCasilla () {
        jTFNombre.setText("");
        jTFDomicilio.setText("");
        jTFTelefono.setText("");
        jCBDni.setSelectedIndex(0);
    }
    
    private void cargarCombo(){
        jCBDni.addItem("- Agregar Paciente -");

        for (Paciente elem : pD.listarPacientesActivos()) {
            jCBDni.addItem(elem.getDni() + "");
        }
    }
    
    private void coloresBotones(){
        jBSalir.setBackground(new java.awt.Color(240,240,240));
        jBGuardar.setBackground(new java.awt.Color(240,240,240));
        jBLimpiar.setBackground(new java.awt.Color(240,240,240));
        jBEliminar.setBackground(new java.awt.Color(240,240,240));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTFTelefono = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jTFDomicilio = new javax.swing.JTextField();
        jCBDni = new javax.swing.JComboBox<>();
        jBGuardar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBLimpiar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        setResizable(true);
        setTitle("Formulario de Paciente");
        setFrameIcon(null);
        setPreferredSize(new java.awt.Dimension(425, 405));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Formulario de Pacientes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 320, 10));

        jTFTelefono.setBackground(new java.awt.Color(242, 248, 248));
        jTFTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFTelefonoKeyTyped(evt);
            }
        });
        getContentPane().add(jTFTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 167, 25));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Documento: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre y Apellido: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Domicilio: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Telefono: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jTFNombre.setBackground(new java.awt.Color(242, 248, 248));
        jTFNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFNombreKeyTyped(evt);
            }
        });
        getContentPane().add(jTFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 167, 25));

        jTFDomicilio.setBackground(new java.awt.Color(242, 248, 248));
        getContentPane().add(jTFDomicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 167, 25));

        jCBDni.setBackground(new java.awt.Color(242, 248, 248));
        jCBDni.setEditable(true);
        jCBDni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCBDniMouseClicked(evt);
            }
        });
        jCBDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBDniActionPerformed(evt);
            }
        });
        jCBDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCBDniKeyTyped(evt);
            }
        });
        getContentPane().add(jCBDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 165, 25));

        jBGuardar.setBackground(new java.awt.Color(0, 38, 255));
        jBGuardar.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jBGuardar.setForeground(new java.awt.Color(51, 51, 51));
        jBGuardar.setText("Guardar");
        jBGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBGuardar.setFocusPainted(false);
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jBGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 90, 38));

        jBEliminar.setBackground(new java.awt.Color(0, 38, 255));
        jBEliminar.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jBEliminar.setForeground(new java.awt.Color(51, 51, 51));
        jBEliminar.setText("Eliminar");
        jBEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBEliminar.setFocusPainted(false);
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jBEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 90, 38));

        jBLimpiar.setBackground(new java.awt.Color(0, 38, 255));
        jBLimpiar.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jBLimpiar.setForeground(new java.awt.Color(51, 51, 51));
        jBLimpiar.setText("Limpiar");
        jBLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBLimpiar.setFocusPainted(false);
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(jBLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 80, 38));

        jBSalir.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        jBSalir.setText("X");
        jBSalir.setBorder(null);
        jBSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBSalir.setFocusPainted(false);
        jBSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBSalirMouseExited(evt);
            }
        });
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jBSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 25, 26));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/fondo azul.jpeg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        limpiarCasilla();
    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void jTFNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreKeyTyped
    int key = evt.getKeyChar();

    boolean mayusculas = key >= 65 && key <= 90;
    boolean minusculas = key >= 97 && key <= 122;
    boolean espacio = key == 32;
            
     if (!(minusculas || mayusculas || espacio)){
        evt.consume();
    }
    }//GEN-LAST:event_jTFNombreKeyTyped

    private void jTFTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTelefonoKeyTyped
    int key = evt.getKeyChar();

    boolean numeros = key >= 48 && key <= 57;
    if (!numeros){
        evt.consume();
    }
    }//GEN-LAST:event_jTFTelefonoKeyTyped

    private void jCBDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCBDniKeyTyped
    int key = evt.getKeyChar();

    boolean numeros = key >= 48 && key <= 57;
    if (!numeros){
        evt.consume();
    }
    }//GEN-LAST:event_jCBDniKeyTyped

    private void jCBDniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBDniMouseClicked
    }//GEN-LAST:event_jCBDniMouseClicked

    private void jCBDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBDniActionPerformed
        try { //mostrar si el paciente esta realizando una dieta??
             if (jCBDni.getSelectedIndex() != 0 && jCBDni.getSelectedIndex() != -1) {
                int dni = Integer.parseInt(jCBDni.getSelectedItem().toString()) ;
                Paciente paciente = pD.buscarPaciente(dni);
                
                if(paciente != null){
                jTFNombre.setText(paciente.getNombre());
                jTFDomicilio.setText(paciente.getDomicilio());
                jTFTelefono.setText(paciente.getTelefono());
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jCBDniActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        try{
            int dni = Integer.parseInt(jCBDni.getSelectedItem().toString());
                        
            if (jCBDni.getSelectedIndex() != -1) {
                Paciente paciente = pD.buscarPaciente(dni);
                int id = paciente.getIdPaciente();
                int dni1 = Integer.parseInt(jCBDni.getSelectedItem().toString()) ;
                String nombre = jTFNombre.getText();
                String domicilio = jTFDomicilio.getText();
                String tel = jTFTelefono.getText();
                
                    Paciente dupPaciente = new Paciente(nombre, dni, domicilio, tel);
                    pD.modificarPaciente(id, dupPaciente);
            } else {
                try{
                    int dni1 = Integer.parseInt(jCBDni.getSelectedItem().toString()) ;
                    String nombre = jTFNombre.getText();
                    String domicilio = jTFDomicilio.getText();
                    String tel = jTFTelefono.getText();

                    Paciente pacienteNuevo = new Paciente(nombre, dni, domicilio, tel);
                    pD.crearPaciente(pacienteNuevo);
                    jCBDni.addItem(pacienteNuevo.getDni()+"");
                    }
                    catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Ingrese valores validos");

                    }catch(NullPointerException e){
                        JOptionPane.showMessageDialog(null, "Complete todos los campos");
                    }
            }
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ingrese valores validos");

        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        }
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        try{
            int dni = Integer.parseInt(jCBDni.getSelectedItem().toString()) ;
            pD.buscarPaciente(dni);
            Paciente paciente = pD.buscarPaciente(dni);
            pD.darBajaPaciente(paciente.getIdPaciente()); //dar de baja o eliminar definitivamente
            
            jCBDni.removeAllItems();
            cargarCombo();
        limpiarCasilla();
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ingrese valores validos");

        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        }
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBSalirMouseEntered
        jBSalir.setBackground(new java.awt.Color(255,0,0));
    }//GEN-LAST:event_jBSalirMouseEntered

    private void jBSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBSalirMouseExited
        jBSalir.setBackground(new java.awt.Color(240,240,240));
    }//GEN-LAST:event_jBSalirMouseExited

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<String> jCBDni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTFDomicilio;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTextField jTFTelefono;
    // End of variables declaration//GEN-END:variables
}
