import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    String pinnumber;

    public MiniStatement(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        setTitle("MINI STATEMENT");

        JLabel bank= new JLabel("INDIAN BANK");
        bank.setBounds(120,20,150,20);
        bank.setFont(new Font("Raleway",Font.BOLD,16));
        add(bank);


        JLabel card= new JLabel();
        card.setBounds(20,70,400,30);
        add(card);

        JLabel mini= new JLabel();
        mini.setBounds(20,100,400,200);
        add(mini);

        JLabel balance= new JLabel();
        balance.setBounds(20,400,400,30);
        add(balance);

        try{
            Conn conn = new Conn();
            ResultSet rs= conn.s.executeQuery("select * from login where pinNumber = '"+pinnumber+"'");
            while (rs.next()){
                card.setText("Card Number:"+rs.getString("cardNumber").substring(0,4)+"XXXXXXXX"+ rs.getString("cardNumber").substring(12));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        try {
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs= conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while (rs.next()){
                mini.setText(mini.getText() + "<html>"+ rs.getString("date") +" "+rs.getString("type")+" "+rs.getString("amount")+"<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal-= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Current Balance is: "+bal);
        }catch (Exception e){
            System.out.println(e);
        }

        setSize(400,600);
        setLocation(40,40);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
