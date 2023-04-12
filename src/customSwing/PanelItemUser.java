/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package customSwing;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Yusuf
 */

public class PanelItemUser extends JPanel {
    public PanelItemUser(){
        setBackground(Color.WHITE);
        setLayout(new WrapLayout(WrapLayout.LEFT, 15, 10));
    }
}
