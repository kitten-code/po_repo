package FIrst_Task_q;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
public class SwingApp extends JFrame {
        private JPanel panel1;
        private JPanel JPanelTop;
        private JPanel JPanelLeft;
        private JPanel JPanelRight;
        private JTextField textName;
        private JTextField textEmail;
        private JTextField textPhoneNumber;
        private JTextField textAddress;
        private JButton buttonNew;
        private JButton buttonSave;
        private JTextField textDateBirth;
        private JLabel JLabelAge;
        private JList listPeople;
        private ArrayList<Person> people;
        private DefaultListModel listPeopleModel;


        public Task_1(){
            super("My Project");
            this.setContentPane(this.panel1);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.pack();
            people = new ArrayList<Person>();
            listPeopleModel = new DefaultListModel();
            listPeople.setModel(listPeopleModel);

            buttonNew.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            listPeople.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    int personNumber = listPeople.getSelectedIndex();
                    if(personNumber >= 0){
                        Person p = people.get(personNumber);
                        textName.setText(p.getName());
                        textEmail.setText(p.getEmail());
                        textPhoneNumber.setText(p.getPhoneNumber());
                        textAddress.setText(p.getAdress());
                        textDateBirth.setText(p.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyya")));
                    }
                }
            });
        }

        public static void main(String[] args) {

            Task_1 task_1 = new Task_1();
            task_1.setVisible(true);

            Person jan = new Person("Jan Kowalski", "jkk@gmail.com", "355-121-642", "Koppisto 3B 222", "22/11/2002");
            Person marek = new Person("Marek Sczeka", "szczeek222@gmail.com", "515-111-642", "Piwwwen 1a 12", "10/09/1997");
            Person sandra = new Person("Sandra Niemiec", "skmm2@gmail.com", "544-351-222", "Piwwwen 6a 121", "15/02/1991");

            task_1.addPerson(jan);
            task_1.addPerson(marek);
            task_1.addPerson(sandra);
        }

        public void refreshPeopleList(){
            listPeopleModel.removeAllElements();
            System.out.println("Delete all elements");
            for(Person p: people){
                System.out.println("Add all elements list " + p.getName());
                listPeopleModel.addElement(p.getName());
            }

        }

        public void addPerson(Person p){
            people.add(p);
            refreshPeopleList();
        }


    }
}
