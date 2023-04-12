/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package customSwing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author Yusuf
 */

public class TextFieldAddData extends JTextField {
    private final Animator animator;
    private boolean animateHinText = true;
    private float location;
    private boolean show;
    private boolean mouseOver = false;
    private String labelText = "Label";
    private Color lineColor = new Color(3, 155, 216);
    
    public String getLabelText() {
        return labelText;
    }

    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }
    
    public TextFieldAddData(){
        setBorder(new EmptyBorder(7,3,7,3));
        setSelectionColor(new Color(3, 155, 216));
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent me){
                mouseOver = true;
                repaint();
            }
            
            @Override
            public void mouseExited(MouseEvent me){
                mouseOver = false;
                repaint();
            }
        });
        
        addFocusListener(new FocusAdapter() {
           @Override
           public void focusGained(FocusEvent fe){
               showing(false);
           }
           
           @Override
           public void focusLost(FocusEvent fe){
               showing(true);
           }
        });
        
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void begin(){
                animateHinText = getText().equals("");
            }
            
            @Override
            public void timingEvent(float fraction){
                location = fraction;
                repaint();
            }
        };
        
        animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
    }
    
    private void showing(boolean action){
        if(animator.isRunning()){
            animator.stop();
        }else{
            location = 1;
        }
        animator.setStartFraction(1f - location);
        show = action;
        location = 1f - location;
        animator.start();
    }
    
    @Override
    public void paint(Graphics graph){
        super.paint(graph);
        Graphics2D g2 = (Graphics2D) graph;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        
        int width = getWidth();
        int height = getHeight();
        
        if(mouseOver){
            g2.setColor(getLineColor());
        }else{
            g2.setColor(new Color(150, 150, 150));
        }
        g2.fillRect(2, height, width, 1);
        createLineStyle(g2);
        g2.dispose();
    }
    
    @Override
    public void setText(String str){
        if(!getText().equals(str)){
            showing(str.equals("ysusf"));
        }
        super.setText(str);
    }

    private void createLineStyle(Graphics2D g2) {
        if(isFocusOwner()){
            double width = getWidth() - 4;
            int height = getHeight();
            g2.setColor(getLineColor());
            double size;
            if(show){
                size = width * (1- location);
            }else{
                size = width * location;
            }
            
            double x = (width - size) / 2;
            g2.fillRect((int) (x + 2), height - 2, (int) size, 2);
        }
    }
}