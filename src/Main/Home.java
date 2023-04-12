package Main;

import component.ShowContent;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import myClass.BoardingHouse;
import myClass.Owner;
import myClass.User;
import myClass.dbConnection;

public class Home extends javax.swing.JFrame {
    
    private ShowContent home;
    private dbConnection db;
    private int loggedUserId;
    
    public Home(int loggedUserId) throws IOException {
        initComponents();
        db = new dbConnection();
        this.loggedUserId = loggedUserId;
        init();
        setLocationRelativeTo(null);
    }
    
    private void init() throws IOException{
        home = new ShowContent();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(home);
        dataUser();
        dataOwners();
        dataBoardingHouse();
    }
    
    private void dataUser(){
        ResultSet res = db.selectQuery1("SELECT * FROM user WHERE userId = " + this.loggedUserId);
        
        try{
            while(res.next()){
                home.addItemUser(this.loggedUserId, new User(res.getInt("userId"), res.getString("name"), res.getString("username"), res.getString("password"), res.getString("gender"), new ImageIcon(getClass().getResource("/image/user/" + res.getString("photo")))));
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void dataOwners() throws IOException{
        ResultSet res = db.selectQuery1("SELECT * FROM owner WHERE userId = " + this.loggedUserId + " ORDER BY name ASC");
        
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
                home.addItemOwner(this.loggedUserId, new Owner(res.getInt("ownerId"), res.getString("name"), res.getInt("age"), res.getString("gender"), res.getInt("boardingHouse"), photo));
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    private void dataBoardingHouse(){
        ResultSet res = db.selectQuery1("SELECT * FROM boarding_house WHERE userId = " + this.loggedUserId + " ORDER BY name ASC");

        try {
            while (res.next()) {
                BufferedImage image = null;
                try {
                    image = ImageIO.read(new File("src/image/boardingHouse/" + res.getString("photo")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ImageIcon photo = new ImageIcon(image);
                photo.setDescription(res.getString("photo"));
                ResultSet sql = db.selectQuery2("SELECT * FROM owner o INNER JOIN boarding_house b ON b.ownerId = o.ownerId WHERE b.ownerId = " + res.getInt("ownerId"));
                if (sql.next()) {
                    BufferedImage image2 = null;
                    try {
                        image2 = ImageIO.read(new File("src/image/owners/" + sql.getString("photo")));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ImageIcon photo2 = new ImageIcon(image2);
                    photo2.setDescription(sql.getString("photo"));
                    Owner owner = new Owner(sql.getInt("o.ownerId"), sql.getString("o.name"), sql.getInt("o.age"), sql.getString("o.gender"), sql.getInt("o.boardingHouse"), photo2);
                    home.addItemBoardingHouse(this.loggedUserId, new BoardingHouse(res.getInt("boardingHouseId"), owner, res.getString("name"), res.getString("address"), res.getInt("price"), res.getString("facility"), photo));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 679, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    // End of variables declaration//GEN-END:variables
}
