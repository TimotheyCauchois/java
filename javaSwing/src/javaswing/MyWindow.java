/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author timot
 */
public class MyWindow extends JFrame {

    

    public MyWindow(){
        super("Ouiiiiiiiiiii");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(null);
        
        JButton btnOui = new JButton("Ouiiiiiiiiii");
        btnOui.setBounds(200,20,160,30);
        contentPane.add(btnOui);
        
        JButton btnNon = new JButton("Noooooooooon");
        btnNon.setBounds(200,70,160,30);
        contentPane.add(btnNon);
        
        
        JCheckBox chkYes = new JCheckBox("Yeeeeeeeees");
        chkYes.setBounds(200,120,160,30);
        contentPane.add(chkYes);
        
        
        JTextField txtNo = new JTextField("Noooooooooon");
        txtNo.setBounds(200,170,160,30);
        contentPane.add(txtNo);
        
      
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        
        
        MyWindow myWindow = new MyWindow();
        myWindow.setVisible(true);

    }

}
