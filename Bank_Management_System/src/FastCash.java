import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit,cashwithdrawl,fastcash,ministatement,pinchange,balancequery,exit;
    String pinnumber;
    public FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        ImageIcon image1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image2= image1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon image3= new ImageIcon(image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("SELECT  YOUR  AMOUNT");
        text.setBounds(230,300,700,30);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        cashwithdrawl = new JButton("Rs 200");
        cashwithdrawl.setBounds(350,415,150,30);
        cashwithdrawl.addActionListener(this);
        image.add(cashwithdrawl);

        fastcash = new JButton("Rs 500");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Rs 1000");
        ministatement.setBounds(350,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Rs 2000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balancequery = new JButton("Rs 5000");
        balancequery.setBounds(350,485,150,30);
        balancequery.addActionListener(this);
        image.add(balancequery);

        exit = new JButton("Back");
        exit.setBounds(350,520,150,30);
        exit.addActionListener(this);
        image.add(exit);


        getContentPane().setBackground(Color.WHITE);
        setSize(900,900);
        setUndecorated(true);
        setVisible(true);
        setLocation(450,60);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== exit){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);// Rs 100
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Balance is Insufficient");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"', 'withdraw', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs. "+amount+" is Debited SuccessFully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }
        }
    }


    public static void main(String[] args) {
        new FastCash("");
    }
}
