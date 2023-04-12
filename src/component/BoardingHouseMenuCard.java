/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package component;

import Main.Home;
import Main.PopUpMenuBoardingHouse;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
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

public class BoardingHouseMenuCard extends javax.swing.JPanel {
    private dbConnection db;
    private String nameFile;
    private int affectedRows = 0;
    private int loggedUserId;
    private int boardingHouseId;
    private boolean isUpdate = false;
    private JFileChooser chooser;
    private int returnVal;
    private List<String> ownerNames = new ArrayList<String>();

    public BoardingHouseMenuCard(int loggedUserId, boolean isUpdate, int boardingHouseId) throws SQLException, IOException {
        initComponents();
        db = new dbConnection();
        this.loggedUserId = loggedUserId;
        this.boardingHouseId = boardingHouseId;
        this.isUpdate = isUpdate;
        
        if(this.isUpdate == true){
            SetForm();
        }
        
        ResultSet res = db.selectQuery1("SELECT name FROM owner ORDER BY name ASC");
        
        while (res.next()) {
            ownerNames.add(res.getString("name"));
        }
        
        ownerName.setModel(new DefaultComboBoxModel(ownerNames.toArray()));
        
        setOpaque(false);
    }
    
    public void InsertData() throws FileNotFoundException, IOException {
        String ownerBoardingHouse = (String) ownerName.getSelectedItem();
        String boardingHouseName = nameInput.getText();
        String addressBoardingHouse = addressInput.getText();
        String priceStr = priceInput.getText();
        int priceBoardingHouse = 0;
        if(priceStr.isEmpty() || !priceStr.matches("\\d+")){
             JOptionPane.showMessageDialog(null, "You haven't entered age or the age you entered is not a number.");
        }else{
            priceBoardingHouse = Integer.parseInt(priceStr);
        }
        String facilityBoardingHouse = facilityInput1.getText();

        if (ownerBoardingHouse != null) {
            if (boardingHouseName.isEmpty() || addressBoardingHouse.isEmpty() || priceBoardingHouse == 0 || facilityBoardingHouse.isEmpty()) {
                JOptionPane.showMessageDialog(null, "The fields are not completely filled!");
            } else {
                if (chooser != null) {
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = chooser.getSelectedFile();
                        try {
                            FileInputStream fis = new FileInputStream(selectedFile);
                            nameFile = selectedFile.getName();

                            FileOutputStream fos = new FileOutputStream(new File("src/image/boardingHouse/" + selectedFile.getName()));
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

                    ResultSet ownerIdRs = db.selectQuery1("SELECT ownerId FROM owner WHERE name = '" + ownerBoardingHouse + "'");

                    try {
                        if (ownerIdRs.next()) {
                            int ownerId = ownerIdRs.getInt("ownerId");

                            if(nameFile != null){
                                String sql = "INSERT INTO boarding_house (userId, ownerId, name, address, price, facility, photo) VALUES ('"
                                    + loggedUserId + "', '" + ownerId + "', '" + boardingHouseName + "', '" + addressBoardingHouse
                                    + "', '" + priceBoardingHouse + "', '" + facilityBoardingHouse + "', '" + nameFile + "')";
                                db.updateQuery1(sql);

                                resetForm();

                                // show information
                                System.out.println("Insert Success!");
                                JOptionPane.showMessageDialog(null, "Owner data added successfully!");

                                Window window = SwingUtilities.getWindowAncestor(this);
                                if (window instanceof PopUpMenuBoardingHouse puad) {
                                    puad.dispose();
                                }
                                
                                Home updateHome = new Home(loggedUserId);
                                updateHome.setVisible(true);
                            }else{
                                JOptionPane.showMessageDialog(null, "You didn't upload a photo!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Owner not found!");
                        }
                    } catch (SQLException ex) {
                        System.out.println("Error selecting owner: " + ex.getMessage());
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "You haven't selected a photo!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "The boarding house must have an owner!");
        }
    }
    
    public void UpdateData() throws FileNotFoundException, IOException {
        String owner = (String)ownerName.getSelectedItem();
        String name = nameInput.getText();
        String address = addressInput.getText();
        String priceStr = priceInput.getText();
        int price = 0;
        if(priceStr.isEmpty() || !priceStr.matches("\\d+")){
             JOptionPane.showMessageDialog(null, "You haven't entered age or the age you entered is not a number.");
        }else{
            price = Integer.parseInt(priceStr);
        }
        String facility = facilityInput1.getText();
        
        if(owner != null){
            if(name.isEmpty() || address.isEmpty() || facility.isEmpty()){
                JOptionPane.showMessageDialog(null, "The fields are not completely filled!");
            }else{
               if(chooser != null){
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = chooser.getSelectedFile();
                        try {
                            FileInputStream fis = new FileInputStream(selectedFile);
                            nameFile = selectedFile.getName();

                            FileOutputStream fos = new FileOutputStream(new File("src/image/boardingHouse/" + selectedFile.getName()));
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
                    
                    ResultSet ownerIdRs = db.selectQuery1("SELECT ownerId FROM owner WHERE name = '" + owner + "'");

                    try {
                        if (ownerIdRs.next()) {
                            int ownerId = ownerIdRs.getInt("ownerId");

                            if(nameFile != null){
                                String sql = "UPDATE boarding_house SET ownerId = '" + ownerId + "', name = '" + name + "', address = '" + address + "', price = '" + price + "', facility = '" + facility + "', photo = '" + nameFile + "' WHERE boardingHouseId = '" + boardingHouseId + "'";
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
                        } else {
                            JOptionPane.showMessageDialog(null, "Owner not found!");
                        }
                    } catch (SQLException ex) {
                        System.out.println("Error selecting owner: " + ex.getMessage());
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
        ResultSet res = db.selectQuery1("SELECT * FROM boarding_house WHERE boardingHouseId = " + this.boardingHouseId + " AND userId = " + this.loggedUserId);
        
        try{
            while(res.next()){
                BufferedImage image = null;
                try {
                    image = ImageIO.read(new File("src/image/boardingHouse/" + res.getString("photo")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ImageIcon photo = new ImageIcon(image);
                photo.setDescription(res.getString("photo"));
                
                ResultSet ownerIdRs = db.selectQuery2("SELECT name FROM owner WHERE ownerId = '" + res.getInt("ownerId") + "'");

                try {
                    if (ownerIdRs.next()) {
                        ownerName.setSelectedItem(ownerIdRs.getString("name"));
                        nameInput.setText(res.getString("name"));
                        addressInput.setText(res.getString("address"));
                        priceInput.setText(String.valueOf(res.getInt("price")));
                        facilityInput1.setText(res.getString("facility"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Owner not found!");
                    }
                } catch (SQLException ex) {
                    System.out.println("Error selecting owner: " + ex.getMessage());
                }
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        addBoardingHouse.setText("Update");
        menuLabel.setText("UPDATE BOARDING HOUSE");     
        resetForm.setVisible(false);
        System.out.println(isUpdate);
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
        ownerInput.setText("");
        nameInput.setText("");
        addressInput.setText("");
        priceInput.setText("");
        facilityInput1.setText("");
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
        ageInput2 = new customSwing.TextFieldAddData();
        ownerInput = new customSwing.TextFieldAddData();
        jScrollPane1 = new javax.swing.JScrollPane();
        facilityInput = new javax.swing.JTextArea();
        textArea1 = new customSwing.TextArea();
        textAreaScroll1 = new customSwing.TextAreaScroll();
        addressLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        addBoardingHouse = new customSwing.Button();
        resetForm = new customSwing.Button();
        menuLabel = new javax.swing.JLabel();
        photoLabel = new javax.swing.JLabel();
        choosePhoto = new customSwing.Button();
        nameInput = new customSwing.TextFieldAddData();
        addressInput = new customSwing.TextFieldAddData();
        cancel = new customSwing.Button();
        ownerLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        priceInput = new customSwing.TextFieldAddData();
        facilityLabel = new javax.swing.JLabel();
        ownerName = new customSwing.ComboboxAddData();
        textAreaScroll2 = new customSwing.TextAreaScroll();
        facilityInput1 = new customSwing.TextArea();

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

        ageInput2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        ownerInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ownerInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ownerInputActionPerformed(evt);
            }
        });

        facilityInput.setColumns(20);
        facilityInput.setRows(5);
        jScrollPane1.setViewportView(facilityInput);

        textArea1.setColumns(20);
        textArea1.setRows(5);
        textArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        setPreferredSize(new java.awt.Dimension(385, 550));

        addressLabel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        addressLabel.setText("Address    :");

        nameLabel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        nameLabel.setText("Name        :");

        addBoardingHouse.setForeground(new java.awt.Color(255, 255, 255));
        addBoardingHouse.setText("Add");
        addBoardingHouse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addBoardingHouse.setRadius(40);
        addBoardingHouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBoardingHouseActionPerformed(evt);
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
        menuLabel.setText("ADD BOARDING HOUSE");

        photoLabel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        photoLabel.setText("Photo        :");

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

        addressInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

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

        ownerLabel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        ownerLabel.setText("Owner       :");

        priceLabel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        priceLabel.setText("Price         :");

        priceInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        facilityLabel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        facilityLabel.setText("Facility      :");

        ownerName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        ownerName.setSelectedIndex(-1);
        ownerName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ownerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ownerNameActionPerformed(evt);
            }
        });

        textAreaScroll2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        facilityInput1.setColumns(20);
        facilityInput1.setRows(5);
        facilityInput1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textAreaScroll2.setViewportView(facilityInput1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(photoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(choosePhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textAreaScroll2, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)))
                            .addComponent(facilityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(ownerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(priceLabel, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nameInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addressInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(priceInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ownerName, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(menuLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(addBoardingHouse, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resetForm, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(menuLabel)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ownerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ownerName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressInput, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textAreaScroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(facilityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choosePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(photoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBoardingHouse, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetForm, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addBoardingHouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBoardingHouseActionPerformed
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
    }//GEN-LAST:event_addBoardingHouseActionPerformed

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
        if (window instanceof PopUpMenuBoardingHouse) {
            PopUpMenuBoardingHouse puabh = (PopUpMenuBoardingHouse) window;
            puabh.dispose();
        }
    }//GEN-LAST:event_cancelActionPerformed

    private void ownerInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ownerInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ownerInputActionPerformed

    private void ownerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ownerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ownerNameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customSwing.Button addBoardingHouse;
    private customSwing.TextFieldAddData addressInput;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField age;
    private customSwing.TextFieldAddData ageInput2;
    private customSwing.Button cancel;
    private customSwing.Button choosePhoto;
    private customSwing.ComboboxAddData comboboxAddData1;
    private customSwing.ComboboxAddData comboboxAddData2;
    private customSwing.ComboboxAddData comboboxAddData3;
    private javax.swing.JTextArea facilityInput;
    private customSwing.TextArea facilityInput1;
    private javax.swing.JLabel facilityLabel;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel menuLabel;
    private javax.swing.JTextField name;
    private customSwing.TextFieldAddData nameInput;
    private javax.swing.JLabel nameLabel;
    private customSwing.TextFieldAddData ownerInput;
    private javax.swing.JLabel ownerLabel;
    private customSwing.ComboboxAddData ownerName;
    private javax.swing.JLabel photoLabel;
    private customSwing.TextFieldAddData priceInput;
    private javax.swing.JLabel priceLabel;
    private customSwing.Button resetForm;
    private customSwing.TextArea textArea1;
    private customSwing.TextAreaScroll textAreaScroll1;
    private customSwing.TextAreaScroll textAreaScroll2;
    private customSwing.TextFieldAddData textFieldAddData1;
    private customSwing.TextFieldAddData textFieldAddData3;
    private customSwing.TextFieldAddData txtImage;
    // End of variables declaration//GEN-END:variables
}
