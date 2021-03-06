package gui;

import implementacion.ImplTrabajador;

public class Autenticacion extends javax.swing.JPanel {

    public Autenticacion() {
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

        jLabel_titulo = new javax.swing.JLabel();
        jLabel_usuario = new javax.swing.JLabel();
        jLabel_pasword = new javax.swing.JLabel();
        jText_usuario = new javax.swing.JTextField();
        jPassword = new javax.swing.JPasswordField();
        jButton_Autenticar = new javax.swing.JButton();

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel_titulo.setText("Sistema de Ventas");

        jLabel_usuario.setText("Usuario:");

        jLabel_pasword.setText("Contraseña:");

        jText_usuario.setToolTipText("");
        jText_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_usuarioActionPerformed(evt);
            }
        });

        jButton_Autenticar.setText("Ingresar");
        jButton_Autenticar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AutenticarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_usuario)
                            .addComponent(jLabel_pasword))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jText_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(jPassword)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jButton_Autenticar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addComponent(jLabel_titulo)
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel_titulo)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_usuario)
                    .addComponent(jText_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_pasword)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton_Autenticar)
                .addContainerGap(92, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jText_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_usuarioActionPerformed
        // TODO add your handling code here:
    }

    private void jButton_AutenticarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AutenticarActionPerformed
                
        System.out.println("estos son los valores"+jText_usuario.getText()+jPassword.getText());
        ImplTrabajador it= new ImplTrabajador();
        if(it.loginSistema(jText_usuario.getText(), jPassword.getText())){
        
        }else{
        
        }
       
        
    }

    private javax.swing.JButton jButton_Autenticar;
    private javax.swing.JLabel jLabel_pasword;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JLabel jLabel_usuario;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jText_usuario;
    // End of variables declaration//GEN-END:variables
}
