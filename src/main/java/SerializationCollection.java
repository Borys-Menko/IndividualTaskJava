import java.beans.Encoder;
import java.beans.Expression;
import java.beans.PersistenceDelegate;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class SerializationCollection {

  private ArrayList<Person> people;

  public SerializationCollection(ArrayList<Person> people) {
    this.people = people;
  }

  public ArrayList<Person> getPeople() {
    return people;
  }

  public void setPeople(ArrayList<Person> people) {
    this.people = people;
  }

  public void serializePeople(String fileName)  {
      XMLEncoder encoder = null;
      try {
          encoder = new XMLEncoder(new FileOutputStream(fileName));
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }
      encoder.setPersistenceDelegate(LocalDate.class,
        new PersistenceDelegate(){
          @Override
          protected Expression instantiate(Object birthDate, Encoder out) {

            return new Expression(birthDate,
                LocalDate.class,
                "parse",
                new Object[]{
                    birthDate.toString()
                });
          }
        });
    encoder.writeObject(this.people);
    encoder.close();
  }

  public void deserializePeople(String fileName){
      XMLDecoder decoder = null;
      try {
          decoder = new XMLDecoder(new FileInputStream(fileName));
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }
      this.people = (ArrayList<Person>)decoder.readObject();
    decoder.close();
  }

  @Override
  public String toString() {
    String str = "";
    for(Person person : people){
      str += person.toString() + "\n";
    }
    return str;
  }
}
