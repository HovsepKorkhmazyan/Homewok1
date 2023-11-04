package OnlineStore;

import OnlineStore.exception.OutOfStockException;
import OnlineStore.model.User;
import OnlineStore.storage.ProductStorage;
import OnlineStore.storage.UserStorage;

import java.util.Scanner;

import static OnlineStore.storage.UserStorage.users;

public class OnlineStoreMain {
    private static Scanner scanner = new Scanner(System.in);
    static UserStorage user = new UserStorage();
    static ProductStorage products = new ProductStorage();

    private static User loggedInUser;

    public static void main(String[] args) {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Choose an option:");
            System.out.println("0 - Login");
            System.out.println("1 - Register");
            System.out.println("2 - Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    login();
                    break;
                case 1:
                    register();
                    break;
                case 2:
                    isExit = true;
                default:
                    System.out.println("Invalid Option");
            }
        }

    }

    private static void login() {
        System.out.println("Please Enter Your Email");
        String email = scanner.nextLine();
        System.out.println("Please Enter Your Password");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                loggedInUser = user;
                if (user.getType() == User.UserType.ADMIN) {
                    showAdminMenu();
                } else {
                    showUserMenu();
                }
                return;
            }
        }
        System.out.println("Invalid Email or Password.");
    }

    private static void register() {
        System.out.println("Enter id:");
        int id = scanner.nextInt();


        System.out.println("Enter name:");
        String name = scanner.nextLine();

        System.out.println("Enter email:");
        String email = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        System.out.println("Enter type (USER or ADMIN):");
        User.UserType type;
        try {
            type = User.UserType.valueOf(scanner.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid user type. Registration failed.");
            return;
        }

        User newUser = new User(id, name, email, password, type);
        user.add(newUser);

        System.out.println("Registration successful!");
        showUserMenu();
    }

    private static void showAdminMenu() {
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("0 - logout");
            System.out.println("1 - add product");

            int choice = scanner.nextInt();


            switch (choice) {
                case 0:
                    logout();
                    return;
                case 1:
                    addProduct();
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void showUserMenu() {
        while (true) {
            System.out.println("User Menu:");
            System.out.println("0 - logout");
            System.out.println("1 - print all products");

            int choice = scanner.nextInt();


            switch (choice) {
                case 0:
                    logout();
                    return;
                case 1:
                    printProducts();
                    break;
                case 2:
                    try {
                        buyProduct();
                    } catch (OutOfStockException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void logout() {
        loggedInUser = null;
        System.out.println("Logged out successfully!");
    }

    private static void addProduct() {

    }

    private static void printProducts() {

    }

    private static void buyProduct() throws OutOfStockException {
        System.out.println("Enter product id:");
        int productId = scanner.nextInt();
    }
}


