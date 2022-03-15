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




public class Main extends JFrame implements TextInterface   {
    
    JTextArea textArea1;
    JTextArea textArea2;
    MainLogic logic;

    JTextArea topPanelArea1;
    JTextArea topPanelArea2;
    JTextArea topPanelArea3;
    public Main (String _name){
        super(_name);

        

        JPanel middlePanel = new JPanel();
        textArea1 = new JTextArea ("App started ...",14,50);
        textArea1.setEditable(false);
        textArea2 = new JTextArea ("",3,50);
        JScrollPane sp = new JScrollPane(textArea1);
        middlePanel.add(sp,BorderLayout.NORTH);
        middlePanel.add(textArea2,BorderLayout.SOUTH);

        JButton button = new JButton("Proceed");

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
        this.add(button,java.awt.BorderLayout.SOUTH);
        
        logic = new MainLogic(Main.this);
        
        
        //An additional thread is created in this program design to empty the messaging queue
        

        connectButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){

                logic.connect(topPanelArea1.getText(),Integer.parseInt(topPanelArea2.getText()),Integer.parseInt(topPanelArea3.getText()));
            }
        });

        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                logic.getData();
                //logic.placeOrderFct();
                
                
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
        textArea2.setText(textArea2.getText() + "\n" + s2);
    }

    

}
