/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author timot
 */
public class MyWindowBordeLayout extends JFrame {

    

    public MyWindowBordeLayout(){
        super("Ouiiiiiiiiiii");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(200,200);
        this.setLocationRelativeTo(null);
        
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        JButton btnOui = new JButton("Ouiiiiiiiiii");
        btnOui.setPreferredSize(new Dimension(200,0));
        contentPane.add(btnOui, BorderLayout.NORTH);
        
        JButton btnNon = new JButton("Noooooooooon");
        contentPane.add(btnNon, BorderLayout.WEST);
        
        JCheckBox chkYes = new JCheckBox("Yeeeeeeeees");
        contentPane.add(chkYes, BorderLayout.SOUTH);
        
        JTextField txtNo = new JTextField("Noooooooooon");
        contentPane.add(txtNo, BorderLayout.EAST);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        
        
        MyWindowBordeLayout myWindow = new MyWindowBordeLayout();
        myWindow.setVisible(true);

    }

}
