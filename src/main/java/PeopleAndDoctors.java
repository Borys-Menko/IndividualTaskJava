import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class PeopleAndDoctors {

    private ArrayList<Person> people;


    public PeopleAndDoctors() {
        people = new ArrayList<>();
    }

    public void add(Person person) {
        people.add(person);
    }


    public void outputArrayToFile() {
        String outputFileName = "PeopleAndDoctorsFile.txt";
        people = new PeopleAndDoctors().getPeopleFullList();

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFileName));
            bufferedWriter.write(people.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void therapistOlder50years() {
        people = new PeopleAndDoctors().getPeopleFullList();
        people.stream().filter(s -> s instanceof Doctor)
            .filter(s -> s.getAge() > 50 && ((Doctor) s).getSpecialization().equals("Therapist"))
            .forEach(System.out::println);
    }


    public ArrayList<Person> sortedByLastAndFirstName() {
         people.sort(new NameComparator());
        return people;
    }

    public void printArray(ArrayList<Person> peopleAndDoctors) {
        for (Person s : peopleAndDoctors) {
            System.out.println(s);
        }
    }

    public ArrayList<Person> getPeopleList() {
        return people;
    }

    public ArrayList<Person> getPeopleFullList() {
        people.add(new Doctor(129, "John", "Lennon", 1969, 1, 19
            , 1990, "Therapist"));
        people.add(new Person(104, "Dima", "Rubachok", 1986, 5, 1));
        people.add(new Person(102, "Frodo", "Begins", 1990, 11, 14));
        people.add(new Person(101, "Dima", "Kardash", 1980, 2, 12));
        people.add(new Person(109, "Sebastian", "Lindel", 1982, 7, 1));
        people.add(new Doctor(111, "John", "Konor", 1967, 9, 17
            , 1990, "Therapist"));
        people.add(new Doctor(143, "Dave", "Batista", 1965, 4, 22
            , 1990, "Cardiologist"));
        people.add(new Doctor(128, "Anderson", "Silva", 1976, 1, 4
            , 1990, "Neurology"));
        people.add(new Doctor(133, "Bill", "Gates", 1972, 6, 16
            , 1990, "Gynecologist"));
        people.add(new Doctor(141, "Russel", "Crow", 1970, 11, 25
            , 1990, "Neurology"));

        return people;
    }

    @Override
    public String toString() {
        return "PeopleAndDoctors{" +
            "people=" + people +
            '}';

    }

    class NameComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            String firstName1 = o1.getFirstName();
            String firstName2 = o2.getFirstName();
            int sComp = firstName1.compareTo(firstName2);
            if (sComp != 0) {
                return sComp;
            }
            firstName1 = o1.getLastName();
            firstName2 = o2.getLastName();
            return firstName1.compareTo(firstName2);

        }

    }


}
