package Main;

import component.Login;
import component.Register;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import myClass.dbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {
    private dbConnection db;
    
    public Main() {
        initComponents();
        db = new dbConnection();
        Login login = new Login();
        Register register = new Register();
        
        slide.setAnimate(25);
        slide.init(login, register);
        
        login.addEventRegister(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                slide.show(1);
            }
        });
        register.addEventLogin(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                slide.show(0);
            }
        });
        login.addEventHome(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                if(login.getUsername().isEmpty() && login.getPassword().isEmpty()){
                    JOptionPane.showMessageDialog(null, "The fields are not completely filled!");
                }else{
                    try {
                        ResultSet sql = db.selectQuery1("SELECT * FROM user WHERE username='" + login.getUsername() + "' AND password='" + login.getPassword() +"'");
                        if(sql.next()){
                            if(login.getUsername().equals(sql.getString("username")) && login.getPassword().equals(sql.getString("password"))){
                                // show information
                                System.out.println("Login Success!");

                                dispose();
                                Home home = new Home(sql.getInt("userId"));
                                home.setVisible(true);
                            }
                        }else{
                            System.out.println("Username or password is incorect!");
                            JOptionPane.showMessageDialog(null, "Username or password not match!");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        register.addEventAfterRegister(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                if(register.getGender() != null){
                    if(register.getNameRegister().isEmpty() && register.getUsername().isEmpty() && login.getPassword().isEmpty()){
                        JOptionPane.showMessageDialog(null, "The fields are not completely filled!");
                    }else{
                        String sql = "INSERT INTO user (name, username, password, gender) VALUES ('" + register.getNameRegister() + "', '" + register.getUsername() + "', '" + register.getPassword() + "', '" + register.getGender()+"')";
                        db.updateQuery1(sql);

                        System.out.println("Register Success!");
                        JOptionPane.showMessageDialog(null, "You have successfully registered!");

                        slide.show(0);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "The gender field is required!");
                }
            }
        });
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        slide = new customSwing.PanelSlide();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        slide.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout slideLayout = new javax.swing.GroupLayout(slide);
        slide.setLayout(slideLayout);
        slideLayout.setHorizontalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        slideLayout.setVerticalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customSwing.PanelSlide slide;
    // End of variables declaration//GEN-END:variables
}
