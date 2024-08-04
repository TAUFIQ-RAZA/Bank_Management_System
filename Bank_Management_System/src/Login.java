
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ExecutionException;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login,clear,signUp;
    JTextField cardTextField;
    JPasswordField pinTextField;

    public Login(){

        // Setting the title of frame
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        //loading the icon and setting and add
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        // Image Sizing
        Image image2 = image1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel label = new JLabel(image3);
        //Image Location
        label.setBounds(70,10,100,100);
        add(label);

        // The adding text after the label
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("OSWARD", Font.BOLD, 38));
        text.setBounds(200,40,400,40);
        add(text);


        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("OSWARD", Font.BOLD, 28));
        cardno.setBounds(120,150,150,30);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD ,16));
        add(cardTextField);

        JLabel pinNo = new JLabel("PIN:");
        pinNo.setFont(new Font("OSWARD", Font.BOLD, 28));
        pinNo.setBounds(120,220,150,30);
        add(pinNo);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD, 16));
        add(pinTextField);

        // the 3 button initialization
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signUp = new JButton("SIGN UP");
        signUp.setBounds(300,350,230,30);
        signUp.setBackground(Color.black);
        signUp.setForeground(Color.white);
        signUp.addActionListener(this);
        add(signUp);


        getContentPane().setBackground(Color.WHITE);
        // Creating frames and setting the size ,location and visible it.
        setSize(800, 480);
        setVisible(true);
        setLocation(480,220);
    }

    //overLoading the ActionListener object
    public void actionPerformed(ActionEvent ae ){
        if(ae.getSource()== clear){
            cardTextField.setText("");
            pinTextField.setText("");

        }else if(ae.getSource() == login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardNumber='"+cardnumber+"' and pinNumber='"+pinnumber+"' ";
            try{
               ResultSet rs=  conn.s.executeQuery(query);
               if (rs.next()){
                   setVisible(false);
                   new Transaction(pinnumber).setVisible(true);
               }else {
                   JOptionPane.showMessageDialog(null,"Incorrect Card Number or Password");
               }
            }catch (Exception e){
                System.out.println(e);
            }

        }else if (ae.getSource() == signUp){
            setVisible(false);
            new SignUpOne().setVisible(true);

        }

    }
    public static void main(String[] args) {

        new Login();

    }
}
