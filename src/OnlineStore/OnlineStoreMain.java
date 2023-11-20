package OnlineStore;

import OnlineStore.exception.OutOfStockException;
import OnlineStore.model.Product;
import OnlineStore.model.User;
import OnlineStore.storages.UserStorage;

import java.util.Scanner;

public class OnlineStoreMain {
    private static final Scanner scanner = new Scanner(System.in);
    private static UserStorage userStorage = new UserStorage();
    private static OnlineStore.ProductStorage productStorage = new OnlineStore.ProductStorage();
    private static OnlineStore.OrderStorage orderStorage = new OnlineStore.OrderStorage();

    private static User loggedInUser;

    public static void main(String[] args) {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Choose an option:");
            System.out.println("0 - Login");
            System.out.println("1 - Register");
            System.out.println("2 - Exit");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 0:
                    login();
                    break;
                case 1:
                    register();
                    break;
                case 2:
                    isExit = true;
                    break;
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

        User user = userStorage.getUser(email);
        if (user != null && user.getPassword().equals(password)) {
            loggedInUser = user;
            if (user.getType() == User.UserType.ADMIN) {
                showAdminMenu();
            } else if (user.getType() == User.UserType.USER) {
                showUserMenu();
            }
            return;
        }
        System.out.println("Invalid Email or Password.");
    }

    private static void register() {
        System.out.println("Enter id:");
        int id = Integer.parseInt(scanner.nextLine());

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
        userStorage.addUser(newUser);

        System.out.println("Registration successful!");
        showUserMenu();
    }

    private static void showAdminMenu() {
        System.out.println("Admin Menu:");
        System.out.println("0 - Logout");
        System.out.println("1 - Add product");
        System.out.println("2 - Print all products");
        System.out.println("3 - Print all users");
        System.out.println("4 - Print all orders");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 0:
                logout();
                return;
            case 1:
                addProduct();
                break;
            case 2:
                productStorage.printProducts();
                break;
            case 3:
                userStorage.printUsers();
                break;
            case 4:
                orderStorage.printAllOrders();
                break;
            default:
                System.out.println("Invalid Choice.");
        }
    }

    private static void addProduct() {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Description: ");
        String description = scanner.nextLine();

        System.out.print("Enter Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter Stock Quantity: ");
        int stockQty = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Product Type (ELECTRONICS, CLOTHING, BOOKS): ");
        Product.ProductType type = Product.ProductType.valueOf(scanner.nextLine().toUpperCase());

        Product product = new Product(id, name, description, price, stockQty, type);

        productStorage.addProduct(product);
        System.out.println("Product Added Successfully!");
    }


    private static void showUserMenu() {
        while (true) {
            System.out.println("User Menu:");
            System.out.println("0 - Logout");
            System.out.println("1 - View all products");
            System.out.println("2 - Buy a product");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 0:
                    logout();
                    return;
                case 1:
                    productStorage.printProducts();
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


}
