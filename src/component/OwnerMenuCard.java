/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package component;

import Main.Home;
import Main.PopUpMenuOwner;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import myClass.dbConnection;

/**
 *
 * @author Yusuf
 */

public class OwnerMenuCard extends javax.swing.JPanel {
    private dbConnection db;
    private String nameFile;
    private int loggedUserId;
    private int ownerId;
    private boolean isUpdate = false;
    private int affectedRows = 0;
    private JFileChooser chooser;
    private int returnVal;

    public OwnerMenuCard(int loggedUserId, boolean isUpdate, int ownerId) throws IOException {
        initComponents();
        db = new dbConnection();
        this.loggedUserId = loggedUserId;
        this.isUpdate = isUpdate;
        this.ownerId = ownerId;
        
        if(this.isUpdate == true){
            SetForm();
        }
        
        setOpaque(false);
    }

    public void InsertData() throws FileNotFoundException, IOException {
        String ownerName = nameInput.getText();
        String ageStr = ageInput.getText();
        int ownerAge = 0;
        if(ageStr.isEmpty() || !ageStr.matches("\\d+")){
             JOptionPane.showMessageDialog(null, "You haven't entered age or the age you entered is not a number.");
        }else{
            ownerAge = Integer.parseInt(ageStr);
        }
        String ownerGender = (String)genderInput.getSelectedItem();
        
        if(ownerGender != null){
            if(ownerName.isEmpty()){
                JOptionPane.showMessageDialog(null, "The fields are not completely filled!");
            }else{
               if(chooser != null){
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = chooser.getSelectedFile();
                        try {
                            FileInputStream fis = new FileInputStream(selectedFile);
                            nameFile = selectedFile.getName();

                            FileOutputStream fos = new FileOutputStream(new File("src/image/owners/" + selectedFile.getName()));
                            byte[] buffer = new byte[1024];
                            int length;
                            while ((length = fis.read(buffer)) > 0) {
                                fos.write(buffer, 0, length);
                            }
                            fis.close();
                            fos.close();
                            System.out.println("File uploaded to src folder");
                        } catch (IOException ex) {
                            System.out.println("Error uploading file: " + ex.getMessage());
                        }
                    }

                    if(nameFile != null){
                        String sql = "INSERT INTO owner (userId, name, age, gender, boardingHouse, photo) VALUES ('" + loggedUserId + "', '" + ownerName + "', '" + ownerAge + "', '" + ownerGender + "', 0, '" + nameFile +"')";
                        affectedRows = db.updateQuery1(sql);

                        resetForm();

                        // show information
                        System.out.println("Insert Success!");
                        JOptionPane.showMessageDialog(null, "Owner data added successfully!");
                        
                        Window window = SwingUtilities.getWindowAncestor(this);
                        if (window instanceof PopUpMenuOwner puad) {
                            puad.dispose();
                        }
                        
                        Home updateHome = new Home(loggedUserId);
                        updateHome.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "You didn't upload a photo!");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "You haven't selected a photo!");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "The gender field is required!");
        }
    }
    
    public void UpdateData() throws FileNotFoundException, IOException {
        String ownerName = nameInput.getText();
        String ageStr = ageInput.getText();
        int ownerAge = 0;
        if(ageStr.isEmpty() || !ageStr.matches("\\d+")){
             JOptionPane.showMessageDialog(null, "You haven't entered age or the age you entered is not a number.");
        }else{
            ownerAge = Integer.parseInt(ageStr);
        }
        String ownerGender = (String)genderInput.getSelectedItem();
        
        if(ownerGender != null){
            if(ownerName.isEmpty()){
                JOptionPane.showMessageDialog(null, "The fields are not completely filled!");
            }else{
               if(chooser != null){
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = chooser.getSelectedFile();
                        try {
                            FileInputStream fis = new FileInputStream(selectedFile);
                            nameFile = selectedFile.getName();

                            FileOutputStream fos = new FileOutputStream(new File("src/image/owners/" + selectedFile.getName()));
                            byte[] buffer = new byte[1024];
                            int length;
                            while ((length = fis.read(buffer)) > 0) {
                                fos.write(buffer, 0, length);
                            }
                            fis.close();
                            fos.close();
                            System.out.println("File uploaded to src folder");
                        } catch (IOException ex) {
                            System.out.println("Error uploading file: " + ex.getMessage());
                        }
                    }

                    if(nameFile != null){
                        String sql = "UPDATE owner SET name = '" + ownerName + "', age = '" + ownerAge + "', gender = '" + ownerGender + "', photo = '" + nameFile + "' WHERE ownerId = '" + ownerId + "'";
                        affectedRows = db.updateQuery1(sql);


                        resetForm();

                        // show information
                        System.out.println("Update Success!");
                        JOptionPane.showMessageDialog(null, "Owner data update successfully!");
                        
                        Window window = SwingUtilities.getWindowAncestor(this);
                        if (window instanceof PopUpMenuOwner puad) {
                            puad.dispose();
                        }
                        
                        Home updateHome = new Home(loggedUserId);
                        updateHome.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "You didn't upload a photo!");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "You haven't selected a photo!");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "The gender field is required!");
        }
    }
    
    public void SetForm() throws FileNotFoundException, IOException {
        ResultSet res = db.selectQuery1("SELECT * FROM owner WHERE ownerId = " + this.ownerId + " AND userId = " + this.loggedUserId);
        
        try{
            while(res.next()){
                BufferedImage image = null;
                try {
                    image = ImageIO.read(new File("src/image/owners/" + res.getString("photo")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ImageIcon photo = new ImageIcon(image);
                photo.setDescription(res.getString("photo"));
                
                nameInput.setText(res.getString("name"));
                ageInput.setText(String.valueOf(res.getInt("age")));
                genderInput.setSelectedItem(res.getString("gender"));
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        addOwner.setText("Update");
        menuLabel.setText("UPDATE OWNER");     
        resetForm.setVisible(false);
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
    
    public void resetForm() {
        // Set All Value Form to Empty
        nameInput.setText("");
        ageInput.setText("");
        genderInput.setSelectedIndex(-1);
        if (chooser != null) {
            chooser.setSelectedFile(null); // reset selected file
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JTextField();
        textFieldAddData1 = new customSwing.TextFieldAddData();
        age = new javax.swing.JTextField();
        textFieldAddData3 = new customSwing.TextFieldAddData();
        gender = new javax.swing.JComboBox<>();
        comboboxAddData1 = new customSwing.ComboboxAddData();
        comboboxAddData2 = new customSwing.ComboboxAddData();
        comboboxAddData3 = new customSwing.ComboboxAddData();
        txtImage = new customSwing.TextFieldAddData();
        ageLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        addOwner = new customSwing.Button();
        resetForm = new customSwing.Button();
        menuLabel = new javax.swing.JLabel();
        genderLabel1 = new javax.swing.JLabel();
        choosePhoto = new customSwing.Button();
        nameInput = new customSwing.TextFieldAddData();
        ageInput = new customSwing.TextFieldAddData();
        genderInput = new customSwing.ComboboxAddData();
        cancel = new customSwing.Button();

        name.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        name.setBorder(null);
        name.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        name.setMargin(new java.awt.Insets(2, 20, 2, 6));

        textFieldAddData1.setText("textFieldAddData1");

        age.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        age.setBorder(null);
        age.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        age.setMargin(new java.awt.Insets(2, 20, 2, 6));

        textFieldAddData3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        textFieldAddData3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAddData3ActionPerformed(evt);
            }
        });

        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        gender.setSelectedIndex(-1);
        gender.setBorder(null);

        comboboxAddData1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        comboboxAddData1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        comboboxAddData2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        comboboxAddData2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboboxAddData2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxAddData2ActionPerformed(evt);
            }
        });

        comboboxAddData3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male" }));
        comboboxAddData3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboboxAddData3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxAddData3ActionPerformed(evt);
            }
        });

        txtImage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        setPreferredSize(new java.awt.Dimension(385, 400));

        ageLabel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        ageLabel.setText("Age           :");

        nameLabel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        nameLabel.setText("Name        :");

        genderLabel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        genderLabel.setText("Gender      :");

        addOwner.setForeground(new java.awt.Color(255, 255, 255));
        addOwner.setText("Add");
        addOwner.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addOwner.setRadius(40);
        addOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOwnerActionPerformed(evt);
            }
        });

        resetForm.setForeground(new java.awt.Color(255, 255, 255));
        resetForm.setText("Reset");
        resetForm.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        resetForm.setRadius(40);
        resetForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetFormActionPerformed(evt);
            }
        });

        menuLabel.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        menuLabel.setText("ADD OWNER");

        genderLabel1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        genderLabel1.setText(" Photo        :");

        choosePhoto.setForeground(new java.awt.Color(255, 255, 255));
        choosePhoto.setText("Choose");
        choosePhoto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        choosePhoto.setRadius(10);
        choosePhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosePhotoActionPerformed(evt);
            }
        });

        nameInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        ageInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        genderInput.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        genderInput.setSelectedIndex(-1);
        genderInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cancel.setBackground(new java.awt.Color(245, 5, 5));
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("Cancel");
        cancel.setBorderColor(new java.awt.Color(245, 5, 5));
        cancel.setColor(new java.awt.Color(245, 5, 5));
        cancel.setColorClick(new java.awt.Color(232, 9, 9));
        cancel.setColorOver(new java.awt.Color(255, 50, 50));
        cancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancel.setRadius(40);
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ageInput, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(menuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(genderInput, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(genderLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(choosePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(addOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(resetForm, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(menuLabel)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ageInput, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genderInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choosePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genderLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetForm, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addOwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOwnerActionPerformed
        if(this.isUpdate == false){
            try {
                InsertData();
                if(affectedRows > 0){
                    Window window = SwingUtilities.getWindowAncestor(this);
                    if (window instanceof Home homeBefore) {
                        homeBefore.dispose();
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(OwnerMenuCard.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(OwnerMenuCard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                UpdateData();
                if(affectedRows > 0){
                    Window window = SwingUtilities.getWindowAncestor(this);
                    if (window instanceof Home homeBefore) {
                        homeBefore.dispose();
                    }
                }
                this.isUpdate = false;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(OwnerMenuCard.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(OwnerMenuCard.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }//GEN-LAST:event_addOwnerActionPerformed

    private void resetFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetFormActionPerformed
        resetForm();
    }//GEN-LAST:event_resetFormActionPerformed

    private void choosePhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosePhotoActionPerformed
        chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
        chooser.setFileFilter(filter);
        returnVal = chooser.showOpenDialog(this);
    }//GEN-LAST:event_choosePhotoActionPerformed

    private void textFieldAddData3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAddData3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldAddData3ActionPerformed

    private void comboboxAddData2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxAddData2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxAddData2ActionPerformed

    private void comboboxAddData3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxAddData3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxAddData3ActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        resetForm();
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window instanceof PopUpMenuOwner) {
            PopUpMenuOwner puad = (PopUpMenuOwner) window;
            puad.dispose();
        }
    }//GEN-LAST:event_cancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customSwing.Button addOwner;
    private javax.swing.JTextField age;
    private customSwing.TextFieldAddData ageInput;
    private javax.swing.JLabel ageLabel;
    private customSwing.Button cancel;
    private customSwing.Button choosePhoto;
    private customSwing.ComboboxAddData comboboxAddData1;
    private customSwing.ComboboxAddData comboboxAddData2;
    private customSwing.ComboboxAddData comboboxAddData3;
    private javax.swing.JComboBox<String> gender;
    private customSwing.ComboboxAddData genderInput;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel genderLabel1;
    private javax.swing.JLabel menuLabel;
    private javax.swing.JTextField name;
    private customSwing.TextFieldAddData nameInput;
    private javax.swing.JLabel nameLabel;
    private customSwing.Button resetForm;
    private customSwing.TextFieldAddData textFieldAddData1;
    private customSwing.TextFieldAddData textFieldAddData3;
    private customSwing.TextFieldAddData txtImage;
    // End of variables declaration//GEN-END:variables
}
