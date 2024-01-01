package bank.management.system;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {

    //Create a Global Variable

    JLabel bankTitle, cardNum, pinNum;
    JTextField cardTextField, pinTextField;

    JButton loginBtn,  signUpBtn, clearBtn;



     Login(){
         super("Bank Management System"); //super keyword is used to call the parent class constructor.



          //Bank Image
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
         Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel l1 = new JLabel(i3);
         l1.setBounds(350 ,10,100,100);
         add(l1);

         //for Card Image
         ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icons/card.png"));
         Image ii2 = ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
         ImageIcon ii3 = new ImageIcon(ii2);
         JLabel l2 = new JLabel(ii3);
         l2.setBounds(700 ,350,100,100);
         add(l2);


         //Now Time for Creating Label

         //for user Welcome Screen
         bankTitle = new JLabel("WELCOME TO ATM");
         // for set Label font and Style
         bankTitle.setFont(new Font("Osward",Font.BOLD,38));
         //label color
         bankTitle.setForeground(Color.WHITE);
         // set Position and Size of BankTitle Label
         bankTitle.setBounds(220,120,400,40);
         add(bankTitle);




     //for User Details Card Number
     cardNum = new JLabel("Card Number:");
     // for set Label font and Style
     cardNum.setFont(new Font("Osward",Font.BOLD,28));
     //label color
     cardNum.setForeground(Color.WHITE);
     // set Position and Size of BankTitle Label
     cardNum.setBounds(180,200,400,40);
     add(cardNum);

     //this for Card Number Text Field
     cardTextField = new JTextField(15);
     cardTextField.setBounds(420,200,250,40);
     cardTextField.setFont(new Font("Osward",Font.BOLD,28));
     add(cardTextField);


     //for User Details PIN
     pinNum = new JLabel("PIN Number:");
     // for set Label font and Style
     pinNum.setFont(new Font("Osward",Font.BOLD,28));
     //label color
     pinNum.setForeground(Color.WHITE);
     // set Position and Size of BankTitle Label
     pinNum.setBounds(180,250,400,40);
     add(pinNum);

     //this for PIN Text Field
     pinTextField = new JPasswordField(15);
     pinTextField.setBounds(420,250,250,40);
     pinTextField.setFont(new Font("Osward",Font.BOLD,28));
     add(pinTextField);


     //for Login or SingIn Buttons
     loginBtn = new JButton("SIGN IN");
     loginBtn.setBounds(420,310,100,30);
     loginBtn.setFont(new Font("Osward",Font.BOLD,15));
     //color for Buttons
         loginBtn.setBackground(Color.BLACK);
         loginBtn.setForeground(Color.WHITE);

         //calling actionPerform() method for Buttons
         loginBtn.addActionListener(this);

     add(loginBtn);



     // for SignUp Buttons
     signUpBtn = new JButton("SIGN UP");
     signUpBtn.setBounds(420,350,250,30);
     signUpBtn.setFont(new Font("Osward",Font.BOLD,15));
         //color for Buttons
         signUpBtn.setBackground(Color.BLACK);
         signUpBtn.setForeground(Color.WHITE);

         //calling actionPerform() method for Buttons
         signUpBtn.addActionListener(this);

     add(signUpBtn);


     //for Clear Buttons
     clearBtn = new JButton("CLEAR");
     clearBtn.setBounds(570,310,100,30);
     clearBtn.setFont(new Font("Osward",Font.BOLD,15));

     //color for Buttons
     clearBtn.setBackground(Color.BLACK);
     clearBtn.setForeground(Color.WHITE);

     //calling actionPerform() method for Buttons
     clearBtn.addActionListener(this);
     add(clearBtn);




        //this should be the last line of the code
         //Background Image
         ImageIcon bgi =new ImageIcon(ClassLoader.getSystemResource("icons/backbg.png"));
         Image bgi2 = bgi.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
         ImageIcon bgi3 = new ImageIcon(bgi2);
         JLabel l3 = new JLabel(bgi3);
         l3.setBounds(0,0,850,480);
         add(l3);


         //this should be the last line of the code
         setLayout(null);
         setSize(850,480); //set size of frame
         setLocation(300,200);
         setUndecorated(true); //remove the title bar;
         setVisible(true);
    }

    //Override the actionPerformed() method of ActionListener Interface.
    @Override
    public void actionPerformed(ActionEvent e) {
         try{
             if(e.getSource()==loginBtn){
                 try{
                     //this for Login Button
                     //this for get the value from the text field.
                     String cardNumber = cardTextField.getText();
                     String pinNumber = pinTextField.getText();

                     Conn c = new Conn();
                     String query = "select * from login where cardNumber = '"+cardNumber+"' and pinNumber = '"+pinNumber+"'";
                     // executeQuery() is used to execute the query. means returns a ResultSet object.
                     // The ResultSet object contains the data returned by the query.  The first row of the ResultSet object contains the column labels.  The second row of the ResultSet object contains the data.  The third row of the ResultSet object contains the column types.  The fourth row of the ResultSet object
                     ResultSet rs = c.statement.executeQuery(query);



                     if(rs.next()){

                         //this for close the current frame
                         setVisible(false);
                         //this for open the next frame
                         new Transactions(pinNumber).setVisible(true);
                     }else{
                         JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin Number");
                         cardTextField.setText("");
                     }

                     //close the connection
                     c.statement.close();
                     c.connection.close();

                     //clear the text field
                     cardTextField.setText("");
                     pinTextField.setText("");

                 }catch(Exception E){
                     E.fillInStackTrace();
                 }


             }else if(e.getSource()==signUpBtn){

                    //this for SignUp Button
                    new SignUp().setVisible(true);
                    dispose();

             }
             else{
                 cardTextField.setText("");
                 pinTextField.setText("");
             }
         }catch(Exception E){
             E.fillInStackTrace();

         }
    }


    public static void main(String[] args) {
        new Login();
    }
}
