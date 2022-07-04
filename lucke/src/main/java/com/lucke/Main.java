package com.lucke;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.io.DataInputStream;
import com.ib.client.*;




public class Main extends JFrame implements TextInterface, KeyListener   {
    
    JTextArea textArea1;
    JTextArea textArea2;
    MainLogic logic;
    
    private GuiThreadDecoupler _guiThreadDecoupl;

    JTextArea topPanelArea1;
    JTextArea topPanelArea2;
    JTextArea topPanelArea3;
    public Main (String _name){
        super(_name);

        

        JPanel middlePanel = new JPanel();
        textArea1 = new JTextArea ("App started ...",14,50);
        textArea1.setEditable(false);
        textArea2 = new JTextArea ("",1,50);
        JPanel lowerPanel = new JPanel();
        JPanel lowerNorthPanel = new JPanel();
        JPanel lowerSouthPanel = new JPanel();
        lowerPanel.add(lowerNorthPanel,BorderLayout.NORTH);
        lowerPanel.add(lowerSouthPanel,BorderLayout.SOUTH);
        
        JScrollPane sp = new JScrollPane(textArea1);
        middlePanel.add(sp,BorderLayout.NORTH);
        middlePanel.add(textArea2,BorderLayout.SOUTH);

        
        JButton buttonLucke = new JButton("Lucke");
        lowerNorthPanel.add(buttonLucke,BorderLayout.CENTER);
        

        JPanel topPanel = new JPanel();
        topPanelArea1 = new JTextArea("127.0.0.1",1,1);
        topPanelArea2 = new JTextArea("7497",1,1);
        topPanelArea3 = new JTextArea("2",1,1);
        JButton connectButton = new JButton("Connect");
        
        topPanel.setLayout(new FlowLayout());
        topPanel.add(topPanelArea1,BorderLayout.CENTER);
        topPanel.add(topPanelArea2,BorderLayout.CENTER);
        topPanel.add(topPanelArea3,BorderLayout.CENTER);
        topPanel.add(connectButton,BorderLayout.CENTER);
        
        this.add(topPanel,java.awt.BorderLayout.NORTH);
        this.add(middlePanel,java.awt.BorderLayout.CENTER);
        this.add(lowerPanel,java.awt.BorderLayout.SOUTH);
        
        logic = new MainLogic(Main.this);
        
        //textArea2.setFont(textArea2.getFont().deriveFont(12f));  // changes the font of the textArea2
        textArea2.getDocument().putProperty("filterNewlines", Boolean.TRUE); // Makes the textArea2 only have 1 line
        textArea2.addKeyListener(this);
        


        




        connectButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){

                logic.connect(topPanelArea1.getText(),Integer.parseInt(topPanelArea2.getText()),Integer.parseInt(topPanelArea3.getText()));
            }
        });

        
        buttonLucke.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                logic.getData(true,false);
            }

        });







        
        setSize(500,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }



    public static void main (String []args){
        Main main1 = new Main("Stock App");
    }

    public void setTextArea1(String s1){
        textArea1.setText(textArea1.getText() + "\n" + s1);
    }

   


    public void setTextArea2(String s2){
        textArea2.setText(s2);
    }

    public String getTextArea2 (){
        return textArea2.getText();
    }

    public void keyPressed(KeyEvent key){
        if ( key.getKeyCode() == KeyEvent.VK_ENTER){
            Runnable runAction = new Runnable() {
                public void run(){
                    logic.checkForCommand();
                }
            };
            _guiThreadDecoupl = new GuiThreadDecoupler(runAction);
            _guiThreadDecoupl.startActionExecution();
            
        }
    }

    public void keyReleased (KeyEvent key){}
    public void keyTyped (KeyEvent key){}


}
