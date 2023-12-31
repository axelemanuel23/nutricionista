/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoADatos.ComidaData;
import entidades.Comida;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Camila
 */
public class ComidaInformacion extends javax.swing.JInternalFrame {
static ComidaData cD = new ComidaData();
    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };
    
    /**
     * Creates new form ComidaInformacion
     */
    public ComidaInformacion() {
        initComponents();
        cargarCabeceras();
        jRBTodas.setSelected(true);
        for (Comida comida : cD.listarComida()) {
                modelo.addRow(new Object[]{comida.getIdComida(), comida.getNombre(), comida.getDetalle(), comida.getCantCalorias()});
                jLCantidadC.setText(cD.listarComida().size() + "");
            }
        
    }

    private void cargarCabeceras() {
        modelo.addColumn("ID ");
        modelo.addColumn("Nombre");
        modelo.addColumn("Detalle");
        modelo.addColumn("Calorias");
        jTComida.setModel(modelo);
    }
    
    public void borrarFilas() {

        int f = jTComida.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }

    }
    
    private void todasLasComidas(){
        for (Comida comida : cD.listarComida()) {
                modelo.addRow(new Object[]{comida.getIdComida(), comida.getNombre(), comida.getDetalle(), comida.getCantCalorias()});
                jLCantidadC.setText(cD.listarComida().size() + "");
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTComida = new javax.swing.JTable();
        jRBMayorCaloria = new javax.swing.JRadioButton();
        jRBMenorCaloria = new javax.swing.JRadioButton();
        jTFCantCalorias = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jBSalir = new javax.swing.JButton();
        jRBTodas = new javax.swing.JRadioButton();
        jLCantidadC = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBorder(null);
        setMaximumSize(new java.awt.Dimension(730, 465));

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel1.setText("Informacion de la Comida");

        jTComida.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTComida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTComida);

        jRBMayorCaloria.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jRBMayorCaloria.setText("Mayor");
        jRBMayorCaloria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBMayorCaloriaActionPerformed(evt);
            }
        });

        jRBMenorCaloria.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jRBMenorCaloria.setText("Menor");
        jRBMenorCaloria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBMenorCaloriaActionPerformed(evt);
            }
        });

        jTFCantCalorias.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jTFCantCalorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFCantCaloriasActionPerformed(evt);
            }
        });
        jTFCantCalorias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFCantCaloriasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFCantCaloriasKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel2.setText("Buscar por Caloria: ");

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

        jRBTodas.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jRBTodas.setText("Todos");
        jRBTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTodasActionPerformed(evt);
            }
        });

        jLCantidadC.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(179, 179, 179)
                        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTFCantCalorias, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLCantidadC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRBMenorCaloria)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRBMayorCaloria)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRBTodas)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLCantidadC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTFCantCalorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRBMenorCaloria)
                        .addComponent(jRBMayorCaloria)
                        .addComponent(jRBTodas)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFCantCaloriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFCantCaloriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFCantCaloriasActionPerformed

    private void jBSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBSalirMouseEntered
        jBSalir.setBackground(new java.awt.Color(255,0,0));
    }//GEN-LAST:event_jBSalirMouseEntered

    private void jBSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBSalirMouseExited
        jBSalir.setBackground(new java.awt.Color(240,240,240));
    }//GEN-LAST:event_jBSalirMouseExited

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jTFCantCaloriasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCantCaloriasKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;
        if (!numeros){
            evt.consume();
        }
    }//GEN-LAST:event_jTFCantCaloriasKeyTyped

    private void jTFCantCaloriasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCantCaloriasKeyReleased
        try{
        int valor = Integer.parseInt(jTFCantCalorias.getText());
        borrarFilas();
        if (jRBMayorCaloria.isSelected()) {
            for (Comida comida : cD.buscarCaloriasMax(valor)) {
                modelo.addRow(new Object[]{comida.getIdComida(), comida.getNombre(), comida.getDetalle(), comida.getCantCalorias()});  
            }
            jLCantidadC.setText(cD.buscarCaloriasMax(valor).size() + "");
            System.out.println(cD.buscarCaloriasMax(valor).size());
        } else if (jRBMenorCaloria.isSelected()) {
            for (Comida comida : cD.buscarCaloriasMin(valor)) {
                modelo.addRow(new Object[]{comida.getIdComida(), comida.getNombre(), comida.getDetalle(), comida.getCantCalorias()});
            }
            jLCantidadC.setText(cD.buscarCaloriasMin(valor).size() + "");
        } else if (jRBTodas.isSelected()){
            for (Comida comida : cD.listarComida()) {
                modelo.addRow(new Object[]{comida.getIdComida(), comida.getNombre(), comida.getDetalle(), comida.getCantCalorias()});
            }
            jLCantidadC.setText(cD.listarComida().size() + "");
        }
        }catch(NumberFormatException e){
            System.out.println("Vacio");
        }
        
    }//GEN-LAST:event_jTFCantCaloriasKeyReleased

    private void jRBMenorCaloriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBMenorCaloriaActionPerformed
        jRBMayorCaloria.setSelected(false);
        jRBTodas.setSelected(false);
        borrarFilas();
        int valor ;
        if(!jTFCantCalorias.getText().equals("")){
            valor = Integer.parseInt(jTFCantCalorias.getText());
        }else valor =0;
        
            for (Comida comida : cD.buscarCaloriasMin(valor)) {
                modelo.addRow(new Object[]{comida.getIdComida(), comida.getNombre(), comida.getDetalle(), comida.getCantCalorias()});
                
            }
            jLCantidadC.setText(cD.buscarCaloriasMin(valor).size() + "");
    }//GEN-LAST:event_jRBMenorCaloriaActionPerformed

    private void jRBMayorCaloriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBMayorCaloriaActionPerformed
        jRBMenorCaloria.setSelected(false);
        jRBTodas.setSelected(false);
        borrarFilas();
        int valor ;
        if(!jTFCantCalorias.getText().equals("")){
            valor = Integer.parseInt(jTFCantCalorias.getText());
        }else valor =0;
        
            for (Comida comida : cD.buscarCaloriasMax(valor)) {
                modelo.addRow(new Object[]{comida.getIdComida(), comida.getNombre(), comida.getDetalle(), comida.getCantCalorias()});
                
                
            }
            jLCantidadC.setText(cD.buscarCaloriasMax(valor).size() + "");
        
    }//GEN-LAST:event_jRBMayorCaloriaActionPerformed

    private void jRBTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBTodasActionPerformed
        jRBMayorCaloria.setSelected(false);
        jRBMenorCaloria.setSelected(false);
        borrarFilas();
        for (Comida comida : cD.listarComida()) {
                modelo.addRow(new Object[]{comida.getIdComida(), comida.getNombre(), comida.getDetalle(), comida.getCantCalorias()});   
            }jLCantidadC.setText(cD.listarComida().size() + "");
    }//GEN-LAST:event_jRBTodasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSalir;
    private javax.swing.JLabel jLCantidadC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRBMayorCaloria;
    private javax.swing.JRadioButton jRBMenorCaloria;
    private javax.swing.JRadioButton jRBTodas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTComida;
    private javax.swing.JTextField jTFCantCalorias;
    // End of variables declaration//GEN-END:variables
}
