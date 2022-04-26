package ventanas;

import clases.Conexion;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import static ventanas.Login.user;

public class InscriptionsControl extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    int user_update;
    String name, lastnamef, lastnamem;

    public InscriptionsControl() {
        initComponents();

        setSize(900, 500);
        setResizable(false);
        setTitle("Control de Administradores");
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/walpaper.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        Tabla();

        jTable_admins.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_admins.rowAtPoint(e.getPoint());
                int id = 0;
                int name_fila = 1;
                int lastanemf_fila = 2;
                int lastnamem_fila = 3;

                if (fila_point > -1) {
                    user_update = (int) model.getValueAt(fila_point, id);
                    name = (String) model.getValueAt(fila_point, name_fila);
                    lastnamef = (String) model.getValueAt(fila_point, lastanemf_fila);
                    lastnamem = (String) model.getValueAt(fila_point, lastnamem_fila);
                    new InscriptionStudent(user_update, name, lastnamef, lastnamem).setVisible(true);
                }
            }
        });
    }

    private void Tabla() {

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select id, name, lastnamef, lastnamem, age, phonenumber from users where typeofuser = 'Estudiante'");
            ResultSet rs = pst.executeQuery();

            jTable_admins = new JTable(model);
            jScrollPane1.setViewportView(jTable_admins);

            model.addColumn("");
            model.addColumn("Nombre");
            model.addColumn("Apellido Paterno");
            model.addColumn("Apellido Materno");
            model.addColumn("Age");
            model.addColumn("Celular");

            while (rs.next()) {
                Object[] fila = new Object[6];

                for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error! en el llenado de la tabla users." + e);
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

        jLabel_User3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel_welcome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_admins = new javax.swing.JTable();
        txt_searchUser = new javax.swing.JTextField();
        jLabel_buscarProducto = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_User3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_User3.setText("Agregar Asignatura");
        getContentPane().add(jLabel_User3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/adduser.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 60, 60));

        jLabel_welcome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel_welcome.setText("Control de Inscripciones");
        getContentPane().add(jLabel_welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        jTable_admins.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_admins);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 800, 210));

        txt_searchUser.setForeground(new java.awt.Color(153, 153, 153));
        txt_searchUser.setToolTipText("");
        txt_searchUser.setBorder(null);
        txt_searchUser.setDoubleBuffered(true);
        txt_searchUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchUserActionPerformed(evt);
            }
        });
        getContentPane().add(txt_searchUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 160, 30));

        jLabel_buscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search2.png"))); // NOI18N
        jLabel_buscarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_buscarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_buscarProductoMouseClicked(evt);
            }
        });
        getContentPane().add(jLabel_buscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 110, 30, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, 190, 10));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new AddSubjects().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_searchUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchUserActionPerformed

        String ID_string = txt_searchUser.getText().trim();

        if (!ID_string.equals("")) {

            int ID = Integer.parseInt(ID_string);

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select name, lastnamef, lastnamem from users where id = '" + ID + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    name = rs.getString("name");
                    lastnamef = rs.getString("lastnamef");
                    lastnamem = rs.getString("lastnamem");
                }

                new InscriptionStudent(user_update, name, lastnamef, lastnamem).setVisible(true);
                txt_searchUser.setText("");

            } catch (SQLException e) {
                System.err.print("Error al consultar el nombre del estudiante." + e);
            }
        }
    }//GEN-LAST:event_txt_searchUserActionPerformed

    private void jLabel_buscarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_buscarProductoMouseClicked

        String ID_string = txt_searchUser.getText().trim();

        if (!ID_string.equals("")) {

            int ID = Integer.parseInt(ID_string);

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select name, lastnamef, lastnamem from users where id = '" + ID + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    name = rs.getString("name");
                    lastnamef = rs.getString("lastnamef");
                    lastnamem = rs.getString("lastnamem");
                }

                new InscriptionStudent(user_update, name, lastnamef, lastnamem).setVisible(true);
                txt_searchUser.setText("");

            } catch (SQLException e) {
                System.err.print("Error al consultar el nombre del estudiante." + e);
            }
        }

    }//GEN-LAST:event_jLabel_buscarProductoMouseClicked

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
            java.util.logging.Logger.getLogger(InscriptionsControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InscriptionsControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InscriptionsControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InscriptionsControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InscriptionsControl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel_User3;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_buscarProducto;
    private javax.swing.JLabel jLabel_welcome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable_admins;
    private javax.swing.JTextField txt_searchUser;
    // End of variables declaration//GEN-END:variables
}