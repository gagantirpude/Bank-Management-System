package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp extends JFrame implements ActionListener {

    //We Add Jar File in Project Structure
    JDateChooser dateChooser;


    //Random is a class in java.util package.
    //Random we used for to creating application form number
    Random ran = new Random();
    long fourDigits = (ran.nextLong() % 9000L)+1000L; //We generate four digits number
    String applicationFormNo = " "+Math.abs(fourDigits); //Math.abs() is used to convert negative value to positive value.


    //Global Variable
    JTextField userName,fathersName,email,address,city,state,pinCode;
    JRadioButton male,female,married,unmarried;
    JButton next,cancel,exit;
   SignUp() {
       ImageIcon bankImg = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
       Image bankImg2 = bankImg.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
       ImageIcon bankImg3 = new ImageIcon(bankImg2);
       JLabel bankImgLabel = new JLabel(bankImg3);
       bankImgLabel.setBounds(50,10,100,100);
       add(bankImgLabel);

       //Application Form Number
       JLabel applicationFormNumber = new JLabel("APPLICATION FORM NO." + applicationFormNo);
       applicationFormNumber.setFont(new Font("Osward",Font.BOLD,38));
       applicationFormNumber.setBounds(200,50,600,40);
       add(applicationFormNumber);

       //Page Number
       JLabel pageNumber = new JLabel("Page 1/3");
       pageNumber.setFont(new Font("Osward",Font.BOLD,20));
       pageNumber.setBounds(420,10,600,30);
       add(pageNumber);

       //Personal Details
       JLabel personalDetails = new JLabel("Personal Details");
       personalDetails.setFont(new Font("Osward",Font.BOLD,38));
       personalDetails.setBounds(320,100,600,40);
       personalDetails.setForeground(new Color(100, 149, 237)); //set color of text
       add(personalDetails);

       //User Name
       JLabel userNameLabel = new JLabel("Name");
       userNameLabel.setFont(new Font("Osward",Font.BOLD,18));
       userNameLabel.setBounds(100,190,100,30);
       add(userNameLabel);

       //User Text Field
       userName = new JTextField(15);
       userName.setFont(new Font("Osward",Font.PLAIN,18));
       userName.setBounds(240,190,450,30);
       add(userName);


       //Father's Name
       JLabel fathersNameLabel = new JLabel("Father's Name");
       fathersNameLabel.setFont(new Font("Osward",Font.BOLD,18));
       fathersNameLabel.setBounds(100,230,200,30);
       add(fathersNameLabel);


       //Father's Name Text Field
       fathersName = new JTextField(15);
       fathersName.setFont(new Font("Osward",Font.PLAIN,18));
       fathersName.setBounds(240,230,450,30);
       add(fathersName);

       //DOB
       JLabel dobLabel = new JLabel("Date of Birth");
       dobLabel.setFont(new Font("Osward",Font.BOLD,18));
       dobLabel.setBounds(100,270,200,30);
       add(dobLabel);

       //DOB Text Field
       dateChooser = new JDateChooser();
       dateChooser.setBounds(240,270,450,30);
       dateChooser.setForeground(new Color(105, 105, 105));
       dateChooser.setFont(new Font("Osward",Font.PLAIN,18));
       add(dateChooser);


       //Email
       JLabel emailLabel = new JLabel("Email");
       emailLabel.setFont(new Font("Osward",Font.BOLD,18));
       emailLabel.setBounds(100,310,200,30);
       add(emailLabel);


       //Email Text Field
       email = new JTextField(15);
       email.setFont(new Font("Osward",Font.PLAIN,18));
       email.setBounds(240,310,450,30);
       add(email);


       //Address
       JLabel addressLabel = new JLabel("Address");
       addressLabel.setFont(new Font("Osward",Font.BOLD,18));
       addressLabel.setBounds(100,350,200,30);
       add(addressLabel);


       //Address Text Field
       address = new JTextField(15);
       address.setFont(new Font("Osward",Font.PLAIN,18));
       address.setBounds(240,350,450,30);
       add(address);


       //City
       JLabel cityLabel = new JLabel("City");
       cityLabel.setFont(new Font("Osward",Font.BOLD,18));
       cityLabel.setBounds(100,390,200,30);
       add(cityLabel);


       //City Text Field
       city = new JTextField(15);
       city.setFont(new Font("Osward",Font.PLAIN,18));
       city.setBounds(240,390,450,30);
       add(city);

       //State
       JLabel stateLabel = new JLabel("State");
       stateLabel.setFont(new Font("Osward",Font.BOLD,18));
       stateLabel.setBounds(100,430,200,30);
       add(stateLabel);


       //State Text Field
       state = new JTextField(15);
       state.setFont(new Font("Osward",Font.PLAIN,18));
       state.setBounds(240,430,450,30);
       add(state);

       //Pin Code
       JLabel pinCodeLabel = new JLabel("Pin Code");
       pinCodeLabel.setFont(new Font("Osward",Font.BOLD,18));
       pinCodeLabel.setBounds(100,470,200,30);
       add(pinCodeLabel);


       //Pin Code Text Field
       pinCode = new JTextField(15);
       pinCode.setFont(new Font("Osward",Font.PLAIN,18));
       pinCode.setBounds(240,470,450,30);
       add(pinCode);

       //Gender
       JLabel genderLabel = new JLabel("Gender");
       genderLabel.setFont(new Font("Osward",Font.BOLD,18));
       genderLabel.setBounds(100,510,200,30);
       add(genderLabel);

       //todo: Radio Button for Gender
       male = new JRadioButton("Male");
       male.setBounds(240,510,100,30);
       male.setBackground(new Color(222,255,228));
       add(male);

       female = new JRadioButton("Female");
       female.setBounds(360,510,100,30);
       female.setBackground(new Color(222,255,228));
       add(female);

       //Button Grouping for Choosing Male or Female
       ButtonGroup btnMaleFemale = new ButtonGroup();
       btnMaleFemale.add(male);
       btnMaleFemale.add(female);



       //Married Status
       JLabel marriedStatusLabel = new JLabel("Married Status");
       marriedStatusLabel.setFont(new Font("Osward",Font.BOLD,18));
       marriedStatusLabel.setBounds(100,540,200,30);
       add(marriedStatusLabel);

       married = new JRadioButton("Married");
       married.setBounds(240,540,100,30);
       married.setBackground(new Color(222,255,228));
       add(married);

       unmarried = new JRadioButton("Unmarried");
       unmarried.setBounds(360,540,100,30);
       unmarried.setBackground(new Color(222,255,228));
       add(unmarried);

       //Button Grouping for Choosing Male or Female
       ButtonGroup btnMarriedStatus = new ButtonGroup();
       btnMarriedStatus.add(married);
       btnMarriedStatus.add(unmarried);




       //todo: JButton
       //Next Button
       next = new JButton("Next");
       next.setFont(new Font("Osward", Font.BOLD, 18));
       next.setBounds(590,590,100,30);
       next.addActionListener(this);
       add(next);

       //Clear Button
       cancel = new JButton("Clear");
       cancel.setFont(new Font("Osward", Font.BOLD,18));
       cancel.setBounds(450,590,100,30);
       cancel.addActionListener(this);
       add(cancel);

       //Login Button
       // If you have Account then you can go to login page
       exit = new JButton("Exit");
       exit.setFont(new Font("Osward", Font.BOLD, 18));
       exit.setBounds(590,650,100,30);
       exit.addActionListener(this);
       add(exit);


       //this for set Frame Size and Position and Other Option
       setTitle("APPLICATION FORM");
       setSize(850,750);
       setLocation(360,40);
       setLayout(null);
       getContentPane().setBackground(new Color(222,255,228));
       setVisible(true);

   }


    //ActionListener
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==next){
                // System.out.println("Next Button Just Click");

                //We create object of Conn class

                //for From Number
                String formNumber=applicationFormNo;

                //for UserName
                String name=userName.getText();

                //for User Father Name
                String fatherName=fathersName.getText();

                //For User Date Of Birth
                String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();

                //user Email
                String userEmail = email.getText();

                //todo: For Gender
                String gender ;
                if(male.isSelected()) {
                    gender = "Male";
                }else if (female.isSelected()){
                    gender="female";
                }else {
                    gender="Not Selected"; //Default Value
                }


                //todo: For Marriage Status
                String marriedStatus ;
                if(married.isSelected()) {
                    marriedStatus = "Married";
                }else if(unmarried.isSelected()){
                    marriedStatus="Unmarried";
                }else{
                    marriedStatus="Not Selected"; //Default Value
                }

                //For User Address
                String userAddress=address.getText();

                //For User City
                String userCity=city.getText();


                //For User State
                String userState=state.getText();


                //For User Pin Code
                String userPinCode=pinCode.getText();


                //Now to Store Data to Database
                try{
                    //Validation
                    if(name.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Please Enter Your Name");
                    }else if(fatherName.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please Enter Your Father's Name");
                    }else if(dob.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please Enter Your Valid Date Of Birth");
                    }else if(userEmail.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please Enter Your Valid Email ID");
                    } else if (gender.equals("Not Selected")) {
                        JOptionPane.showMessageDialog(null,"Please Select You Gender");
                    } else if (marriedStatus.equals("Not Selected")) {
                        JOptionPane.showMessageDialog(null,"Please Select You Marriage Status");
                    } else if (userAddress.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please Enter Your Valid Address");
                    } else if (userCity.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please Enter Your Valid City");
                    } else if (userState.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please Enter Your Valid State");
                    }else if (userPinCode.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please Enter Your Valid Pin Code");
                    }else{

                        //todo: Now we store data to database

                        //todo: called Conn class
                        // for create object of Conn class and pass the parameter as database name and password.
                        //for create object of Conn class we need to import package from package name.
                        //import package from package name.
                        //package name.class name.
                        Conn conn = new Conn();

                        //Query for Insert Data to Database
                        String query = "insert into signup values('"+formNumber+"','"+name+"','"+fatherName+"','"+dob+"','"+userEmail+"','"+gender+"','"+marriedStatus+"','"+userAddress+"','"+userCity+"','"+userState+"','"+userPinCode+"')";

                        //here we execute query
                        //for execute query
                        // todo: we use statement object
                        //Statement Object is a part of connection object
                        //statement object is used to execute query


                        // executeUpdate() is used to execute the query. means returns A integer value.
                        conn.statement.executeUpdate(query);

                        //for close connection
                        conn.statement.close();

                        //for show message
                        //JOptionPane.showMessageDialog(null,"Data Inserted Successfully");

                        //for clear data
                        pinCode.setText("");
                        state.setText("");
                        city.setText("");
                        address.setText("");
                        email.setText("");
                        fathersName.setText("");
                        userName.setText("");

                        //Call Second Frame or Window
                        // Pass Form Number to Second Frame or Window.
                        new SignUp2(formNumber);

                        //for closing current frame
                        setVisible(false);
                    }
                }catch(Exception E){
                    //for print exception
                    E.fillInStackTrace();
                }


                //todo :- Exit Button
            }else if(e.getSource()==exit){
                JOptionPane.showMessageDialog(null,"Thank You for Visiting Our Bank");
                System.exit(0);


                //todo :- Clear Button
            }else{

                System.out.println("Cancel Button Just Click");
                setVisible(false);
                new Login();
            }
        }catch(Exception E){
            E.fillInStackTrace();

        }
    }



    public static void main(String[] args) {
        new SignUp();
    }
}
