/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package component;

import Main.PopUpMenuBoardingHouse;
import Main.PopUpMenuOwner;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import myClass.User;

/**
 *
 * @author Yusuf
 */

public class UserCard extends javax.swing.JPanel {
    private int loggedUserId;
    
    public User getData() {
        return data;
    }

    public UserCard(int loggedUserId) {
        initComponents();
        this.loggedUserId = loggedUserId;
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private User data;

    public void setData(User data) {
        this.data = data;
        name.setText(data.getName());
        username.setText(data.getUsername());
        gender.setText(data.getGender());
        profilePicture.setImage(data.getPhoto());
    }

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(242, 242, 242));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.dispose();
        super.paint(grphcs);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        profilePicture = new customSwing.PictureBox();
        usernameLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        gender = new javax.swing.JLabel();
        addOwner = new customSwing.Button();
        addBoarding = new customSwing.Button();
        usernameLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(385, 400));

        nameLabel.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        nameLabel.setText("Name          :");

        profilePicture.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/boardingHouse/pablo-kost1.jpg"))); // NOI18N

        usernameLabel.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        usernameLabel.setText("Username   :");

        genderLabel.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        genderLabel.setText("Gender       :");

        username.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        username.setText("maikel10");

        name.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        name.setText("Maikel");

        gender.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        gender.setText("Male");

        addOwner.setForeground(new java.awt.Color(255, 255, 255));
        addOwner.setText("Add owner data");
        addOwner.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addOwner.setRadius(40);
        addOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOwnerActionPerformed(evt);
            }
        });

        addBoarding.setForeground(new java.awt.Color(255, 255, 255));
        addBoarding.setText("Add boarding data");
        addBoarding.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBoarding.setRadius(40);
        addBoarding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBoardingActionPerformed(evt);
            }
        });

        usernameLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        usernameLabel1.setText("USER PROFILE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(profilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(usernameLabel1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(genderLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(username)
                                    .addComponent(name)
                                    .addComponent(gender)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addOwner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(addBoarding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(usernameLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(profilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(username))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderLabel)
                    .addComponent(gender))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBoarding, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addOwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOwnerActionPerformed
        PopUpMenuOwner puad;
        try {
            puad = new PopUpMenuOwner(loggedUserId, false, -1);
            puad.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            puad.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(UserCard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addOwnerActionPerformed

    private void addBoardingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBoardingActionPerformed
        PopUpMenuBoardingHouse puabh;
        try {
            puabh = new PopUpMenuBoardingHouse(loggedUserId, false, -1);
            puabh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            puabh.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(UserCard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserCard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addBoardingActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customSwing.Button addBoarding;
    private customSwing.Button addOwner;
    private javax.swing.JLabel gender;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel name;
    private javax.swing.JLabel nameLabel;
    private customSwing.PictureBox profilePicture;
    private javax.swing.JLabel username;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel usernameLabel1;
    // End of variables declaration//GEN-END:variables
}
