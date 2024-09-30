package Syncrafoodcart;

public class User {
    public static int currentUserId = 4;
    private int id;
    private String name;
    private int mobileNo;
    private int pincode;
    private int password;
    
    public User() {}
    
    public User(int id, String name, int password, int mobileNo, int pincode) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.mobileNo = mobileNo;
        this.pincode = pincode;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getMobileNo() { return mobileNo; }
    public void setMobileNo(int mobileNo) { this.mobileNo = mobileNo; }

    public int getPassword() { return password; }
    public void setPassword(int password) { this.password = password; }

    public int getPincode() { return pincode; }
    public void setPincode(int pincode) { this.pincode = pincode; }
}

