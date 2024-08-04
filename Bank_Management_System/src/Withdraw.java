import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Withdraw extends JFrame implements ActionListener {
    JButton withdraw,back;
    JTextField amount;
    String pinnumber;
    public Withdraw(String pinnumber){
        this.pinnumber=pinnumber;
        ImageIcon image1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image2= image1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon image3= new ImageIcon(image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter The Amount You want to Withdraw");
        text.setBounds(195,300,700,30);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);

        amount = new JTextField();
        amount.setBounds(200,350,280,25);
        amount.setFont(new Font("System",Font.BOLD,22));
        amount.setBackground(Color.WHITE);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(350,485,150,30);
        withdraw.setFont(new Font("System",Font.BOLD,16));
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(350,520,150,30);
        back.setFont(new Font("System",Font.BOLD,16));
        back.addActionListener(this);
        image.add(back);

        getContentPane().setBackground(Color.WHITE);
        setSize(900,900);
        setUndecorated(true);
        setVisible(true);
        setLocation(450,60);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==withdraw){
            String anumber= amount.getText();
            Date date = new Date();
            if (anumber.equals("")){
                JOptionPane.showMessageDialog(null, "Enter The Amount");
            }else {
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnumber+"','"+date+"', 'withdraw', '"+anumber+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs. "+anumber+" is withdraw SuccessFully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }catch (Exception e){
                    System.out.println(e);
                }
            }

        }else if (ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }


    public static void main(String[] args) {
        new Withdraw("");
    }
}
