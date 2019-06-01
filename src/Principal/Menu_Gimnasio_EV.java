/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BlackSpider232
 */
public class Menu_Gimnasio_EV extends javax.swing.JFrame {

    DefaultTableModel modeloTabla;
    Conectar con = new Conectar();
    Connection cc = con.conexion();
    public Menu_Gimnasio_EV() {
        modeloTabla = new DefaultTableModel(null, getColumnas());
        setFilas();
        initComponents();
    }
    
    
    private String[] getColumnas(){
        String columna[]= new String[]{"NOMBRE EVENTO","DESCRIPCION","FECHA DE INICIO","FECHA DE FINALIZACION","HORA DE INICIO","HORA DE FINALIZACION","REQUISITOS"};
        return columna;
    }
    
    private void setFilas(){
        try{
            String sql = "Select nombre,descripcion,fechaInicio,fechaInicio,horaInicio,horaFin,requisitos from evento order by nombre";
            PreparedStatement ps = con.conexion().prepareStatement(sql);
            try (ResultSet res = ps.executeQuery()) {
                Object datos[]= new Object[7];
                while(res.next()){
                    for (int i = 0;i<7;i++){
                        datos[i]= res.getObject(i+1);
                    }
                    modeloTabla.addRow(datos);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Gimnasio_E.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
    
    void borrar (String borrar){
       try{
        PreparedStatement ps= cc.prepareStatement(borrar);
        ps.execute();
        JOptionPane.showMessageDialog(null, "El evento se ha ELIMINADO");
       }
       catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error al Intentar Borrar : \n "+e);
       }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnMParticipantes = new javax.swing.JButton();
        btnMEventos = new javax.swing.JButton();
        btnMEjercicios = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtParticipantes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        EActivos = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnAñadir = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Participantes");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 32, 43));

        btnMParticipantes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMParticipantes.setForeground(new java.awt.Color(255, 255, 255));
        btnMParticipantes.setText("Participantes");
        btnMParticipantes.setContentAreaFilled(false);
        btnMParticipantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMParticipantesActionPerformed(evt);
            }
        });

        btnMEventos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMEventos.setForeground(new java.awt.Color(0, 248, 11));
        btnMEventos.setText("Eventos");
        btnMEventos.setContentAreaFilled(false);
        btnMEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMEventosActionPerformed(evt);
            }
        });

        btnMEjercicios.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMEjercicios.setForeground(new java.awt.Color(255, 255, 255));
        btnMEjercicios.setText("Ejercicios");
        btnMEjercicios.setContentAreaFilled(false);
        btnMEjercicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMEjerciciosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMParticipantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMEventos, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
            .addComponent(btnMEjercicios, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnMParticipantes, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMEjercicios, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jtParticipantes.setModel(modeloTabla);
        jtParticipantes.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jtParticipantes);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Eventos Activos :");

        EActivos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        EActivos.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EActivos)
                        .addGap(130, 458, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(EActivos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));

        btnAñadir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAñadir.setForeground(new java.awt.Color(255, 255, 255));
        btnAñadir.setText("Añadir");
        btnAñadir.setContentAreaFilled(false);
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Modificar");
        btnModificar.setContentAreaFilled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAñadir, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        Añadir_evento ae = new Añadir_evento(this,true);
        ae.addWindowListener(new WindowAdapter() {
                    public void windowClosed(WindowEvent e) {
                        //modeloTabla.setRowCount(0);
                        try{
                            String sql = "Select nombre,descripcion,fechaInicio,fechaInicio,horaInicio,horaFin,requisitos from evento order by nombre";
                            PreparedStatement ps = con.conexion().prepareStatement(sql);
                            try (ResultSet res = ps.executeQuery()) {
                                Object datos[]= new Object[7];
                                while(res.next()){
                                    for (int i = 0;i<7;i++){
                                        datos[i]= res.getObject(i+1);
                                    }
                                    modeloTabla.addRow(datos);
                                }
                             }
                        } catch (SQLException ex) {
                            Logger.getLogger(Menu_Gimnasio_EV.class.getName()).log(Level.SEVERE, null, ex);
                            ex.printStackTrace();
                        }
                    }
           }); 
        ae.setVisible(true);
    }//GEN-LAST:event_btnAñadirActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        Modificar_evento ae = new Modificar_evento(this,true);
        /*ap.addWindowListener(new WindowAdapter() {
                    public void windowClosed(WindowEvent e) {
                        //modeloTabla.setRowCount(0);
                        try{
                            String sql = "Select * from cliente order by nit";
                            PreparedStatement ps = con.conexion().prepareStatement(sql);
                            try (ResultSet res = ps.executeQuery()) {
                                Object datos[]= new Object[7];
                                while(res.next()){
                                    for (int i = 0;i<7;i++){
                                        datos[i]= res.getObject(i+1);
                                    }
                                    modeloTabla.addRow(datos);
                                }
                             }
                        } catch (SQLException ex) {
                            Logger.getLogger(Lista_Clientes.class.getName()).log(Level.SEVERE, null, ex);
                            ex.printStackTrace();
                        }
                    }
           }); */
        ae.setVisible(true);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnMParticipantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMParticipantesActionPerformed
        Menu_Gimnasio_P mgp = new Menu_Gimnasio_P();
        this.setVisible(false);
        mgp.setVisible(true);
    }//GEN-LAST:event_btnMParticipantesActionPerformed

    private void btnMEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMEventosActionPerformed
        
    }//GEN-LAST:event_btnMEventosActionPerformed

    private void btnMEjerciciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMEjerciciosActionPerformed
        Menu_Gimnasio_E mgp = new Menu_Gimnasio_E();
        this.setVisible(false);
        mgp.setVisible(true);
    }//GEN-LAST:event_btnMEjerciciosActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Menu_Gimnasio_EV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Gimnasio_EV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Gimnasio_EV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Gimnasio_EV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Gimnasio_EV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EActivos;
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnMEjercicios;
    private javax.swing.JButton btnMEventos;
    private javax.swing.JButton btnMParticipantes;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtParticipantes;
    // End of variables declaration//GEN-END:variables
}
