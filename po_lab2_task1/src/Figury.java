import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Figury extends JFrame {
    private JPanel panel1;
    private JRadioButton kwadratradioButtonKwadrat;
    private JRadioButton prostokatRadioButton;
    private JRadioButton trojkatRadioButton;
    private JRadioButton trapezRadioButton;
    private JRadioButton szescianRadioButton;
    private JRadioButton prostopadloscianRadioButton;
    private JRadioButton walecRadioButton;
    private JRadioButton kulaRadioButton;
    private JTextField textFieldPodajBokA;
    private JTextField textFieldPodajBokB;
    private JTextField textFieldPodajWysokosc;
    private JTextField textFieldPodajPromien;
    private JTextField textFieldPole;
    private JTextField textFieldObwod;
    private JTextField textFieldObjetosc;

    public static void main(String[] args) {
        Figury conTemp = new Figury();
        conTemp.setVisible(true);
    }

    public Figury() {
        super("Figury Geometryczne Calc");
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        setLayout(null);

        DisableAll();
        textFieldPodajBokA.disable();
        textFieldPodajBokB.disable();
        textFieldObjetosc.disable();
        textFieldPodajWysokosc.disable();
        textFieldPodajPromien.disable();
        textFieldObwod.disable();
        textFieldPole.disable();

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };

    }

    public void DisableAll() {
        textFieldPodajBokA.disable();
        textFieldPodajBokB.disable();
        textFieldObjetosc.disable();
        textFieldPodajWysokosc.disable();
        textFieldPodajPromien.disable();
        textFieldObwod.disable();
        textFieldPole.disable();
    }
}
