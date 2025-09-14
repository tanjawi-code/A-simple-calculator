import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Calculator implements ActionListener {

    ImageIcon calculatorIcon = new ImageIcon("calcuator.png");

    Color colorBlack = new Color(32, 33, 36);
    Color colorGray = new Color(55, 53, 54);
    Color colorRed = new Color(255, 60, 31);
    Color colorGreen = new Color(44, 157, 84);

    ImageIcon imageIcon = new ImageIcon("close.png");
    Image scaledImage = imageIcon.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
    ImageIcon icon = new ImageIcon(scaledImage);

    JFrame frame = new JFrame();
    JButton[] buttons = new JButton[20];
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel displayButtons = new JPanel(new GridLayout(5,4));

    int width = 360;
    int height = 540;
    String[] values = {"C","%"," ","/",
                       "7","8","9","*",
                       "4","5","6","-",
                       "1","2","3","+",
                       "H","0",".","="};
    String[] symbols = {"%","/","*","-","+","=","H"};
    String[] clearValue = {"C"," "};
    String operator = null;
    double number1;
    double number2;
    double result;

    Calculator(){
        frame.setTitle("Calculator");
        frame.setSize(width,height);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // The screen goes to center
        frame.setLayout(new BorderLayout());
        frame.setIconImage(calculatorIcon.getImage());

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
            buttons[x].setBorder(new LineBorder(colorBlack));
            buttons[x].setBackground(colorGray);
            buttons[x].setFont(new Font("Arial", Font.PLAIN, 25));
            buttons[x].addActionListener(this);

            if (Arrays.asList(symbols).contains(value)) {
                if(buttons[x].getText().equals("=")){
                    buttons[x].setForeground(Color.WHITE);
                    buttons[x].setBackground(colorGreen);
                }
                else{
                    buttons[x].setForeground(colorGreen);
                }
            }
            else if (Arrays.asList(clearValue).contains(value)) {
                if(buttons[x].getText().equals("C")){
                    buttons[x].setForeground(colorRed);
                }
                else{
                    buttons[x].setIcon(icon);
                    buttons[x].setBackground(colorGreen);
                }
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
          JButton button = (JButton) e.getSource();
          String value = button.getText();

        if(Arrays.asList(symbols).contains(value)) {
            if(displayLabel.getText().isEmpty()){

            }
            else if ("%/*-+".contains(value)) {
                switch (value){
                    case "+" :
                        number1 = Double.parseDouble(displayLabel.getText());
                        operator = "+";
                        displayLabel.setText("");
                        break;
                    case "-" :
                        number1 = Double.parseDouble(displayLabel.getText());
                        operator = "-";
                        displayLabel.setText("");
                        break;
                    case "*" :
                        number1 = Double.parseDouble(displayLabel.getText());
                        operator = "*";
                        displayLabel.setText("");
                        break;
                    case "/" :
                        number1 = Double.parseDouble(displayLabel.getText());
                        operator = "/";
                        displayLabel.setText("");
                        break;
                    case "%" :
                        number1 = Double.parseDouble(displayLabel.getText());
                        operator = "%";
                        displayLabel.setText("");
                        break;
                    default:
                }
            }
            else if(value.equals("=")){
                number2 = Double.parseDouble(displayLabel.getText());
                switch (operator){
                    case "+" : result = number1+number2; break;
                    case "-" : result = number1-number2; break;
                    case "*" : result = number1*number2; break;
                    case "/" : result = number1/number2; break;
                    case "%" : result = number1%number2; break;
                 }
                displayLabel.setText(String.valueOf(result));
            }
            else{
                JOptionPane.showMessageDialog(null,"It's coming later","Message",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if(Arrays.asList(clearValue).contains(value)){
            if(value.equals("C")){
                displayLabel.setText("0");
            }
            else{
                String text = displayLabel.getText();
                if(!text.isEmpty()){
                    displayLabel.setText(text.substring(0,text.length()-1));
                }
            }
        }
        else {
            if(value.equals(".")){
                if(!displayLabel.getText().contains(".")){
                    displayLabel.setText(displayLabel.getText()+value);
                }
            }
            else if("0123456789".contains(value)){
                if(displayLabel.getText().equals("0")){
                    displayLabel.setText(value);
                }
                else{
                    displayLabel.setText(displayLabel.getText()+value);
                }
            }
        }
    }
}
