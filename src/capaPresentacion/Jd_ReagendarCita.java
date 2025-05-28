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
import java.awt.Font;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Antonio
 */
public class Jd_ReagendarCita extends javax.swing.JDialog {

    cls_Trabajador objT = new cls_Trabajador();
    cls_Tratamiento objTR = new cls_Tratamiento();
    cls_Cita objC = new cls_Cita();
    cls_Persona objP = new cls_Persona();
    cls_Cliente objCliente = new cls_Cliente();
    private ArrayList<String> doctor_id_array = new ArrayList<>();
    private ArrayList<String> cita_id_array = new ArrayList<>();

    DefaultListModel<String> modelo = new DefaultListModel<>();
    private Jd_ReagendarCita formularioModificarCita;
    private String cliente_id = "";

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static String citaEscogida = "";

    private boolean seleccion = false;

    public Jd_ReagendarCita(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        listarDoctores();
        listarTratamientos();
        DTPFechaHora.setEnabled(false);
        cliente_id = "";
    }

    public void setClienteSeleccionado(String cliente) throws Exception {
        cliente_id = cliente;
        ResultSet rs = objP.buscarPersonaPorID(cliente);
        try {
            while (rs.next()) {
                txtnombre.setText(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
        } catch (Exception e) {
            Logger.getLogger(Jd_ProgramarCita.class.getName()).log(Level.SEVERE, null, e.getMessage());
        }
        listarTabla();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel7.setText("Fecha :");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reagendar Cita");

        jPanel1.setBackground(new java.awt.Color(225, 255, 255));

        jLabel2.setText("Cliente:");
        jLabel2.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 75, 97));

        txtnombre.setEditable(false);
        txtnombre.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color2/right-long-solid.png"))); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setBackground(new java.awt.Color(0, 178, 195));
        btnSeleccionar.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        jLabel4.setText("Doctor :");
        jLabel4.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 75, 97));

        cbxDoctor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxDoctor.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        cbxDoctor.setPreferredSize(new java.awt.Dimension(72, 24));

        jLabel3.setText("Tratamiento :");
        jLabel3.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 75, 97));

        cbxTratamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTratamiento.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        cbxTratamiento.setPreferredSize(new java.awt.Dimension(72, 24));

        jLabel8.setText("Fecha y hora :");
        jLabel8.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 75, 97));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color2/arrows-rotate-solid.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setBackground(new java.awt.Color(0, 178, 195));
        btnActualizar.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnAnular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color2/ban-solid.png"))); // NOI18N
        btnAnular.setText("Anular");
        btnAnular.setBackground(new java.awt.Color(0, 178, 195));
        btnAnular.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnAnular.setForeground(new java.awt.Color(255, 255, 255));
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });

        DTPFechaHora.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        chkReprogramar.setText("Reprogramar");
        chkReprogramar.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        chkReprogramar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkReprogramarActionPerformed(evt);
            }
        });

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(tbl);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(btnSeleccionar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(DTPFechaHora, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(cbxDoctor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(cbxTratamiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chkReprogramar))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnSeleccionar))
                .addGap(21, 21, 21)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cbxDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cbxTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(chkReprogramar))
                        .addGap(18, 18, 18)
                        .addComponent(DTPFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActualizar)
                            .addComponent(btnAnular))
                        .addGap(42, 42, 42))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        DatePickerSettings dateSettings = DTPFechaHora.getDatePicker().getSettings();

        // --- Configuración de FECHA ---
        LocalDate hoy = LocalDate.now();

        // 1. Veto para fechas pasadas (excluyendo hoy)
        dateSettings.setVetoPolicy(date -> date.isBefore(hoy));

        // 2. Rango visual en el calendario (opcional)
        dateSettings.setDateRangeLimits(hoy, null);

        // --- Configuración de HORA (solo si la fecha es hoy) ---
        DTPFechaHora.getTimePicker().addTimeChangeListener(e -> {
            LocalDate fechaSeleccionada = DTPFechaHora.getDatePicker().getDate();
            LocalTime horaSeleccionada = DTPFechaHora.getTimePicker().getTime();

            if (fechaSeleccionada != null && horaSeleccionada != null && fechaSeleccionada.isEqual(LocalDate.now())) {
                // Hora actual redondeada a minutos
                LocalTime ahora = LocalTime.now().withSecond(0).withNano(0);
                if (horaSeleccionada.isBefore(ahora)) {
                    DTPFechaHora.getTimePicker().setTime(null); // Limpiar selección
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
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        //Jd_ReagendarCita jdModificarCita = this;
        Jd_SeleccionarCliente jdSeleccionar = new Jd_SeleccionarCliente(null, true);
        jdSeleccionar.setVisible(true);
        try {
            setClienteSeleccionado(jdSeleccionar.getCliente_id());
        } catch (Exception ex) {
            Logger.getLogger(Jd_ReagendarCita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (txtnombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente");
            return;
        }
        if (!seleccion) {
            JOptionPane.showMessageDialog(this, "Escoja una cita de la lista");
            return;
        }
        try {
            // ─── Datos seleccionados ────────────────────────────────────────────
            int tratamiento_id = objTR.buscarTratamiento_id(cbxTratamiento.getSelectedItem().toString());
            int duracionMin = objTR.duracionTratamiento(tratamiento_id);

            int posDoc = cbxDoctor.getSelectedIndex();
            int doctor_id = Integer.parseInt(doctor_id_array.get(posDoc));

            int cita_id = Integer.parseInt(citaEscogida);

            //  Fecha/hora        
            LocalDateTime nuevaFechaHora;
            if (chkReprogramar.isSelected()) {
                if (DTPFechaHora.getDatePicker().getDate() == null) {
                    JOptionPane.showMessageDialog(this, "Seleccione fecha y hora válidas");
                    return;
                }
                nuevaFechaHora = DTPFechaHora.getDateTimeStrict();
            } else {
                // Si no se reprograma fecha, usamos la hora original de la cita
                String fechaOriginal = tbl.getValueAt(tbl.getSelectedRow(), 3).toString();
                nuevaFechaHora = LocalDateTime.parse(fechaOriginal, formatter);
            }

            // ─── Validar disponibilidad del doctor ─────────────────────────────
            boolean disponible = objC.verificarDisponibilidadDoctor(
                    doctor_id,
                    nuevaFechaHora,
                    duracionMin,
                    cita_id);   //  ← excluye la cita actual
            if (!disponible) {
                JOptionPane.showMessageDialog(this,
                        "El doctor tiene otra cita que se superpone con el horario seleccionado.\n"
                        + "Por favor elija otro horario o profesional.");
                return;
            }

            // ─── Confirmar acción ──────────────────────────────────────────────
            int rpta = JOptionPane.showOptionDialog(this,
                    "¿Estás seguro que deseas modificar tu cita?",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Sí", "No"},
                    "Sí");
            if (rpta != JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, "Operación cancelada");
                return;
            }

            int agendador_id = Jd_IniciarSesion.id_usuario;

            // ─── Actualizar cita ───────────────────────────────────────────────
            if (chkReprogramar.isSelected()) {
                objC.modificarCita(cita_id, doctor_id, tratamiento_id, agendador_id, nuevaFechaHora);
            } else {
                objC.modificarCitaSF(cita_id, doctor_id, tratamiento_id, agendador_id);
            }
            JOptionPane.showMessageDialog(this, "Operación realizada con éxito");

            listarTabla();
            limpiarValores();
            seleccion = false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar cita: " + e.getMessage());
            Logger.getLogger(Jd_ReagendarCita.class.getName()).log(Level.SEVERE, null, e);
        }


    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        if (!seleccion) {
            JOptionPane.showMessageDialog(this, "Escoja una cita de la lista");
            return;
        }
        try {
            int cita_id = Integer.parseInt(citaEscogida);
            int rpta = JOptionPane.showOptionDialog(this,
                    "¿Estás seguro que deseas anular la cita?",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, new Object[]{"Sí", "No"}, "Sí");
            if (rpta == JOptionPane.YES_OPTION) {
                objC.anularCita(cita_id);
                JOptionPane.showMessageDialog(this, "Cita anulada");
                listarTabla();
                limpiarValores();
                seleccion = false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al anular cita: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAnularActionPerformed

    private void chkReprogramarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkReprogramarActionPerformed
        if (chkReprogramar.isSelected()) {
            DTPFechaHora.setEnabled(true);
        } else {
            DTPFechaHora.setEnabled(false);
        }
    }//GEN-LAST:event_chkReprogramarActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        int filaSeleccionada = tbl.getSelectedRow();
        if (filaSeleccionada != -1) {

            cbxDoctor.setSelectedItem(tbl.getValueAt(filaSeleccionada, 2).toString());

            cbxTratamiento.setSelectedItem(tbl.getValueAt(filaSeleccionada, 1).toString());

            String fecha_hora = String.valueOf(tbl.getValueAt(filaSeleccionada, 3));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            LocalDateTime FH = LocalDateTime.parse(fecha_hora, formatter);

            DTPFechaHora.setDateTimeStrict(FH);

            citaEscogida = cita_id_array.get(filaSeleccionada);
            seleccion = true;
        }
    }//GEN-LAST:event_tblMouseClicked

    private void tblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblMouseEntered

    private void listarDoctores() {
        ResultSet rsDoc = null;
        DefaultComboBoxModel modeloMar = new DefaultComboBoxModel();
        cbxDoctor.setModel(modeloMar);
        doctor_id_array.clear();
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

    private void listarTabla() {
        Font fuenteEnca = new Font("Cambria", Font.PLAIN, 14);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cliente");
        modelo.addColumn("Tratamiento");
        modelo.addColumn("Doctor");
        modelo.addColumn("Fecha-Hora");
        modelo.addColumn("Costo");

        String fecha = "";
        cita_id_array.clear(); 

        try {
            ResultSet rs = objC.buscarCitas(cliente_id);
            while (rs.next()) {
                if (rs.getString("reagendada") == null) {
                    fecha = rs.getString("fecha_hora");
                } else {
                    fecha = rs.getString("reagendada");
                }
                modelo.addRow(new Object[]{
                    rs.getString("Nombre_C"),
                    rs.getString("Nombre_T"),
                    rs.getString("Nombre_D"),
                    fecha,
                    rs.getString("costo")
                });
                cita_id_array.add(rs.getString("cita_id"));
            }
            tbl.setModel(modelo); 
            if (tbl.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No hay citas para este paciente");
            }
            tbl.getTableHeader().setReorderingAllowed(false);
            tbl.getTableHeader().setFont(fuenteEnca);

            DefaultTableCellRenderer right = new DefaultTableCellRenderer();
            right.setHorizontalAlignment(SwingConstants.RIGHT);
            tbl.getColumnModel().getColumn(4).setCellRenderer(right);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar citas de cliente: " + e.getMessage());
        }
    }

    private void limpiarValores() {
        cbxDoctor.setSelectedIndex(-1);
        cbxTratamiento.setSelectedIndex(-1);
        DTPFechaHora.setDateTimeStrict(LocalDateTime.now());
        chkReprogramar.setSelected(false);
        DTPFechaHora.setEnabled(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DateTimePicker DTPFechaHora;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
