/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package component;

import customSwing.ScrollBarCustom;
import java.awt.Color;
import myClass.BoardingHouse;
import myClass.Owner;
import myClass.User;

/**
 *
 * @author Yusuf
 */

public class ShowContent extends javax.swing.JPanel{
    /**
     * Creates new form showContent
     */
    public ShowContent() {
        initComponents();
        setBackground(Color.WHITE);
        scrollOwner.setVerticalScrollBar(new ScrollBarCustom());
        scrollOwner.getVerticalScrollBar().setUnitIncrement(4);
        scrollBoardingHouse.setVerticalScrollBar(new ScrollBarCustom());
        scrollBoardingHouse.getVerticalScrollBar().setUnitIncrement(4);
    }
    
    public void addItemOwner(int loggedUserId, Owner data) {
        OwnerCard item = new OwnerCard(loggedUserId);
        item.setData(data);
        panelItemOwner.add(item);
        panelItemOwner.repaint();
        panelItemOwner.revalidate();
    }
     
    public void addItemBoardingHouse(int loggedUserId, BoardingHouse data) {
        BoardingHouseCard item = new BoardingHouseCard(loggedUserId);
        item.setData(data);
        panelItemBoardingHouse.add(item);
        panelItemBoardingHouse.repaint();
        panelItemBoardingHouse.revalidate();
    }
    
    public void addItemUser(int loggedUserId, User data) {
        UserCard item = new UserCard(loggedUserId);
        item.setData(data);
        panelItemUser.add(item);
        panelItemUser.repaint();
        panelItemUser.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane1 = new customSwing.TabbedPane();
        owners = new javax.swing.JPanel();
        scrollOwner = new javax.swing.JScrollPane();
        panelItemOwner = new customSwing.PanelItem();
        boardingHouse = new javax.swing.JPanel();
        scrollBoardingHouse = new javax.swing.JScrollPane();
        panelItemBoardingHouse = new customSwing.PanelItem();
        menu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelItemUser = new customSwing.PanelItemUser();

        tabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        tabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        scrollOwner.setBorder(null);
        scrollOwner.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollOwner.setPreferredSize(new java.awt.Dimension(9, 60));
        scrollOwner.setViewportView(panelItemOwner);

        javax.swing.GroupLayout ownersLayout = new javax.swing.GroupLayout(owners);
        owners.setLayout(ownersLayout);
        ownersLayout.setHorizontalGroup(
            ownersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollOwner, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
        );
        ownersLayout.setVerticalGroup(
            ownersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollOwner, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
        );

        tabbedPane1.addTab("Owners", owners);

        boardingHouse.setBackground(new java.awt.Color(255, 255, 255));

        scrollBoardingHouse.setBorder(null);
        scrollBoardingHouse.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBoardingHouse.setViewportView(panelItemBoardingHouse);

        javax.swing.GroupLayout boardingHouseLayout = new javax.swing.GroupLayout(boardingHouse);
        boardingHouse.setLayout(boardingHouseLayout);
        boardingHouseLayout.setHorizontalGroup(
            boardingHouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollBoardingHouse, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
        );
        boardingHouseLayout.setVerticalGroup(
            boardingHouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollBoardingHouse, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
        );

        tabbedPane1.addTab("Boarding House", boardingHouse);

        menu.setBackground(new java.awt.Color(255, 51, 51));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setViewportView(panelItemUser);

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );

        tabbedPane1.addTab("Menu", menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel boardingHouse;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel owners;
    private customSwing.PanelItem panelItemBoardingHouse;
    private customSwing.PanelItem panelItemOwner;
    private customSwing.PanelItemUser panelItemUser;
    private javax.swing.JScrollPane scrollBoardingHouse;
    private javax.swing.JScrollPane scrollOwner;
    private customSwing.TabbedPane tabbedPane1;
    // End of variables declaration//GEN-END:variables
}
