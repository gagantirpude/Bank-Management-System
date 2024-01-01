package bank.management.system;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    //Create a Global Variable
    String pinNumber;


    //text field for the amount to deposit
    JTextField amount;

    //Button
    JButton deposit, back, exit;

    Deposit(String pinNumber) {

        // Set the pinNumber to the global variable pinNumber
        this.pinNumber = pinNumber;



        //ATM Image to the Frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 830);
        add(image);

        //for User Details Card Number
        JLabel cardNum = new JLabel("Enter Amount You Want To Deposit");
        cardNum.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        cardNum.setForeground(new java.awt.Color(254, 254, 254));
        cardNum.setBounds(480, 180, 400, 35);
        //add the amount  above the image
        image.add(cardNum);


        amount = new JTextField();
        amount.setFont(new java.awt.Font("Tahoma", Font.BOLD, 20));
        amount.setForeground(Color.WHITE);
        amount.setBackground(new Color(65, 125,128 ));
        amount.setBounds(480, 220, 290, 30);
        //add the amount  above the image
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(700, 340, 150, 30);
        deposit.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        deposit.setForeground(Color.WHITE);
        deposit.setBackground(new Color(65, 125, 128));
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(700, 380, 150, 30);
        back.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(65, 125, 128));
        back.addActionListener(this);
        image.add(back);

        exit = new JButton("Exit");
        exit.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        exit.setForeground(Color.WHITE);
        exit.setBackground(new Color(65, 125, 128));
        exit.setBounds(700, 420, 150, 30);
        exit.addActionListener(this);
        exit.addActionListener(this);
        image.add(exit);


        setLayout(null);
        setSize(1550, 830);
        setLocation(0,0);
        setTitle("Deposit");
        setUndecorated(true);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        

        try {
            if (e.getSource() == deposit) {

                //get the amount from the text field
                String depositAmount = amount.getText();

                //Date of Deposit
                Date date = new Date();

                //check if the amount is less than 0
                if ((depositAmount.isBlank() || depositAmount.equals("0")|| depositAmount.isEmpty())) {

                    JOptionPane.showMessageDialog(null, "Please Enter the Amount to you want to Deposit");

                } else {
                        try{
                        //get the current balance from the database
                        Conn c1 = new Conn();

                        //get the current balance from the database
                        // executeQuery used for select statement form database
                        // execute the query to get the balance from the database
                        ResultSet rs = c1.statement.executeQuery("select * from bank where pinNumber = '" + pinNumber + "'");
                        int balance = 0;


                        //add the current balance with the deposit amount
                        while (rs.next()) {
                            //todo: getString() method is used to get the value of the column
                            if (rs.getString("type").equals("Deposit")) {
                                balance += Integer.parseInt(rs.getString("amount"));
                            } else {
                                balance -= Integer.parseInt(rs.getString("amount"));
                            }
                        }

                        //add the current balance with the deposit amount
                        balance += Integer.parseInt(depositAmount);

                        //update the balance in the database
                        String q1 = "insert into bank values('" + pinNumber + "','" + date + "','Deposit','" + balance + "')";
                        c1.statement.executeUpdate(q1);

                        //show the message that the amount is deposited successfully
                        JOptionPane.showMessageDialog(null, "Rs. " + depositAmount + " Deposited Successfully");

                        //show the transactions page
                        new Transactions(pinNumber).setVisible(true);

                        //hide the deposit page
                        setVisible(false);
                        }catch(Exception E){
                            E.printStackTrace();
                        }
                    }

            }
            else if (e.getSource() == back) {
                //this for back Button
                System.out.println("Back Button Clicked");
                new Transactions(pinNumber);
                setVisible(false);
            } else {
                new Login();
                setVisible(false);
            }

        } catch (Exception E) {
            E.printStackTrace();

        }


    }

    public static void main(String[] args) {
        new Deposit("" );
    }


}
