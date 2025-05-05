package capaPresentacion;

import capaNegocio.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Jd_Gestion_Tratamiento extends javax.swing.JDialog {

    cls_Tratamiento objTrat = new cls_Tratamiento();

    public Jd_Gestion_Tratamiento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarTablaTratamientos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDuracion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        btnNuevo = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTratamientos = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnNuevo1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel2.setText("Nombre:");

        txtNombre.setMinimumSize(new java.awt.Dimension(64, 24));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel4.setText("Duracion:");

        txtDuracion.setMinimumSize(new java.awt.Dimension(64, 24));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel5.setText("Costo:");

        txtCosto.setMinimumSize(new java.awt.Dimension(64, 24));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel6.setText("Duracion:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tblTratamientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTratamientosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTratamientos);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnNuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnNuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1)
                            .addComponent(jSeparator1)
                            .addComponent(jScrollPane2))))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarControles() {
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtDuracion.setText("");
        txtCosto.setText("");
        cargarTablaTratamientos();
    }

    private void cargarTablaTratamientos() {
        try {
            ResultSet rs = objTrat.listarTratamientos();
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Descripcion");
            modelo.addColumn("Duracion");
            modelo.addColumn("Costo");
            tblTratamientos.setModel(modelo);
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("tratamiento_id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getInt("duracion_estimada"),
                    rs.getDouble("costo")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar tratamientos: " + e.getMessage());
        }
    }

    private void cargarTablaTratamientosPorNombre(String nombre) {
        try {
            ResultSet rs = objTrat.buscarTratamientosPorNombre(nombre);
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Descripcion");
            modelo.addColumn("Duracion");
            modelo.addColumn("Costo");
            tblTratamientos.setModel(modelo);
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("tratamiento_id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getInt("duracion_estimada"),
                    rs.getDouble("costo")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar tratamientos por nombre: " + e.getMessage());
        }
    }

    private void cargarDatosPrimerTratamiento(String nombre) {
        try {
            ResultSet rs = objTrat.buscarTratamientosPorNombre(nombre);
            if (rs.next()) {
                txtNombre.setText(rs.getString("nombre"));
                txtDuracion.setText(String.valueOf(rs.getInt("duracion_estimada")));
                txtCosto.setText(String.valueOf(rs.getDouble("costo")));
                txtDescripcion.setText(rs.getString("descripcion"));
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró tratamiento con ese nombre.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos del tratamiento: " + e.getMessage());
        }
    }


    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        try {
            if (btnNuevo.getText().equals("Nuevo")) {
                btnNuevo.setText("Guardar");
                limpiarControles();
                txtNombre.requestFocus();
            } else {
                btnNuevo.setText("Nuevo");
                int cod = objTrat.generarCodigoTratamiento();
                objTrat.registrar(cod, txtNombre.getText(), txtDescripcion.getText(), Integer.parseInt(txtDuracion.getText()), Double.parseDouble(txtCosto.getText()));
                limpiarControles();
                cargarTablaTratamientos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar un tratamiento" + e.getMessage());
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarControles();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tblTratamientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTratamientosMouseClicked
        int filaSeleccionada = tblTratamientos.getSelectedRow();
        if (filaSeleccionada != -1) {
            txtNombre.setText(tblTratamientos.getValueAt(filaSeleccionada, 1).toString());
            txtDescripcion.setText(tblTratamientos.getValueAt(filaSeleccionada, 2).toString());
            txtDuracion.setText(tblTratamientos.getValueAt(filaSeleccionada, 3).toString());
            txtCosto.setText(tblTratamientos.getValueAt(filaSeleccionada, 4).toString());
        }
    }//GEN-LAST:event_tblTratamientosMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        try {
            int filaSeleccionada = tblTratamientos.getSelectedRow();
            if (filaSeleccionada != -1) {
                Integer cod = Integer.parseInt(tblTratamientos.getValueAt(filaSeleccionada, 0).toString());
                objTrat.modificar(cod, txtNombre.getText(), txtDescripcion.getText(), Integer.parseInt(txtDuracion.getText()), Double.parseDouble(txtCosto.getText()));
                limpiarControles();
                cargarTablaTratamientos();
                JOptionPane.showMessageDialog(this, "Tratamiento modificado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un tratamiento de la tabla para modificar.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al modificar el tratamiento: " + e.getMessage());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            int filaSeleccionada = tblTratamientos.getSelectedRow();
            if (filaSeleccionada != -1) {
                Integer cod = Integer.parseInt(tblTratamientos.getValueAt(filaSeleccionada, 0).toString());
                int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este tratamiento?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    objTrat.eliminar(cod);
                    limpiarControles();
                    cargarTablaTratamientos();
                    JOptionPane.showMessageDialog(this, "Tratamiento eliminado correctamente.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un tratamiento de la tabla para eliminar.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar el tratamiento: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo1ActionPerformed
        String nombreBuscar = txtNombre.getText().trim();
        if (!nombreBuscar.isEmpty()) {
            cargarTablaTratamientosPorNombre(nombreBuscar);
            cargarDatosPrimerTratamiento(nombreBuscar);
        } else {
            limpiarControles();
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre para buscar");
        }
    }//GEN-LAST:event_btnNuevo1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevo1;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblTratamientos;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
