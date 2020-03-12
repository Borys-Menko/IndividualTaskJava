import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestPerson {

    @Test(priority = 1,dataProvider = "testPersonGetAge",dataProviderClass = PersonDataProvider.class)
    public void testGetAge(Person person,int ExpectedAge) {
        //Act
        int actualAge = person.getAge();
        //Assert
        Assert.assertEquals(actualAge, ExpectedAge);
    }

    @Test(priority = 2,dataProvider = "testPersonSort",dataProviderClass = PersonDataProvider.class)
    public void sortByFirstAndLastName(PeopleAndDoctors actualSort,
        PeopleAndDoctors expectedSort) {
        //Act
        actualSort.sortedByLastAndFirstName();

        ArrayList<Person> actualResult = actualSort.getPeopleList();
        ArrayList<Person> expectedResult = expectedSort.getPeopleList();
        //Assert
        Assert.assertEquals(actualResult,expectedResult);

    }

    @Test(priority = 3,dataProvider = "testOutputPerson", dataProviderClass = PersonDataProvider.class)
    public void outputPerson(Person person) throws IOException {
        //Arrange
        InputStream is = new FileInputStream("PersonFile.txt");
        BufferedReader bw = new BufferedReader(new InputStreamReader(is));

        //Act
        person.outputPerson();

        String actualResult = bw.readLine();
        String expectedResult = person.toString();
        //Assert
        Assert.assertEquals(actualResult, expectedResult);

    }

}
