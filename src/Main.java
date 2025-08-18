import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // I will create a simple calculator that does not do calculating just a screen.
        // I will create 16 buttons.

        JFrame frame = new JFrame();
        frame.setTitle("A simple calculator");
        frame.setSize(300,300);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel(new FlowLayout());
        JLabel labelMessage = new JLabel("Calculate numbers");
        labelMessage.setForeground(Color.BLUE);
        topPanel.add(labelMessage);

        JPanel centerPanel = new JPanel(new BorderLayout());
        JLabel labelNumber = new JLabel("0");
        labelNumber.setFont(new Font("Arial",Font.BOLD,30));
        centerPanel.add(labelNumber);

        JPanel numbers = new JPanel(new GridLayout(4,4,20,20));
        numbers.add(new JButton("9"));
        numbers.add(new JButton("8"));
        numbers.add(new JButton("7"));
        numbers.add(new JButton("/"));
        numbers.add(new JButton("4"));
        numbers.add(new JButton("5"));
        numbers.add(new JButton("6"));
        numbers.add(new JButton("*"));
        numbers.add(new JButton("1"));
        numbers.add(new JButton("2"));
        numbers.add(new JButton("3"));
        numbers.add(new JButton("-"));
        numbers.add(new JButton("0"));
        numbers.add(new JButton("C"));
        numbers.add(new JButton("="));
        numbers.add(new JButton("+"));


        frame.setLayout(new BorderLayout());
        frame.add(topPanel,BorderLayout.NORTH);
        frame.add(numbers,BorderLayout.SOUTH);
        frame.add(centerPanel,BorderLayout.EAST);


        frame.setVisible(true);
        input.close();
    }
}