import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinnumber ;
    JButton back;
    public BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;

        ImageIcon image1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image2= image1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon image3= new ImageIcon(image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0,0,900,900);
        add(image);

        back = new JButton("Back");
        back.setBounds(350,520,150,30);
        back.setFont(new Font("System",Font.BOLD,16));
        back.addActionListener(this);
        image.add(back);

        Conn c = new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

        JLabel text = new JLabel("Your Current Balance is Rs. "+balance);
        text.setBounds(190,300,400,30);
        text.setFont(new Font("Raleway",Font.BOLD,18));
        text.setForeground(Color.WHITE);
        image.add(text);

        getContentPane().setBackground(Color.WHITE);
        setSize(900,900);
        setUndecorated(true);
        setVisible(true);
        setLocation(450,60);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }


    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
