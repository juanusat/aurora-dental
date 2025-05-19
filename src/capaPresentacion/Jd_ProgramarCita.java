/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package capaPresentacion;

import capaNegocio.cls_Cita;
import capaNegocio.cls_Cliente;
import capaNegocio.cls_Persona;
import capaNegocio.cls_Trabajador;
import capaNegocio.cls_Tratamiento;
import com.github.lgooddatepicker.components.DatePickerSettings;

import java.sql.ResultSet;
import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
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
    cls_Cliente objCliente = new cls_Cliente();
    private ArrayList<String> doctor_id_array = new ArrayList<>();
    private String cliente_id = "";

    public Jd_ProgramarCita(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        listarDoctores();
        listarTratamientos();
        cliente_id = "";
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
        setTitle("Agendar Cita");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(225, 255, 255));

        jLabel5.setText("Recepcionista:");
        jLabel5.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 75, 97));

        lblRecep.setText("......");
        lblRecep.setFont(new java.awt.Font("Cambria", 0, 15)); // NOI18N

        jLabel2.setText("Cliente:");
        jLabel2.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 75, 97));

        cbxDoctor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxDoctor.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        cbxDoctor.setPreferredSize(new java.awt.Dimension(72, 24));

        jLabel3.setText("Tratamiento:");
        jLabel3.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 75, 97));

        txtCliente.setEditable(false);
        txtCliente.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        jLabel4.setText("Doctor:");
        jLabel4.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 75, 97));

        cbxTratamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTratamiento.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        cbxTratamiento.setPreferredSize(new java.awt.Dimension(72, 24));
        cbxTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTratamientoActionPerformed(evt);
            }
        });

        jLabel7.setText("Fecha - Hora:");
        jLabel7.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 75, 97));

        btnProgramar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color2/calendar-check-solid.png"))); // NOI18N
        btnProgramar.setText("Programar");
        btnProgramar.setBackground(new java.awt.Color(0, 178, 195));
        btnProgramar.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnProgramar.setForeground(new java.awt.Color(255, 255, 255));
        btnProgramar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProgramarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setBackground(new java.awt.Color(0, 178, 195));
        btnCancelar.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSeleccionarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color2/right-long-solid.png"))); // NOI18N
        btnSeleccionarCliente.setText("Seleccionar");
        btnSeleccionarCliente.setBackground(new java.awt.Color(0, 178, 195));
        btnSeleccionarCliente.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnSeleccionarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarClienteActionPerformed(evt);
            }
        });

        jLabel6.setText("Precio:");
        jLabel6.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 75, 97));

        txtPrecio.setEditable(false);
        txtPrecio.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnSeleccionarCliente))
                                .addGap(12, 12, 12)))
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DTPfechahora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRecep, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(btnProgramar)
                                .addGap(51, 51, 51)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblRecep))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionarCliente)
                    .addComponent(jLabel2))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DTPfechahora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProgramar)
                    .addComponent(btnCancelar))
                .addGap(16, 16, 16))
        );

        DatePickerSettings dateSettings = DTPfechahora.getDatePicker().getSettings();

        // --- Configuración de FECHA ---
        LocalDate hoy = LocalDate.now();

        // 1. Veto para fechas pasadas (excluyendo hoy)
        dateSettings.setVetoPolicy(date -> date.isBefore(hoy));

        // 2. Rango visual en el calendario (opcional)
        dateSettings.setDateRangeLimits(hoy, null);

        // --- Configuración de HORA (solo si la fecha es hoy) ---
        DTPfechahora.getTimePicker().addTimeChangeListener(e -> {
            LocalDate fechaSeleccionada = DTPfechahora.getDatePicker().getDate();
            LocalTime horaSeleccionada = DTPfechahora.getTimePicker().getTime();

            if (fechaSeleccionada != null && horaSeleccionada != null && fechaSeleccionada.isEqual(LocalDate.now())) {
                // Hora actual redondeada a minutos
                LocalTime ahora = LocalTime.now().withSecond(0).withNano(0);
                if (horaSeleccionada.isBefore(ahora)) {
                    DTPfechahora.getTimePicker().setTime(null); // Limpiar selección
                    JOptionPane.showMessageDialog(null,
                        "¡No puedes seleccionar horas pasadas para hoy!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setClienteSeleccionado(String cliente) throws Exception {
        cliente_id = cliente;
        ResultSet rs = objP.buscarPersonaPorID(cliente);

        try {
            while (rs.next()) {
                txtCliente.setText(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
        } catch (Exception e) {
            Logger.getLogger(Jd_ProgramarCita.class.getName()).log(Level.SEVERE, null, e.getMessage());
        }
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSeleccionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarClienteActionPerformed
        Jd_ProgramarCita jdRogramarCita = this;
        Jd_SeleccionarCliente jdSeleccionar = new Jd_SeleccionarCliente(null, true);
        jdSeleccionar.setVisible(true);
        try {
            setClienteSeleccionado(jdSeleccionar.getCliente_id());
        } catch (Exception ex) {
            Logger.getLogger(Jd_ProgramarCita.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSeleccionarClienteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        lblRecep.setText(Jd_IniciarSesion.nombreCompleto);
    }//GEN-LAST:event_formWindowOpened

    private void btnProgramarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProgramarActionPerformed
        if (txtCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente");
        } else {
            if (DTPfechahora.getDatePicker().getDate() != null) {
                try {
                    int posDoc = cbxDoctor.getSelectedIndex();
                    String id_Doc = doctor_id_array.get(posDoc);

                    objC.insertCita(Integer.parseInt(cliente_id), objTR.buscarTratamiento_id(cbxTratamiento.getSelectedItem().toString()), Integer.parseInt(id_Doc), Jd_IniciarSesion.id_usuario, DTPfechahora.getDateTimeStrict(), Float.parseFloat(txtPrecio.getText()));
                    System.out.println(Jd_SeleccionarCliente.getNombre());
                    JOptionPane.showMessageDialog(this, "Cita registrada correctamente");
                    limpiar();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al insertar cita " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una fecha - hora");
            }

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
                modeloMar.addElement(rsDoc.getString("nombre") + " " + rsDoc.getString("apellido"));
                doctor_id_array.add(rsDoc.getString("trabajador_id"));

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

    private void limpiar() {
        txtCliente.setText("");
        cbxDoctor.setSelectedIndex(-1);
        cbxTratamiento.setSelectedIndex(-1);
        txtPrecio.setText("");
        DTPfechahora.setDateTimePermissive(LocalDateTime.now());
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
