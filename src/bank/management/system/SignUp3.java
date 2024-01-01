package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Arrays;
import java.util.Random;

public class SignUp3 extends JFrame implements ActionListener{

    //Create a Global Variable
    String formNum;

    //Radio Buttons for Account Type
    JRadioButton savingAccount, currentAccount, fixedDepositAccount, recurringDepositAccount;


    //CheckBox for Services Required
    JCheckBox atmCard, internetBanking, mobileBanking, emailAlerts, chequeBook, eStatement;

    //Buttons
    JButton submitBtn, backBtn;


    SignUp3(String formNumber){

        //store formNumber in form Num
        //formNum is Global Variable
        this.formNum = formNumber;

        ImageIcon bankImg = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image bankImg2 = bankImg.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon bankImg3 = new ImageIcon(bankImg2);
        JLabel bankImgLabel = new JLabel(bankImg3);
        bankImgLabel.setBounds(150,40,100,100);
        add(bankImgLabel);

        //Application Form Number
        JLabel applicationFormNumber = new JLabel("APPLICATION FORM NO." + formNum);
        applicationFormNumber.setFont(new Font("Osward",Font.BOLD,35));
        applicationFormNumber.setBounds(270,50,600,40);
        add(applicationFormNumber);

        //Page Number
        JLabel pageNumber = new JLabel("Page 3/3");
        pageNumber.setFont(new Font("Osward",Font.BOLD,20));
        pageNumber.setBounds(420,10,600,30);
        add(pageNumber);

        //Additional Personal Details
        JLabel personalDetails = new JLabel("Account Details");
        personalDetails.setFont(new Font("Osward",Font.BOLD,28));
        personalDetails.setBounds(270,100,600,40);
        personalDetails.setForeground(new Color(0, 0, 0)); //set color of text
        add(personalDetails);


        //Account Type
        JLabel accountType = new JLabel("Account Type:");
        accountType.setFont(new Font("Osward",Font.BOLD,18));
        accountType.setBounds(100,180,150,30);
        add(accountType);

        //Account Type Radio Button
        //todo: Account Type CheckBox for Saving Account.
        savingAccount = new JRadioButton("Saving Account");
        savingAccount.setFont(new Font("Raleway",Font.BOLD,16));
        savingAccount.setBackground(new Color(215, 252, 252));
        savingAccount.setBounds(130,220,150,30);
        add(savingAccount);

        //todo: Account Type CheckBox for Current Account.
        currentAccount = new JRadioButton("Current Account");
        currentAccount.setFont(new Font("Raleway",Font.BOLD,16));
        currentAccount.setBackground(new Color(215, 252, 252));
        currentAccount.setBounds(130,250,150,30);
        add(currentAccount);


        //todo: Account Type CheckBox for Fixed Deposit Account.
        fixedDepositAccount = new JRadioButton("Fixed Deposit Account");
        fixedDepositAccount.setFont(new Font("Raleway",Font.BOLD,16));
        fixedDepositAccount.setBackground(new Color(215, 252, 252));
        fixedDepositAccount.setBounds(450,220,200,30);
        add(fixedDepositAccount);

        //todo: Account Type CheckBox for Recurring Deposit Account.
        recurringDepositAccount = new JRadioButton("Recurring Deposit Account");
        recurringDepositAccount.setFont(new Font("Raleway",Font.BOLD,16));
        recurringDepositAccount.setBackground(new Color(215, 252, 252));
        recurringDepositAccount.setBounds(450,250,250,30);
        add(recurringDepositAccount);

        //todo: ButtonGroup for Account Type
        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(savingAccount);
        accountTypeGroup.add(currentAccount);
        accountTypeGroup.add(fixedDepositAccount);
        accountTypeGroup.add(recurringDepositAccount);


        //todo: Card Number
        JLabel cardNumber = new JLabel("Card Number:");
        cardNumber.setFont(new Font("Osward",Font.BOLD,18));
        cardNumber.setBounds(100,340,150,30);
        add(cardNumber);

        //Card Number TextField
        JLabel cardNumberTextField = new JLabel("XXXX-XXXX-XXXX-4841");
        cardNumberTextField.setFont(new Font("Raleway",Font.BOLD,18));
        cardNumberTextField.setBounds(400,340,300,30);
        add(cardNumberTextField);

        //Card Details
        JLabel cardDetails = new JLabel("(Your 16 Digit Card Number is Safe with Us)");
        cardDetails.setFont(new Font("Raleway",Font.BOLD,12));
        cardDetails.setBounds(100,360,500,30);
        add(cardDetails);

        //Card Number details
        JLabel cardNumberDetails = new JLabel("(We will never share your card number with anyone else)");
        cardNumberDetails.setFont(new Font("Raleway",Font.BOLD,12));
        cardNumberDetails.setBounds(400,360,500,30);
        add(cardNumberDetails);

        //PIN Number
        JLabel pinNumber = new JLabel("PIN Number:");
        pinNumber.setFont(new Font("Osward",Font.BOLD,18));
        pinNumber.setBounds(100,420,150,30);
        add(pinNumber);



        //PIN Number TextField
        JLabel pinNumberTextField = new JLabel("XXXX");
        pinNumberTextField.setFont(new Font("Raleway",Font.BOLD,18));
        pinNumberTextField.setBounds(400,420,300,30);
        add(pinNumberTextField);


        //PIN  Details
        JLabel pinNumberDetails = new JLabel("(Your 4 Digit PIN is Safe with Us)");
        pinNumberDetails.setFont(new Font("Raleway",Font.BOLD,12));
        pinNumberDetails.setBounds(100,440,500,30);
        add(pinNumberDetails);

        //PIN Details
        JLabel pinNumberDetails2 = new JLabel("(We will never share your PIN number with anyone else)");
        pinNumberDetails2.setFont(new Font("Raleway",Font.BOLD,12));
        pinNumberDetails2.setBounds(400,440,500,30);
        add(pinNumberDetails2);



        //Services Required
        JLabel servicesRequired = new JLabel("Services Required:");
        servicesRequired.setFont(new Font("Osward",Font.BOLD,18));
        servicesRequired.setBounds(100,500,200,30);
        add(servicesRequired);



        //Services Required CheckBox
        //todo: Services Required CheckBox for ATM Card.
        atmCard = new JCheckBox("ATM Card");
        atmCard.setFont(new Font("Raleway",Font.BOLD,16));
        atmCard.setBackground(new Color(215, 252, 252));
        atmCard.setBounds(130,540,150,30);
        add(atmCard);

        //todo: Services Required CheckBox for Internet Banking.
        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setFont(new Font("Raleway",Font.BOLD,16));
        internetBanking.setBackground(new Color(215, 252, 252));
        internetBanking.setBounds(130,570,150,30);
        add(internetBanking);


        //todo: Services Required CheckBox for Mobile Banking.
        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setFont(new Font("Raleway",Font.BOLD,16));
        mobileBanking.setBackground(new Color(215, 252, 252));
        mobileBanking.setBounds(130,600,150,30);
        add(mobileBanking);

        //todo: Services Required CheckBox for Email Alerts.
        emailAlerts = new JCheckBox("Email Alerts");
        emailAlerts.setFont(new Font("Raleway",Font.BOLD,16));
        emailAlerts.setBackground(new Color(215, 252, 252));
        emailAlerts.setBounds(450,540,150,30);
        add(emailAlerts);


        //todo: Services Required CheckBox for Cheque Book.
        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setFont(new Font("Raleway",Font.BOLD,16));
        chequeBook.setBackground(new Color(215, 252, 252));
        chequeBook.setBounds(450,570,150,30);
        add(chequeBook);


        //todo: Services Required CheckBox for eStatement.
        eStatement = new JCheckBox("E-Statement");
        eStatement.setFont(new Font("Raleway",Font.BOLD,16));
        eStatement.setBackground(new Color(215, 252, 252));
        eStatement.setBounds(450,600,150,30);
        add(eStatement);



        //todo: Declares that the above entered details correct to th best of my knowledge.
        JCheckBox servicesRequiredCheckBox = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.",true);
        servicesRequiredCheckBox.setFont(new Font("Raleway",Font.BOLD,16));
        servicesRequiredCheckBox.setBackground(new Color(215, 252, 252));
        servicesRequiredCheckBox.setBounds(80,630,700,30);
        add(servicesRequiredCheckBox);

        //todo: Next Button
         submitBtn = new JButton("Submit");
        submitBtn.setFont(new Font("Osward",Font.BOLD,14));
        submitBtn.setBackground(Color.BLACK);
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setBounds(600,680,100,30);
        submitBtn.addActionListener(this); //calling actionPerform() method for Buttons
        add(submitBtn);

        //todo: Back Button
         backBtn = new JButton("BACK");
        backBtn.setFont(new Font("Osward",Font.BOLD,14));
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        backBtn.setBounds(400,680,100,30);
        backBtn.addActionListener(this); //calling actionPerform() method for Buttons
        add(backBtn);



        //this for set Frame Size and Position and Other Option
        setTitle("Bank Management System");
        setSize(850,750);
        setLocation(360,40);
        setLayout(null);
        getContentPane().setBackground(new Color(215,252,252));
        setVisible(true);
    }


