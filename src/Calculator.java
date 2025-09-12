import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Calculator implements ActionListener {

    Color colorBlack = new Color(32, 33, 36);
    Color colorGray = new Color(55, 53, 54);
    Color colorRed = new Color(255, 60, 31);
    Color colorGreen = new Color(44, 157, 84);

    JFrame frame = new JFrame();
    JButton[] buttons = new JButton[20];
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel displayButtons = new JPanel(new GridLayout(5,4));

    int width = 360;
    int height = 540;
    String[] values = {"C","%","R","/",
                       "7","8","9","*",
                       "4","5","6","-",
                       "1","2","3","+",
                       "H","0",".","="};
    String[] symbols = {"%","R","/","*","-","+","=","H"};
    String[] clearValue = {"C"};

    Calculator(){
        frame.setTitle("Calculator");
        frame.setSize(width,height);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // The screen goes to center
        frame.setLayout(new BorderLayout());

        displayLabel.setText("0");
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setFont(new Font("Arial",Font.PLAIN,50));
        displayLabel.setForeground(Color.WHITE);
        displayLabel.setBackground(colorBlack);
        displayLabel.setOpaque(true); // Show the color of the background.
        displayLabel.setPreferredSize(new Dimension(0,100));
        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);

        for (int x = 0; x< values.length; x++) {
            buttons[x] = new JButton();
            String value = values[x];
            buttons[x].setFocusable(false);
            buttons[x].setText(value);
            buttons[x].setBorder(BorderFactory.createEtchedBorder());
            buttons[x].setBackground(colorGray);
            buttons[x].setFont(new Font("Arial", Font.PLAIN, 25));

            if (Arrays.asList(symbols).contains(value)) {
                buttons[x].setForeground(colorGreen);
            }
            else if (Arrays.asList(clearValue).contains(value)) {
                buttons[x].setForeground(colorRed);
            }
            else {
                buttons[x].setForeground(Color.WHITE);
            }
            displayButtons.add(buttons[x]);
        }

        frame.add(displayPanel,BorderLayout.NORTH);
        frame.add(displayButtons);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
