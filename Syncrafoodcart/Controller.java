package Syncrafoodcart;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Controller {
    static ArrayList<User> userList = new ArrayList<>();
    static ArrayList<Restaurant> restaurantList = new ArrayList<>();
    static ArrayList<Order> orderList = new ArrayList<>();

    public static void main(String[] args) {
        populatedata();
        Scanner scn = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("Welcome to SYNCRA FOODCART!!!!");
            System.out.println("1) User login");
            System.out.println("2) Restaurant login");
            System.out.println("3) Register user");
            System.out.println("4) Exit");
            System.out.println("Enter your choice:");
            int choice = scn.nextInt();
            System.out.println("----------------------------------------");

            switch (choice) {
                case 1:
                    userLogin();
                    break;
                case 2:
                    restaurantLogin();
                    break;
                case 3:
                    registerUser();
                    break;
                case 4:
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid Input");
                    System.out.println("----------------------------------------");
            }
        }
    }

    private static void populatedata() {
        // Sample Users
        userList.add(new User(1, "aaa", 101, 101, 111));
        userList.add(new User(2, "bbb", 102, 102, 222));
        userList.add(new User(3, "ccc", 103, 103, 333));
        userList.add(new User(4, "ddd", 104, 104, 444));

        // Sample Restaurants
        restaurantList.add(new Restaurant("aar", 1, "Tharik", "Briyani", 300, 200, 1100, 1100, Arrays.asList(111, 222)));
        restaurantList.add(new Restaurant("bbr", 2, "Mijo", "Dosa", 50, 100, 2200, 2200, Arrays.asList(333, 444)));
        restaurantList.add(new Restaurant("ccr", 3, "Varun", "Idly", 30, 300, 3300, 3300, Arrays.asList(111, 333)));
        restaurantList.add(new Restaurant("ddr", 4, "Sravana", "Naan", 150, 20, 4400, 4400, Arrays.asList(222, 444, 111)));
    }

    private static void userLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter mobile number: ");
        int mobileNo = sc.nextInt();
        System.out.println("Enter password: ");
        int password = sc.nextInt();
        System.out.println("----------------------------------------");

        User currentUser = null;
        for (User user : userList) {
            if (user.getMobileNo() == mobileNo && user.getPassword() == password) {
                currentUser = user;
                break;
            }
        }

        if (currentUser == null) {
            System.out.println("Invalid mobile number or password.");
            return;
        }

        System.out.println("Welcome, " + currentUser.getName());
        System.out.println("Restaurants serving your area:");
        for (Restaurant restaurant : restaurantList) {
            if (restaurant.servesPincode(currentUser.getPincode())) {
                System.out.println("Restaurant ID: " + restaurant.getResId());
                System.out.println("Restaurant Name: " + restaurant.getResName());
                System.out.println("Dish: " + restaurant.getDish());
                System.out.println("Price: $" + restaurant.getDishPrice());
                System.out.println("Available Quantity: " + restaurant.getAvailableQuantity());
            }
        }

        System.out.println("Select restaurant by ID:");
        int restaurantId = sc.nextInt();
        System.out.println("Enter quantity:");
        int quantity = sc.nextInt();

        for (Restaurant restaurant : restaurantList) {
            if (restaurant.getResId() == restaurantId) {
                restaurant.placeOrder(quantity);
                Order neworder=new Order(++Order.currentOrderID, restaurant.getResName(), restaurantId, currentUser.getId(), currentUser.getMobileNo(), restaurant.getDish(), quantity * restaurant.getDishPrice());
                orderList.add(neworder);
                System.out.println("Please rate your meal (1 to 5):");
                int rating = sc.nextInt();
                while (rating < 1 || rating > 5) {
                    System.out.println("Invalid rating. Please enter a rating from 1 to 5:");
                    rating = sc.nextInt();
                }
                neworder.setRating(rating);
                System.out.println("Thank you for your feedback!");

            
            }
        }
    }

    private static void restaurantLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter mobile number: ");
        int mobileNo = sc.nextInt();
        System.out.println("Enter password: ");
        int password = sc.nextInt();
        System.out.println("----------------------------------------");

        for (Restaurant res : restaurantList) {
            if (res.getOwnerNum() == mobileNo && res.getPassword() == password) {
                System.out.println("Welcome, " + res.getOwnerName());
                System.out.println("Dish: " + res.getDish());
                System.out.println("Price: $" + res.getDishPrice());
                System.out.println("Available Quantity: " + res.getAvailableQuantity());
                System.out.println("Earnings:"+res.getearning());
                System.out.println("----------------------------------------");
                System.out.println("Do you want to update the available quantity? (yes/no)");
                String updateChoice = sc.next();
                if (updateChoice.equalsIgnoreCase("yes")) 
                {
                    System.out.println("Enter new available quantity:");
                    int newQuantity = sc.nextInt();
                    res.setAvailableQuantity(newQuantity);
                    System.out.println("Available quantity updated to " + newQuantity);
                }
            }
        }

        System.out.println("Invalid credentials.");
    }

    private static void registerUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = sc.next();
        System.out.println("Enter mobile number:");
        int mobileNo = sc.nextInt();
        System.out.println("Enter password:");
        int password = sc.nextInt();
        System.out.println("Enter pincode:");
        int pincode = sc.nextInt();

        User newUser = new User(++User.currentUserId, name, password, mobileNo, pincode);
        userList.add(newUser);
        System.out.println("User registered successfully!");
        System.out.println("----------------------------------------");
    }
}