    //todo: Action Listener
    @Override
    public void actionPerformed(ActionEvent e){
      try{
          //todo: Submit Button
          if(submitBtn == e.getSource()){

              //todo: for Account Type
              String accountType = null;

              if(savingAccount.isSelected()){
                  accountType = "Saving Account";

              }else if(currentAccount.isSelected()){
                  accountType = "Current Account";

              }else if(fixedDepositAccount.isSelected()){
                  accountType = "Fixed Deposit Account";

              }else if(recurringDepositAccount.isSelected()){
                  accountType = "Recurring Deposit Account";
              }
              //System.out.println(accountType);


              //todo: Card Number
              //Generating Random Card Number
              Random ran = new Random();
              long cardRanNo = (ran.nextLong() % 90000000L) + 5040936000000000L;
              String cardNumber = "" + Math.abs(cardRanNo);
              // System.out.println(cardNumber);


              //todo: PIN Number
              //Generating Random PIN Number
              long pinRanNo = (ran.nextLong() % 9000L) + 1000L;
              String pinNumber = "" + Math.abs(pinRanNo);
              // System.out.println(pinNumber);


              //todo: for Services Required
              String servicesRequired = null;

              if(atmCard.isSelected()){
                  servicesRequired =  "ATM Card";

              }else if(internetBanking.isSelected()){
                  servicesRequired = "Internet Banking";

              }else if(mobileBanking.isSelected()){
                  servicesRequired =  "Mobile Banking";


              }else if(emailAlerts.isSelected()){
                  servicesRequired =  "Email Alerts";

              }
              else if(chequeBook.isSelected()){
                  servicesRequired =  "Cheque Book";


              }else if(eStatement.isSelected()){
                  servicesRequired =  "E-Statement";

              }
              //System.out.println(servicesRequired);


              //todo: Validation for Account Type and Services Required.
              if(accountType == null){

                  JOptionPane.showMessageDialog(null,"Please Select Account Type");
                  //return;
              } else if (servicesRequired == null) {

                  JOptionPane.showMessageDialog(null, "Please Select Services Required");
                  //return;
              } else {

                  //JOptionPane.showMessageDialog(null,"Account Type: " + accountType + "\n" + "Services Required: " + servicesRequired);

                  // todo: Database Connection
                  try {

                        Conn connection = new Conn();
                        String query1 = "insert into signup3 values('" + formNum + "','" + accountType + "','" + cardNumber + "','" + pinNumber + "','" + servicesRequired + "')";
                        String query2 = "insert into login values('" + formNum + "','" + cardNumber + "','" + pinNumber + "')";
                        connection.statement.executeUpdate(query1);
                        connection.statement.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\n Pin:" + pinNumber);


                        new Deposit(pinNumber).setVisible(true);
                        setVisible(false);

                  }catch (Exception exception){
                      exception.fillInStackTrace();
                  }
              }



          }else if(backBtn == e.getSource()){

              // System.out.println("Back Button Clicked");  //this for Back Button
              new SignUp2(formNum).setVisible(true);
              dispose();                                  //for closing the current window.
          }



      }catch(Exception exception) {

               JOptionPane.showMessageDialog(null, "Error in SignUp3");
               exception.fillInStackTrace();
               System.exit(0);
               //return; //for closing the current window.

      }

    }

    public static void main(String[] args) {
        new SignUp3("");
    }
}
