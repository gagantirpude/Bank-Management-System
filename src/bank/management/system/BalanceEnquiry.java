package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    //todo: Global Variables
    String pinNumber;

    String balanceAmount;

    JLabel accountBalance, balanceDetails;
    JButton back, exit, balanceEnquiryBtn;
    BalanceEnquiry(String pinNumber){

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
        accountBalance = new JLabel("Your Current Account Balance is: ");
        accountBalance.setFont(new Font("Tahoma", Font.BOLD, 16));
        accountBalance.setForeground(new Color(254, 254, 254));
        accountBalance.setBounds(480, 180, 400, 35);
        //add the amount  above the image
        image.add(accountBalance);



        //get the balance amount from the database
        int balance = 0;
        try{
            Conn c1 = new Conn();
            String q1 = "select * from bank where pinNumber = '"+pinNumber+"'";
            ResultSet rs = c1.statement.executeQuery(q1);
            while (rs.next()){

                if (rs.getString("type").equals("Deposit")){
                    System.out.println("Deposit");
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    System.out.println("Withdraw");
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception E){
            E.printStackTrace();
        }



        //set the balance amount to the label



        //User Details Balance Amount Label
        balanceDetails = new JLabel("Rs. "+(balance));
        balanceDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
        balanceDetails.setForeground(new Color(254, 254, 254));
        balanceDetails.setBounds(480, 220, 400, 35);
        //add the amount  above the image
        image.add(balanceDetails);



        back = new JButton("Back");
        back.setBounds(700, 380, 150, 30);
        back.setFont(new Font("Tahoma", Font.BOLD, 16));
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(65, 125, 128));
        back.addActionListener(this);
        image.add(back);

        exit = new JButton("Exit");
        exit.setFont(new Font("Tahoma", Font.BOLD, 16));
        exit.setForeground(Color.WHITE);
        exit.setBackground(new Color(65, 125, 128));
        exit.setBounds(700, 420, 150, 30);
        exit.addActionListener(this);
        exit.addActionListener(this);
        image.add(exit);


        setLayout(null);
        setSize(1550, 830);
        setLocation(0, 0);
        setTitle("Deposit");
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == back){
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }else if(e.getSource() == exit){
                System.exit(0);
            }
        }catch (Exception e1){
            System.out.println(e1);
        }
    }

    public static void main(String[] args) {

        new BalanceEnquiry("");

    }
}
