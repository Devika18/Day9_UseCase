package AddressBook;

public class AddressBookManager implements InAddressBookManager {
    public void createAddressBook() {
        AddressBookMain.userInput();
    }

    public void openAddressBook() {
        AddressBookMain.openUserIn();
    }

    public void deleteAllAddress() {
        AddressBookSystem.dataBase.clear();
        System.out.println("Address book data cleared...!");
    }

    public void quitAddressBook() {
        System.out.println("Quitting address book...!");
    }
}
