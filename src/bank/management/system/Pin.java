package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener{
    JButton pinChangeBtn, back, exit;

    JPasswordField pinField, confirmPinField;

    //todo: Global Variables
    String pinNumber;
    Pin( String pinNumber) {

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
        JLabel  text = new JLabel("Change Your Pin Number");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        // upper case
        text.setText(text.getText().toUpperCase());
        text.setBounds(520, 150, 700, 35);
        image.add(text);

        //todo: Text for Pin Number
        JLabel  pinNum = new JLabel("Enter New Pin Number");
        pinNum.setForeground(Color.WHITE);
        pinNum.setFont(new Font("System", Font.BOLD, 15));
        // upper case
        pinNum.setText(pinNum.getText().toUpperCase());
        pinNum.setBounds(530, 200, 700, 35);
        image.add(pinNum);

        //todo Password Field
        //Pin Field
        pinField = new JPasswordField();
        pinField.setFont(new java.awt.Font("Tahoma", Font.BOLD, 20));
        pinField.setForeground(Color.WHITE);
        pinField.setBackground(new Color(65, 125, 128));
        pinField.setBounds(507, 230, 230, 30);
        image.add(pinField);



        //todo: Text for Confirm Pin Number
        JLabel  confirmPinNum = new JLabel("Confirm New Pin Number");
        confirmPinNum.setForeground(Color.WHITE);
        confirmPinNum.setFont(new Font("System", Font.BOLD, 15));
        // upper case
        confirmPinNum.setText(confirmPinNum.getText().toUpperCase());
        confirmPinNum.setBounds(518, 270, 700, 35);
        image.add(confirmPinNum);

        //Confirm Pin Field
        confirmPinField = new JPasswordField();
        confirmPinField.setFont(new java.awt.Font("Tahoma", Font.BOLD, 20));
        confirmPinField.setForeground(Color.WHITE);
        confirmPinField.setBackground(new Color(65, 125, 128));
        confirmPinField.setBounds(507, 300, 230, 30);

        image.add(confirmPinField);




        //todo: Button to the Frame
        //Change Pin Number Button
        pinChangeBtn = new JButton("Change Pin");
        pinChangeBtn.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        pinChangeBtn.setForeground(Color.WHITE);
        pinChangeBtn.setBackground(new Color(65, 125, 128));
        pinChangeBtn.setBounds(685, 365, 165, 30);
        pinChangeBtn.addActionListener(this);
        image.add(pinChangeBtn);

        //Back Button
        back = new JButton("Back");
        back.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(65, 125, 128));
        back.setBounds(685, 413, 165, 30);
        back.addActionListener(this);
        image.add(back);

        exit = new JButton("Exit");
        exit.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        exit.setForeground(Color.WHITE);
        exit.setBackground(new Color(65, 125, 128));
        exit.setBounds(410, 413, 165, 30);
        exit.addActionListener(this);
        image.add(exit);


        setLayout(null);
        setSize(1550, 1080);
        setLocation(0,0);
        setUndecorated(true);
        setTitle("Pin Change");
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == pinChangeBtn) {
                String newPin = pinField.getText();
                String confirmPin = confirmPinField.getText();



                if (newPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter a Pin Number");
                    return;
                } else if (confirmPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Confirm a Pin Number");
                    return;
                } else  if (!newPin.equals(confirmPin)) {
                    JOptionPane.showMessageDialog(null, "Pin Number Does Not Match");
                    return;
                } else if (newPin.length() != 4) {
                    JOptionPane.showMessageDialog(null, "Pin Number Must be 4 Digits");
                    return;
                }else{

                    try {
                        Conn conn = new Conn();
                        String query = "update bank set pinNumber = '" + newPin + "' where pinNumber = '" + pinNumber + "'";
                        String query2 = "update login set pinNumber = '" + newPin + "' where pinNumber = '" + pinNumber + "'";
                        String query3 = "update signup3 set pinNumber = '" + newPin + "' where pinNumber = '" + pinNumber + "'";

                        //System.out.println(query);
                        //System.out.println(query2);
                        //System.out.println(query3);
                        //execute the query
                        conn.statement.executeUpdate(query);
                        conn.statement.executeUpdate(query2);
                        conn.statement.executeUpdate(query3);

                        //show the message
                        JOptionPane.showMessageDialog(null, "Pin Number Changed Successfully");
                        setVisible(false);
                        new Transactions(newPin).setVisible(true);
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }

            } else if (e.getSource() == back) {
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);

            } else if (e.getSource() == exit) {
                JOptionPane.showMessageDialog(null, "Exit");
                System.exit(0);
            }

            }catch(Exception e1){
                e1.printStackTrace();
            }
        }




        public static void main(String[] args) {
            new Pin("");
        }






}
