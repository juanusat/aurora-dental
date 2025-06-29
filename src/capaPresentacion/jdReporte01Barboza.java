/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package capaPresentacion;

import capaNegocio.clsReporte;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JOptionPane;
import net.sf.jasperreports.swing.JRViewer;
import capaNegocio.clsReporte;
import java.awt.BorderLayout;
import java.awt.Container;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextField; // Asumiendo que txtAnio es un JTextField
import javax.swing.JComboBox;  // Asumiendo que cmbMes es un JComboBox

/**
 *
 * @author Ryzen7
 */
public class jdReporte01Barboza extends javax.swing.JDialog {

    /**
     * Creates new form jdReporte02Barboza
     */
    public jdReporte01Barboza(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        verReporte = new javax.swing.JButton();
        vistaReporte = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbMes = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel1.setText("Ganancias por mes y semana");

        verReporte.setBackground(new java.awt.Color(0, 102, 102));
        verReporte.setForeground(new java.awt.Color(204, 255, 255));
        verReporte.setText("Ver Reporte");
        verReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verReporteActionPerformed(evt);
            }
        });

        vistaReporte.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout vistaReporteLayout = new javax.swing.GroupLayout(vistaReporte);
        vistaReporte.setLayout(vistaReporteLayout);
        vistaReporteLayout.setHorizontalGroup(
            vistaReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        vistaReporteLayout.setVerticalGroup(
            vistaReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        jLabel2.setText("INGRESE UN AÑO:");

        jLabel3.setText("MES:");

        cmbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vistaReporte)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                        .addComponent(verReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verReporte)
                    .addComponent(jLabel2)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vistaReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verReporteActionPerformed
        try {
            // 1. Capturar el Año
            String anioStr = txtAnio.getText().trim();
            if (anioStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un año.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Integer anioSeleccionado;
            try {
                anioSeleccionado = Integer.parseInt(anioStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El año debe ser un número válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 2. Capturar el Mes y Convertirlo a Número
            // El índice de JComboBox es 0-based, así que Enero (índice 0) es mes 1, Febrero (índice 1) es mes 2, etc.
            int mesSeleccionado = cmbMes.getSelectedIndex() + 1; // Sumar 1 para obtener el número de mes (1-12)

            // 3. Crear el Mapa de Parámetros
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("AnioSeleccionado", anioSeleccionado); // Asegúrate que el nombre del parámetro coincide con iReport
            parametros.put("MesSeleccionado", mesSeleccionado);   // Asegúrate que el nombre del parámetro coincide con iReport

            // 4. Limpiar el contenedor anterior y establecer el layout
            Container contenedor = this.vistaReporte;
            contenedor.removeAll();
            contenedor.revalidate();
            contenedor.repaint();
            contenedor.setLayout(new BorderLayout());

            // 5. Generar y mostrar el reporte
            // Asegúrate que "reporte01_Barboza.jasper" es el nombre correcto de tu reporte compilado
            // y que el clsReporte está importado correctamente.
            JRViewer objReporte = new clsReporte().reporteInterno("reporte01_Barboza.jasper", parametros);

            if (objReporte != null) {
                contenedor.add(objReporte);
                objReporte.setVisible(true);
                this.vistaReporte.setVisible(true);
            } else {
                // Manejar caso donde el reporte no se pudo generar (ej. JRException atrapada en clsReporte)
                JOptionPane.showMessageDialog(this, "No se pudo generar el reporte. Consulte la consola para más detalles.", "Error de Reporte", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage() + " Error en Reporte", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_verReporteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JButton verReporte;
    private javax.swing.JDesktopPane vistaReporte;
    // End of variables declaration//GEN-END:variables
}
