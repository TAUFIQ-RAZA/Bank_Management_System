import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class SignUpThree extends JFrame implements ActionListener {

     JRadioButton r1,r2,r3,r4;
     JCheckBox c1,c2,c3,c4,c5,c6,c7;
     JButton submit, cancel;
     String formno;

    public SignUpThree(String formno){
        this.formno = formno;
         JLabel account = new JLabel("PAGE 3: ACCOUNT DETAILS");
         account.setFont(new Font("Raleway",Font.BOLD,22));
         account.setBounds(250,50,400,30);
         add(account);

         JLabel accountType = new JLabel("Account Type:");
         accountType.setFont(new Font("Raleway",Font.BOLD,20));
         accountType.setBounds(100,120,200,30);
         add(accountType);

         r1 = new JRadioButton("Saving Account");
         r1.setFont(new Font("Raleway",Font.BOLD,16));
         r1.setBackground(Color.WHITE);
         r1.setBounds(120,160,200,30);
         add(r1);

        r2 = new JRadioButton("Fixed Deposite Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,160,300,30);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(120,200,200,30);
        add(r3);

        r4 = new JRadioButton("Recurring Deposite Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,200,300,30);
        add(r4);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(r1);
        accountGroup.add(r2);
        accountGroup.add(r3);
        accountGroup.add(r4);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,20));
        card.setBounds(100,270,200,30);
        add(card);

        JLabel cnumber = new JLabel("XXXX-XXXX-XXXX-4164");
        cnumber.setFont(new Font("Raleway",Font.BOLD,20));
        cnumber.setBounds(350,270,400,30);
        add(cnumber);

        JLabel cardDeatil = new JLabel("Your 16 digit Card Number");
        cardDeatil.setFont(new Font("Raleway",Font.BOLD,14));
        cardDeatil.setBounds(100,300,400,30);
        add(cardDeatil);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100,350,200,30);
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,20));
        pnumber.setBounds(350,350,400,30);
        add(pnumber);

        JLabel pinDeatil = new JLabel("Your 4 digit PIN Number");
        pinDeatil.setFont(new Font("Raleway",Font.BOLD,14));
        pinDeatil.setBounds(100,380,400,30);
        add(pinDeatil);

        JLabel service = new JLabel("Service Request:");
        service.setFont(new Font("Raleway",Font.BOLD,20));
        service.setBounds(100,450,200,30);
        add(service);

        c1= new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBackground(Color.WHITE);
        c1.setBounds(120,500,200,30);
        add(c1);

        c2= new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBackground(Color.WHITE);
        c2.setBounds(350,500,200,30);
        add(c2);

        c3= new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBackground(Color.WHITE);
        c3.setBounds(120,530,200,30);
        add(c3);

        c4= new JCheckBox("Email & SMS Alert");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBackground(Color.WHITE);
        c4.setBounds(350,530,400,30);
        add(c4);


        c5= new JCheckBox("Check Book");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBackground(Color.WHITE);
        c5.setBounds(120,560,200,30);
        add(c5);

        c6= new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBackground(Color.WHITE);
        c6.setBounds(350,560,200,30);
        add(c6);

        c7= new JCheckBox("I hereby declare that the above entered details are correct to the knowledge");
        c7.setFont(new Font("Raleway",Font.BOLD,14));
        c7.setBackground(Color.WHITE);
        c7.setBounds(100,680,800,30);
        add(c7);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway",Font.BOLD,18));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250,730,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway",Font.BOLD,18));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(450,730,100,30);
        cancel.addActionListener(this);
        add(cancel);

        setTitle("NEW ACCOUNT APPLICATION FORM: 3");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(850,900);
        setVisible(true);
        setLocation(500,40);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit){
            String accountType = "null";
            if (r1.isSelected()){
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType= "Fixed Deposite Account";
            } else if (r3.isSelected()) {
                accountType ="Current Account";
            } else if (r4.isSelected()) {
                accountType ="Recurring Deposite Account";
            }

            Random random = new Random();
            String cardNumber = " "+Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

            String pinNumber = " "+Math.abs((random.nextLong() % 9000L)+1000L);

            String facility =" ";
            if (c1.isSelected()){
                facility = facility + "ATM CARD";
            } else if (c2.isSelected()) {
                facility = facility + "Internet Banking";
            } else if (c3.isSelected()) {
                facility= facility+ "Mobile Banking";
            } else if (c4.isSelected()) {
                facility = facility+ "Email & SMS Alert";
            } else if (c5.isSelected()) {
                facility = facility + "Check Book";
            } else if (c6.isSelected()) {
                facility = facility +"E-Statement";
            }

             try{
                 if (accountType.equals("")){
                     JOptionPane.showMessageDialog(null,"Account Type is Required");
                 }else {
                     Conn con = new Conn();
                     String query1 = "insert into signupthree values('"+formno+"', '"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                     String query2 = "insert into login values('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
                     con.s.executeUpdate(query1);
                     con.s.executeUpdate(query2);

                     JOptionPane.showMessageDialog(null, "Card Number: "+cardNumber+ "\n PIN: "+pinNumber);

                     setVisible(false);
                     new Deposit(pinNumber).setVisible(true);
                 }
             }catch (Exception e){
                 System.out.println(e);
             }

        }else if (ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }


    public static void main(String[] args) {
        new SignUpThree("");
    }


}
