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
        //coloresBotones();
        //cargarCombo();
    }

    private void limpiarCasilla () {
        jTFNombre.setText("");
        jTFDomicilio.setText("");
        jTFTelefono.setText("");
        jCBDni.setSelectedIndex(0);
    }
    
    public void cargarCombo(){
        jCBDni.removeAllItems();
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

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        setResizable(true);
        setTitle("Formulario de Paciente");
        setFrameIcon(null);

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Formulario de Pacientes");

        jTFTelefono.setBackground(new java.awt.Color(242, 248, 248));
        jTFTelefono.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jTFTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFTelefonoKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel2.setText("Documento: ");

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel3.setText("Nombre y Apellido: ");

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel4.setText("Domicilio: ");

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel5.setText("Telefono: ");

        jTFNombre.setBackground(new java.awt.Color(242, 248, 248));
        jTFNombre.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jTFNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFNombreKeyTyped(evt);
            }
        });

        jTFDomicilio.setBackground(new java.awt.Color(242, 248, 248));
        jTFDomicilio.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N

        jCBDni.setBackground(new java.awt.Color(242, 248, 248));
        jCBDni.setEditable(true);
        jCBDni.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
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

        jBGuardar.setBackground(new java.awt.Color(0, 255, 0));
        jBGuardar.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jBGuardar.setForeground(new java.awt.Color(255, 255, 255));
        jBGuardar.setText("Guardar");
        jBGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBGuardar.setFocusPainted(false);
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBEliminar.setBackground(new java.awt.Color(255, 51, 51));
        jBEliminar.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jBEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jBEliminar.setText("Eliminar");
        jBEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBEliminar.setFocusPainted(false);
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBLimpiar.setBackground(new java.awt.Color(0, 102, 255));
        jBLimpiar.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jBLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        jBLimpiar.setText("Limpiar");
        jBLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBLimpiar.setFocusPainted(false);
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addGap(61, 61, 61)
                        .addComponent(jCBDni, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jBLimpiar)
                        .addGap(87, 87, 87)
                        .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(100, 100, 100)
                .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(21, 21, 21)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2))
                    .addComponent(jCBDni, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jTFDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTFTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

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
                Paciente paciente = pD.buscarPacienteXDNI(dni);
                
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
                Paciente paciente = pD.buscarPacienteXDNI(dni);
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
            pD.buscarPacienteXDNI(dni);
            Paciente paciente = pD.buscarPacienteXDNI(dni);
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTFDomicilio;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTextField jTFTelefono;
    // End of variables declaration//GEN-END:variables
}
