package Syncrafoodcart;

import java.util.List;

public class Restaurant {
    private int resId;
    private String resName;
    private String ownerName;
    private int password;
    private int ownerNum;
    private String dish;
    private long dishPrice;
    private int availableQuantity;
    private long totalearnings=0;
    private List<Integer> servingPincodes;

    public Restaurant() {}

    public Restaurant(String resName, int resId, String ownerName, String dish, long dishPrice, int availableQuantity, int ownerNum, int password, List<Integer> servingPincodes)
    {
        this.resName = resName;
        this.resId = resId;
        this.ownerName = ownerName;
        this.dish = dish;
        this.dishPrice = dishPrice;
        this.availableQuantity = availableQuantity;
        this.ownerNum = ownerNum;
        this.password = password;
        this.servingPincodes = servingPincodes;
    }

    public int getResId() { return resId; }
    public void setResId(int resId) { this.resId = resId; }

    public String getResName() { return resName; }
    public void setResName(String resName) { this.resName = resName; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getDish() { return dish; }
    public void setDish(String dish) { this.dish = dish; }

    public long getDishPrice() { return dishPrice; }
    public void setDishPrice(long dishPrice) { this.dishPrice = dishPrice; }
    
    public long getearning() { return totalearnings; }

    public int getAvailableQuantity() { return availableQuantity; }
    public void setAvailableQuantity(int availableQuantity) { this.availableQuantity = availableQuantity; }

    public boolean servesPincode(int pincode) { return servingPincodes.contains(pincode); }

    public void placeOrder(int quantity) {
        if (availableQuantity >= quantity) {
            System.out.println("Order placed for " + this.getDish() + " from " + this.getResName());
            System.out.println("Total price: " + (quantity * this.getDishPrice()));
            this.availableQuantity -= quantity;
            totalearnings+=quantity*this.getDishPrice();
        } else {
            System.out.println("Insufficient quantity or invalid pincode.");
        }
    }

	public int getPassword() {
		
		return password;
	}

	public int getOwnerNum() {
		
		return ownerNum;
	}
}

