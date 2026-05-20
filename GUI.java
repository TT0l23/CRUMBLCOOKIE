import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    Cookies logic = new Cookies();
    Color myColor = new Color(174, 150, 48);
    JFrame frame;
    JButton cookieButton;
    JButton Upgrade1Button;
    JPanel panel;
    JLabel CountLabel;
    ImageIcon Nummie = new ImageIcon("src/insomnia.png");


    public GUI() {
        frame = new JFrame("COOKIE CRASH!");
        cookieButton = new JButton(Nummie);
        cookieButton.setPreferredSize(new Dimension(512,512));
        cookieButton.addActionListener(e -> {
            logic.Click();
            UpdateCountLabel();
        });
        Upgrade1Button = new JButton("Upgrade (+1 APC) | Cost: "+logic.getUpgrade1Cost()+" Cookies");
        Upgrade1Button.addActionListener(e -> {
            if(logic.buyUpgrade1()){
                UpdateCountLabel();
                Upgrade1Button.setText("Upgrade (+1 APC) | Cost: "+logic.getUpgrade1Cost()+" Cookies");
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + logic.getUpgrade1Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        CountLabel = new JLabel("Cookies: "+logic.getCookieCount()+" | APC: "+logic.getAmountPerClick());//

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //panel.setLayout(new GridLayout(2, 1));
        panel.setBackground(myColor);

        panel.add(cookieButton);
        panel.add(Upgrade1Button);
        panel.add(CountLabel);



        frame.add(panel, BorderLayout.CENTER);
        frame.setIconImage(Nummie.getImage());

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }

    private void UpdateCountLabel(){
        CountLabel.setText("Cookies: "+logic.getCookieCount()+" | APC: "+logic.getAmountPerClick());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }
}