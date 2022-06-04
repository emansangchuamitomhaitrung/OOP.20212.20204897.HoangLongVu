package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;


public class Aims {
    private static final Store store = new Store();
    private static final Cart cart = new Cart();
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // Testing console application
        // populating store
        DigitalVideoDisc d1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        store.addDVD(d1);

        DigitalVideoDisc d2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addDVD(d2);

        DigitalVideoDisc d3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addDVD(d3);

        DigitalVideoDisc d4 = new DigitalVideoDisc("Before sunrise", "Romance", "Richard Linklater", 70, 20f);
        store.addDVD(d4);

        DigitalVideoDisc d5 = new DigitalVideoDisc("Before sunset", "Romance", "Richard Linklater", 65, 21.5f);
        store.addDVD(d5);

        DigitalVideoDisc d6 = new DigitalVideoDisc("Before midnight", "Romance", "Richard Linklater", 75, 22.3f);
        store.addDVD(d6);

        DigitalVideoDisc d7 = new DigitalVideoDisc("Sadness", "Tragedy", "My Life", 100, 1f);
        store.addDVD(d7);

        DigitalVideoDisc d8 = new DigitalVideoDisc("Eternal Sunshine of the Spotless Mind", "Romance", "Michel Gondry", 150, 21.5f);
        store.addDVD(d8);

