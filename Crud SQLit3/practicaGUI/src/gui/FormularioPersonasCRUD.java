/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import implementacion.ImplPersona;

/**
 *
 * @author MSI
 */
public class FormularioPersonasCRUD extends javax.swing.JFrame{

    /**
     * Creates new form FormularioPersonasCRUD
     */
    public FormularioPersonasCRUD() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1_file = new javax.swing.JMenu();
        jMenuItem1_salir = new javax.swing.JMenuItem();
        jMenu2_Personas = new javax.swing.JMenu();
        jMenuItem_agregar = new javax.swing.JMenuItem();
        jMenuItem_reportar = new javax.swing.JMenuItem();
        jMenuItem_modificar = new javax.swing.JMenuItem();
        jMenuItem_eliminar = new javax.swing.JMenuItem();
        jMenuItemPersona_Gestion_Persona = new javax.swing.JMenuItem();
        jMenu_Clientes = new javax.swing.JMenu();
        jMenu_Trabajador = new javax.swing.JMenu();
        jMenu_Productos = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu_Ventas = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu_ReporteVentas = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Como extender? :'v");

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(1834, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(823, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jMenu1_file.setText("File");

        jMenuItem1_salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1_salir.setText("Salir");
        jMenuItem1_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1_salirActionPerformed(evt);
            }
        });
        jMenu1_file.add(jMenuItem1_salir);

        jMenuBar1.add(jMenu1_file);

        jMenu2_Personas.setText("CRUD Persona");

        jMenuItem_agregar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem_agregar.setText("Agregar");
        jMenuItem_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_agregarActionPerformed(evt);
            }
        });
        jMenu2_Personas.add(jMenuItem_agregar);

        jMenuItem_reportar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem_reportar.setText("Reportar");
        jMenuItem_reportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_reportarActionPerformed(evt);
            }
        });
        jMenu2_Personas.add(jMenuItem_reportar);

        jMenuItem_modificar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem_modificar.setText("Modificar");
        jMenuItem_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_modificarActionPerformed(evt);
            }
        });
        jMenu2_Personas.add(jMenuItem_modificar);

        jMenuItem_eliminar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem_eliminar.setText("Eliminar");
        jMenuItem_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_eliminarActionPerformed(evt);
            }
        });
        jMenu2_Personas.add(jMenuItem_eliminar);

        jMenuItemPersona_Gestion_Persona.setText("Gestionar Persona");
        jMenuItemPersona_Gestion_Persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPersona_Gestion_PersonaActionPerformed(evt);
            }
        });
        jMenu2_Personas.add(jMenuItemPersona_Gestion_Persona);

        jMenuBar1.add(jMenu2_Personas);

        jMenu_Clientes.setText("Clientes");
        jMenuBar1.add(jMenu_Clientes);

        jMenu_Trabajador.setText("Trabajador");
        jMenuBar1.add(jMenu_Trabajador);

        jMenu_Productos.setText("Productos");

        jMenuItem1.setText("Reporte");
        jMenu_Productos.add(jMenuItem1);

        jMenuItem2.setText("Gestionar Productos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu_Productos.add(jMenuItem2);

        jMenuBar1.add(jMenu_Productos);

        jMenu_Ventas.setText("Ventas");

        jMenuItem5.setText("Registrar Venta");
        jMenu_Ventas.add(jMenuItem5);

        jMenuBar1.add(jMenu_Ventas);

        jMenu_ReporteVentas.setText("Reporte Ventas");

        jMenuItem3.setText("Registrar");
        jMenu_ReporteVentas.add(jMenuItem3);

        jMenuBar1.add(jMenu_ReporteVentas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1_salirActionPerformed

    private void jMenuItem_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_agregarActionPerformed
        Agregar agr = new Agregar();
        jDesktopPane1.add(agr);
        agr.show();
        
    }//GEN-LAST:event_jMenuItem_agregarActionPerformed

    private void jMenuItem_reportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_reportarActionPerformed
   
        Reportar re = new Reportar();
        jDesktopPane1.add(re);
        re.show();
    }//GEN-LAST:event_jMenuItem_reportarActionPerformed

    private void jMenuItem_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_modificarActionPerformed
        
        Modificar mo = new Modificar();
        jDesktopPane1.add(mo);
        mo.show();
        
        
    }//GEN-LAST:event_jMenuItem_modificarActionPerformed

    private void jMenuItem_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_eliminarActionPerformed
        
        Eliminar eli = new Eliminar();
        jDesktopPane1.add(eli);
        eli.show();
    }//GEN-LAST:event_jMenuItem_eliminarActionPerformed

    private void jMenuItemPersona_Gestion_PersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPersona_Gestion_PersonaActionPerformed
        
    }//GEN-LAST:event_jMenuItemPersona_Gestion_PersonaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioPersonasCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioPersonasCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioPersonasCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioPersonasCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioPersonasCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1_file;
    private javax.swing.JMenu jMenu2_Personas;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem1_salir;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItemPersona_Gestion_Persona;
    private javax.swing.JMenuItem jMenuItem_agregar;
    private javax.swing.JMenuItem jMenuItem_eliminar;
    private javax.swing.JMenuItem jMenuItem_modificar;
    private javax.swing.JMenuItem jMenuItem_reportar;
    private javax.swing.JMenu jMenu_Clientes;
    private javax.swing.JMenu jMenu_Productos;
    private javax.swing.JMenu jMenu_ReporteVentas;
    private javax.swing.JMenu jMenu_Trabajador;
    private javax.swing.JMenu jMenu_Ventas;
    // End of variables declaration//GEN-END:variables
}
