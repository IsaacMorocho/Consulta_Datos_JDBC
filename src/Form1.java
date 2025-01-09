import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form1 {
    private JTextField logintxt;
    private JPasswordField passwordtxt;
    private JButton Ingresarbtn;
    private JPanel LoginP;

    public Form1() {
        Ingresarbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Form2 dataForm = new Form2();
                dataForm.setVisible(true);
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(LoginP);
                frame.dispose();
            }
        });
    }

    public JPanel getMainPanel() {
        return LoginP;
    }
}