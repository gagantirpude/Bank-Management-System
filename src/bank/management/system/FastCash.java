package bank.management.system;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {


    //Global Variables
    String pinNumber;

    JButton rs100Btn, rs500Btn, rs1000Btn, rs2000Btn, rs5000Btn, rs10000Btn, back;


    public FastCash(String pinNumber) {

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
        JLabel  text = new JLabel("Select Withdrawl Amount");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        // upper case
        text.setText(text.getText().toUpperCase());
        text.setBounds(510, 150, 700, 35);
        image.add(text);


        //todo: Button to the Frame
        //Deposit Button
        rs100Btn = new JButton("Rs. 100");
        rs100Btn.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        rs100Btn.setForeground(Color.WHITE);
        rs100Btn.setBackground(new Color(65, 125, 128));
        rs100Btn.setBounds(410, 272, 165, 30);
        rs100Btn.addActionListener(this);
        image.add(rs100Btn);

        //Withdraw Button
        rs500Btn = new JButton("Rs. 500");
        rs500Btn.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        rs500Btn.setForeground(Color.WHITE);
        rs500Btn.setBackground(new Color(65, 125, 128));
        rs500Btn.setBounds(685, 272, 165, 30);
        rs500Btn.addActionListener(this);
        image.add(rs500Btn);

        //Fast Cash Button
        rs1000Btn = new JButton("Rs. 1000");
        rs1000Btn.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        rs1000Btn.setForeground(Color.WHITE);
        rs1000Btn.setBackground(new Color(65, 125, 128));
        rs1000Btn.setBounds(410, 320, 165, 30);
        rs1000Btn.addActionListener(this);
        image.add(rs1000Btn);

        //Mini Statement Button
        rs2000Btn = new JButton("Rs. 2000");
        rs2000Btn.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        rs2000Btn.setForeground(Color.WHITE);
        rs2000Btn.setBackground(new Color(65, 125, 128));
        rs2000Btn.setBounds(685, 320, 165, 30);
        rs2000Btn.addActionListener(this);
        image.add(rs2000Btn);


        //Pin Change Button
        rs5000Btn = new JButton("Rs. 5000");
        rs5000Btn.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        rs5000Btn.setForeground(Color.WHITE);
        rs5000Btn.setBackground(new Color(65, 125, 128));
        rs5000Btn.setBounds(410, 365, 165, 30);
        rs5000Btn.addActionListener(this);
        image.add(rs5000Btn);

        //Balance Enquiry Button
        rs10000Btn = new JButton("Rs. 10000");
        rs10000Btn.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        rs10000Btn.setForeground(Color.WHITE);
        rs10000Btn.setBackground(new Color(65, 125, 128));
        rs10000Btn.setBounds(685, 365, 165, 30);
        rs10000Btn.addActionListener(this);
        image.add(rs10000Btn);

        //Exit Button
        back = new JButton("Back");
        back.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(65, 125, 128));
        back.setBounds(685, 413, 165, 30);
        back.addActionListener(this);
        image.add(back);


        setLayout(null);
        setTitle("Fast Cash");
        setSize(1550,1080);
        setLocation(0,0);
        setBackground(Color.ORANGE);
        setUndecorated(true);
        setVisible(true);
        //end of the constructor
    }


    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == back){
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }else {

                //todo: get the amount from the button
                //todo:((JButton) e.getSource()) -> get the button that is clicked.
                // getText() -> get the text of the button
                // substring(4) -> get the text after the 4th character.
                String amount = ((JButton) e.getSource()).getText().substring(4);

                //todo: Database Connection
                // Conn -> Connection Object.
                // statement -> Statement Object.

                // executeUpdate() -> execute the query.
                // The executeUpdate() method returns the number of rows affected by the query.
                // The executeUpdate() method is used to update the database.
                // The executeUpdate() method is used to execute the SQL statements, INSERT, UPDATE, or DELETE statement.
                // The executeUpdate() method returns an int value which represents the number of rows affected by the query.
                // The executeUpdate() method returns 0 if the query returns nothing.
                // The executeUpdate() method throws SQLException if the query is not a SQL INSERT, UPDATE or DELETE statement.
                // The executeUpdate() method is a part of the Statement interface and is available since JDK 1.2.
                // The executeUpdate() method is available in both Connection and Statement interface.
                // The executeUpdate() method is an overloaded method and can accept both String and PreparedStatement as arguments.

                //todo: Date
                Date date = new Date();
                Conn conn = new Conn();
                try{
                    String query = "select * from bank where pinNumber = '"+pinNumber+"'";
                    ResultSet  rs = conn.statement.executeQuery(query);

                    int balance = 0;

                    //todo: check the balance
                    //rs.next() -> move the pointer to the next row.
                    //rs.getString("type") -> get the value of the type column.
                    //Integer.parseInt(rs.getString("amount")) -> get the value of the amount column and convert it to an integer.
                    //balance += Integer.parseInt(rs.getString("amount")) -> add the amount to the balance.
                    //balance -= Integer.parseInt(rs.getString("amount")) -> subtract the amount from the balance.
                    while (rs.next()){
                        if (rs.getString("type").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        }else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }String num="17";

                    if (e.getSource() != back && balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }else {
                        balance -= Integer.parseInt(amount);
                        String query1 = "insert into bank values('" + pinNumber + "', '" + date + "', 'Fast Cash', '" + amount + "')";
                        conn.statement.executeUpdate(query1);
                        JOptionPane.showMessageDialog(null, "Rs. " + amount + " Withdrawl Successful");
                    }
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }

        }catch(Exception E){
            E.printStackTrace();
        }

        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }

    public static void main(String[] args) {
        new FastCash("");
    }


}
