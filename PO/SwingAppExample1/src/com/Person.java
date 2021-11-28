package com;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.Period;


public class Person {
    protected String getYears;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private LocalDate dateofBirth;

    public Person(String name, String email, String phoneNumber, String address, LocalDate dateofBirth) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateofBirth = dateofBirth;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(LocalDate dateofBirth) {
        this.dateofBirth = dateofBirth;
    }


    //metoda pozwalająca na wyświetlanie daty urodzenia w formacie dd/mm/yyyy jako string
    public void setDateOfBirth(String dateOfBirth){
        this.dateofBirth=LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }


// tworzymy konstruktor który jako parametr daty urodzenia przekazywany jest String ( dateOfBirth -String)

    public Person(String name, String email, String phoneNumber, String address, String dateofBirth){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.setDateOfBirth(dateofBirth);
    }

    /* Wykorzystanie klasy Peroid( używa jednostek dzień, miesiąc, rok) - dla jednostek możemy wykorzystywać metody - dni,
    tygodnie, miesiące. Tworzymy obiekt klasy i wywołujemy przez to ( możemy podawać argumenty jako wzorce, jeżeli mamy
    argument wzoraca to definiowany jest jako tekst a różnica lat between_
*/






/*public class Period {
    public static void main(String[] args){
        private static Period between(LocalDate date1, LocalDate date2) {
        }

        LocalDate date1 = LocalDate.of(2000, Month.JANUARY, 2);
        LocalDate date2 = LocalDate.of(2000, Month.FEBRUARY, 2);

        Period period = Period.between(date1, date2);


        System.out.println("Różnica dat wynosi:");
        System.out.println( period.getYears()+" lat");
        System.out.println( period.getMonths()+ " miesięcy");
        System.out.println(period.getDays()+" dni");

    }




    public void setYears(String years) {
        this.years = years;
    }
}

*/

    public int getAge(){
        LocalDate today=LocalDate.now();
        Period period= Period.between(this.dateofBirth,today);
        return period.getYears();
    }
}
