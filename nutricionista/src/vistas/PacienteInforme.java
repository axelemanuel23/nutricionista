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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Camila
 */
public class PacienteInforme extends javax.swing.JInternalFrame {
static PacienteData pD = new PacienteData();
static DietaComidaData dCD = new DietaComidaData();
static DietaData dD = new DietaData();

private DefaultTableModel modelo = new DefaultTableModel(){
        public boolean isCellEditable(int f, int c) {
            return false;
        } 
    };
    /**
     * Creates new form PacienteInforme
     */
    public PacienteInforme() {
        initComponents();
        cargarCabecera();
    }

    private void cargarCabecera(){
        modelo.addColumn("Nombre");
        modelo.addColumn("DNI");
        modelo.addColumn("Estado");
        modelo.addColumn("Nombre Dieta");
        jTPInforme.setModel(modelo);
    }
    
    public void borrarFilas(){
        
        int f = jTPInforme.getRowCount()-1;
        for (; f >= 0 ; f--) {
            modelo.removeRow(f);
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
        jTPInforme = new javax.swing.JTable();
        jRBPacienteE = new javax.swing.JRadioButton();
        jRBPacientesS = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(746, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTPInforme.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(jTPInforme);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 690, 350));

        jRBPacienteE.setBackground(null);
        jRBPacienteE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRBPacienteE.setText("Pacientes exitosos");
        jRBPacienteE.setBorder(null);
        jRBPacienteE.setOpaque(false);
        jRBPacienteE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBPacienteEActionPerformed(evt);
            }
        });
        getContentPane().add(jRBPacienteE, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jRBPacientesS.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRBPacientesS.setText("Pacientes sin Exito");
        jRBPacientesS.setBorder(null);
        jRBPacientesS.setOpaque(false);
        jRBPacientesS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBPacientesSActionPerformed(evt);
            }
        });
        getContentPane().add(jRBPacientesS, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Informe de Paciente");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/fondo azul 2.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(730, 450));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRBPacienteEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBPacienteEActionPerformed
        try {
            borrarFilas();
            jRBPacientesS.setSelected(false);
            for (Paciente PExitoso : dCD.listarPacientesExitosos()) {
                Dieta dieta = dD.buscarDietaXPaciente(PExitoso.getIdPaciente());
                modelo.addRow(new Object[]{PExitoso.getNombre(), PExitoso.getDni(), PExitoso.getEstado(), dieta.getNombre()});
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar la tabla");
        }
        
    }//GEN-LAST:event_jRBPacienteEActionPerformed

    private void jRBPacientesSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBPacientesSActionPerformed
       try {
           borrarFilas();
           jRBPacienteE.setSelected(false);
            for (Paciente PExitoso : dCD.listarPacientesSinExito()) {
                Dieta dieta = dD.buscarDietaXPaciente(PExitoso.getIdPaciente());
                modelo.addRow(new Object[]{PExitoso.getNombre(), PExitoso.getDni(), PExitoso.getEstado(), dieta.getNombre()});
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar la tabla");
        }
    }//GEN-LAST:event_jRBPacientesSActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRBPacienteE;
    private javax.swing.JRadioButton jRBPacientesS;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTPInforme;
    // End of variables declaration//GEN-END:variables
}
