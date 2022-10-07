package AddressBook;

public interface InAddressBookSystem {
    public void addPerson(Person a);
    public void editPerson();
    public void deletePerson(long phoneNumber);
    public void searchPerson(long phoneNumber);
    public void sortByZip();
    public void sortByFirstName();
    public void display();
}
