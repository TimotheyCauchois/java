/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author timot
 */
public class MyBled extends JFrame {

    

    public MyBled(){
        super("Ouiiiiiiiiiii");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        
        JPanel contentPane = (JPanel) this.getContentPane();
        //contentPane.setLayout(new GridLayout(2,2,30,30));
        
        
        contentPane.add(createToolBar(), BorderLayout.NORTH);
        
        JScrollPane westComponent = new JScrollPane(new JTree());
        westComponent.setPreferredSize(new Dimension(200,0));
        contentPane.add(westComponent, BorderLayout.WEST);
        
        JTextArea txtNo = new JTextArea("Noooooooooo");
        JScrollPane scrTxtNo = new JScrollPane(txtNo);
        contentPane.add(scrTxtNo);
        
        contentPane.add(createRightPanel(), BorderLayout.EAST);

        contentPane.add(createStatusBar(), BorderLayout.SOUTH);
        
    }
    private JToolBar createToolBar(){
        JToolBar toolBar = new JToolBar();
        
        JButton btnOui = new JButton("Ouiiiiiiiiii");
        toolBar.add(btnOui);
        
        JButton btnNon = new JButton("Noooooooooon");
        toolBar.add(btnNon);
        
        JCheckBox chkYes = new JCheckBox("Yeeeeeeeees");
        toolBar.add(chkYes);
        
        JTextField txtNo = new JTextField("Noooooooooon");
        toolBar.add(txtNo); 
        txtNo.setPreferredSize(new Dimension(140,30));
        
        return toolBar;
    }
    
    private JPanel createStatusBar(){
        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JLabel lblStatus1 = new JLabel("ouiiiiiiiii");
        lblStatus1.setPreferredSize(new Dimension(100,30));
        statusBar.add(lblStatus1);
        
        JLabel lblStatus2 = new JLabel("noooooooooon");
        lblStatus2.setPreferredSize(new Dimension(100,30));
        statusBar.add(lblStatus2);
        
        JLabel lblStatus3 = new JLabel("yeeeeeeeeees");
        lblStatus3.setPreferredSize(new Dimension(100,30));
        statusBar.add(lblStatus3);
        
        return statusBar;
    }
    
    private JPanel createRightPanel(){
        JPanel panel = new JPanel(new GridLayout(4,1));
        
        
        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("4"));

        
        
        return panel;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        
        
        MyBled myWindow = new MyBled();
        myWindow.setVisible(true);

    }

}
