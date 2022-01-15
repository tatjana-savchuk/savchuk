import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ChatClient extends JFrame implements ActionListener {

    public void ChatClient() {
        initUI();
    }
    private JButton button1;
    private JPanel rootPanel;

    public ChatClient() {
        setContentPane(rootPanel);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    //   public static void main(String[] args) {
//        new ChatClient();
//    }
//}
    private void initUI() {

        JButton showBtn = new JButton("чат");
        showBtn.addActionListener(this);
        showBtn.setMnemonic(KeyEvent.VK_S);

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(showBtn)
                .addGap(250)
        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(showBtn)
                .addGap(150)
        );

        pack();

        setTitle("JButton");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(this, "Button clicked",
                "сообщение", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            new ChatClient().setVisible(true);
        });
    }
}
