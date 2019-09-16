
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class ActionListenerTest extends JFrame {

private static final long serialVersionUID = 1L;

public ActionListenerTest(){
    super("Yeah");
    setLayout(new FlowLayout());
    setSize(800,800);
    setVisible(true);
    setResizable(false);
    setLocationRelativeTo(null);


    ImageIcon image=new ImageIcon (getClass().getResource("FileName2.png"));
    JPanel p =new JPanel(new GridBagLayout());
    JPanel p2 =new JPanel(new GridBagLayout());
    JLabel lbl= new JLabel(image);
    JButton b=new JButton("Button Test");
    JButton b2=new JButton("Button Test 2");
    lbl.addMouseListener(new MouseListener() {

        public void mouseReleased(MouseEvent e) {
            JOptionPane.showMessageDialog(null, "Men... you weak..","WOOOOO",JOptionPane.PLAIN_MESSAGE);
        }

        public void mousePressed(MouseEvent e) {
            JDialog d=new JDialog();
            d.setLocationRelativeTo(null);
            d.setSize(300,300);
            d.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            d.setTitle("Dialog TEST");
            d.setVisible(true);
            JButton test=new JButton("TESTING");
            JPanel testP= new JPanel();
            testP.add(test);
            d.add(testP, BorderLayout.WEST);
        }

        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        public void mouseClicked(MouseEvent e) {

        }
    });
    b.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Hey wanna hang out sometime?","WOOOOO",JOptionPane.PLAIN_MESSAGE);
        }
    });


    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets=new Insets(150,20,30,20);
    gbc.gridx=3;
    gbc.gridy=2;
    p.add(b, gbc);
    gbc.gridx=3;
    gbc.gridy=3;
    p.add(b2, gbc);
    gbc.gridx=15;
    gbc.gridy=15;
    p2.add(lbl, gbc);
    add(p2, BorderLayout.SOUTH);
    add(p, BorderLayout.NORTH);
}
public static void main(String[] args){
    ActionListenerTest a = new ActionListenerTest();
       a.setVisible(true);
}
}