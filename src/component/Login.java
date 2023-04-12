/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package component;

import java.awt.event.ActionListener;

/**
 *
 * @author Yusuf
 */

public class Login extends javax.swing.JPanel {
    public Login() {
        initComponents();
    }
    
    public String getUsername(){
        return usernameLogin.getText();
    }
    
    public String getPassword(){
        char[] password = passwordLogin.getPassword();
        String passToStr = new String(password);
        
        return passToStr;
    }
    
    public void addEventRegister(ActionListener event){
        toRegister.addActionListener(event);
    }
    
    public void addEventHome(ActionListener event){
        login.addActionListener(event);
    }
    
    public void resetForm() {
        usernameLogin.setText("");
        passwordLogin.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new customSwing.PanelRound();
        usernameLogin = new customSwing.TextField();
        passwordLogin = new customSwing.PasswordField();
        login = new customSwing.Button();
        jLabel1 = new javax.swing.JLabel();
        toRegister = new customSwing.Link();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 253, 253));
        setOpaque(false);
        setLayout(null);

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(80);
        panelRound1.setRoundTopRight(80);

        usernameLogin.setLabelText("Username");
        usernameLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameLoginActionPerformed(evt);
            }
        });

        passwordLogin.setLabelText("Password");

        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setLabel("Login");
        login.setRadius(29);
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel1.setText("don't have an account?");

        toRegister.setText("register now");
        toRegister.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        toRegister.setIconTextGap(0);
        toRegister.setMargin(new java.awt.Insets(0, 0, 0, 0));
        toRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passwordLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(usernameLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(toRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        add(panelRound1);
        panelRound1.setBounds(60, 190, 292, 310);

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel2.setText("Boarding House Apps!");
        add(jLabel2);
        jLabel2.setBounds(60, 130, 260, 30);

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel3.setText("Welcome to");
        add(jLabel3);
        jLabel3.setBounds(60, 100, 140, 30);

        background.setIcon(new javax.swing.ImageIcon("D:\\Coding\\NetBeansProjects\\Dormitory\\picture\\Amazing Girl (just_amazinggirl) on Pinterest.jpg")); // NOI18N
        add(background);
        background.setBounds(0, 0, 420, 680);
    }// </editor-fold>//GEN-END:initComponents

    private void toRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toRegisterActionPerformed

    private void usernameLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameLoginActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        resetForm();
    }//GEN-LAST:event_loginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private customSwing.Button login;
    private customSwing.PanelRound panelRound1;
    private customSwing.PasswordField passwordLogin;
    private customSwing.Link toRegister;
    private customSwing.TextField usernameLogin;
    // End of variables declaration//GEN-END:variables
}
