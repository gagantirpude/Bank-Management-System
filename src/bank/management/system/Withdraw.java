package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {

    //Create a Global Variable
    String pinNumber;


    //text field for the amount to deposit
    JTextField amount;

    //Button
    JButton withdrawBtn, back, exit;

    Withdraw(String pinNumber) {

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
        JLabel cardNum = new JLabel("Enter Amount You Want To Withdraw");
        cardNum.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        cardNum.setForeground(new java.awt.Color(254, 254, 254));
        cardNum.setBounds(480, 180, 400, 35);
        //add the amount  above the image
        image.add(cardNum);


        amount = new JTextField();
        amount.setFont(new java.awt.Font("Tahoma", Font.BOLD, 20));
        amount.setForeground(Color.WHITE);
        amount.setBackground(new Color(65, 125, 128));
        amount.setBounds(480, 220, 305, 30);
        //add the amount  above the image
        image.add(amount);

        withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(700, 340, 150, 30);
        withdrawBtn.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        withdrawBtn.setForeground(Color.WHITE);
        withdrawBtn.setBackground(new Color(65, 125, 128));
        withdrawBtn.addActionListener(this);
        image.add(withdrawBtn);

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
        setLocation(0, 0);
        setTitle("Deposit");
        setVisible(true);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
       try{
              if(e.getSource() == withdrawBtn) {
                  // Get the amount to withdraw
                  String amountToWithdraw = amount.getText();

                  // Date of Withdrawal
                  Date date = new Date();

                    // Check if the amount to withdraw is empty
                    if (amountToWithdraw.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter the amount to withdraw");
                    } else {
                        Conn conn = new Conn();

                        String query1 ="select * from bank where pinNumber = '" + pinNumber + "'";

                        // executeQuery() is used to execute the query. means returns a ResultSet object.
                        ResultSet resultSet = conn.statement.executeQuery(query1);


                        // Initialize the balance to 0
                        int balance = 0;


                        // Loop through the ResultSet and add the deposit amount to the balance.
                        while (resultSet.next()) {
                            // Check if the transaction type is Deposit or Withdraw
                           if(resultSet.getString("type").equals("Deposit")) {
                               System.out.println(resultSet.getString("amount") + " Deposit");
                               balance += Integer.parseInt(resultSet.getString("amount"));
                           } else {
                               System.out.println(resultSet.getString("amount") + " Withdraw");
                               balance -= Integer.parseInt(resultSet.getString("amount") );
                           }
                        }

                        // Check if the balance is greater than the amount to withdraw
                        if (balance < Integer.parseInt(amountToWithdraw)) {
                            JOptionPane.showMessageDialog(null, "Insufficient Balance");
                            //return; // Return to the previous page without updating the balance.

                        } else {

                            // Insert the transaction details into the database
                            String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Withdraw', '"+amountToWithdraw+"')";

                            // Update the balance in the database
                            conn.statement.executeUpdate(query);

                            // Show the message that the amount is debited successfully
                            JOptionPane.showMessageDialog(null, "Rs. "+amountToWithdraw+" Withdraw Successfully");
                            setVisible(false);
                            new Transactions(pinNumber).setVisible(true);
                        }

                    }
              } else if (e.getSource() == back) {
                  setVisible(false);
                  new Transactions(pinNumber).setVisible(true);
              } else if (e.getSource() == exit) {
                  System.exit(0);
              }
       }
       catch(Exception E){
           E.printStackTrace();
       }
    }




    public static void main(String[] args) {
        new Withdraw("");
    }
}
