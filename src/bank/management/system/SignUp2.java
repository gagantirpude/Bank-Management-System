package bank.management.system;

import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp2 extends JFrame implements ActionListener {


    //Create a Global Variable
    //JComboBox is a class in javax.swing package.
    //JComboBox is used to create a drop-down list.
    //JComboBox is a combination of a text field and a drop-down list from which the user can choose a value.
    //JComboBox is Generic Class.
    JComboBox<String> religionComboBox, categoryComboBox, educationComboBox, occupationComboBox, incomeComboBox;

    //JTextField is a class in javax.swing package.
    //JTextField is used to create a single line text field.
    //JTextField is a component that allows editing of a single line of text.
    //JTextField is a Generic Class.
    JTextField aadharNumberTextField, panNumberTextField;


    //JRadioButton is a class in javax.swing package.
    //JRadioButton is used to create a radio button.
    //JRadioButton is a component that allows us to select only one option from a set of options.
    //JRadioButton is a Generic Class.
    JRadioButton seniorYes, seniorNo, existingYes, existingNo;


    //Button
    JButton nextBtn, cancelBtn;

    //todo: Create a Global Variable
    String formNum;



    SignUp2(String formNumber){

        //store formNumber in form Num
        //formNum is Global Variable
        this.formNum = formNumber;

        ImageIcon bankImg = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image bankImg2 = bankImg.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon bankImg3 = new ImageIcon(bankImg2);
        JLabel bankImgLabel = new JLabel(bankImg3);
        bankImgLabel.setBounds(50,40,100,100);
        add(bankImgLabel);

        //Application Form Number
        JLabel applicationFormNumber = new JLabel("APPLICATION FORM NO." + formNum);
        applicationFormNumber.setFont(new Font("Osward",Font.BOLD,38));
        applicationFormNumber.setBounds(200,50,600,40);
        add(applicationFormNumber);

        //Page Number
        JLabel pageNumber = new JLabel("Page 2/3");
        pageNumber.setFont(new Font("Osward",Font.BOLD,20));
        pageNumber.setBounds(420,10,600,30);
        add(pageNumber);

        //Additional Personal Details
        JLabel personalDetails = new JLabel("Additional Details");
        personalDetails.setFont(new Font("Osward",Font.BOLD,38));
        personalDetails.setBounds(320,100,600,40);
        personalDetails.setForeground(new Color(100, 149, 237)); //set color of text
        add(personalDetails);


        //Religion
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Osward",Font.BOLD,18));
        religion.setBounds(180,180,100,30);
        add(religion);


        religionComboBox = new JComboBox<>(new String[]{"Hindu","Muslim","Sikh","Christian","Other"});
        religionComboBox.setBounds(340,180,320,30);
        religionComboBox.setBackground(Color.WHITE);
        add(religionComboBox);


        //Category
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Osward",Font.BOLD,18));
        category.setBounds(180,220,100,30);
        add(category);

        categoryComboBox = new JComboBox<>(new String[]{"General","OBC","SC","ST"});
        categoryComboBox.setBounds(340,220,320,30);
        categoryComboBox.setBackground(Color.WHITE);
        add(categoryComboBox);


        //Income
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Osward",Font.BOLD,18));
        income.setBounds(180,260,100,30);
        add(income);

        incomeComboBox = new JComboBox<>(new String[]{"Null","< 1,50,000","< 2,50,000","< 5,00,000","< 10,00,000","Above 10,00,000"});
        incomeComboBox.setBounds(340,260,320,30);
        incomeComboBox.setBackground(Color.WHITE);
        add(incomeComboBox);



        //Education
        JLabel education = new JLabel("Education:");
        education.setFont(new Font("Osward",Font.BOLD,18));
        education.setBounds(180,300,100,30);
        add(education);

        educationComboBox = new JComboBox<>(new String[]{"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"});
        educationComboBox.setBounds(340,300,320,30);
        educationComboBox.setBackground(Color.WHITE);
        add(educationComboBox);


        //Occupation
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Osward",Font.BOLD,18));
        occupation.setBounds(180,340,150,30);
        add(occupation);

        occupationComboBox = new JComboBox<>(new String[]{"Salaried","Self-Employed","Business","Student","Retired","Others"});
        occupationComboBox.setBounds(340,340,320,30);
        occupationComboBox.setBackground(Color.WHITE);
        add(occupationComboBox);


        //Aadhar Number
        JLabel aadharNumber = new JLabel("Aadhar Number:");
        aadharNumber.setFont(new Font("Osward",Font.BOLD,18));
        aadharNumber.setBounds(180,380,150,30);
        add(aadharNumber);

        aadharNumberTextField = new JTextField();
        aadharNumberTextField.setBounds(340,380,320,30);
        aadharNumberTextField.setFont(new Font("Osward",Font.BOLD,18));
        add(aadharNumberTextField);

        //PAN Number
        JLabel panNumber = new JLabel("PAN Number:");
        panNumber.setFont(new Font("Osward",Font.BOLD,18));
        panNumber.setBounds(180,420,150,30);
        add(panNumber);


        panNumberTextField = new JTextField();
        panNumberTextField.setBounds(340,420,320,30);
        panNumberTextField.setFont(new Font("Osward",Font.BOLD,18));
        add(panNumberTextField);


        //Senior Citizen
        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Osward",Font.BOLD,18));
        seniorCitizen.setBounds(180,460,150,30);
        add(seniorCitizen);

         seniorYes = new JRadioButton("Yes");
        seniorYes.setFont(new Font("Osward",Font.BOLD,18));
        seniorYes.setBackground(new Color(252,208,76));
        seniorYes.setBounds(400,460,80,20);
        add(seniorYes);


         seniorNo = new JRadioButton("No");
        seniorNo.setFont(new Font("Osward",Font.BOLD,18));
        seniorNo.setBackground(new Color(252,208,76));
        seniorNo.setBounds(520,460,80,20);
        add(seniorNo);

        //todo: Button Grouping for Choosing Yes or No for Senior Citizen.
        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(seniorYes);
        seniorCitizenGroup.add(seniorNo);


        //Existing Account
        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Osward",Font.BOLD,18));
        existingAccount.setBounds(180,500,200,30);
        add(existingAccount);

         existingYes = new JRadioButton("Yes");
        existingYes.setFont(new Font("Osward",Font.BOLD,18));
        existingYes.setBackground(new Color(252,208,76));
        existingYes.setBounds(400,500,80,20);
        add(existingYes);


         existingNo = new JRadioButton("No");
        existingNo.setFont(new Font("Osward",Font.BOLD,18));
        existingNo.setBackground(new Color(252,208,76));
        existingNo.setBounds(520,500,80,20);
        add(existingNo);

        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(existingYes);
        existingAccountGroup.add(existingNo);



        //Button
        nextBtn = new JButton("NEXT");
        nextBtn.setFont(new Font("Osward",Font.BOLD,18));
        nextBtn.setBackground(Color.BLACK);
        nextBtn.setForeground(Color.WHITE);
        nextBtn.setBounds(550,650,100,30);
        //calling actionPerform() method for Buttons
        nextBtn.addActionListener(this);
        add(nextBtn);



        //Button for Cancelling the Application Form.
        cancelBtn = new JButton("CANCEL");
        cancelBtn.setFont(new Font("Osward",Font.BOLD,18));
        cancelBtn.setBackground(Color.BLACK);
        cancelBtn.setForeground(Color.WHITE);
        cancelBtn.setBounds(420,650,120,30);
        //calling actionPerform() method for Buttons
        cancelBtn.addActionListener(this);
        add(cancelBtn);




        //this for set Frame Size and Position and Other Option
        setTitle("Bank Management System");
        setSize(850,750);
        setLocation(360,40);
        setLayout(null);
        getContentPane().setBackground(new Color(252,208,76));
        setVisible(true);
    }


    //todo: Action Listener
    @Override
    public void actionPerformed(ActionEvent e) {

      try{
          if(e.getSource()==nextBtn){
              //this for Next Button

              //for From Number
              String fromNumber = formNum;

              //for Additional Details
              //todo: Get the value from the ComboBox
              String religion = (String)religionComboBox.getSelectedItem();
              String category = (String)categoryComboBox.getSelectedItem();
              String income = (String)incomeComboBox.getSelectedItem();
              String education = (String)educationComboBox.getSelectedItem();
              String occupation = (String)occupationComboBox.getSelectedItem();
              String aadharNumber = aadharNumberTextField.getText();
              String panNumber = panNumberTextField.getText();

              //todo: Get the value from the JRadioButton.
              String seniorCitizen = null;
              if(seniorYes.isSelected()) {
                  seniorCitizen = "Yes";
              }else if(seniorNo.isSelected()) {
                  seniorCitizen = "No";
              }

              String existingAccount = null;
              if(existingYes.isSelected()) {
                  existingAccount = "Yes";
              }else if(existingNo.isSelected()) {
                  existingAccount = "No";
              }


              //todo: Validation
              if(aadharNumber.isEmpty() || panNumber.isEmpty() || seniorCitizen==null || existingAccount==null || religion==null || category==null || income==null || education==null || occupation==null){
                  JOptionPane.showMessageDialog(null,"Please Fill all the Required Fields");
                  //return; //for closing the current window.
              }else {
                  //todo: Insert the data into the database.
                  try {
                      //todo: Create a object of Conn Class
                      Conn conn = new Conn();

                      System.out.println("Connection Successfully");

                      //todo: Create a query
                      String query = "insert into signup2 values('"+ fromNumber + "','" + religion + "','" + category + "','" + income + "','" + education + "','" + occupation + "','" + aadharNumber + "','" + panNumber + "','" + seniorCitizen + "','" + existingAccount + "')";

                      //System.out.println("query: " + query);
                      //todo: execute the query
                      conn.statement.executeUpdate(query);

                      //for show message
                      //JOptionPane.showMessageDialog(null,"SignUp2 Successfully");

                      //close the connection
                      conn.statement.close();
                      conn.connection.close();

                      // calling the next page
                      new SignUp3(fromNumber).setVisible(true);
                      dispose(); //for closing the current window.
                  } catch (Exception exception) {
                      exception.fillInStackTrace();
                      System.out.println("Error in SignUp2");
                      JOptionPane.showMessageDialog(null, "Error in SignUp2");
                      System.exit(0);
                      //return; //for closing the current window.
                  }

              }
          }else if(e.getSource()==cancelBtn){
              //this for Cancel Button
              System.out.println("Cancel Button Clicked");
              new Login().setVisible(true);
              //for closing the current window.
              dispose();
          }else{
              this.setVisible(false);
          }

      }catch (Exception ex){
          ex.fillInStackTrace();
      }

    }



    public static void main(String[] args) {
        new SignUp2("");
    }
}
