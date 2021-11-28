package com;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.*;

public class SwingApp extends JFrame {
    private JPanel PanelMain;
    private JPanel JPanelTop;
    private JPanel JPanelLeft;
    private JPanel JPanelRight;
    private JLabel JLabelAge;
    private JButton buttonNew;
    private JButton buttonSave;
    private JTextField textName;
    private JTextField textEmail;
    private JTextField textPhoneNumber;
    private JTextField textAddress;
    private JTextField textDateBirth;
    private JList listPeople;
    private ArrayList<Person> people;
    private DefaultListModel listPeopleModel;


// konstruktor klasy
public SwingApp(){
    super("My Project"); //wywolanie konstruktora super z nazwa naszego okna
    this.setContentPane(this.PanelMain);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();

    people = new ArrayList<Person>();
    listPeopleModel = new DefaultListModel();
    listPeople.setModel(listPeopleModel);

    buttonSave.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int personNumber=listPeople.getSelectedIndex();
            if (personNumber>=0){
                Person p=people.get(personNumber);
                p.setName(textName.getText());
                p.setPhoneNumber(textPhoneNumber.getText());
                p.setAddress(textAddress.getText());
                p.setDateOfBirth(textDateBirth.getText());
                refreshPeopleList();
            }

        }});
    buttonNew.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Person p=new Person(
                  textName.getText(),
                    textEmail.getText(),
                    textPhoneNumber.getText(),
                    textAddress.getText(),
                    textDateBirth.getText());
            people.add(p);
            refreshPeopleList();
        }});

    listPeople.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            int personNumber = listPeople.getSelectedIndex();
            if(personNumber >= 0){
                Person p = people.get(personNumber);
                textName.setText(p.getName());
                textEmail.setText(p.getEmail());
                textPhoneNumber.setText(p.getPhoneNumber());
                textAddress.setText(p.getAddress());
                textDateBirth.setText(p.getDateofBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyya")));
                JLabelAge.setText(Integer.toString(p.getAge())+"lat/lata");
                buttonSave.setEnabled(true);
            }else{
                buttonSave.setEnabled(false);
            }
        }
    });
}

    public static void main(String[] args) {
        SwingApp swingApp=new SwingApp();
        swingApp.setVisible(true);
        Person jan= new Person("Jan Kowalski", "jkowalski@gmail.com", "234 443 922", "Ogrodowa 14", "14/07/2001");
        Person marian = new Person("Marian Nowak", "mnowak@gmail.com", "634 113 912", "Taneczna 22/2", "15/08/1992");
        Person janina = new Person("Janina Urban", "jurban@gmail.com", "544 351 222", "Małosolna 23b", "02/02/1981");

        swingApp.addPerson(jan);
        swingApp.addPerson(marian);
        swingApp.addPerson(janina);
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

