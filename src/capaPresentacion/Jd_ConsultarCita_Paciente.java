/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package capaPresentacion;

import capaNegocio.cls_Cita;
import capaNegocio.cls_Cliente;
import capaNegocio.cls_Persona;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jd_ConsultarCita_Paciente extends javax.swing.JDialog {

    cls_Cita objC = new cls_Cita();
    cls_Cliente objCliente = new cls_Cliente();
    cls_Persona objPE = new cls_Persona();

    public Jd_ConsultarCita_Paciente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void setClienteSeleccionado(String cliente) throws Exception {
        ResultSet rs = objPE.buscarPersonaPorID(cliente);
        try {
            while (rs.next()) {
                txtnombre.setText(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
        } catch (Exception e) {
            Logger.getLogger(Jd_ProgramarCita.class.getName()).log(Level.SEVERE, null, e.getMessage());
        }
        listarCitas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        Lista = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Citas por Paciente");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel1.setText("Cliente:");

        txtnombre.setEditable(false);
        txtnombre.setMinimumSize(new java.awt.Dimension(64, 24));

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        Lista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tratamiento", "Doctor", "Fecha_hora", "Costo", "Reagendado", "Estado"
            }
        ));
        jScrollPane1.setViewportView(Lista);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSeleccionar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar))
                .addGap(25, 25, 25)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        Jd_ConsultarCita_Paciente jdConsultarCitasP = this;
        Jd_SeleccionarCliente jdSeleccionar = new Jd_SeleccionarCliente(null, true);
        jdSeleccionar.setVisible(true);
        try {
            setClienteSeleccionado(jdSeleccionar.getCliente_id());
        } catch (Exception ex) {
            Logger.getLogger(Jd_ModificarCita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed
    private void listarCitas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Tratamiento");
        modelo.addColumn("Doctor");
        modelo.addColumn("Fecha_hora");
        modelo.addColumn("Costo");
        modelo.addColumn("Reagendada");
        modelo.addColumn("Estado");
        Lista.setModel(modelo);

        try {
            ResultSet rs = objC.buscarTodasCitasPaciente(Jd_SeleccionarCliente.getNombre(), Jd_SeleccionarCliente.getApellido());
            while (rs.next()) {
                if (rs.getString("estado").equals("reagendada")) {
                    String cita = rs.getString("Nombre_T") + " / " + rs.getString("Nombre_D") + " / " + rs.getString("reagendada") + " / " + rs.getString("costo") + "Si" + rs.getString("estado");
                    modelo.addRow(new Object[]{rs.getString("Nombre_T"), rs.getString("Nombre_D"), rs.getString("reagendada"), rs.getString("costo"), "SI", rs.getString("estado")});
                } else {
                    String cita = rs.getString("Nombre_T") + " / " + rs.getString("Nombre_D") + " / " + rs.getString("fecha_hora") + " / " + rs.getString("costo") + "No" + rs.getString("estado");
                    modelo.addRow(new Object[]{rs.getString("Nombre_T"), rs.getString("Nombre_D"), rs.getString("fecha_hora"), rs.getString("costo"), "NO", rs.getString("estado")});
                }
            }
            Lista.setModel(modelo);
            if (modelo.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "El paciente no tiene ninguna cita ");
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar citas de cliente " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Lista;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
