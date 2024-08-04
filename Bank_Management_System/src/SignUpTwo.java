import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;



public class SignUpTwo extends JFrame implements ActionListener {

    JLabel name,additionalDetails,fname,dob,gender,email,address,marital,city,state;
    JTextField pan,adhar;
    JRadioButton syes,sno,eyes,eno;
    JButton next;
    JComboBox religion, category, education, occupation,income;
    String formno;

    public SignUpTwo(String formno){
        this.formno=formno;
        Random ram = new Random();
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM: 2");

        //PAGE 1 : PERSONAL DETAILS
        additionalDetails = new JLabel("PAGE 2: ADDITIONAL DETAILS");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(250,50,400,30);
        add(additionalDetails);

        name = new JLabel("Religion: ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,120,200,30);
        add(name);

        String[] relig = {"HINDU","MUSLIM", "CHRISTAN","SIKH", "OTHERS"};
        religion = new JComboBox(relig);
        religion.setFont(new Font("Raleway",Font.BOLD,14));
        religion.setBounds(300,120,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        fname = new JLabel("Category: ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,170,200,30);
        add(fname);

        String[] categ = {"General","OBC", "SC","ST", "OTHERS"};
        category = new JComboBox(categ);
        category.setFont(new Font("Raleway",Font.BOLD,14));
        category.setBounds(300,170,400,30);
        category.setBackground(Color.WHITE);
        add(category);

        dob = new JLabel("Income: ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,220,200,30);
        add(dob);

        String[] inco = {"Nothing","< 1,00,000", "< 1,50,000","< 2,00,000", "< 2,50,000", " More"};
        income = new JComboBox(inco);
        income.setFont(new Font("Raleway",Font.BOLD,14));
        income.setBounds(300,220,400,30);
        income.setBackground(Color.WHITE);
        add(income);

        gender = new JLabel("Educational : ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,270,200,30);
        add(gender);

        String[] edutionalValues = {"Non-Graduated","Graduated", "Post-Graduated","Doctorate", "Others"};
        education = new JComboBox(edutionalValues);
        education.setFont(new Font("Raleway",Font.BOLD,14));
        education.setBounds(300,270,400,30);
        education.setBackground(Color.WHITE);
        add(education);


        email = new JLabel("Occupation : ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,320,200,30);
        add(email);

        String[] occupationValues = {"Salaried", "Self Employee","Student", "Business", "Retired", "Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setFont(new Font("Raleway",Font.BOLD,14));
        occupation.setBounds(300,320,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        marital = new JLabel("PAN Number: ");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,370,200,30);
        add(marital);

        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,370,400,30);
        add(pan);


        address = new JLabel("Aadhar Number : ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,420,200,30);
        add(address);

        adhar = new JTextField();
        adhar.setFont(new Font("Raleway",Font.BOLD,14));
        adhar.setBounds(300,420,400,30);
        add(adhar);

        city = new JLabel("Senior Citizen : ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,470,200,30);
        add(city);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,470,100,30);
        syes.setFont(new Font("Raleway",Font.BOLD,14));
        syes.setBackground(Color.WHITE);
        syes.setForeground(Color.BLACK);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(400,470,100,30);
        sno.setFont(new Font("Raleway",Font.BOLD,14));
        sno.setBackground(Color.WHITE);
        sno.setForeground(Color.BLACK);
        add(sno);

        ButtonGroup seniourGroup = new ButtonGroup();
        seniourGroup.add(syes);
        seniourGroup.add(sno);

        state = new JLabel("Existing Account : ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,520,200,30);
        add(state);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,520,100,30);
        eyes.setFont(new Font("Raleway",Font.BOLD,14));
        eyes.setBackground(Color.WHITE);
        eyes.setForeground(Color.BLACK);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(400,520,100,30);
        eno.setFont(new Font("Raleway",Font.BOLD,14));
        eno.setBackground(Color.WHITE);
        eno.setForeground(Color.BLACK);
        add(eno);

        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(eyes);
        existingGroup.add(eno);

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
        setLocation(500,50);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        String sreligion = (String) religion.getSelectedItem();

        String scategory = (String)category.getSelectedItem();

        String sincome = (String)income.getSelectedItem();

        String seductaion = (String)education.getSelectedItem();

        String soccupation = (String)occupation.getSelectedItem();

        String span = pan.getText();

        String sadhar = adhar.getText();

        String seniorCitizen ="null";
        if (syes.isSelected()){
            seniorCitizen = "Yes";
        }else if (sno.isSelected()){
            seniorCitizen ="No";
        }

        String existingAccount ="null";
        if (eyes.isSelected()){
            existingAccount="Yes";
        }else {
            existingAccount ="No";
        }


        try{
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seductaion+"','"+soccupation+"','"+span+"','"+sadhar+"','"+seniorCitizen+"','"+existingAccount+"')";
            c.s.executeUpdate(query);

            setVisible(false);
            new SignUpThree(formno).setVisible(true);

        }catch (Exception e){
            System.out.println(e);
        }


    }


    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
