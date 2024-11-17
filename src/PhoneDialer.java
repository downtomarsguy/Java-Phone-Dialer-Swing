import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhoneDialer implements ActionListener {
    private JButton[] numberButtons = new JButton[11];
    private StringBuilder phoneNumber;

    public PhoneDialer() {
        phoneNumber = new StringBuilder();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Phone Dialer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 250);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JPanel labelPanel = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Enter the number to dial:");
        labelPanel.add(label);
        frame.add(labelPanel);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 3, 5, 5));
        char[] buttons = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-'};

        for (int i = 0; i < buttons.length; i++) {
            numberButtons[i] = new JButton(String.valueOf(buttons[i]));
            numberButtons[i].addActionListener(this);
            buttonPanel.add(numberButtons[i]);
        }

        frame.add(buttonPanel);

        JButton dialButton = new JButton("Dial Number");
        dialButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        dialButton.addActionListener(this);
        frame.add(dialButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Dial Number")) {
            JOptionPane.showMessageDialog(null, "Dialing: " + phoneNumber.toString());
            phoneNumber.setLength(0);
        } else {
            phoneNumber.append(e.getActionCommand());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PhoneDialer());
    }
}