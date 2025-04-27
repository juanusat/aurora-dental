/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package capaPresentacion;

import capaNegocio.cls_Cita;
import capaNegocio.cls_Persona;
import capaNegocio.cls_Trabajador;
import capaNegocio.cls_Tratamiento;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonio
 */
public class Jd_ProgramarCita extends javax.swing.JDialog {

    cls_Trabajador objT = new cls_Trabajador();
    cls_Tratamiento objTR = new cls_Tratamiento();
    cls_Cita objC = new cls_Cita();
    cls_Persona objP = new cls_Persona();
    

    public Jd_ProgramarCita(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        listarDoctores();
        listarTratamientos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblRecep = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxDoctor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxTratamiento = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnProgramar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSeleccionarCliente = new javax.swing.JButton();
        DTPfechahora = new com.github.lgooddatepicker.components.DateTimePicker();
        jLabel6 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Programar Cita");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Recepcionista:");
        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N

        lblRecep.setText("......");

        jLabel2.setText("Cliente :");
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N

        cbxDoctor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxDoctor.setPreferredSize(new java.awt.Dimension(72, 24));

        jLabel3.setText("Tratamiento :");
        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N

        txtCliente.setEditable(false);
        txtCliente.setMinimumSize(new java.awt.Dimension(64, 24));

        jLabel4.setText("Doctor :");
        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N

        cbxTratamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTratamiento.setPreferredSize(new java.awt.Dimension(72, 24));
        cbxTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTratamientoActionPerformed(evt);
            }
        });

        jLabel7.setText("Fecha - Hora :");
        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N

        btnProgramar.setText("Programar");
        btnProgramar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProgramarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSeleccionarCliente.setText("Seleccionar");
        btnSeleccionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarClienteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel6.setText("Precio:");

        txtPrecio.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(DTPfechahora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(lblRecep, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSeleccionarCliente))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnProgramar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbxTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblRecep))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionarCliente))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(65, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(DTPfechahora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnProgramar)
                            .addComponent(btnCancelar))
                        .addGap(16, 16, 16))))
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

    public void setClienteSeleccionado(String cliente) {
        txtCliente.setText(cliente);
    }


    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSeleccionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarClienteActionPerformed
        Jd_ProgramarCita jdProgramarCita = this;
        Jd_SeleccionarCliente jdSeleccionarCliente = new Jd_SeleccionarCliente(this, true, jdProgramarCita);
        jdSeleccionarCliente.setVisible(true);

    }//GEN-LAST:event_btnSeleccionarClienteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        lblRecep.setText(Jd_IniciarSesion.nombreCompleto);
    }//GEN-LAST:event_formWindowOpened

    private void btnProgramarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProgramarActionPerformed
        try {
            String [] partes =txtCliente.getText().split(" ");
            objC.insertCita(objP.buscarCliente_id(partes[0]), objTR.buscarTratamiento_id(cbxTratamiento.getSelectedItem().toString()), objT.buscarID_Doctor(cbxDoctor.getSelectedItem().toString()),Jd_IniciarSesion.id_usuario , DTPfechahora.getDateTimeStrict(),Integer.parseInt(txtPrecio.getText())); 
            JOptionPane.showMessageDialog(this, "Cita registrada correctamente");
            txtCliente.setText("");
            cbxDoctor.setSelectedIndex(-1);
            cbxTratamiento.setSelectedIndex(-1);
            txtPrecio.setText("");
            DTPfechahora.setDateTimePermissive(LocalDateTime.now());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al insertar cita " + e.getMessage());
        }
    }//GEN-LAST:event_btnProgramarActionPerformed

    private void cbxTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTratamientoActionPerformed
        try {
            txtPrecio.setText(String.valueOf(objTR.precioTratamiento(cbxTratamiento.getSelectedItem().toString())));
        } catch (Exception ex) {
            Logger.getLogger(Jd_ProgramarCita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbxTratamientoActionPerformed
    private void listarDoctores() {
        ResultSet rsDoc = null;
        DefaultComboBoxModel modeloMar = new DefaultComboBoxModel();
        cbxDoctor.setModel(modeloMar);
        try {
            rsDoc = objT.listarDoctores();
            while (rsDoc.next()) {
                modeloMar.addElement(rsDoc.getString("nombre"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar doctores " + e.getMessage());
        }
    }

    private void listarTratamientos() {
        ResultSet rsTra = null;
        DefaultComboBoxModel modeloMar = new DefaultComboBoxModel();
        cbxTratamiento.setModel(modeloMar);
        try {
            rsTra = objTR.listarTratamientos();
            while (rsTra.next()) {
                modeloMar.addElement(rsTra.getString("nombre"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar tratamientos " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DateTimePicker DTPfechahora;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnProgramar;
    private javax.swing.JButton btnSeleccionarCliente;
    private javax.swing.JComboBox<String> cbxDoctor;
    private javax.swing.JComboBox<String> cbxTratamiento;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblRecep;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
