import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorFrame extends JFrame {
    private JTextField display;
    private double firstNumber = 0;
    private String operator = "";
    private boolean isNewInput = false;

    public CalculatorFrame() {
        setTitle("電卓アプリ");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 表示欄
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        add(display, BorderLayout.NORTH);

        // ボタンパネル
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] buttons = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "0", "C", "=", "/"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));

            // 数字ボタン
            if (text.equals("0") || text.equals("1") || text.equals("2") ||
                text.equals("3") || text.equals("4") || text.equals("5") ||
                text.equals("6") || text.equals("7") || text.equals("8") ||
                text.equals("9")) {

                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (isNewInput) {
                            display.setText(text);
                            isNewInput = false;
                        } else {
                            display.setText(display.getText() + text);
                        }
                    }
                });

            // 演算子（+, -, *, /）
            } else if (text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/")) {
                button.addActionListener(e -> {
                    firstNumber = Double.parseDouble(display.getText());
                    operator = text;
                    isNewInput = true;
                });

            // = ボタン
            } else if (text.equals("=")) {
                button.addActionListener(e -> {
                    double secondNumber = Double.parseDouble(display.getText());
                    double result = 0;

                    switch (operator) {
                        case "+": result = firstNumber + secondNumber; break;
                        case "-": result = firstNumber - secondNumber; break;
                        case "*": result = firstNumber * secondNumber; break;
                        case "/":
                            if (secondNumber == 0) {
                                display.setText("エラー: 0除算");
                                isNewInput = true;
                                return;
                            }
                            result = firstNumber / secondNumber; break;
                    }

                    display.setText(String.valueOf(result));
                    isNewInput = true;
                });

            // C ボタン（クリア）
            } else if (text.equals("C")) {
                button.addActionListener(e -> {
                    display.setText("");
                    firstNumber = 0;
                    operator = "";
                    isNewInput = false;
                });
            }

            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CalculatorFrame();
    }
}
