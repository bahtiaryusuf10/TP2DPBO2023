/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package component;

import Main.Home;
import Main.PopUpMenuBoardingHouse;
import myClass.BoardingHouse;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
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

public class BoardingHouseCard extends javax.swing.JPanel {
    private dbConnection db;
    private int loggedUserId;
    private boolean flag = false;
    
    
    public BoardingHouse getData() {
        return data;
    }

    public BoardingHouseCard(int loggedUserId) {
        initComponents();
        db = new dbConnection();
        this.loggedUserId = loggedUserId;
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    public BoardingHouseCard(int loggedUserId, boolean flag) {
        initComponents();
        db = new dbConnection();
        this.loggedUserId = loggedUserId;
        this.flag = flag;
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private BoardingHouse data;

    public void setData(BoardingHouse data) {
        this.data = data;
        boardingPicture.setImage(data.getPhoto());
        name.setText(data.getName());
        address.setText(data.getAddress());
        owner.setText(data.getOwner().getName());
        price.setText(String.format("Rp %,d", data.getPrice()).replaceAll(",", "."));
        facility.setText(data.getFacility());
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

        actionButton1 = new customSwing.ActionButton();
        name = new javax.swing.JLabel();
        owner = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        boardingPicture = new customSwing.PictureBox();
        ownerLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        facilityLabel = new javax.swing.JLabel();
        facility = new javax.swing.JTextPane();
        perMonth = new javax.swing.JLabel();
        edit = new customSwing.ActionButton();
        delete = new customSwing.ActionButton();

        actionButton1.setText("actionButton1");

        setPreferredSize(new java.awt.Dimension(385, 372));

        name.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        name.setText("Boarding House Name");

        owner.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        owner.setForeground(new java.awt.Color(76, 76, 76));
        owner.setText("Pablo Escobar");

        address.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        address.setForeground(new java.awt.Color(76, 76, 76));
        address.setText("Medellin");

        priceLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(76, 76, 76));
        priceLabel.setText("Price         :");

        price.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        price.setForeground(new java.awt.Color(76, 76, 76));
        price.setText("2.500.000");

        boardingPicture.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/boardingHouse/pablo-kost1.jpg"))); // NOI18N

        ownerLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        ownerLabel.setForeground(new java.awt.Color(76, 76, 76));
        ownerLabel.setText("Owner       :");

        addressLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        addressLabel.setForeground(new java.awt.Color(76, 76, 76));
        addressLabel.setText("Address   :");

        facilityLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        facilityLabel.setForeground(new java.awt.Color(76, 76, 76));
        facilityLabel.setText("Facility      :");

        facility.setBackground(new java.awt.Color(242, 242, 242));
        facility.setBorder(null);
        facility.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        facility.setForeground(new java.awt.Color(76, 76, 76));

        perMonth.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        perMonth.setForeground(new java.awt.Color(76, 76, 76));
        perMonth.setText("/ month");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boardingPicture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(priceLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(price)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(perMonth))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(addressLabel)
                                            .addComponent(ownerLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(owner)
                                            .addComponent(address)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(facilityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(facility, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 2, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boardingPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(owner)
                    .addComponent(ownerLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel)
                    .addComponent(address))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel)
                    .addComponent(price)
                    .addComponent(perMonth))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(facilityLabel)
                    .addComponent(facility, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        int boardingHouseId = this.getData().getBoardingHouseId();
        int ownerId = this.getData().getOwner().getOwnerId();

        PopUpMenuBoardingHouse puabh;
        try {
            puabh = new PopUpMenuBoardingHouse(loggedUserId, true, boardingHouseId);
            puabh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            puabh.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(BoardingHouseCard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BoardingHouseCard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure to delete this data?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            int boardingHouseId = this.getData().getBoardingHouseId();

            if (db.updateQuery1("DELETE FROM boarding_house WHERE boardingHouseId = " + boardingHouseId) > 0) {
                ImageIcon imageIcon = (ImageIcon) this.getData().getPhoto();
                String fileName = imageIcon.getDescription();
                File file = new File("src/image/boardingHouse/" + fileName);

                if (file.exists()) {
                    file.delete();
                    System.out.println("File photo deleted successfully");
                } else {
                    System.out.println("File photo not found");
                }

                System.out.println("Data has been deleted");
                JOptionPane.showMessageDialog(null, "Boarding House has been deleted!");

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
    private customSwing.ActionButton actionButton1;
    private javax.swing.JLabel address;
    private javax.swing.JLabel addressLabel;
    private customSwing.PictureBox boardingPicture;
    private customSwing.ActionButton delete;
    private customSwing.ActionButton edit;
    private javax.swing.JTextPane facility;
    private javax.swing.JLabel facilityLabel;
    private javax.swing.JLabel name;
    private javax.swing.JLabel owner;
    private javax.swing.JLabel ownerLabel;
    private javax.swing.JLabel perMonth;
    private javax.swing.JLabel price;
    private javax.swing.JLabel priceLabel;
    // End of variables declaration//GEN-END:variables
}
