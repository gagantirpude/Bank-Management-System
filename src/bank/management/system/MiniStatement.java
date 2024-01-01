package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener{

    JLabel  cardNumber,cardNumber1,accountBalance;
    //todo: Global Variables
    String pinNumber;

    JButton button;

    MiniStatement(String pinNumber){

        // Set the pinNumber to the global variable pinNumber
        this.pinNumber = pinNumber;


        JLabel  text = new JLabel("Your Mini Statement");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.BLACK);
        text.setText(text.getText().toUpperCase());
        text.setBounds(105, 50, 200, 20);
        add(text);


        //todo: Card Number
        cardNumber1 = new JLabel();

        //todo: Create a new Conn object to connect to the database
        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM login WHERE pinNumber = '" + pinNumber + "'";
            ResultSet rs = conn.statement.executeQuery(query);
            while (rs.next()) {
                cardNumber1.setText(rs.getString("cardNumber").substring(0, 4) + "XXXXXXXX"+ rs.getString("cardNumber").substring(12));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        cardNumber = new JLabel("Your Card Number : "+ cardNumber1.getText());
        cardNumber.setForeground(Color.WHITE);
        cardNumber.setFont(new Font("System", Font.BOLD, 10));
        cardNumber.setForeground(Color.BLACK);
        cardNumber.setText(cardNumber.getText().toUpperCase());
        cardNumber.setBounds(90, 80, 500, 20);
        add(cardNumber);


        JLabel label1 = new JLabel();
        label1.setBounds(20,130,400,350);
        add(label1);


        JLabel label4 = new JLabel();
        label4.setBounds(180,500,300,20);
        add(label4);


        try{
            int balance =0;
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pinNumber = '"+pinNumber+"'");
            while (resultSet.next()){

                label1.setText(label1.getText() + "<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+ "<br><br><html>");

                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            label4.setText("Your Total Balance is Rs "+balance);
        }catch (Exception e){
            e.printStackTrace();
        }

        button = new JButton("Back");
        button.setBounds(20,500,100,25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);

















        setLayout(null);
        // Set the title of the frame
        setTitle("Mini Statement");
        setSize(400, 600);
        setLocation(600, 100);
        getContentPane().setBackground(new Color(161, 238, 189));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
            if(ae.getSource() == button){
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }
        }catch (Exception e){
                e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }

}
