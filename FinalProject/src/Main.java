import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AuthenticationService authService = new AuthenticationService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1, 2, or 3): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline

            if (choice == 3) {
                System.out.println("Exiting the application...");
                break;
            }

            switch (choice) {
                case 1: // Login
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();

                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();

                    if (authService.login(loginUsername, loginPassword)) {
                        System.out.println(loginUsername + " logged In");
                        // Call to display products or other post-login actions
                        ProductService productService=new ProductService();
                        List<Product> products= productService.getAllProducts();
                        products.forEach(System.out::println);
                    } else {
                        System.out.println("Invalid credentials.");
                    }
                    break;

                case 2: // Register
                    System.out.print("Enter username: ");
                    String registerUsername = scanner.nextLine();

                    System.out.print("Enter password: ");
                    String registerPassword = scanner.nextLine();

                    if (!authService.register(registerUsername, registerPassword)) {
                        System.out.println("User already exists, please Login");
                    } else {
                        System.out.println("Registration successful. Please log in.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1 for Login, 2 for Register, or 3 to Exit.");
            }
        }
    }
}

