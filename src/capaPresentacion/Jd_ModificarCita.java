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
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonio
 */
public class Jd_ModificarCita extends javax.swing.JDialog {

    cls_Trabajador objT = new cls_Trabajador();
    cls_Tratamiento objTR = new cls_Tratamiento();
    cls_Cita objC = new cls_Cita();
    cls_Persona objP = new cls_Persona();
    cls_Cliente objCL = new cls_Cliente();

    DefaultListModel<String> modelo = new DefaultListModel<>();
    private Jd_ModificarCita formularioModificarCita;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static String citaEscogida = "";

    public Jd_ModificarCita(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        listarDoctores();
        listarTratamientos();
        DTPFechaHora.setEnabled(false);
    }

    public void setClienteSeleccionado(String cliente) {
        System.out.println("cliente : " + cliente);
        txtnombre.setText(cliente);
        listarCitas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbxDoctor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxTratamiento = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnAnular = new javax.swing.JButton();
        DTPFechaHora = new com.github.lgooddatepicker.components.DateTimePicker();
        chkReprogramar = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        Lista = new javax.swing.JList<>();

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel7.setText("Fecha :");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar Cita");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Nombre:");
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N

        txtnombre.setEditable(false);
        txtnombre.setMinimumSize(new java.awt.Dimension(64, 24));

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        jLabel4.setText("Doctor :");
        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N

        cbxDoctor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxDoctor.setPreferredSize(new java.awt.Dimension(72, 24));

        jLabel3.setText("Tratamiento :");
        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N

        cbxTratamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTratamiento.setPreferredSize(new java.awt.Dimension(72, 24));

