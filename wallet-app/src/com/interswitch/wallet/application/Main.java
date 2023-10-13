package com.interswitch.wallet.application;

import com.interswitch.wallet.dto.Cart;
import com.interswitch.wallet.model.Customer;
import com.interswitch.wallet.model.Product;
import com.interswitch.wallet.service.WalletService;

import java.util.*;

public class Main {
    private static WalletService walletService = new WalletService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        homePageView();
    }

    private static void homePageView() throws Exception {
        // Introduction or home page
        try {
            HomePage homePage = new HomePage();
            System.out.println(homePage.title());
            System.out.println(homePage.instruction());

            boolean query = true;
            while (query) {
                System.out.println("1: Register new Customer \n" + "2: Add Product to Catalog \n" +
                        "3: Display all products \n" + "4: Restock products \n" +
                        "5: Fund your wallet \n" +
                        "6: Add Product to Cart (and Checkout) ");
                System.out.println("Please enter your option: ");
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        registerPage();
                        break;
                    case 2:
                        addProductsToStore();
                        break;
                    case 3:
                        displayAllProducts();
                        break;
                    case 4:
                        restockProducts();
                        break;
                    case 5:
                        fundYourWallet();
                        break;
                    case 6:
                        addToCart();
                        displayCart();
                        while (true) {
                            System.out.println("Select 1 to add more to cart or 2 to checkout.");
                            int select = scanner.nextInt();
                            if (select == 1) {
                                addToCart();
                            } else if (select == 2) {
                                checkOutCart();
                                break;
                            }
                        }
                        break;
                    default:
                        System.out.println("End of program");
                        break;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addProductsToStore() {
        // Product page
        ProductCatalogPage productCatalogPage = new ProductCatalogPage();
        System.out.println(productCatalogPage.title());

        // Adding products for the store
        boolean check = true;
        do {
            System.out.println("Please enter a product name");
            String productName = scanner.next();
            System.out.println("Please enter description for this product");
            String description = scanner.next();
            System.out.println("Please enter unit price for product");
            double unitPrice = scanner.nextDouble();
            System.out.println("Please enter quantity for the stock");
            int quantity = scanner.nextInt();
            Product product = new Product(productName, description, unitPrice, quantity);
            List<Product> products = new ArrayList<>();
            products.add(product);
            System.out.println("Product added successfully");
            walletService.populateProductCatalog(products);
            System.out.println("Do you still want to add a product? YES or NO");
            String reply = scanner.next();
            if (Objects.equals(reply, "NO")) {
                check = false;
            }
        } while (check);
    }

    private static void displayAllProducts() {
        ProductCatalogPage productCatalogPage = new ProductCatalogPage();
        System.out.println(productCatalogPage.title());

        // display all products before prompting for selection
        System.out.println(walletService.getProductCatalog());
        System.out.println(productCatalogPage.instruction());
        viewSingleProductByID();
    }

    private static void viewSingleProductByID() {
       // retrieve a particular product by id
        int retrieveId = scanner.nextInt();
        System.out.println(walletService.getProductById(retrieveId));
    }

    private static void registerPage() throws Exception {
        // Customer registration
        RegistrationPage registrationPage = new RegistrationPage();
        System.out.println(registrationPage.title());
        System.out.println(registrationPage.instruction());

        System.out.println("Kindly enter your username: ");
        String username = scanner.next();
        System.out.println("Kindly enter your phone number: ");
        String phoneNumber = scanner.next();
        System.out.println("Kindly enter your address: ");
        String address = scanner.next();

        String walletId = walletService.registerCustomer(username,phoneNumber,address);
        System.out.println("Customer created successfully");
        System.out.printf("Kindly note your wallet id: %s", walletId);
        System.out.println();

    }

    private static void viewCustomerDetails() {
        // Retrieve a customer by wallet ID
    System.out.println("Enter your wallet id to view your details");
        String walletId = scanner.nextLine();
    Customer customer = walletService.getCustomerByWallet(walletId);
        System.out.printf("Viola!!: %s", customer);

    }

    private static void fundYourWallet() throws Exception {
        // Fund customer wallet with a particular amount.
        System.out.println("Fund your wallet with a specified amount");
        System.out.println("Kindly enter your wallet id and particular amount");
        String walletID = scanner.next();
        double amount = scanner.nextDouble();
        walletService.fundCustomerWallet(walletID, amount);
    }

    private static void addToCart() {
        // Add product to cart
        System.out.println("Please enter the product id to add to cart");
        int productId = scanner.nextInt();
        System.out.println("Please enter the number of products to add");
        int productQty = scanner.nextInt();
        walletService.addProductToCart(productId, productQty);
    }

    private static void displayCart() {
        // Display products in cart
        System.out.println(walletService.getMyProductCart());
    }

    private static void restockProducts() {
        System.out.println("Please enter product id and quantity to restock: ");
        int productId = scanner.nextInt();
        int productQty = scanner.nextInt();
        walletService.restockProduct(productId, productQty);
        System.out.println("Restock successful");
    }

    private static void checkOutCart() throws Exception {
        System.out.println("Please enter your wallet id to checkout cart: ");
        String walletId = scanner.next();
        List<Cart> cartList = walletService.checkOutProduct(walletId);
        System.out.println(cartList);
    }
}
