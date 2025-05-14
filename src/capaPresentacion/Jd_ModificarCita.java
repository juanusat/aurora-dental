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
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Antonio
 */
public class Jd_ModificarCita extends javax.swing.JDialog {

    cls_Trabajador objT = new cls_Trabajador();
    cls_Tratamiento objTR = new cls_Tratamiento();
    cls_Cita objC = new cls_Cita();
    cls_Persona objP = new cls_Persona();
    cls_Cliente objCliente = new cls_Cliente();
    private ArrayList<String> doctor_id_array = new ArrayList<>();
    private ArrayList<String> cita_id_array = new ArrayList<>();

    DefaultListModel<String> modelo = new DefaultListModel<>();
    private Jd_ModificarCita formularioModificarCita;
    private String cliente_id = "";

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static String citaEscogida = "";

    public Jd_ModificarCita(java.awt.Frame parent, boolean modal) {
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Cliente:");
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

        tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(btnSeleccionar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnActualizar)
                                        .addGap(86, 86, 86)
                                        .addComponent(btnAnular))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chkReprogramar))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DTPFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 15, Short.MAX_VALUE)))
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
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cbxDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        Jd_ModificarCita jdModificarCita = this;
        Jd_SeleccionarCliente jdSeleccionar = new Jd_SeleccionarCliente(null, true);
        jdSeleccionar.setVisible(true);
        try {
            setClienteSeleccionado(jdSeleccionar.getCliente_id());
        } catch (Exception ex) {
            Logger.getLogger(Jd_ModificarCita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        try {
            int cl_id = Integer.parseInt(cliente_id);
            
            int tratamiento_id = objTR.buscarTratamiento_id(cbxTratamiento.getSelectedItem().toString());
          
            int posDoc = cbxDoctor.getSelectedIndex(); 
            String id_Doc = doctor_id_array.get(posDoc); 
         
            //----------------------------------------
            
            LocalDateTime fecha = DTPFechaHora.getDateTimeStrict();
            System.out.println(fecha);
            //------------------------------
            int cita_id = objC.buscarCita_id(Integer.parseInt(citaEscogida));
         
            int agendor_id = Jd_IniciarSesion.id_usuario;
       

            if (chkReprogramar.isSelected()) {
                int rpta = JOptionPane.showOptionDialog(this, "¿Estás seguro que deseas modificar tu cita?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, "Sí");
                if (rpta == JOptionPane.YES_OPTION) {
                    objC.modificarCita(cita_id, Integer.parseInt(id_Doc), tratamiento_id, agendor_id, DTPFechaHora.getDateTimeStrict());
                    JOptionPane.showMessageDialog(this, "Operacion Realizada con exito");
                } else {
                    JOptionPane.showMessageDialog(this, "Operacion Cancelada");
                }
                listarTabla();
                limpiarValores();
            } else {
                int rpta = JOptionPane.showOptionDialog(this, "¿Estás seguro que deseas modificar tu cita?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, "Sí");

                if (rpta == JOptionPane.YES_OPTION) {
                    objC.modificarCitaSF(cita_id, Integer.parseInt(id_Doc), tratamiento_id, agendor_id);
                    JOptionPane.showMessageDialog(this, "Operacion Realizada con exito");
                } else {
                    JOptionPane.showMessageDialog(this, "Operacion Cancelada");
                }
                listarTabla();
                limpiarValores();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar cita " + e.getMessage());
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed

        try {
            int cl_id = Integer.parseInt(cliente_id);
            LocalDateTime fecha = DTPFechaHora.getDateTimeStrict();
            int cita_id = objC.buscarCita_id(Integer.parseInt(citaEscogida));
            int rpta = JOptionPane.showOptionDialog(this, "¿Estás seguro que deseas modificar tu cita?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, "Sí");
            if (rpta == JOptionPane.YES_OPTION) {
                objC.anularCita(cita_id);
                JOptionPane.showMessageDialog(this, "Cita Anulada");
                listarTabla();
                limpiarValores();
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

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        int filaSeleccionada = tbl.getSelectedRow();
        if (filaSeleccionada != -1) {
            
            cbxDoctor.setSelectedItem(tbl.getValueAt(filaSeleccionada, 2).toString());
            
            cbxTratamiento.setSelectedItem(tbl.getValueAt(filaSeleccionada, 1).toString());
            
            String fecha_hora = String.valueOf(tbl.getValueAt(filaSeleccionada, 3));
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            
            LocalDateTime FH = LocalDateTime.parse(fecha_hora, formatter);
            
            DTPFechaHora.setDateTimeStrict(FH); 
            
            citaEscogida=cita_id_array.get(filaSeleccionada); 
           
        }
    }//GEN-LAST:event_tblMouseClicked
    
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
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cliente");
        modelo.addColumn("Tratamiento");
        modelo.addColumn("Doctor");
        modelo.addColumn("Fecha-Hora");
        modelo.addColumn("Costo");
        
        String fecha=""; 

        try {
            ResultSet rs = objC.buscarCitas(cliente_id);
            while (rs.next()) {
                if (rs.getString("reagendada") == null) {
                    fecha = rs.getString("fecha_hora");
                }else{
                    fecha = rs.getString("reagendada");
                }
                
                modelo.addRow(new Object[]{rs.getString("Nombre_C"), rs.getString("Nombre_T"), rs.getString("Nombre_D"), fecha, rs.getString("costo")});
              
                cita_id_array.add(rs.getString("cita_id"));
            }
            if (tbl.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No hay citas para este paciente");
            }
            tbl.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar citas de cliente " + e.getMessage());
        }
    }
    
    private void limpiarValores(){
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