        jLabel8.setText("Fecha y hora :");
        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnAnular.setText("Anular");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });

        chkReprogramar.setText("Reprogramar");
        chkReprogramar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkReprogramarActionPerformed(evt);
            }
        });

        Lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Lista);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnSeleccionar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnActualizar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAnular))
                                    .addComponent(DTPFechaHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(chkReprogramar))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxDoctor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxTratamiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 59, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(chkReprogramar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DTPFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActualizar)
                            .addComponent(btnAnular)))
                    .addComponent(jScrollPane1))
                .addGap(36, 36, 36))
        );

        DatePickerSettings dateSettings = DTPFechaHora.getDatePicker().getSettings();

        // --- Configuración de FECHA ---
        LocalDate hoy = LocalDate.now();

        // 1. Veto para fechas pasadas (excluyendo hoy)
        DTPFechaHora.getDatePicker().getSettings().setVetoPolicy(date -> {
            boolean esPasada = date.isBefore(hoy);
            System.out.println("[DEBUG] Fecha evaluada: " + date + " - ¿Vetada? " + esPasada);
            return esPasada;
        });

        // 2. Rango visual en el calendario (opcional)
        DTPFechaHora.getDatePicker().getSettings().setDateRangeLimits(hoy, null);

        // --- Configuración de HORA (solo si la fecha es hoy) ---
        DTPFechaHora.getTimePicker().addTimeChangeListener(e -> {
            LocalDate fechaSeleccionada = DTPFechaHora.getDatePicker().getDate();
            LocalTime horaSeleccionada = DTPFechaHora.getTimePicker().getTime();

            if (fechaSeleccionada != null && horaSeleccionada != null && fechaSeleccionada.isEqual(hoy)) {
                LocalTime ahora = LocalTime.now();
                if (horaSeleccionada.isBefore(ahora)) {
                    // Vetar hora pasada para hoy
                    DTPFechaHora.getTimePicker().setTime(null); // Limpiar selección
                    System.out.println("[DEBUG] Hora vetada: " + horaSeleccionada + " (Hora actual: " + ahora + ")");
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

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        Jd_ModificarCita jdModificarCita = this;
        Jd_SeleccionarCliente jdSeleccionarCliente = new Jd_SeleccionarCliente(this, true, jdModificarCita);
        jdSeleccionarCliente.setVisible(true);
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void ListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaMouseClicked
        if (evt.getClickCount() == 2) {
            int indiceSeleccionado = Lista.locationToIndex(evt.getPoint());
            String clienteSeleccionado = modelo.getElementAt(indiceSeleccionado);
            citaEscogida = clienteSeleccionado;
            if (formularioModificarCita != null) {
                formularioModificarCita.citaEscogida = citaEscogida;
            }
        }
        System.out.println(citaEscogida);
        enviarValores();

    }//GEN-LAST:event_ListaMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        String[] partes = citaEscogida.split(" / ");
        try {
            int cliente_id = objP.buscarCliente_id(partes[0]);
            int tratamiento_id = objTR.buscarTratamiento_id(cbxTratamiento.getSelectedItem().toString());
            int doctor_id = objT.buscarID_Doctor(cbxDoctor.getSelectedItem().toString());
            LocalDateTime fecha = LocalDateTime.parse(partes[3], formatter);
            int cita_id = objC.buscarCita_id(cliente_id, fecha);
            String nombreRec = Jd_IniciarSesion.nombreCompleto;
            String[] NomRec = nombreRec.split(" ");
            int agendor_id = objT.buscarID_Recepcionista(NomRec[0]);

            if (chkReprogramar.isSelected()) {
                int rpta = JOptionPane.showConfirmDialog(this, "¿Estas seguro que deseas modificar tu cita?", "Panel de confirmarcion", JOptionPane.YES_NO_CANCEL_OPTION);
                if (rpta == JOptionPane.YES_OPTION) {
                    objC.modificarCita(cita_id, doctor_id, tratamiento_id, agendor_id, DTPFechaHora.getDateTimeStrict());
                    JOptionPane.showMessageDialog(this, "Operacion Realizada con exito");
                } else {
                    JOptionPane.showMessageDialog(this, "Operacion Cancelada");
                }
            } else {
                int rpta = JOptionPane.showConfirmDialog(this, "¿Estas seguro que deseas modificar tu cita?", "Panel de confirmarcion", JOptionPane.YES_NO_CANCEL_OPTION);
                if (rpta == JOptionPane.YES_OPTION) {
                    objC.modificarCitaSF(cita_id, doctor_id, tratamiento_id, agendor_id);
                    JOptionPane.showMessageDialog(this, "Operacion Realizada con exito");
                } else {
                    JOptionPane.showMessageDialog(this, "Operacion Cancelada");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar cita " + e.getMessage());
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        String[] partes = citaEscogida.split(" / ");
        try {
            int cliente_id = objP.buscarCliente_id(partes[0]);
            LocalDateTime fecha = LocalDateTime.parse(partes[3], formatter);
            int cita_id = objC.buscarCita_id(cliente_id, fecha);

            int rpta = JOptionPane.showConfirmDialog(this, "¿Estas seguro que deseas anular tu cita?", "Panel de confirmarcion", JOptionPane.YES_NO_CANCEL_OPTION);
            if (rpta == JOptionPane.YES_OPTION) {
                objC.anularCita(cita_id);
                JOptionPane.showMessageDialog(this, "Cita Anulada");
                listarCitas();
            } else {
                JOptionPane.showMessageDialog(this, "Operacion Cancelada");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnAnularActionPerformed

    private void chkReprogramarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkReprogramarActionPerformed
        if (chkReprogramar.isSelected()) {
            DTPFechaHora.setEnabled(true);
        } else {
            DTPFechaHora.setEnabled(false);
        }
    }//GEN-LAST:event_chkReprogramarActionPerformed
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

    private void listarCitas() {
        modelo.clear(); //limpia lista anterior
        Lista.setModel(modelo); //llena lista

        try {
            String[] partes = txtnombre.getText().split(" ");
            ResultSet rs = objC.buscarCitas(partes[0]);
            System.out.println(rs);
            while (rs.next()) {
                String cita = rs.getString("Nombre_C") + " / " + rs.getString("Nombre_T") + " / " + rs.getString("Nombre_D") + " / " + rs.getString("fecha_hora") + " / " + rs.getString("costo");
                modelo.addElement(cita);
            }
            Lista.setModel(modelo);
            if (modelo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay citas para este paciente");
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar citas de cliente " + e.getMessage());
        }
    }

    private void enviarValores() {
        String[] partes = citaEscogida.split(" / ");

        cbxTratamiento.setSelectedItem(partes[1]);
        cbxDoctor.setSelectedItem(partes[2]);
        LocalDateTime fecha = LocalDateTime.parse(partes[3], formatter);
        DTPFechaHora.setDateTimePermissive(fecha);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DateTimePicker DTPFechaHora;
    private javax.swing.JList<String> Lista;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<String> cbxDoctor;
    private javax.swing.JComboBox<String> cbxTratamiento;
    private javax.swing.JCheckBox chkReprogramar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
