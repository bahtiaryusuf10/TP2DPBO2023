package Main;

import component.BoardingHouseMenuCard;
import java.awt.BorderLayout;
import java.io.IOException;
import java.sql.SQLException;

public class PopUpMenuBoardingHouse extends javax.swing.JFrame {
    private int loggedUserId;
    private int boardingHouseId;
    private boolean flag = false;
        
    public PopUpMenuBoardingHouse(int loggedUserId,  boolean flag, int boardingHouseId) throws SQLException, IOException {
        initComponents();
        this.loggedUserId = loggedUserId;
        this.boardingHouseId = boardingHouseId;
        this.flag = flag;
        init();
        setLocationRelativeTo(null);
    }
    
    private void init() throws SQLException, IOException{
        BoardingHouseMenuCard cabh = new BoardingHouseMenuCard(loggedUserId, flag, boardingHouseId);
        panelItem1.setLayout(new BorderLayout());
        panelItem1.add(cabh);
        panelItem1.repaint();
        panelItem1.revalidate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        panelItem1 = new customSwing.PanelItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setPreferredSize(new java.awt.Dimension(385, 375));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(panelItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private customSwing.PanelItem panelItem1;
    // End of variables declaration//GEN-END:variables
}
