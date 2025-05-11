/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package capaPresentacion;

import capaNegocio.cls_Pago;
import static capaPresentacion.Jd_ModificarCita.citaEscogida;
import java.sql.ResultSet;
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

    public Jd_RegistrarPago(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        btnG.add(rbtnCredito);
        btnG.add(rbtnDebito);
        btnG.add(rbtnEfectivo);
        btnG.add(rbtnTransferencia);
        txtNombre.setEnabled(false);
    }

    public void setClienteSeleccionado(String cliente) {
        txtNombre.setText(cliente);
        listarCitas();
    }

    private void listarCitas() {
        modelo.clear(); //limpia lista anterior
        List1.setModel(modelo); //llena lista

        try {
            String[] partes = txtNombre.getText().split(" ");
            ResultSet rs = objP.buscarCitasconMontoPagado(partes[0], partes[1]);
            System.out.println(rs);
            while (rs.next()) {
                String cita = rs.getString("cita_id") + " / " + rs.getString("tratamiento") + " / " + rs.getString("doctor") + " / " + rs.getString("fecha") + " / " + rs.getString("costo") + " / " + rs.getString("estado") + " / " + rs.getString("monto_pagado");
                modelo.addElement(cita);
            }
            List1.setModel(modelo);
            if (modelo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay citas para este paciente");
            }
            rs.close();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        List1 = new javax.swing.JList<>();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Pago");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Cliente:");

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        List1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                List1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(List1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Monto:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Emisor:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Metodo de pago:");

        rbtnCredito.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbtnCredito.setText("Credito");
        rbtnCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCreditoActionPerformed(evt);
            }
        });

        rbtnDebito.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbtnDebito.setText("Debito");
        rbtnDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnDebitoActionPerformed(evt);
            }
        });

        rbtnTransferencia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbtnTransferencia.setText("Transferencia");
        rbtnTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTransferenciaActionPerformed(evt);
            }
        });

        rbtnEfectivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbtnEfectivo.setText("Efectivo");
        rbtnEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnEfectivoActionPerformed(evt);
            }
        });

        btnPagar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbtnCredito)
                                    .addComponent(rbtnTransferencia))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbtnEfectivo)
                                    .addComponent(rbtnDebito)))
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spinMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmisor, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(52, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPagar)
                        .addGap(37, 37, 37))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtEmisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(spinMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnCredito)
                            .addComponent(rbtnDebito))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnTransferencia)
                            .addComponent(rbtnEfectivo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPagar)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

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
        Jd_RegistrarPago jdRegistrarPago = this;
        Jd_SeleccionarCliente jdSeleccionar = new Jd_SeleccionarCliente(this, true, jdRegistrarPago);
        jdSeleccionar.setInterfazPadre("registrarPago");
        jdSeleccionar.setVisible(true);
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void List1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_List1MouseClicked

        if (evt.getClickCount() == 1) {
            int indiceSeleccionado = List1.locationToIndex(evt.getPoint());
            String clienteSeleccionado = modelo.getElementAt(indiceSeleccionado);
            cita = clienteSeleccionado;
            System.out.println(cita);
            if (formularioRegistrarPago != null) {
                formularioRegistrarPago.cita = cita;
            }
        }
        calcularMaxPago();

    }//GEN-LAST:event_List1MouseClicked

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        try {
            if ("".equals(txtEmisor.getText()) || (!rbtnCredito.isSelected() && !rbtnDebito.isSelected() && !rbtnEfectivo.isSelected() && !rbtnTransferencia.isSelected())) {
                JOptionPane.showMessageDialog(this, "Escoja una cita");
            } else {
                if (cita == "") {

                    JOptionPane.showMessageDialog(this, "Completo el campo o el metodo");
                } else {
                    String[] partes = cita.split(" / ");
                    objP.registrarPago(Integer.parseInt(partes[0]), txtEmisor.getText(), ((Number) spinMonto.getValue()).floatValue(), metodo);
                    JOptionPane.showMessageDialog(this, "Pago realizado con exito");
                    txtEmisor.setText("");
                    listarCitas();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registar pago " + e.getMessage());
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
    public void calcularMaxPago() {
        String[] partes = cita.split(" / ");
        float costo = Float.parseFloat(partes[4]);
        float monto_pagado = Float.parseFloat(partes[6]);
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
    private javax.swing.JList<String> List1;
    private javax.swing.ButtonGroup btnG;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnCredito;
    private javax.swing.JRadioButton rbtnDebito;
    private javax.swing.JRadioButton rbtnEfectivo;
    private javax.swing.JRadioButton rbtnTransferencia;
    private javax.swing.JSpinner spinMonto;
    private javax.swing.JTextField txtEmisor;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
