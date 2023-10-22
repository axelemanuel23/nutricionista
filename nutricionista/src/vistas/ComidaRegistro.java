/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoADatos.ComidaData;
import accesoADatos.DietaComidaData;
import entidades.Comida;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Camila
 */
public class ComidaRegistro extends javax.swing.JInternalFrame {
static ComidaData cD = new ComidaData();
static DietaComidaData dCD = new DietaComidaData();
    /**
     * Creates new form ComidaRegistro
     */
    public ComidaRegistro() {
        initComponents();
        cargarCombo();
    }
    
    public void cargarCombo(){
        jCBNombreComida.removeAllItems();
        jCBNombreComida.addItem("- Agregar Comida -");
        for (Comida elem : cD.listarComida()) {
            jCBNombreComida.addItem(elem.getNombre()+ "");
        }
    }
    
     private void limpiarCasilla () {
        jCBNombreComida.setSelectedIndex(0);
        jTFDescripcion.setText("");
        jTFCantCaloria.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTFDescripcion = new javax.swing.JTextField();
        jTFCantCaloria = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jBEliminar = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jBLimpiar = new javax.swing.JButton();
        jCBNombreComida = new javax.swing.JComboBox<>();

        setBorder(null);

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Registro de Comidas");

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel2.setText("Nombre: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel3.setText("Descripcion: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel4.setText("Cantidad de Caloria: ");

        jTFDescripcion.setColumns(6);
        jTFDescripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFDescripcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFDescripcionMouseClicked(evt);
            }
        });

        jTFCantCaloria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFCantCaloria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFCantCaloriaMouseClicked(evt);
            }
        });
        jTFCantCaloria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFCantCaloriaKeyTyped(evt);
            }
        });

        jBEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBLimpiar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBLimpiar.setText("Limpiar");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });

        jCBNombreComida.setEditable(true);
        jCBNombreComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBNombreComidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(jCBNombreComida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFCantCaloria, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(jBGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBEliminar)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCBNombreComida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTFDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTFCantCaloria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBSalirMouseEntered
        jBSalir.setBackground(new java.awt.Color(255,0,0));
    }//GEN-LAST:event_jBSalirMouseEntered

    private void jBSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBSalirMouseExited
        jBSalir.setBackground(new java.awt.Color(240,240,240));
    }//GEN-LAST:event_jBSalirMouseExited

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jTFDescripcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFDescripcionMouseClicked

    }//GEN-LAST:event_jTFDescripcionMouseClicked

    private void jTFCantCaloriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFCantCaloriaMouseClicked
  
    }//GEN-LAST:event_jTFCantCaloriaMouseClicked

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        limpiarCasilla();
    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
       try{
            String nComida = jCBNombreComida.getSelectedItem().toString();
                        
            if (jCBNombreComida.getSelectedIndex() != -1) {
                Comida comida = cD.buscarComida(nComida);
                int id = comida.getIdComida();
                String nombre = nComida;
                String desc = jTFDescripcion.getText();
                int cantCal = Integer.parseInt(jTFCantCaloria.getText());

                Comida comidaMod = new Comida(nombre, desc, cantCal);
                cD.modificarComida(id, comidaMod);
            } else {
                try{
//                    int dni1 = Integer.parseInt(jCBNombreComida.getSelectedItem().toString());
//                    String nombre = nComida;
                    String desc = jTFDescripcion.getText();
                    int cantCal = Integer.parseInt(jTFCantCaloria.getText());

                    Comida comidaNueva = new Comida(nComida, desc, cantCal);
                    cD.guardarComida(comidaNueva);
                    jCBNombreComida.addItem(comidaNueva.getNombre());
//                    }
//                    catch(NumberFormatException e){
//                        JOptionPane.showMessageDialog(null, "Ingrese valores validos");

                    }catch(NullPointerException e){
                        JOptionPane.showMessageDialog(null, "Complete todos los campos");
                    }
            }
//        }
//        catch(NumberFormatException e){
//            JOptionPane.showMessageDialog(null, "Ingrese valores validos");

        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        }
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        try{
            
            String nombreC = jCBNombreComida.getSelectedItem().toString();
            cD.buscarComida(nombreC);
            Comida comida = cD.buscarComida(nombreC);
            dCD.eliminarRelacionesXidComida(comida.getIdComida());
            cD.eliminarComida(comida.getIdComida()); 
            
            jCBNombreComida.removeAllItems();
            cargarCombo();
            limpiarCasilla();
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ingrese valores validos");

        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        }
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jCBNombreComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBNombreComidaActionPerformed
        try { //mostrar si el paciente esta realizando una dieta??
             if (jCBNombreComida.getSelectedIndex() != 0 && jCBNombreComida.getSelectedIndex() != -1) {
                String nombreC = jCBNombreComida.getSelectedItem().toString();
                Comida comida = cD.buscarComida(nombreC);
                
                if(comida != null){
                jTFDescripcion.setText(comida.getDetalle());
                jTFCantCaloria.setText(comida.getCantCalorias() + "");
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jCBNombreComidaActionPerformed

    private void jTFCantCaloriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCantCaloriaKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;
        if (!numeros){
            evt.consume();
        }
    }//GEN-LAST:event_jTFCantCaloriaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<String> jCBNombreComida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTFCantCaloria;
    private javax.swing.JTextField jTFDescripcion;
    // End of variables declaration//GEN-END:variables
}
