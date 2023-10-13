package com.interswitch.wallet.application;

import com.interswitch.wallet.model.Customer;
import com.interswitch.wallet.model.Product;
import com.interswitch.wallet.service.WalletService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sample {
    static WalletService serv = new WalletService();
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
// System.out.println(getCustomerByWalletID());


        try {
            System.out.println("============================WELCOME!============================");
            System.out.println("Are you a registered user?");
            System.out.println("Please see below our catalog: ");
            System.out.println(serv.getProductCatalog());
            System.out.println();

            boolean cond = true;

            while (cond) {
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("1: Register new Customer || 2: Add Product to Catalog || 3: Restock a Product || 4: Add Product to Cart (and Checkout) || 5: Fund A Customer ");
                System.out.println("Choose out of the options above: ");
                int selection = scn.nextInt();

                switch (selection) {
                    case 1:
                        createCustomer();
                        break;

                    case 2:
                        createProduct();
                        break;

                    case 3:
                        restockProduct();
                        break;

                    case 4:
                        boolean cond2 = true;

                        addToCart();
                        while (cond2) {
                            System.out.println("Do you want to add more Items to cart? (Press 1 for yes, 2 to checkout): ");
                            int s = scn.nextInt();
                            if (s == 1) {
                                System.out.println(cond2);
                                addToCart();
                            } else if (s == 2) {
                                checkout();
                                cond2 = false;
                                System.out.println(cond2);
                                break;
                            }
                        }
                        break;

                    case 5:
                        fundCustomer();
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static Scanner createScannerObj() {
        return new Scanner(System.in);
    }

    public static void getProductCatalog() {
        serv.getProductCatalog();
    }

    public static void createCustomer() {
        try {
            System.out.println("Welcome!");

            System.out.println("Please enter your name: ");
            String name = scn.nextLine();

            System.out.println("Please enter your phone number: ");
            String phoneNumber = scn.nextLine();

            System.out.println("Welcome! Please enter your address: ");
            String address = scn.nextLine();

            System.out.println("Please note your WALLET ID!");

            System.out.println(serv.registerCustomer(name, phoneNumber, address));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static Customer getCustomerByWalletID() {
        Customer c = null;
        try {
            System.out.println("Welcome!");

            System.out.println("Please enter your wallet ID: ");
            String walletID = scn.nextLine();

            c = serv.getCustomerByWallet(walletID);
            System.out.println(c.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public static void createProduct() {

        try {
            for (int a = 1; a <= 5; a++) {
                Scanner scn = createScannerObj();

                System.out.println("Please enter product name: ");
                String prodName = scn.nextLine();

                System.out.println("Please enter product description: ");
                String prodDesc = scn.nextLine();

                System.out.println("Please enter product unit price: ");
                Double prodPrice = scn.nextDouble();

                System.out.println("Please enter product quantity in stick: ");
                Integer prodQuantity = scn.nextInt();


                List<Product> listProd = new ArrayList<>();
                Product newProduct = new Product(prodName, prodDesc, prodPrice, prodQuantity);

                listProd.add(newProduct);

                serv.populateProductCatalog(listProd);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    public static void fundCustomer() {
//// // Fund a customer wallet
        try {
            System.out.println("Please enter your walletID: ");
            String walletID = scn.nextLine();

            System.out.println("Please enter amount to fund: ");
            Double amount = scn.nextDouble();

            serv.fundCustomerWallet(walletID, amount);

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void addToCart() {

        try {
            System.out.println("Please enter product ID: ");
            Integer prodID = scn.nextInt();


            System.out.println("Please enter quantity: ");
            Integer quantity = scn.nextInt();

            serv.addProductToCart(prodID, quantity);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void restockProduct() {
        System.out.println("Please enter product ID to restock: ");
        Integer productID = scn.nextInt();

        System.out.println("Please enter quantity: ");
        Integer quantity = scn.nextInt();

        serv.restockProduct(productID, quantity);
    }

    public static void checkout() throws Exception {
        Scanner scn = new Scanner(System.in);
        try {
            System.out.println("Please enter wallet ID to checkout: ");
            String walletID = scn.nextLine();

            serv.checkOutProduct(walletID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
