import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Person {

    private int taxNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;


    public Person() {
    }

    public Person(int taxNumber, String firstName, String lastName, int year, int month, int day) {
        this.taxNumber = taxNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = LocalDate.of(year, month, day);
        ;
    }

    public int getAge() {
        LocalDate date = LocalDate.now();
        int newDate = date.getYear() - birthDate.getYear() - 1;

        if (birthDate.getMonthValue() < date.getMonthValue()) {
            newDate++;
        } else if (birthDate.getMonthValue() == date.getMonthValue()) {
            if (birthDate.getDayOfMonth() < date.getDayOfMonth()) {
                newDate++;
            }
        }

        return newDate;
    }


    public void inputPerson() {
        Scanner sc = new Scanner(System.in);
        try {
        System.out.println("Please, enter Tax Number of this person");
        taxNumber = sc.nextInt();
        System.out.println("Please, enter First Name of this person");
        firstName = sc.next();
        System.out.println("Please, enter Last Name of this person");
        lastName = sc.next();
        System.out.println("Please, enter Birth Date of this person in format like yyyy-MM-dd");
            birthDate = LocalDate.parse(sc.next());
        } catch (Exception e) {
            System.out.println("Wrong date format, please try again");
            inputPerson();
        }

    }

    public void outputPerson() {
        String outputFileName = "PersonFile.txt";

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFileName));
            bufferedWriter.write(toString());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(int taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }


    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return taxNumber == person.taxNumber &&
            Objects.equals(firstName, person.firstName) &&
            Objects.equals(lastName, person.lastName) &&
            Objects.equals(birthDate, person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taxNumber, firstName, lastName, birthDate);
    }

    @Override
    public String toString() {
        return "Person{" +
            "taxNumber=" + taxNumber +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", birthDate=" + birthDate +
            '}';
    }
}
