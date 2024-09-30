package Syncrafoodcart;

public class Order {
    private int id;
    private String restaurantName;
    private int restaurantId;
    private int userId;
    private int userMobile;
    private String dish;
    private long price;
    private int rating=0;
    
    public static int currentOrderID = 0;

    public Order() {}

    public Order(int id, String restaurantName, int restaurantId, int userId, int userMobile, String dish, long price) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.restaurantId = restaurantId;
        this.userId = userId;
        this.userMobile = userMobile;
        this.dish = dish;
        this.price = price;
    }

    public int getId() { return id; }
    public String getRestaurantName() { return restaurantName; }
    public int getRestaurantId() { return restaurantId; }
    public int getUserId() { return userId; }
    public int getUserMobile() { return userMobile; }
    public String getDish() { return dish; }
    public long getPrice() { return price; }
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}


