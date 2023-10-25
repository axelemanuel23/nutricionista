/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoADatos.DietaComidaData;
import accesoADatos.DietaData;
import accesoADatos.PacienteData;
import entidades.Dieta;
import entidades.Paciente;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Camila
 */
public class PacienteConsulta extends javax.swing.JInternalFrame {

    static PacienteData pD = new PacienteData();
    static DietaComidaData dCD = new DietaComidaData();
    static DietaData dD = new DietaData();

    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };
    
    
    public PacienteConsulta() {
        initComponents();
        cargarCabecera();
        cargarDatos();
    }

    private void cargarCabecera() {
        modelo.addColumn("Nombre");
        modelo.addColumn("DNI");
        modelo.addColumn("Telefono");
        jTPacientesInactivos.setModel(modelo);
    }

    public void borrarFilas() {

        int f = jTPacientesInactivos.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }

    }
    
    
    public void cargarDatos(){
         try {
            
            borrarFilas();
            //Iterar sobre pacientes inactivos
            List<Paciente> pInactivos = pD.listarPacientesInactivos();
            for (Paciente pInactivo : pInactivos ) {
                //Obtener la dieta exitosa de cada paciente
                javax.swing.JCheckBox cBReactivar = new javax.swing.JCheckBox();
                Dieta dieta = dD.buscarDietaXPaciente(pInactivo.getIdPaciente());
                //
                modelo.addRow(new Object[]{pInactivo.getNombre(), pInactivo.getDni(), pInactivo.getTelefono()});
            }
        } catch (NullPointerException e) {
             System.out.println("Error al cargar los datos de la tabla");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTPacientesInactivos = new javax.swing.JTable();
        jBSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(565, 225));

        jTPacientesInactivos.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jTPacientesInactivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null,  new Boolean(false)},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTPacientesInactivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPacientesInactivosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTPacientesInactivos);

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

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel1.setText("Pacientes Inactivos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTPacientesInactivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPacientesInactivosMouseClicked
        try {
            int itemIndex = jTPacientesInactivos.getSelectedRow();
            int dniPaciente = (int) jTPacientesInactivos.getValueAt(itemIndex, 1);
            if (itemIndex != -1) {
                pD.reactivarPaciente(pD.buscarPacienteXDNI(dniPaciente).getIdPaciente());
                modelo.removeRow(itemIndex);
                System.out.println("Se ha reactivado un paciente");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error de indices");
        }
    }//GEN-LAST:event_jTPacientesInactivosMouseClicked

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
    private javax.swing.JButton jBSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTPacientesInactivos;
    // End of variables declaration//GEN-END:variables
}
