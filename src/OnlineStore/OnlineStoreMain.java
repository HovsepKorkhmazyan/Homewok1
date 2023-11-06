package OnlineStore;

import OnlineStore.exception.OutOfStockException;
import OnlineStore.model.Order;
import OnlineStore.model.Product;
import OnlineStore.model.User;
import OnlineStore.storage.OrderStorage;
import OnlineStore.storage.ProductStorage;
import OnlineStore.storage.UserStorage;

import java.util.Scanner;

import static OnlineStore.storage.UserStorage.users;

public class OnlineStoreMain {
    private static Scanner scanner = new Scanner(System.in);
    static UserStorage user = new UserStorage();
    static ProductStorage products = new ProductStorage();
    static OrderStorage orders = new OrderStorage();

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
        user.add(newUser);

        System.out.println("Registration successful!");
        showUserMenu();
    }

    private static void showAdminMenu() {
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("0 - logout");
            System.out.println("1 - add product");
            System.out.println("2 - print all products");
            System.out.println("3 - print all users");
            System.out.println("4 - print all orders");

            int choice = scanner.nextInt();


            switch (choice) {
                case 0:
                    logout();
                    return;
                case 1:
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
                    Product.ProductType type = Product.ProductType.valueOf(scanner.nextLine());

                    Product product = new Product(id, name, description, price, stockQty, type);

                    products.addProduct(product);
                    System.out.println("The Product has been added!");
                    break;
                case 2:
                    products.printProducts();
                    break;
                case 3:
                    user.printUSers();
                case 4:
                    orders.printAllOrders();

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
                    products.printProducts();
                    break;
                case 3:
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


    private static void printProducts() {

    }

    private static void buyProduct() throws OutOfStockException {
        System.out.println("Enter product id:");
        int productId = scanner.nextInt();
    }

}


