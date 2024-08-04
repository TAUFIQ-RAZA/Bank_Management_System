import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;


public class SignUpOne extends JFrame implements ActionListener {

    long random;
    JLabel name,personalDetails,fname,dob,gender,email,address,marital,city,state,pincode,formno;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JRadioButton male,female,married,unmarried,other;
    JButton next;
    JDateChooser dateChooser;

    public SignUpOne(){

        Random ran = new Random();
        random =Math.abs(ran.nextLong() % 9000L)+1000L;

        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM: 1");

        //APPLICATION TITLE
        formno = new JLabel("APPLICATION FORM NO: "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(100,20,600,30);
        add(formno);

        //PAGE 1 : PERSONAL DETAILS
        personalDetails = new JLabel("PAGE 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(250,70,400,30);
        add(personalDetails);

        name = new JLabel("NAME: ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,120,200,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,16));
        nameTextField.setBounds(300,120,400,30);
        add(nameTextField);

        fname = new JLabel("FATHER NAME: ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,170,200,30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,16));
        fnameTextField.setBounds(300,170,400,30);
        add(fnameTextField);

        dob = new JLabel("D.O.B : ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,220,200,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setFont(new Font("Raleway",Font.BOLD,18));
        dateChooser.setBounds(300, 220,400,30);
        add(dateChooser);


        gender = new JLabel("GENDER : ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,270,200,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Raleway",Font.BOLD,18));
        male.setBounds(300,270,100,30);
        male.setBackground(Color.WHITE);
        male.setForeground(Color.BLACK);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Raleway",Font.BOLD,18));
        female.setBounds(400,270,100,30);
        female.setBackground(Color.WHITE);
        female.setForeground(Color.BLACK);
        add(female);

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        email = new JLabel("EMAIL : ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,320,200,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,16));
        emailTextField.setBounds(300,320,400,30);
        add(emailTextField);

        marital = new JLabel("Marital Status : ");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,370,200,30);
        add(marital);

        married = new JRadioButton("Married");
        married.setFont(new Font("Raleway",Font.BOLD,18));
        married.setBounds(300,370,100,30);
        married.setBackground(Color.WHITE);
        married.setForeground(Color.BLACK);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Raleway",Font.BOLD,18));
        unmarried.setBounds(400,370,150,30);
        unmarried.setBackground(Color.WHITE);
        unmarried.setForeground(Color.BLACK);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setFont(new Font("Raleway",Font.BOLD,18));
        other.setBounds(550,370,100,30);
        other.setBackground(Color.WHITE);
        other.setForeground(Color.BLACK);
        add(other);

        ButtonGroup marriegegroup = new ButtonGroup();
        marriegegroup.add(married);
        marriegegroup.add(unmarried);
        marriegegroup.add(other);

        address = new JLabel("Address : ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,420,200,30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,16));
        addressTextField.setBounds(300,420,400,30);
        add(addressTextField);

        city = new JLabel("City : ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,470,200,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,16));
        cityTextField.setBounds(300,470,400,30);
        add(cityTextField);

        state = new JLabel("State : ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,520,200,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,16));
        stateTextField.setBounds(300,520,400,30);
        add(stateTextField);

        pincode = new JLabel("Pincode : ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,570,200,30);
        add(pincode);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,16));
        pinTextField.setBounds(300,570,400,30);
        add(pinTextField);

        //next Button
        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,18));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(600,620,100,30);
        next.addActionListener(this);
        add(next);

        // Frame Creation
        getContentPane().setBackground(Color.WHITE);
        //Setting Size of Frame
        setSize(850,800);
        setLocation(500,70);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        String formno = " "+ random;
        String name =nameTextField.getText();
        String fname= fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();

        String gender="null";
        if (male.isSelected()){
            gender = "Male";
        }else if (female.isSelected()){
            gender = "Female";
        }

        String email =emailTextField.getText();

        String marital="null";
        if (married.isSelected()){
            marital="Marrieged";
        }else if (unmarried.isSelected()){
            marital ="UnMarrieged";
        }else if (other.isSelected()){
            marital ="Other";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pinTextField.getText();

        try{
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else {
                Conn c = new Conn();
                String query = "insert into signupone values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }

        }catch (Exception e){
            System.out.println(e);
        }

    }


    public static void main(String[] args) {
        new SignUpOne();
    }
}
