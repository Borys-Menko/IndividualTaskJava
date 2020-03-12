import java.time.LocalDateTime;
import org.testng.annotations.DataProvider;

public class PersonDataProvider {

    @DataProvider(name = "testPersonGetAge")
    public Object[][] dataProviderAge(){
        LocalDateTime now = LocalDateTime.now();
        int expectedAge = 34;
        Person person = new Person(129, "John", "Lennon",
            now.getYear() - expectedAge, now.getMonthValue(), now.getDayOfMonth() - 1);
        return new Object[][]{{person,expectedAge}};
    }

    @DataProvider(name = "testPersonSort")
    public Object[][] dataProviderSort(){
        PeopleAndDoctors unsortedPeople = new PeopleAndDoctors();
        unsortedPeople.add(new Person(104, "Dima", "Rubachok",
            1986, 5, 1));
        unsortedPeople.add(new Doctor(111, "John", "Conor",
            1967, 9, 17, 1990, "Therapist"));
        unsortedPeople.add(new Doctor(128, "Anderson", "Silva",
            1976, 1, 4, 1990, "Neurology"));

        PeopleAndDoctors sortedPeople = new PeopleAndDoctors();
        sortedPeople.add(new Doctor(128, "Anderson", "Silva",
            1976, 1, 4, 1990, "Neurology"));
        sortedPeople.add(new Person(104, "Dima", "Rubachok",
            1986, 5, 1));
        sortedPeople.add(new Doctor(111, "John", "Conor",
            1967, 9, 17, 1990, "Therapist"));

        return new  Object[][]{{unsortedPeople,sortedPeople}};
    }

    @DataProvider(name = "testOutputPerson")
    public Object[][] testOutputPerson(){
        Person person = new Person(104, "Dima", "Rubachok",
            1986, 5, 1);
        return new  Object[][]{{person}};
    }

}
