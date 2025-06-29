/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package capaPresentacion;

import capaNegocio.clsReporte;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author RICARDO
 */
public class jdReporte08Saavedra extends javax.swing.JDialog {

    /**
     * Creates new form jdReporte08Saavedra
     */
    public jdReporte08Saavedra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.vistaReporte.setVisible(false);
        cargarCombo();
    }

    private void cargarCombo() {
        ResultSet rs = null;
        try {
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            cmbCantidadCitas.setModel(modelo);
            modelo.addElement("--Seleccione--");
            for (int i = 1; i <= 9; i++) {
                modelo.addElement(i);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        verReporte = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbCantidadCitas = new javax.swing.JComboBox<>();
        vistaReporte = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte 08");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        verReporte.setBackground(new java.awt.Color(153, 0, 153));
        verReporte.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        verReporte.setForeground(new java.awt.Color(255, 255, 255));
        verReporte.setText("Ver reporte");
        verReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verReporteActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingrese la cantidad que requiere listar para los odontólogos con más citas agendadas:");

        cmbCantidadCitas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione--" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cmbCantidadCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(verReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verReporte)
                    .addComponent(jLabel1)
                    .addComponent(cmbCantidadCitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout vistaReporteLayout = new javax.swing.GroupLayout(vistaReporte);
        vistaReporte.setLayout(vistaReporteLayout);
        vistaReporteLayout.setHorizontalGroup(
            vistaReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        vistaReporteLayout.setVerticalGroup(
            vistaReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(vistaReporte)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vistaReporte)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verReporteActionPerformed
        // TODO add your handling code here:
        try {
            String cant = cmbCantidadCitas.getSelectedItem().toString();
            if (cant.equalsIgnoreCase("--Seleccione--")) {
                JOptionPane.showMessageDialog(this, "Primero debe seleccionar una cantidad", "Sistema", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    Container contenedor = this.vistaReporte;
                    contenedor.removeAll();
                    contenedor.revalidate();
                    contenedor.repaint();

                    contenedor.setLayout(new BorderLayout());

                    Map parametros = new HashMap();
                    parametros.put("parLimit", Integer.parseInt(cmbCantidadCitas.getSelectedItem().toString()));

                    JRViewer objReporte = new clsReporte().reporteInterno("reporte08_Saavedra.jasper", parametros);
                    contenedor.add(objReporte);
                    objReporte.setVisible(true);
                    this.vistaReporte.setVisible(true);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage() + " ERROR en Reporte", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_verReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbCantidadCitas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton verReporte;
    private javax.swing.JDesktopPane vistaReporte;
    // End of variables declaration//GEN-END:variables
}
