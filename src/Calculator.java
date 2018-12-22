import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import static java.awt.EventQueue.invokeLater;
import static java.lang.Short.MAX_VALUE;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;
import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;

public class Calculator extends JFrame {

    private JTextField jTextField1;

    private double num;
    private int calculation;

    private Calculator() {
        initComponents();
    }

    private void arithmeticOperation() {
        double ans = 0;
        switch (calculation) {
            case 1:
                ans = num + Double.parseDouble(getText());
                break;

            case 2:
                ans = num - Double.parseDouble(getText());
                break;

            case 3:
                ans = num * Double.parseDouble(getText());
                break;

            case 4:
                ans = num / Double.parseDouble(getText());
                break;
            case 5:
                ans = Math.pow(num, Double.parseDouble(getText()));
                break;
        }
        DecimalFormatSymbols separators = new DecimalFormatSymbols(Locale.getDefault());
        separators.setDecimalSeparator('.');
        separators.setGroupingSeparator('.');
        jTextField1.setText(new DecimalFormat("#.#########", separators).format(ans));
    }

    private String getText() {
        return jTextField1.getText();
    }

    private void initComponents() {

        Font buttonFont = new Font("Tahoma", Font.BOLD, 20);

        jTextField1 = new JTextField();
        jTextField1.setEditable(false);
        jTextField1.setFont(new Font("Tahoma", Font.BOLD, 23)); // NOI18N
        jTextField1.setHorizontalAlignment(JTextField.RIGHT);

        JLabel jLabel1 = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setLocation(new Point(500, 250));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);


        JButton zeroButton = new JButton("0");
        JButton oneButton = new JButton("1");
        JButton twoButton = new JButton("2");
        JButton threeButton = new JButton("3");
        JButton fourButton = new JButton("4");
        JButton fiveButton = new JButton("5");
        JButton sixButton = new JButton("6");
        JButton sevenButton = new JButton("7");
        JButton eightButton = new JButton("8");
        JButton nineButton = new JButton("9");
        JButton plusButton = new JButton("+");
        JButton powerButton = new JButton("^");
        JButton backspaceButton = new JButton("<");
        JButton minusButton = new JButton("-");
        JButton multipleButton = new JButton("*");
        JButton pointButton = new JButton(".");
        JButton divideButton = new JButton("/");
        JButton resultButton = new JButton("=");
        JButton clearButton = new JButton("C");

        Collection<JButton> buttons = Arrays.asList(zeroButton, oneButton, twoButton, threeButton, fourButton,
                fiveButton, sixButton, sevenButton, eightButton, nineButton, plusButton, powerButton, backspaceButton,
                minusButton, multipleButton, pointButton, divideButton, resultButton, clearButton);
        buttons.forEach(button -> button.setFont(buttonFont));

        buttons.stream()
                .filter(b -> b.getText().matches("\\d"))
                .forEach(b -> b.addActionListener(e -> jTextField1.setText(getText() + b.getText())));

        clearButton.addActionListener(e -> jTextField1.setText(""));

        pointButton.addActionListener(e -> jTextField1.setText(getText() + "."));

        backspaceButton.addActionListener(e -> {
            int length = getText().length();
            int number = getText().length() - 1;
            String store;

            if (length > 0) {
                StringBuilder back = new StringBuilder(getText());
                back.deleteCharAt(number);
                store = back.toString();
                jTextField1.setText(store);
            }
        });

        plusButton.addActionListener(e -> {
            num = Double.parseDouble(getText());
            calculation = 1;
            jTextField1.setText("");
            jLabel1.setText(num + "+");
        });

        minusButton.addActionListener(e -> {
            num = Double.parseDouble(getText());
            calculation = 2;
            jTextField1.setText("");
            jLabel1.setText(num + "+");
        });

        multipleButton.addActionListener(e -> {
            num = Double.parseDouble(getText());
            calculation = 3;
            jTextField1.setText("");
            jLabel1.setText(num + "*");
        });

        divideButton.addActionListener(e -> {
            num = Double.parseDouble(getText());
            calculation = 4;
            jTextField1.setText("");
            jLabel1.setText(num + "/");
        });

        powerButton.addActionListener(e -> {
            num = Double.parseDouble(getText());
            calculation = 5;
            jTextField1.setText("");
            jLabel1.setText(num + "^");
        });

        resultButton.addActionListener(e -> {
            arithmeticOperation();
            jLabel1.setText("");
        });


