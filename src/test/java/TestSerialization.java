import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSerialization {

    String file1 = "C:\\Users\\Boris\\IdeaProjects\\IndividualTask\\SerializationFile.xml";
    String file2 = "C:\\Users\\Boris\\IdeaProjects\\IndividualTask\\x.xml";
    SerializationCollection serializationCollection = new SerializationCollection(
        new PeopleAndDoctors().getPeopleFullList());

    @Test
    public void serializationTest() throws IOException {
        serializationCollection.serializePeople(file1);
        BufferedReader br1 = new BufferedReader(new FileReader(file1));
        BufferedReader br2 = new BufferedReader(new FileReader(file2));

        int actualResult = br1.read();
        int expectedResult = br2.read();
        br1.close();
        br2.close();

        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void deserializationTest() {
        serializationCollection.deserializePeople(file1);

        ArrayList<Person> actualResult = serializationCollection.getPeople();
        ArrayList<Person> expectedResult = new PeopleAndDoctors().getPeopleFullList();

        Assert.assertEquals(actualResult, expectedResult);



    }
}
