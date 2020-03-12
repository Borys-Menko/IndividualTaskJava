import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    PeopleAndDoctors peopleAndDoctors;
    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner input = new Scanner(System.in);

    public View() {
        menu = new LinkedHashMap<>();
        menu.put("1", "  1 - Input doctor from console and output to file");
        menu.put("2", "  2 - Input person from console and get age in full years");
        menu.put("3", "  3 - Output the data about doctors-therapists elder than 50 years");
        menu.put("4", "  4 - Sort the data by first name and last name");
        menu.put("5", "  5 - Output the collection to a file");
        menu.put("6", "  6 - Serialize the collection to XML file and deserialize it back");
        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("1", this::pressButton1);
        methodsMenu.put("2", this::pressButton2);
        methodsMenu.put("3", this::pressButton3);
        methodsMenu.put("4", this::pressButton4);
        methodsMenu.put("5", this::pressButton5);
        methodsMenu.put("6", this::pressButton6);
    }


    private void pressButton1() {
        Doctor doctor = new Doctor();
        doctor.inputPerson();
        doctor.outputPerson();
        System.out.println(doctor);

    }

    private void pressButton2() {
        Person person = new Person();
        person.inputPerson();
        System.out.println("\n" + person.getFirstName() + " is " + person.getAge() + " years old");

    }


    private void pressButton3() {
        new PeopleAndDoctors().therapistOlder50years();
    }

    private void pressButton4() {
        peopleAndDoctors = new PeopleAndDoctors();
        peopleAndDoctors.printArray(peopleAndDoctors.getPeopleFullList());
        System.out.println("\n");
        peopleAndDoctors.printArray(peopleAndDoctors.sortedByLastAndFirstName());

    }

    private void pressButton5() {
        new PeopleAndDoctors().outputArrayToFile();

    }

    private void pressButton6() {
        String file = "C:\\Users\\Boris\\IdeaProjects\\IndividualTask\\SerializationFile.xml";

        SerializationCollection serializationCollection = new SerializationCollection(
            new PeopleAndDoctors().getPeopleFullList());
        serializationCollection.serializePeople(file);
        serializationCollection.deserializePeople(file);
        System.out.println("\n");
        System.out.println(serializationCollection);
    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point");
            keyMenu = input.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
            }
        } while (!keyMenu.equals("Q"));
    }
}