        showMenu();
    }

    public static void showMenu() {
        clearScreen();
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");

        int choice = scan.nextInt();
        scan.nextLine();

        // check choice validity
        while ((choice != 0) && (choice != 1) && (choice != 2) && (choice != 3)) {
            System.out.println("Please choose a valid option.");
            choice = scan.nextInt();
            scan.nextLine();
        }
        switch (choice) {
            case 0:
                System.out.println("Thank you for using our service. Meow~");
                System.exit(0);
            case 1:
                clearScreen();
                storeMenu();
            case 2:
                clearScreen();
                updateStore();
                showMenu();
            case 3:
                clearScreen();
                cartMenu();
        }
    }

    public static void storeMenu() {
        System.out.println();
        store.print();
        System.out.println();
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a DVD's details");
        System.out.println("2. Add a DVD to cart");
        System.out.println("3. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");

        int choice = scan.nextInt();
        scan.nextLine();

        // check input validity
        while ((choice != 0) && (choice != 1) && (choice != 2) && (choice != 3)) {
            System.out.println("Please choose a valid option.");
            choice = scan.nextInt();
            scan.nextLine();
        }

        switch (choice) {
            case 0:
                clearScreen();
                showMenu();
            case 1:
                seeDetails();
                storeMenu();
            case 2:
                addToCart();
                storeMenu();
            case 3:
                cartMenu();
                storeMenu();
        }
    }


    public static void seeDetails() {
        System.out.println("Enter the title of DVD to see details");
        String title = scan.nextLine();
        DigitalVideoDisc result = store.searchDVD(title);

        // check title validity
        while (result == null) {
            System.out.println("Item not found. Please enter another title (case-insensitive)");
            title = scan.nextLine();
            result = store.searchDVD(title);
        }
        System.out.println(result);

        System.out.println("Do you want to add this item to cart? [y/n]");
        String ynOption = scan.nextLine();
        if (ynOption.equals("y")) {
            cart.addDigitalVideoDisc(result);
        } else {
            storeMenu();
        }
    }

    public static void updateStore() {
        store.print();
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add DVD to cart");
        System.out.println("2. Remove DVD from cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int choice = scan.nextInt();
        scan.nextLine();

        // check input validity
        while ((choice != 0) && (choice != 1) && (choice != 2)) {
            System.out.println("Please choose a valid option.");
            choice = scan.nextInt();
            scan.nextLine();
        }

        switch (choice) {
            case 0:
                showMenu();
            case 1:
                addToCart();
                updateStore();
            case 2:
                removeFromCart();
                updateStore();
        }
    }

    public static void cartMenu() {
        cart.print();
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter DVDs in cart");
        System.out.println("2. Sort DVDs in cart");
        System.out.println("3. Remove DVD from cart");
        System.out.println("4. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

        int choice = scan.nextInt();
        scan.nextLine();


        // check input validity
        while ((choice != 0) && (choice != 1) && (choice != 2) && (choice != 3) && (choice != 4)) {
            System.out.println("Please choose a valid option.");
            choice = scan.nextInt();
            scan.nextLine();
        }

        switch (choice) {
            case 0:
                storeMenu();
            case 1:
                filterCart();
                cartMenu();
            case 2:
                sortCart();
                cartMenu();
            case 3:
                removeFromCart();
                cartMenu();
            case 4:
                System.out.println("Order created successfully.");
                System.out.println("Options: ");
                System.out.println("1. Go back to AIMS Homepage");
                System.out.println("0. Exit");

                int option = scan.nextInt();
                scan.nextLine();

                if (option == 1) {
                    clearScreen();
                    showMenu();
                } else {
                    System.out.println("Thank you for using our service. Meow~");
                    System.exit(0);
                }
        }
    }

    public static void filterCart() {
        System.out.println("Filtering options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int choice = scan.nextInt();
        scan.nextLine();

        // check input validity
        while ((choice != 0) && (choice != 1) && (choice != 2)) {
            System.out.println("Please choose a valid option.");
            choice = scan.nextInt();
            scan.nextInt();
        }

        switch (choice) {
            case 0:
                cartMenu();
            case 1:
                System.out.println("Enter ID: ");
                int id = scan.nextInt();
                scan.nextLine();
                cart.filterById(id);
                cartMenu();
            case 2:
                System.out.println("Enter title");
                String title = scan.nextLine();
                cart.filterByTitle(title);
                cartMenu();
        }
    }

    public static void sortCart() {
        System.out.println("Sorting options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int choice = scan.nextInt();
        scan.nextLine();

        // check input validity
        while ((choice != 0) && (choice != 1) && (choice != 2)) {
            System.out.println("Please choose a valid option.");
            choice = scan.nextInt();
            scan.nextInt();
        }
        switch (choice) {
            case 0:
                System.out.println("Thank you for using our service. Meow~");
                System.exit(0);
            case 1:
                DigitalVideoDisc[] tmp = new DigitalVideoDisc[cart.getQtyOrdered()];
                System.arraycopy(cart.getItemsOrdered(), 0, tmp, 0, cart.getQtyOrdered());
                cart.sortByTitleCost(tmp);

                for (int i = 0; i < cart.getQtyOrdered(); i++) {
                    System.out.println(i + 1 + ". " + tmp[i].toString());
                }
                System.out.println("Total cost: $" + cart.totalCost());

            case 2:
                tmp = new DigitalVideoDisc[cart.getQtyOrdered()];
                System.arraycopy(cart.getItemsOrdered(), 0, tmp, 0, cart.getQtyOrdered());
                cart.sortByCostTitle(tmp);

                for (int i = 0; i < cart.getQtyOrdered(); i++) {
                    System.out.println(i + 1 + ". " + tmp[i].toString());
                }
                System.out.println("Total cost: $" + cart.totalCost());
        }
    }

    public static void addToCart() {
        System.out.println("Enter DVD title to add to cart: ");
        String title = scan.nextLine();
        DigitalVideoDisc result = store.searchDVD(title);

        // check title validity
        while (result == null) {
            System.out.println("Item not found. Please enter another title (case-insensitive)");
            title = scan.nextLine();
            result = store.searchDVD(title);
        }
        cart.addDigitalVideoDisc(result);
    }


    public static void removeFromCart() {
        System.out.println("Enter DVD title to remove from cart: ");
        String title = scan.nextLine();
        DigitalVideoDisc result = store.searchDVD(title);

        // check title validity
        while (result == null) {
            System.out.println("Item not found. Please enter another title (case-insensitive)");
            title = scan.nextLine();
            result = store.searchDVD(title);
        }
        cart.removeDigitalVideoDisc(result);
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
