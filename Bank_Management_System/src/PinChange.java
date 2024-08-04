import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;

    public PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        ImageIcon image1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image2= image1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon image3= new ImageIcon(image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(230,300,500,30);
        text.setFont(new Font("System",Font.BOLD,20));
        text.setForeground(Color.WHITE);
        image.add(text);

        JLabel pinlabel = new JLabel("New PIN:");
        pinlabel.setBounds(180, 340, 180,25);
        pinlabel.setFont(new Font("Railway",Font.BOLD ,18));
        pinlabel.setForeground(Color.WHITE);
        image.add(pinlabel);

        pin = new JPasswordField();
        pin.setBounds(330, 340, 180,25);
        pin.setFont(new Font("Railway",Font.BOLD ,16));
        image.add(pin);

        JLabel repinlabel = new JLabel("Re-enter PIN:");
        repinlabel.setBounds(180, 370, 500,25);
        repinlabel.setFont(new Font("Railway",Font.BOLD ,18));
        repinlabel.setForeground(Color.WHITE);
        image.add(repinlabel);

        repin = new JPasswordField();
        repin.setBounds(330, 370, 180,25);
        repin.setFont(new Font("Railway",Font.BOLD ,16));
        image.add(repin);

        change = new JButton("Change");
        change.setBounds(350,485,150,30);
        change.setFont(new Font("System",Font.BOLD,16));
        change.addActionListener(this);
        image.add(change);

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
        if (ae.getSource()==change){
            try {
                String npin = pin.getText();
                String rpin =repin.getText();

                if (!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Password is Not Matched");
                    return;
                }

                if (npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter The New Pin");
                    return;
                }

                if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter The Re-Pin");
                    return;
                }

                Conn conn = new Conn();
                String query1= "update bank set pin ='"+rpin+"' where pin='"+pinnumber+"' ";
                String query2= "update login set pinNumber ='"+rpin+"' where pinNumber='"+pinnumber+"' ";
                String query3= "update signupthree set pinNumber ='"+rpin+"' where pinNumber='"+pinnumber+"' ";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"Pin Changed SuccessFully");
                setVisible(false);
                new Transaction(rpin).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }

        }else{
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }


    public static void main(String[] args) {
        new PinChange("");
    }
}
