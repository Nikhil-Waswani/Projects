import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Server implements ActionListener {
   static DataOutputStream dout;
    JTextField text1;
    JPanel a1;
    static JFrame f1=new JFrame();
   static Box vertical=Box.createVerticalBox();
   LoginSignupForm l1=new LoginSignupForm();

    Server(){
        f1.setLayout(null);
        JPanel p1=new JPanel();
        p1.setBackground(Color.BLUE);
        p1.setBounds(0,0,450,70);
        f1.add(p1);

        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2=i1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(5,20,25,25);
        p1.setLayout(null);
        p1.add(back);

        back.addMouseListener(new MouseAdapter(){
             public void mouseClicked(MouseEvent me) {
                 System.exit(0);
             }
        });

        ImageIcon i4 =new ImageIcon(ClassLoader.getSystemResource("icons/1.png"));
        Image i5=i4.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel back1 = new JLabel(i6);
        back1.setBounds(40,10,50,50);
        p1.setLayout(null);
        p1.add(back1);




        ImageIcon i7 =new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i8=i7.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        JLabel back2 = new JLabel(i9);
        back2.setBounds(300,10,50,50);
        p1.setLayout(null);
        p1.add(back2);

        ImageIcon i10 =new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i11=i10.getImage().getScaledInstance(35,35,Image.SCALE_DEFAULT);
        ImageIcon i12=new ImageIcon(i11);
        JLabel back3 = new JLabel(i12);
        back3.setBounds(360,15,35,35);
        p1.setLayout(null);
        p1.add(back3);


        ImageIcon i13 =new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i14=i13.getImage().getScaledInstance(10,25,Image.SCALE_DEFAULT);
        ImageIcon i15=new ImageIcon(i14);
        JLabel back4 = new JLabel(i15);
        back4.setBounds(420,20,10,25);
        p1.setLayout(null);
        p1.add(back4);

        JLabel name =new JLabel(l1.t1);
        name.setBounds(110,20,100,18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        p1.add(name);

        JLabel Active =new JLabel("Active Now");
        Active.setBounds(110,40,100,18);
        Active.setForeground(Color.WHITE);
        Active.setFont(new Font("SAN_SERIF",Font.BOLD,12));
        p1.add(Active);



a1=new JPanel();
a1.setBounds(5,75,440,530);
f1.add(a1);

text1=new JTextField();
text1.setBounds(5,615 ,310,40);
text1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
f1.add(text1);

JButton send=new JButton("Send");
send.setBounds(320,615,110,40);
        send.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        send.addActionListener(this);

send.setBackground(Color.blue);
send.setForeground(Color.WHITE);
f1.add(send);


        f1.setSize(450,700);
        f1.setLocation(200,50);
        //setUndecorated(true);
       f1. getContentPane().setBackground(Color.white);





        f1.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try {
            String output = text1.getText();


            JPanel p1 = format_label(output);

            a1.setLayout(new BorderLayout());
            JPanel right = new JPanel(new BorderLayout());
            right.add(p1, BorderLayout.LINE_END);

            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15));

            a1.add(vertical, BorderLayout.PAGE_START);
            dout.writeUTF(output);

            text1.setText("");


            f1.repaint();
            f1.invalidate();
            f1.validate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static JPanel format_label(String output){
JPanel panel =new JPanel();
panel.setLayout(new BoxLayout(panel ,BoxLayout.Y_AXIS ) );
JLabel output1 =new JLabel("<html><p style=\"width: 150px\">"+output+"</p></html>");
output1.setFont(new Font("Tahoma",Font.PLAIN,16));
output1.setBackground(Color.BLUE);
output1.setForeground(Color.WHITE);
output1.setOpaque(true);
output1.setBorder(new EmptyBorder(15,15,15,50));

        Calendar cal=Calendar.getInstance();
        SimpleDateFormat s1=new SimpleDateFormat("HH:mm");
        JLabel time=new JLabel();
        time.setText(s1.format(cal.getTime()));
        panel.add(time);
panel.add(output1);

return panel;
    }
    public static void main(String[] args) {
        new Server();
        try{
            ServerSocket skt=new ServerSocket(6001);
            while(true){
              Socket s= skt.accept();
                DataInputStream dn=new DataInputStream(s.getInputStream());
                dout=new DataOutputStream(s.getOutputStream());
                while (true){
                    String msg=dn.readUTF();
                    JPanel panel=format_label(msg);


                     JPanel left=new JPanel(new BorderLayout());
                    left.add(panel,BorderLayout.LINE_START);
                    vertical.add(left);
                    f1.validate();
                }

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
