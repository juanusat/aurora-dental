/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package capaPresentacion;

import capaNegocio.cls_Cliente;
import capaNegocio.cls_Pago;
import capaNegocio.cls_Persona;
import static capaPresentacion.Jd_ReagendarCita.citaEscogida;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Antonio
 */
public class Jd_RegistrarPago extends javax.swing.JDialog {

    public static String metodo;
    public static String cita;
    DefaultListModel<String> modelo = new DefaultListModel<>();
    private Jd_RegistrarPago formularioRegistrarPago;
    cls_Pago objP = new cls_Pago();
    cls_Cliente objCliente = new cls_Cliente();
    cls_Persona objPE = new cls_Persona();
    private String cliente_id = "";
    private boolean seleccion = false;

    public Jd_RegistrarPago(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        btnG.add(rbtnCredito);
        btnG.add(rbtnDebito);
        btnG.add(rbtnEfectivo);
        btnG.add(rbtnTransferencia);
        txtNombre.setEnabled(false);
        cliente_id = "";
    }

    public void setClienteSeleccionado(String cliente) throws Exception {
        cliente_id = cliente;
        ResultSet rs = objPE.buscarPersonaPorID(cliente);
        try {
            while (rs.next()) {
                txtNombre.setText(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
        } catch (Exception e) {
            Logger.getLogger(Jd_ProgramarCita.class.getName()).log(Level.SEVERE, null, e.getMessage());
        }
        listarTabla();
    }

    private void listarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cita_id");
        modelo.addColumn("Tratamiento");
        modelo.addColumn("NomDoctor");
        modelo.addColumn("Fecha");
        modelo.addColumn("Costo");
        modelo.addColumn("Estado");
        modelo.addColumn("Monto_pagado");
        try {
            ResultSet rs = objP.buscarCitasconMontoPagado(cliente_id);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString("cita_id"), rs.getString("tratamiento"), rs.getString("doctor"), rs.getString("fecha"), rs.getString("costo"), rs.getString("estado"), rs.getString("monto_pagado")});
            }
            tbl.setModel(modelo);
            if (tbl.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No hay citas para este paciente");
            }
            tbl.getTableHeader().setReorderingAllowed(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar citas de cliente " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnG = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEmisor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rbtnCredito = new javax.swing.JRadioButton();
        rbtnDebito = new javax.swing.JRadioButton();
        rbtnTransferencia = new javax.swing.JRadioButton();
        rbtnEfectivo = new javax.swing.JRadioButton();
        btnPagar = new javax.swing.JButton();
        spinMonto = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Pago");

        jPanel1.setBackground(new java.awt.Color(225, 255, 255));

        jLabel1.setText("Cliente:");
        jLabel1.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 75, 97));

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

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

        jLabel2.setText("Monto:");
        jLabel2.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 75, 97));

        jLabel3.setText("Emisor:");
        jLabel3.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 75, 97));

        txtEmisor.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        jLabel4.setText("Método de pago:");
        jLabel4.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 75, 97));

        rbtnCredito.setText("Crédito");
        rbtnCredito.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        rbtnCredito.setForeground(new java.awt.Color(0, 75, 97));
        rbtnCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCreditoActionPerformed(evt);
            }
        });

        rbtnDebito.setText("Débito");
        rbtnDebito.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        rbtnDebito.setForeground(new java.awt.Color(0, 75, 97));
        rbtnDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnDebitoActionPerformed(evt);
            }
        });

        rbtnTransferencia.setText("Transferencia");
        rbtnTransferencia.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        rbtnTransferencia.setForeground(new java.awt.Color(0, 75, 97));
        rbtnTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTransferenciaActionPerformed(evt);
            }
        });

        rbtnEfectivo.setText("Efectivo");
        rbtnEfectivo.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        rbtnEfectivo.setForeground(new java.awt.Color(0, 75, 97));
        rbtnEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnEfectivoActionPerformed(evt);
            }
        });

        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color2/money-check-dollar-solid.png"))); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.setBackground(new java.awt.Color(0, 178, 195));
        btnPagar.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(255, 255, 255));
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        spinMonto.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

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
        });
        jScrollPane2.setViewportView(tbl);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmisor)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(33, 33, 33))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbtnTransferencia)
                                    .addComponent(rbtnCredito))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbtnDebito)
                                    .addComponent(rbtnEfectivo))
                                .addGap(58, 58, 58))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spinMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4))
                                .addGap(172, 172, 172))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addGap(33, 33, 33))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar))
                .addGap(21, 21, 21)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtEmisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(spinMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnCredito)
                            .addComponent(rbtnDebito))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnTransferencia)
                            .addComponent(rbtnEfectivo))
                        .addGap(52, 52, 52)
                        .addComponent(btnPagar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        Jd_RegistrarPago jdRegistrarPago = this;
        Jd_SeleccionarCliente jdSeleccionar = new Jd_SeleccionarCliente(null, true);
        jdSeleccionar.setVisible(true);
        try {
            setClienteSeleccionado(jdSeleccionar.getCliente_id());
        } catch (Exception ex) {
            Logger.getLogger(Jd_RegistrarPago.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        if (seleccion == true) {
            try {
                if ("".equals(txtEmisor.getText()) || (!rbtnCredito.isSelected() && !rbtnDebito.isSelected() && !rbtnEfectivo.isSelected() && !rbtnTransferencia.isSelected())) {
                    JOptionPane.showMessageDialog(this, "Escoja una cita");
                } else {
                    if (cita == "") {
                        JOptionPane.showMessageDialog(this, "Completo el campo o el metodo");
                    } else {
                        objP.registrarPago(Integer.parseInt(cita), txtEmisor.getText(), ((Number) spinMonto.getValue()).floatValue(), metodo);
                        JOptionPane.showMessageDialog(this, "Pago realizado con exito");
                        txtEmisor.setText("");
                        listarTabla();
                        seleccion = false;
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al registar pago " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente");
        }

    }//GEN-LAST:event_btnPagarActionPerformed

    private void rbtnCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCreditoActionPerformed
        if (rbtnCredito.isSelected()) {
            metodo = "credito";
        }
    }//GEN-LAST:event_rbtnCreditoActionPerformed

    private void rbtnDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnDebitoActionPerformed
        if (rbtnDebito.isSelected()) {
            metodo = "debito";
        }
    }//GEN-LAST:event_rbtnDebitoActionPerformed

    private void rbtnTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTransferenciaActionPerformed
        if (rbtnTransferencia.isSelected()) {
            metodo = "transferencia";

        }
    }//GEN-LAST:event_rbtnTransferenciaActionPerformed

    private void rbtnEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnEfectivoActionPerformed
        if (rbtnEfectivo.isSelected()) {
            metodo = "efectivo";
        }
    }//GEN-LAST:event_rbtnEfectivoActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        int filaSeleccionada = tbl.getSelectedRow();
        if (filaSeleccionada != -1) {
            cita = (String) tbl.getValueAt(filaSeleccionada, 0);
            calcularMaxPago(filaSeleccionada);
            seleccion = true;
        }
    }//GEN-LAST:event_tblMouseClicked
    public void calcularMaxPago(int fila) {
        float costo = Float.parseFloat((String) tbl.getValueAt(fila, 4));
        float monto_pagado = Float.parseFloat((String) tbl.getValueAt(fila, 6));
        float max = costo - monto_pagado;

        SpinnerNumberModel modelo;

        if (max > 0) {
            modelo = new SpinnerNumberModel(max, 0, max, 10);
            rbtnCredito.setEnabled(true);
            rbtnDebito.setEnabled(true);
            rbtnEfectivo.setEnabled(true);
            rbtnTransferencia.setEnabled(true);
        } else {
            modelo = new SpinnerNumberModel(0, 0, 0, 10);
            JOptionPane.showMessageDialog(this, "Esta cita ya está pagada en su totalidad");
            rbtnCredito.setEnabled(false);
            rbtnDebito.setEnabled(false);
            rbtnEfectivo.setEnabled(false);
            rbtnTransferencia.setEnabled(false);
        }
        spinMonto.setModel(modelo);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnG;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rbtnCredito;
    private javax.swing.JRadioButton rbtnDebito;
    private javax.swing.JRadioButton rbtnEfectivo;
    private javax.swing.JRadioButton rbtnTransferencia;
    private javax.swing.JSpinner spinMonto;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtEmisor;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
