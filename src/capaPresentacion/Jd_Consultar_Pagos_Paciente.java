/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package capaPresentacion;

import capaNegocio.cls_Cliente;
import capaNegocio.cls_Pago;
import capaNegocio.cls_Persona;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Antonio
 */
public class Jd_Consultar_Pagos_Paciente extends javax.swing.JDialog {

    cls_Pago objP = new cls_Pago();
    cls_Cliente objCliente = new cls_Cliente();
    cls_Persona objPE = new cls_Persona();
    private String cliente_id = "";

    public Jd_Consultar_Pagos_Paciente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txtNombre.setEnabled(false);
    }

    public void setClienteSeleccionado(String cliente_id_obtenido) throws Exception {
        cliente_id = cliente_id_obtenido;
        ResultSet rs = objPE.buscarPersonaPorID(cliente_id_obtenido);
        try {
            while (rs.next()) {
                txtNombre.setText(rs.getString("nombre") + " " + rs.getString("apellido"));
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
        txtNombre = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Pagos de Paciente");

        jPanel1.setBackground(new java.awt.Color(225, 255, 255));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 75, 97));
        jLabel1.setText("Cliente:");

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N

        btnSeleccionar.setBackground(new java.awt.Color(0, 178, 195));
        btnSeleccionar.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color2/right-long-solid.png"))); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        tbl.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnSeleccionar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
                            .addComponent(jSeparator1))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
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
        Jd_Consultar_Pagos_Paciente jdConsultarPagosP = this;
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
        modelo.addColumn("Emisor");
        modelo.addColumn("Fecha_hora");
        modelo.addColumn("Monto");
        modelo.addColumn("Metodo");
        modelo.addColumn("Estado");
        tbl.setModel(modelo);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tbl.getColumnModel().getColumn(3).setCellRenderer(renderer);
        try {
            ResultSet rs = objP.listarPagosCitasCliente(cliente_id);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString("tratamiento"), rs.getString("emisor"), rs.getString("fecha_hora"), rs.getString("monto"), rs.getString("metodo"), rs.getString("estado")});
            }
            tbl.setModel(modelo);
            if (modelo.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "El paciente no tiene ningun Pago ");
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar pagos de citas del cliente " + e.getMessage());
        }
        tbl.getTableHeader().setReorderingAllowed(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
