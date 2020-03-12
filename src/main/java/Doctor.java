import java.util.Objects;
import java.util.Scanner;

public class Doctor extends Person {

    private int yearOfStartPractice;
    private String specialization;

    public Doctor() {
    }

    public Doctor(int taxNumber, String firstName, String lastName, int year, int month, int day,
        int yearOfStartPractice, String specialization) {
        super(taxNumber, firstName, lastName, year, month, day);
        this.yearOfStartPractice = yearOfStartPractice;
        this.specialization = specialization;
    }

    public int getYearOfStartPractice() {
        return yearOfStartPractice;
    }

    public void setYearOfStartPractice(int yearOfStartPractice) {
        this.yearOfStartPractice = yearOfStartPractice;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public void inputPerson() {
        super.inputPerson();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, enter year of start practice");
        yearOfStartPractice = sc.nextInt();
        System.out.println("Please, enter your specialization");
        specialization = sc.next();


    }

    @Override
    public void outputPerson() {
        super.outputPerson();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Doctor)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Doctor doctor = (Doctor) o;
        return yearOfStartPractice == doctor.yearOfStartPractice &&
            Objects.equals(specialization, doctor.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), yearOfStartPractice, specialization);
    }

    @Override
    public String toString() {
        return "Doctor " + super.toString() +
            ", {yearOfStartPractice=" + yearOfStartPractice +
            ", specialization='" + specialization + '\'' +
            '}';
    }
}
