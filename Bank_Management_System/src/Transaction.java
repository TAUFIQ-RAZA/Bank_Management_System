import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {

   JButton deposit,cashwithdrawl,fastcash,ministatement,pinchange,balancequery,exit;
    String pinnumber;
    public Transaction(String pinnumber){
        this.pinnumber=pinnumber;
        ImageIcon image1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image2= image1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon image3= new ImageIcon(image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(210,300,700,30);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        cashwithdrawl = new JButton("Cash Withdrawl");
        cashwithdrawl.setBounds(350,415,150,30);
        cashwithdrawl.addActionListener(this);
        image.add(cashwithdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(350,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balancequery = new JButton("Balance Query");
        balancequery.setBounds(350,485,150,30);
        balancequery.addActionListener(this);
        image.add(balancequery);

        exit = new JButton("Exit");
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
            System.exit(0);
        }else if (ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource()==cashwithdrawl) {
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        } else if (ae.getSource()== fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource()== pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource() == balancequery) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if (ae.getSource()==ministatement){
            setVisible(true);
            new MiniStatement(pinnumber).setVisible(true);
        }
    }


    public static void main(String[] args) {
        new Transaction("");
    }
}
