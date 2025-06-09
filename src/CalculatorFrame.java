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

    public CalculatorFrame() {
        setTitle("電卓アプリ");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 中央に表示

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

            // 　数字ボタンだけ動作をつける
            //------------------------------------------------------------------
            if (
            	    text.equals("") || text.equals("") || text.equals("") ||
            	    text.equals("") || text.equals("") || text.equals("") ||
            	    text.equals("") || text.equals("") || text.equals("") ||
            	    text.equals("")
            	) {
            //------------------------------------------------------------------
            	    button.addActionListener(new ActionListener() {
            	        public void actionPerformed(ActionEvent e) {
            	            display.setText(display.getText() + text);
            	        }
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
