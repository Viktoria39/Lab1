package Lab2.V3;
public class Reader extends Person {

    public Reader(String firstname, String lastname, Long readerID) {
        super(firstname, lastname, readerID);
    }

    public Reader() {
        super();
    }

    @Override
    public String toString() {
        return "Reader{" + "id=" + getId() + ", firstname=" + getFirstname() + ", lastname=" + getLastname() + "}";
    }
}