        jLabel1.setForeground(new java.awt.Color(255, 51, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addGroup(TRAILING, layout.createSequentialGroup()
                                                .addComponent(powerButton, PREFERRED_SIZE, 49, PREFERRED_SIZE)
                                                .addPreferredGap(UNRELATED)
                                                .addComponent(backspaceButton)
                                                .addPreferredGap(RELATED, DEFAULT_SIZE, MAX_VALUE)
                                                .addComponent(clearButton, PREFERRED_SIZE, 49, PREFERRED_SIZE)
                                                .addPreferredGap(UNRELATED)
                                                .addComponent(plusButton, PREFERRED_SIZE, 49, PREFERRED_SIZE))
                                        .addComponent(jTextField1)
                                        .addGroup(TRAILING, layout.createSequentialGroup()
                                                .addComponent(zeroButton, PREFERRED_SIZE, 60, PREFERRED_SIZE)
                                                .addPreferredGap(RELATED)
                                                .addComponent(pointButton, PREFERRED_SIZE, 60, PREFERRED_SIZE)
                                                .addPreferredGap(RELATED)
                                                .addComponent(resultButton, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE))
                                        .addGroup(TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(LEADING)
                                                        .addGroup(TRAILING, layout.createSequentialGroup()
                                                                .addComponent(sevenButton, PREFERRED_SIZE, 60, PREFERRED_SIZE)
                                                                .addPreferredGap(RELATED)
                                                                .addComponent(eightButton, PREFERRED_SIZE, 60, PREFERRED_SIZE)
                                                                .addPreferredGap(RELATED)
                                                                .addComponent(nineButton, PREFERRED_SIZE, 60, PREFERRED_SIZE)
                                                                .addPreferredGap(RELATED)
                                                                .addComponent(minusButton, PREFERRED_SIZE, 60, PREFERRED_SIZE))
                                                        .addGroup(TRAILING, layout.createSequentialGroup()
                                                                .addComponent(fourButton, PREFERRED_SIZE, 60, PREFERRED_SIZE)
                                                                .addPreferredGap(RELATED)
                                                                .addComponent(fiveButton, PREFERRED_SIZE, 60, PREFERRED_SIZE)
                                                                .addPreferredGap(RELATED)
                                                                .addComponent(sixButton, PREFERRED_SIZE, 60, PREFERRED_SIZE)
                                                                .addPreferredGap(RELATED)
                                                                .addComponent(multipleButton, PREFERRED_SIZE, 60, PREFERRED_SIZE))
                                                        .addGroup(TRAILING, layout.createSequentialGroup()
                                                                .addComponent(oneButton, PREFERRED_SIZE, 60, PREFERRED_SIZE)
                                                                .addPreferredGap(RELATED)
                                                                .addComponent(twoButton, PREFERRED_SIZE, 60, PREFERRED_SIZE)
                                                                .addPreferredGap(RELATED)
                                                                .addComponent(threeButton, PREFERRED_SIZE, 60, PREFERRED_SIZE)
                                                                .addPreferredGap(RELATED)
                                                                .addComponent(divideButton, PREFERRED_SIZE, 60, PREFERRED_SIZE))
                                                        .addGroup(TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jLabel1, PREFERRED_SIZE, 56, PREFERRED_SIZE)
                                                                .addGap(9, 9, 9)))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1, PREFERRED_SIZE, 14, PREFERRED_SIZE)
                                .addPreferredGap(RELATED)
                                .addComponent(jTextField1, PREFERRED_SIZE, 45, PREFERRED_SIZE)
                                .addPreferredGap(RELATED)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(clearButton, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                        .addComponent(backspaceButton, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                        .addComponent(plusButton)
                                        .addComponent(powerButton))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(sevenButton)
                                        .addComponent(eightButton)
                                        .addComponent(nineButton)
                                        .addComponent(minusButton))
                                .addPreferredGap(UNRELATED)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(fourButton)
                                        .addComponent(fiveButton)
                                        .addComponent(sixButton)
                                        .addComponent(multipleButton))
                                .addPreferredGap(UNRELATED)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(oneButton)
                                        .addComponent(twoButton)
                                        .addComponent(threeButton)
                                        .addComponent(divideButton))
                                .addPreferredGap(UNRELATED)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(zeroButton)
                                        .addComponent(pointButton)
                                        .addComponent(resultButton))
                                .addGap(18, 18, 18))
        );

        pack();
    }


    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        invokeLater(() -> new Calculator().setVisible(true));
    }

}
