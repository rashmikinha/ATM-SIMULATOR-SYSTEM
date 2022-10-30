package atm.simulator.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

//JFrame is  a class of swing so import swing package
public class Login extends JFrame implements ActionListener{
    //we define globally because we want to use these outside constructor also
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2,b3;
  
    //constructor
    Login(){
        // set title
        setTitle("AUTOMATED TELLER MACHINE");
        
        //for image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        // for scale or change
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        //we can't directly use image in JLabel so change into imageicon
        ImageIcon i3 = new ImageIcon(i2);
        //JLabel is udes to set image here
        JLabel label = new JLabel(i3);
        //set location of image
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        //add text 
        l1 = new JLabel("WELCOME TO ATM");
         //change font
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        //for location
        l1.setBounds(200,40,450,40);
        add(l1);
        
        //add card number
        l2 = new JLabel("Card No:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(125,150,375,30);
        add(l2);
        
        //textfield for card number
        tf1 = new JTextField(15);
        tf1.setBounds(300,150,230,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf1);
        
        //add pin tex
        l3 = new JLabel("PIN:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(125,220,375,30);
        add(l3);
        
        //textfield for password
        pf2 = new JPasswordField(15);
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300,220,230,30);
        add(pf2);
        
        // button for sign in , clear and signup        
        b1 = new JButton("SIGN IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("SIGN UP");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        setLayout(null);
        
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(300,300,100,30);
        add(b1);
        
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430,300,100,30);
        add(b2);
        
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(300,350,230,30);
        add(b3);
        
        // for show actions
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
       //to change background color        
        getContentPane().setBackground(Color.WHITE);
//        
        //setLength of frame 
        setSize(800,500);
        
        //setLocation where you want to locate frame on screen bydefault it is top left most
        setLocation(300,100);
        
        //frame visible or not by default it is hidden
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        try{        
            if(ae.getSource()==b1){
                Conn c1 = new Conn();
                String cardno  = tf1.getText();
                String pin  = pf2.getText();
                String q  = "select * from login where cardnumber = '"+cardno+"' and pin = '"+pin+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }else if(ae.getSource()==b2){
                tf1.setText("");
                pf2.setText("");
            }else if(ae.getSource()==b3){
                setVisible(false);
                new Signup().setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
            //e.printStackTrace();
        }
    }
    public static void main(String[] args){
        // ananomous object of class so when we run it class constructor so made constructor
        new Login().setVisible(true);
    }

    
}
