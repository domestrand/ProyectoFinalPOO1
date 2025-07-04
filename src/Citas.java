import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.ArrayList;


public class Citas extends javax.swing.JFrame {

    public Citas() 
    {
        initComponents();
        setLocationRelativeTo(null);
        mostrarCitas();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCitas = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cbxFiltroEstado = new javax.swing.JComboBox<>();
        btnFiltrar = new javax.swing.JButton();
        txtFiltroFecha = new javax.swing.JTextField();
        txtFiltroMedico = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtFiltroID = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnCancelarCita = new javax.swing.JButton();
        btnFinalizarCita = new javax.swing.JButton();
        btnEliminarCita = new javax.swing.JButton();
        btnAtrasCitas = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnAgendarCitas = new javax.swing.JButton();

        jLabel12.setBackground(new java.awt.Color(255, 0, 0));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("Filtrar por el ID del Paciente");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        tblCitas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblCitas);

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("CITAS");
        jLabel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));

        jPanel1.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.GreyInline"));

        cbxFiltroEstado.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.GreyInline"));
        cbxFiltroEstado.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbxFiltroEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Agendada", "Finalizada", "Cancelada" }));

        btnFiltrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.setBorder(null);
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        txtFiltroFecha.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.GreyInline"));
        txtFiltroFecha.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtFiltroFecha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtFiltroFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroFechaActionPerformed(evt);
            }
        });

        txtFiltroMedico.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.GreyInline"));
        txtFiltroMedico.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtFiltroMedico.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtFiltroMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroMedicoActionPerformed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(255, 0, 0));
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("FILTRACIÓN");
        jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));

        txtFiltroID.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.GreyInline"));
        txtFiltroID.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtFiltroID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtFiltroID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroIDActionPerformed(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(255, 0, 0));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Filtrar por el ID del Paciente");

        jLabel16.setBackground(new java.awt.Color(255, 0, 0));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Filtrar por Estado");

        jLabel17.setBackground(new java.awt.Color(255, 0, 0));
        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Filtrar por Fecha");

        jLabel18.setBackground(new java.awt.Color(255, 0, 0));
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Filtrar por Medico");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel14)
                        .addComponent(txtFiltroFecha, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtFiltroID, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addComponent(jLabel16)
                        .addComponent(cbxFiltroEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFiltroMedico)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel14)
                .addGap(25, 25, 25)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(txtFiltroID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtFiltroFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(cbxFiltroEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(txtFiltroMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        btnCancelarCita.setBackground(new java.awt.Color(0, 204, 255));
        btnCancelarCita.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancelarCita.setText("Cancelar");
        btnCancelarCita.setBorder(null);
        btnCancelarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCitaActionPerformed(evt);
            }
        });

        btnFinalizarCita.setBackground(new java.awt.Color(0, 204, 255));
        btnFinalizarCita.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnFinalizarCita.setText("Finalizar");
        btnFinalizarCita.setBorder(null);
        btnFinalizarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarCitaActionPerformed(evt);
            }
        });

        btnEliminarCita.setBackground(new java.awt.Color(0, 204, 255));
        btnEliminarCita.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEliminarCita.setText("Eliminar");
        btnEliminarCita.setBorder(null);
        btnEliminarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnCancelarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFinalizarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnEliminarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFinalizarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnAtrasCitas.setBackground(new java.awt.Color(0, 204, 255));
        btnAtrasCitas.setForeground(new java.awt.Color(102, 255, 255));
        btnAtrasCitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        btnAtrasCitas.setBorder(null);
        btnAtrasCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasCitasActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("HOSPITAL MANUEL AREVALO");

        btnAgendarCitas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAgendarCitas.setText("Agendar Citas");
        btnAgendarCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarCitasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(176, 176, 176))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAtrasCitas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgendarCitas)
                .addGap(17, 17, 17))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgendarCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtrasCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnAtrasCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasCitasActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasCitasActionPerformed

    private void txtFiltroIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroIDActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        String idPacienteTexto = txtFiltroID.getText().trim();
        String estadoSeleccionado = cbxFiltroEstado.getSelectedItem().toString();
        String fechaTexto = txtFiltroFecha.getText().trim();
        String medicoTexto = txtFiltroMedico.getText().trim();
        String sql = "SELECT c.fechaCita, c.hora, c.motivo, c.idpacientes, " + "CONCAT(m.nomMedico, ' ', m.apeMedico) AS medicoNombre, c.estado " + "FROM citas c " + "JOIN medicos m ON c.idmedicos = m.idmedicos " + "WHERE 1=1";

        List<Object> parametros = new ArrayList<>();

        if (!idPacienteTexto.isEmpty()) 
        {
            sql += " AND c.idpacientes = ?";
            parametros.add(Integer.parseInt(idPacienteTexto));
        }

        if (!estadoSeleccionado.equals("Todos")) 
        {
            sql += " AND c.estado = ?";
            parametros.add(estadoSeleccionado);
        }

        if (!fechaTexto.isEmpty()) 
        {
            sql += " AND c.fechaCita = ?";
            parametros.add(fechaTexto);
        }

        if (!medicoTexto.isEmpty()) 
        {
            sql += " AND CONCAT(m.nomMedico, ' ', m.apeMedico) LIKE ?";
            parametros.add("%" + medicoTexto + "%");
        }

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Fecha exacta");
        modelo.addColumn("Hora");
        modelo.addColumn("Motivo");
        modelo.addColumn("ID del Paciente");
        modelo.addColumn("Médico");
        modelo.addColumn("Estado");
        tblCitas.setModel(modelo);

        try 
        {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            for (int i = 0; i < parametros.size(); i++) 
            {
                ps.setObject(i + 1, parametros.get(i));
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) 
            {
                String fecha = rs.getString("fechaCita");
                String hora = rs.getString("hora");
                String motivo = rs.getString("motivo");
                String idPaciente = rs.getString("idpacientes");
                String medico = rs.getString("medicoNombre");
                String estado = rs.getString("estado");
                modelo.addRow(new Object[]{fecha, hora, motivo, idPaciente, medico, estado});
            }

            rs.close();
            ps.close();
            con.close();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnCancelarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCitaActionPerformed
        int fila = tblCitas.getSelectedRow();

        if (fila == -1) 
        {
            JOptionPane.showMessageDialog(this, "Selecciona una cita para cancelar.");
            return;
        }

        String fecha = tblCitas.getValueAt(fila, 0).toString();
        String hora = tblCitas.getValueAt(fila, 1).toString();
        int idPaciente = Integer.parseInt(tblCitas.getValueAt(fila, 3).toString());

        try 
        {
            Connection con = Conexion.conectar();
            String sql = "UPDATE citas SET estado = 'Cancelada' WHERE fechaCita = ? AND hora = ? AND idpacientes = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fecha);
            ps.setString(2, hora);
            ps.setInt(3, idPaciente);
            ps.executeUpdate();
            ps.close();
            con.close();
            
            JOptionPane.showMessageDialog(this, "Cita cancelada.");
            mostrarCitas();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCancelarCitaActionPerformed

    private void btnEliminarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCitaActionPerformed
        int fila = tblCitas.getSelectedRow();

        if (fila == -1) 
        {
            JOptionPane.showMessageDialog(this, "Selecciona una cita para eliminar.");
            return;
        }

        String fecha = tblCitas.getValueAt(fila, 0).toString();
        String hora = tblCitas.getValueAt(fila, 1).toString();
        int idPaciente = Integer.parseInt(tblCitas.getValueAt(fila, 3).toString());
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar esta cita?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) 
        {
            try 
            {
                Connection con = Conexion.conectar();
                String sql = "DELETE FROM citas WHERE fechaCita = ? AND hora = ? AND idpacientes = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, fecha);
                ps.setString(2, hora);
                ps.setInt(3, idPaciente);
                ps.executeUpdate();
                ps.close();
                con.close();

                JOptionPane.showMessageDialog(this, "Cita eliminada.");
                mostrarCitas();

            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnEliminarCitaActionPerformed

    private void btnFinalizarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarCitaActionPerformed
        int fila = tblCitas.getSelectedRow();

        if (fila == -1) 
        {
            JOptionPane.showMessageDialog(this, "Selecciona una cita para finalizar.");
            return;
        }

        String fecha = tblCitas.getValueAt(fila, 0).toString();
        String hora = tblCitas.getValueAt(fila, 1).toString();
        int idPaciente = Integer.parseInt(tblCitas.getValueAt(fila, 3).toString());

        try 
        {
            Connection con = Conexion.conectar();
            String sql = "UPDATE citas SET estado = 'Finalizada' WHERE fechaCita = ? AND hora = ? AND idpacientes = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fecha);
            ps.setString(2, hora);
            ps.setInt(3, idPaciente);
            ps.executeUpdate();
            ps.close();
            con.close();

            JOptionPane.showMessageDialog(this, "Cita finalizada.");
            mostrarCitas();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnFinalizarCitaActionPerformed

    private void txtFiltroFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroFechaActionPerformed

    private void btnAgendarCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarCitasActionPerformed
        AgendarCitas agendarCitas = new AgendarCitas();
        agendarCitas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgendarCitasActionPerformed

    private void txtFiltroMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroMedicoActionPerformed

    private void mostrarCitas() 
    {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Fecha exacta");
        modelo.addColumn("Hora");
        modelo.addColumn("Motivo");
        modelo.addColumn("ID del Paciente");
        modelo.addColumn("Médico tratante");
        modelo.addColumn("Estado");
        tblCitas.setModel(modelo);

        try 
        {
            Connection con = Conexion.conectar();
            String sql = "SELECT c.fechaCita, c.hora, c.motivo, c.idpacientes, " + "CONCAT(m.nomMedico, ' ', m.apeMedico) AS medicoNombre, c.estado " + "FROM citas c " + "JOIN medicos m ON c.idmedicos = m.idmedicos";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) 
            {
                String fecha = rs.getString("fechaCita");
                String hora = rs.getString("hora");
                String motivo = rs.getString("motivo");
                String idPaciente = rs.getString("idpacientes");
                String medico = rs.getString("medicoNombre");
                String estado = rs.getString("estado");
                modelo.addRow(new Object[]{fecha, hora, motivo, idPaciente, medico, estado});
            }

            rs.close();
            ps.close();
            con.close();
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Citas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendarCitas;
    private javax.swing.JButton btnAtrasCitas;
    private javax.swing.JButton btnCancelarCita;
    private javax.swing.JButton btnEliminarCita;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnFinalizarCita;
    private javax.swing.JComboBox<String> cbxFiltroEstado;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCitas;
    private javax.swing.JTextField txtFiltroFecha;
    private javax.swing.JTextField txtFiltroID;
    private javax.swing.JTextField txtFiltroMedico;
    // End of variables declaration//GEN-END:variables
}
