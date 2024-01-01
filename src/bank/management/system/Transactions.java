package bank.management.system;

import javax.swing.*;
import javax.swing.JButton;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    //Create a Global Variable
    String pinNumber;

    //Button
    JButton deposit,withdraw, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    Transactions(String pinNumber){


        // Set the pinNumber to the global variable pinNumber
        this.pinNumber = pinNumber;


        //todo: ATM Image to the Frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 830);
        add(image);

        //todo: Text to the Frame
        JLabel  text = new JLabel("Please Select Your Transaction");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        // upper case
        text.setText(text.getText().toUpperCase());
        text.setBounds(480, 150, 700, 35);
        image.add(text);


        //todo: Button to the Frame
        //Deposit Button
        deposit = new JButton("Deposit");
        deposit.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        deposit.setForeground(Color.WHITE);
        deposit.setBackground(new Color(65, 125, 128));
        deposit.setBounds(410, 272, 165, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        //Withdraw Button
        withdraw = new JButton("Withdraw");
        withdraw.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        withdraw.setForeground(Color.WHITE);
        withdraw.setBackground(new Color(65, 125, 128));
        withdraw.setBounds(685, 272, 165, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        //Fast Cash Button
        fastCash = new JButton("Fast Cash");
        fastCash.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        fastCash.setForeground(Color.WHITE);
        fastCash.setBackground(new Color(65, 125, 128));
        fastCash.setBounds(410, 320, 165, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        //Mini Statement Button
        miniStatement = new JButton("Mini Statement");
        miniStatement.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        miniStatement.setForeground(Color.WHITE);
        miniStatement.setBackground(new Color(65, 125, 128));
        miniStatement.setBounds(685, 320, 165, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);


        //Pin Change Button
        pinChange = new JButton("Pin Change");
        pinChange.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        pinChange.setForeground(Color.WHITE);
        pinChange.setBackground(new Color(65, 125, 128));
        pinChange.setBounds(410, 365, 165, 30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        //Balance Enquiry Button
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        balanceEnquiry.setForeground(Color.WHITE);
        balanceEnquiry.setBackground(new Color(65, 125, 128));
        balanceEnquiry.setBounds(685, 365, 165, 30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        //Exit Button
        exit = new JButton("Exit");
        exit.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        exit.setForeground(Color.WHITE);
        exit.setBackground(new Color(65, 125, 128));
        exit.setBounds(685, 413, 165, 30);
        exit.addActionListener(this);
        image.add(exit);




        setLayout(null);
        setTitle("Transaction");
        setSize(1550,1080);
        setLocation(0,0);
        setBackground(Color.ORANGE);
        setUndecorated(true);
        setVisible(true);
        //end of the constructor
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == deposit) {

                new Deposit(pinNumber).setVisible(true);
                setVisible(false);

            } else if (e.getSource() == withdraw) {

                new Withdraw(pinNumber).setVisible(true);
                setVisible(false);

            }   else if (e.getSource() == fastCash) {

                new FastCash(pinNumber).setVisible(true);
                setVisible(false);

            }   else if (e.getSource() == miniStatement) {

                new MiniStatement(pinNumber).setVisible(true);
                setVisible(false);

            }   else if (e.getSource() == pinChange) {

                new Pin(pinNumber).setVisible(true);
                setVisible(false);

            }   else if (e.getSource() == balanceEnquiry) {

                new BalanceEnquiry(pinNumber).setVisible(true);
                setVisible(false);

            }   else if (e.getSource() == exit) {

                JOptionPane.showMessageDialog(null, "Exit");
                System.exit(0);
            }

        }catch(Exception ex){
            ex.fillInStackTrace();
        }

    }


    public static void main(String[] args) {
        new Transactions("");
    }
}
