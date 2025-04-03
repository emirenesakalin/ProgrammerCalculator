import java.awt.*;
import javax.swing.*;

public class ProgrammerCalculator extends JFrame {
    JTextField display;
    JRadioButton hexRadioButton, decRadioButton, binRadioButton;
    JButton hexButtonA, hexButtonB, hexButtonC, hexButtonD, hexButtonE, hexButtonF;
    JButton andButton, orButton, xorButton, notButton, shiftLeftButton, shiftRightButton;
    JButton addButton, subtractButton, multiplyButton, divideButton, clearButton, equalsButton;
    JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;

    private String currentMode = "Hexadecimal";
    private String firstOperand = "";
    private String operator = "";

    public ProgrammerCalculator() {
        setTitle("Programmer Calculator");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Display
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 20));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setBackground(Color.WHITE);
        display.setEditable(false);
        display.setBounds(150, 20, 300, 100);
        add(display);

        // Radio Buttons
        hexRadioButton = new JRadioButton("Hexadecimal", true);
        decRadioButton = new JRadioButton("Decimal");
        binRadioButton = new JRadioButton("Binary");
        ButtonGroup modeGroup = new ButtonGroup();
        modeGroup.add(hexRadioButton);
        modeGroup.add(decRadioButton);
        modeGroup.add(binRadioButton);

        hexRadioButton.setBounds(20, 20, 120, 30);
        decRadioButton.setBounds(20, 60, 120, 30);
        binRadioButton.setBounds(20, 100, 120, 30);

        add(hexRadioButton);
        add(decRadioButton);
        add(binRadioButton);

        // Hexadecimal Buttons
        hexButtonA = new JButton("A");
        hexButtonB = new JButton("B");
        hexButtonC = new JButton("C");
        hexButtonD = new JButton("D");
        hexButtonE = new JButton("E");
        hexButtonF = new JButton("F");

        // Setting bounds for hex buttons
        hexButtonA.setBounds(20, 150, 50, 40); // A
        hexButtonB.setBounds(20, 200, 50, 40); // B
        hexButtonC.setBounds(20, 250, 50, 40); // C
        hexButtonD.setBounds(20, 300, 50, 40); // D
        hexButtonE.setBounds(20, 350, 50, 40); // E
        hexButtonF.setBounds(20, 400, 50, 40); // F

        // Set actions for hexadecimal buttons
        hexButtonA.addActionListener(e -> appendToDisplay("A"));
        hexButtonB.addActionListener(e -> appendToDisplay("B"));
        hexButtonC.addActionListener(e -> appendToDisplay("C"));
        hexButtonD.addActionListener(e -> appendToDisplay("D"));
        hexButtonE.addActionListener(e -> appendToDisplay("E"));
        hexButtonF.addActionListener(e -> appendToDisplay("F"));

        add(hexButtonA);
        add(hexButtonB);
        add(hexButtonC);
        add(hexButtonD);
        add(hexButtonE);
        add(hexButtonF);

        // Logical and Clear Buttons
        notButton = new JButton("NOT");
        shiftLeftButton = new JButton("<<");
        shiftRightButton = new JButton(">>");
        clearButton = new JButton("Clear");
        clearButton.setBackground(Color.RED);
        clearButton.setForeground(Color.BLACK);

        notButton.setBounds(80, 150, 80, 40);
        shiftLeftButton.setBounds(170, 150, 80, 40);
        shiftRightButton.setBounds(260, 150, 80, 40);
        clearButton.setBounds(350, 150, 80, 40);

        notButton.addActionListener(e -> performNot());
        shiftLeftButton.addActionListener(e -> setOperator("<<"));
        shiftRightButton.addActionListener(e -> setOperator(">>"));
        clearButton.addActionListener(e -> clear());

        add(notButton);
        add(shiftLeftButton);
        add(shiftRightButton);
        add(clearButton);

        // Logical Operators
        andButton = new JButton("AND");
        orButton = new JButton("OR");
        xorButton = new JButton("XOR");
        addButton = new JButton("+");

        andButton.setBounds(80, 200, 80, 40);
        orButton.setBounds(170, 200, 80, 40);
        xorButton.setBounds(260, 200, 80, 40);
        addButton.setBounds(350, 200, 80, 40);

        andButton.addActionListener(e -> setOperator("AND"));
        orButton.addActionListener(e -> setOperator("OR"));
        xorButton.addActionListener(e -> setOperator("XOR"));
        addButton.addActionListener(e -> setOperator("+"));

        add(andButton);
        add(orButton);
        add(xorButton);
        add(addButton);

        // Arithmetic Operators
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");

        subtractButton.setBounds(350, 250, 80, 40);
        multiplyButton.setBounds(350, 300, 80, 40);
        divideButton.setBounds(350, 350, 80, 40);
        equalsButton.setBounds(350, 400, 80, 40);

        subtractButton.addActionListener(e -> setOperator("-"));
        multiplyButton.addActionListener(e -> setOperator("*"));
        divideButton.addActionListener(e -> setOperator("/"));
        equalsButton.addActionListener(e -> calculate());

        add(subtractButton);
        add(multiplyButton);
        add(divideButton);
        add(equalsButton);

        // Set positions, sizes, and actions for number buttons
        int buttonWidth = andButton.getWidth();
        int buttonHeight = andButton.getHeight();

        // Number Buttons (0-9)
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");

        // Positioning the number buttons like NumLock keys
        button1.setBounds(80, 250, buttonWidth, buttonHeight);
        button2.setBounds(170, 250, buttonWidth, buttonHeight);
        button3.setBounds(260, 250, buttonWidth, buttonHeight);
        button4.setBounds(80, 300, buttonWidth, buttonHeight);
        button5.setBounds(170, 300, buttonWidth, buttonHeight);
        button6.setBounds(260, 300, buttonWidth, buttonHeight);
        button7.setBounds(80, 350, buttonWidth, buttonHeight);
        button8.setBounds(170, 350, buttonWidth, buttonHeight);
        button9.setBounds(260, 350, buttonWidth, buttonHeight);
        button0.setBounds(170, 400, buttonWidth, buttonHeight);

        // Set gray background for number buttons
        button0.setBackground(Color.LIGHT_GRAY);
        button1.setBackground(Color.LIGHT_GRAY);
        button2.setBackground(Color.LIGHT_GRAY);
        button3.setBackground(Color.LIGHT_GRAY);
        button4.setBackground(Color.LIGHT_GRAY);
        button5.setBackground(Color.LIGHT_GRAY);
        button6.setBackground(Color.LIGHT_GRAY);
        button7.setBackground(Color.LIGHT_GRAY);
        button8.setBackground(Color.LIGHT_GRAY);
        button9.setBackground(Color.LIGHT_GRAY);

        // Set actions for number buttons
        button0.addActionListener(e -> appendToDisplay("0"));
        button1.addActionListener(e -> appendToDisplay("1"));
        button2.addActionListener(e -> appendToDisplay("2"));
        button3.addActionListener(e -> appendToDisplay("3"));
        button4.addActionListener(e -> appendToDisplay("4"));
        button5.addActionListener(e -> appendToDisplay("5"));
        button6.addActionListener(e -> appendToDisplay("6"));
        button7.addActionListener(e -> appendToDisplay("7"));
        button8.addActionListener(e -> appendToDisplay("8"));
        button9.addActionListener(e -> appendToDisplay("9"));

        // Add number buttons to frame
        add(button0);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
        add(button7);
        add(button8);
        add(button9);

        // Mode Change Listener
        hexRadioButton.addActionListener(e -> setMode("Hexadecimal"));
        decRadioButton.addActionListener(e -> setMode("Decimal"));
        binRadioButton.addActionListener(e -> setMode("Binary"));

        setMode("Hexadecimal");
    }

    private void setMode(String mode) {
        currentMode = mode;
        display.setText("");
        firstOperand = "";
        operator = "";

        for (JButton button : new JButton[]{button0, button1, button2, button3, button4, button5, button6, button7, button8, button9}) {
            button.setEnabled(mode.equals("Decimal") || mode.equals("Hexadecimal") || mode.equals("Binary"));
        }

        for (JButton button : new JButton[]{hexButtonA, hexButtonB, hexButtonC, hexButtonD, hexButtonE, hexButtonF}) {
            button.setEnabled(mode.equals("Hexadecimal"));
        }

        if (mode.equals("Binary")) {
            for (int i = 2; i <= 9; i++) {
                new JButton[]{button0, button1, button2, button3, button4, button5, button6, button7, button8, button9}[i].setEnabled(false);
            }
        }

        andButton.setEnabled(!mode.equals("Decimal"));
        orButton.setEnabled(!mode.equals("Decimal"));
        xorButton.setEnabled(!mode.equals("Decimal"));
    }

    private void appendToDisplay(String value) {
        display.setText(display.getText() + value);
    }

    private void setOperator(String op) {
        firstOperand = display.getText();
        operator = op;
        display.setText("");
    }

    private void performNot() {
        if (display.getText().isEmpty()) return;
        int value = parseInput(display.getText());
        display.setText(formatOutput(~value));
    }

    private void calculate() {
        if (firstOperand.isEmpty() || display.getText().isEmpty()) return;

        int num1 = parseInput(firstOperand);
        int num2 = parseInput(display.getText());
        int result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            case "AND":
                result = num1 & num2;
                break;
            case "OR":
                result = num1 | num2;
                break;
            case "XOR":
                result = num1 ^ num2;
                break;
            case "<<":
                result = num1 << num2;
                break;
            case ">>":
                result = num1 >> num2;
                break;
        }

        display.setText(formatOutput(result));
    }

    private int parseInput(String input) {
        switch (currentMode) {
            case "Hexadecimal":
                return Integer.parseInt(input, 16);
            case "Decimal":
                return Integer.parseInt(input);
            case "Binary":
                return Integer.parseInt(input, 2);
            default:
                return 0;
        }
    }

    private String formatOutput(int result) {
        switch (currentMode) {
            case "Hexadecimal":
                return Integer.toHexString(result).toUpperCase();
            case "Decimal":
                return Integer.toString(result);
            case "Binary":
                return Integer.toBinaryString(result);
            default:
                return "";
        }
    }

    private void clear() {
        display.setText("");
        firstOperand = "";
        operator = "";
    }

    public static void main(String[] args) {
        ProgrammerCalculator calculator = new ProgrammerCalculator();
        calculator.setVisible(true);
    }
}
