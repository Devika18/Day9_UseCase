package AddressBook;

import java.util.InputMismatchException;
import java.util.Scanner;
public class AddressBookMain {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book...!");
        System.out.println("Existing data:");
        AddressBookSystem.readingData();
        menu();
    }
    private static void menu() {
        Scanner sc = new Scanner(System.in);
        loop1:while (true) {
            System.out.println("\nwhich one Would you like to open....");
            System.out.println("1.create Address Book");
            System.out.println("2.Open Address Book");
            System.out.println("3.Delete All Address");
            System.out.println("4.Quit");

            int choice = sc.nextInt();
            sc.nextLine();
            AddressBookManager addMan = new AddressBookManager();
            switch (choice) {
                case 1:
                    addMan.createAddressBook();
                    break;
                case 2:
                    addMan.openAddressBook();
                    break;
                case 3:
                    addMan.deleteAllAddress();
                    break loop1;
                case 4:
                    addMan.quitAddressBook();
                    break loop1;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    public static void userInput() {

        Person newPerson = new Person();
        scan.nextLine();
        System.out.println("Enter First Name: ");
        newPerson.setFirstName(scan.nextLine());
        System.out.println("Enter Last Name: ");
        newPerson.setLastName(scan.nextLine());
        System.out.println("Enter City: ");
        newPerson.setCity(scan.nextLine());
        System.out.println("Enter State: ");
        newPerson.setState(scan.nextLine());
        zip:while (true) {
            try {
                System.out.println("Enter Zip: ");
                Scanner scan = new Scanner(System.in);
                newPerson.setZip(scan.nextInt());
                break zip;
            } catch (InputMismatchException e) {
                System.out.println("invalid...! entr again");
                continue ;
            }
        }
        ph:while (true){
            try {
                System.out.println("Enter Phone Number: ");
                Scanner scan = new Scanner(System.in);
                newPerson.setPhoneNumber(scan.nextLong());
                break ph;
            } catch (InputMismatchException e) {
                System.out.println("invalid...! entr again");
                continue ;
            }
        }
        AddressBookSystem newEntry = new AddressBookSystem();
        newEntry.addPerson(newPerson);
    }
    public static void openUserIn() {
        Scanner sc = new Scanner(System.in);
        loop: while (true) {
            System.out.println("Choose the option...!");
            System.out.println("1. Add person ");
            System.out.println("2. edit person ");
            System.out.println("3. delete person ");
            System.out.println("4. search person ");
            System.out.println("5. Sort by zip ");
            System.out.println("6. sort by name ");
            System.out.println("7. Display ");
            int option = sc.nextInt();
            sc.nextLine();
            AddressBookSystem tempObj = new AddressBookSystem();
            switch (option) {
                case 1:
                    userInput();
                    break;
                case 2:
                    tempObj.editPerson();
                    break;
                case 3:
                    System.out.println("Enter the phone number of the person to be deleted");
                    long num = scan.nextLong();
                    tempObj.deletePerson(num);
                    break loop;
                case 4:
                    System.out.println("Enter the phone number of the person to be search");
                    long num1 = scan.nextLong();
                    tempObj.searchPerson(num1);
                    System.out.println();
                    break;
                case 5:
                    tempObj.sortByZip();
                    System.out.println();
                    break;
                case 6:
                    tempObj.sortByFirstName();
                    System.out.println();
                    break;
                case 7:
                    tempObj.display();
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid Option");
                    break loop;
            }
        }
    }
}
