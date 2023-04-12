/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package component;

import Main.Home;
import Main.PopUpMenuOwner;
import myClass.Owner;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import myClass.dbConnection;

/**
 *
 * @author Yusuf
 */

public class OwnerCard extends javax.swing.JPanel {
    private dbConnection db;
    private int loggedUserId;
    private boolean flag = false;
    
    public Owner getData() {
        return data;
    }

    public OwnerCard(int loggedUserId) {
        initComponents();
        db = new dbConnection();
        this.loggedUserId = loggedUserId;
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    public OwnerCard(int loggedUserId, boolean flag) {
        initComponents();
        db = new dbConnection();
        this.loggedUserId = loggedUserId;
        this.flag = flag;
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private Owner data;

    public void setData(Owner data) {
        this.data = data;
        profilePicture.setImage(data.getPhoto());
        name.setText(data.getName());
        age.setText(String.valueOf(data.getAge()));
        gender.setText(data.getGender());
        sumBoardingHouse.setText(String.valueOf(data.getSumBoardingHouse()));
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

        name = new javax.swing.JLabel();
        gender = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        sum = new javax.swing.JLabel();
        sumBoardingHouse = new javax.swing.JLabel();
        profilePicture = new customSwing.PictureBox();
        labelGender = new javax.swing.JLabel();
        labelGender1 = new javax.swing.JLabel();
        edit = new customSwing.ActionButton();
        delete = new customSwing.ActionButton();

        setPreferredSize(new java.awt.Dimension(385, 172));

        name.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        name.setText("Name Owner");

        gender.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        gender.setForeground(new java.awt.Color(76, 76, 76));
        gender.setText("Male");

        age.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        age.setForeground(new java.awt.Color(76, 76, 76));
        age.setText("30");

        sum.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        sum.setForeground(new java.awt.Color(76, 76, 76));
        sum.setText("Boarding House  :");

        sumBoardingHouse.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        sumBoardingHouse.setForeground(new java.awt.Color(76, 76, 76));
        sumBoardingHouse.setText("30");

        profilePicture.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/owners/Pablo-Escobar.jpg"))); // NOI18N

        labelGender.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelGender.setForeground(new java.awt.Color(76, 76, 76));
        labelGender.setText("Gender                :");

        labelGender1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelGender1.setForeground(new java.awt.Color(76, 76, 76));
        labelGender1.setText("Age                      :");

        edit.setIcon(new javax.swing.ImageIcon("D:\\Coding\\NetBeansProjects\\Dormitory\\picture\\edit.png")); // NOI18N
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setIcon(new javax.swing.ImageIcon("D:\\Coding\\NetBeansProjects\\Dormitory\\picture\\delete.png")); // NOI18N
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelGender1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                    .addComponent(labelGender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(gender)
                                    .addComponent(age)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sum, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(sumBoardingHouse))))
                        .addContainerGap(37, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(40, 40, 40))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gender)
                            .addComponent(labelGender))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelGender1)
                            .addComponent(age))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sum)
                            .addComponent(sumBoardingHouse))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        int ownerId = this.getData().getOwnerId();
        
        PopUpMenuOwner puad;
        try {
            puad = new PopUpMenuOwner(loggedUserId, true, ownerId);
            puad.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            puad.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(OwnerCard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure to delete this data?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            int ownerId = this.getData().getOwnerId();

            if (db.updateQuery1("DELETE FROM owner WHERE ownerId = " + ownerId) > 0) {
                ImageIcon imageIcon = (ImageIcon) this.getData().getPhoto();
                String fileName = imageIcon.getDescription();
                File file = new File("src/image/owners/" + fileName);

                if (file.exists()) {
                    file.delete();
                    System.out.println("File photo deleted successfully");
                } else {
                    System.out.println("File photo not found");
                }

                System.out.println("Data has been deleted");
                JOptionPane.showMessageDialog(null, "Owner data has been deleted!");

                Window window = SwingUtilities.getWindowAncestor(this);
                if (window instanceof Home homey) {
                    homey.setVisible(false);
                }

                Home updateHome = null;
                try {
                    updateHome = new Home(this.loggedUserId);
                } catch (IOException ex) {
                    Logger.getLogger(OwnerCard.class.getName()).log(Level.SEVERE, null, ex);
                }
                updateHome.setVisible(true);
            } else {
                System.out.println("Failed to delete owner data");
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel age;
    private customSwing.ActionButton delete;
    private customSwing.ActionButton edit;
    private javax.swing.JLabel gender;
    private javax.swing.JLabel labelGender;
    private javax.swing.JLabel labelGender1;
    private javax.swing.JLabel name;
    private customSwing.PictureBox profilePicture;
    private javax.swing.JLabel sum;
    private javax.swing.JLabel sumBoardingHouse;
    // End of variables declaration//GEN-END:variables
}
