/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing;

import java.awt.Dimension;
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
public class MyWindowFlowLayout extends JFrame {

    

    public MyWindowFlowLayout(){
        super("Ouiiiiiiiiiii");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(200,200);
        this.setLocationRelativeTo(null);
        
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.RIGHT,20,30));
        
        JButton btnOui = new JButton("Ouiiiiiiiiii");
        contentPane.add(btnOui);
        
        JButton btnNon = new JButton("Noooooooooon");
        contentPane.add(btnNon);
        
        JCheckBox chkYes = new JCheckBox("Yeeeeeeeees");
        contentPane.add(chkYes);
        
        JTextField txtNo = new JTextField("Noooooooooon");
        txtNo.setPreferredSize(new Dimension(120, 20));
        contentPane.add(txtNo);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        
        
        MyWindowFlowLayout myWindow = new MyWindowFlowLayout();
        myWindow.setVisible(true);

    }

}
