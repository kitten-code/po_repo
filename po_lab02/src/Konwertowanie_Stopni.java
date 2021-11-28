import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Konwertowanie_Stopni extends JFrame {
    private JPanel Main;
    private JTextField textCelcius;
    private JTextField textFarenheit;
    private JButton buttonWyczysc;
    private JButton buttonKonwertuj;
    private JButton buttonWyjscie;
    private JRadioButton radioCzcionkaMala;
    private JRadioButton radioCzcionkaSrednia;
    private JRadioButton radioCzcionkaDuza;
    private JCheckBox checkBoxWielkieLitery;
    private JButton resetujButton;
    private double tempC, tempF;



    public static void main(String[] args) {
        Konwertowanie_Stopni conTemp = new Konwertowanie_Stopni();
        conTemp.setVisible(true);
    }

    public Konwertowanie_Stopni() {
        super("Konwertowanie stopni C -> F");
        this.setContentPane(this.Main);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        setLayout(null);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object ob1 = e.getSource();
                if (ob1 == buttonKonwertuj || ob1 == textCelcius) {
                    tempC = Double.parseDouble(textCelcius.getText());
                    tempF = 32.00 * (9.0 / 5.0) * tempC;
                    textFarenheit.setText(String.valueOf(tempF));
                }else if (ob1 == resetujButton){
                    textFarenheit.setText("");
                    textCelcius.setText("");
                    if(checkBoxWielkieLitery.isSelected() == true) checkBoxWielkieLitery.setSelected(false);
                    else if (radioCzcionkaMala.isSelected() == true) radioCzcionkaMala.setSelected(false);
                    else if(radioCzcionkaSrednia.isSelected() == true) radioCzcionkaSrednia.setSelected(false);
                    else if (radioCzcionkaDuza.isSelected() == true) radioCzcionkaDuza.setSelected(false);

                }else if (ob1 == buttonWyjscie){
                    dispose();
                }else if( ob1 == checkBoxWielkieLitery) {
                    if (checkBoxWielkieLitery.isSelected() == true) {
                        textFarenheit.setFont(new Font("SansSerif", Font.BOLD, 18));
                    }else{
                        textFarenheit.setFont(new Font("SansSerif", Font.PLAIN, 12));
                    }
                }else if (ob1 == radioCzcionkaMala){
                    textFarenheit.setFont(new Font("SansSerif", Font.PLAIN, 8));
                }else if (ob1 == radioCzcionkaSrednia){
                    textFarenheit.setFont(new Font("SansSerif", Font.PLAIN, 12));
                }else if (ob1 == radioCzcionkaDuza){
                    textFarenheit.setFont(new Font("SansSerif", Font.PLAIN, 20));
                }
            }
        };

        buttonKonwertuj.addActionListener(listener);
        resetujButton.addActionListener(listener);
        buttonWyjscie.addActionListener(listener);
        checkBoxWielkieLitery.addActionListener(listener);
        radioCzcionkaMala.addActionListener(listener);
        radioCzcionkaSrednia.addActionListener(listener);
        radioCzcionkaDuza.addActionListener(listener);
    }
}
