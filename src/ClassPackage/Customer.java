package ClassPackage;

public class Customer {
    private int customerId;
    private User user;
    private String address;
    private String telephone;
    private String nic;
    private byte[] profile_picture;  // Changed from String to byte[]

    public Customer(int customerId, User user, String address, String telephone, String nic, byte[] profile_picture) {
        this.customerId = customerId;
        this.user = user;
        this.address = address;
        this.telephone = telephone;
        this.nic = nic;
        this.profile_picture = profile_picture;
    }

    public Customer(int customerId, String address, String telephone, String nic, byte[] profile_picture) {
        this.customerId = customerId;
        this.address = address;
        this.telephone = telephone;
        this.nic = nic;
        this.profile_picture = profile_picture;
    }

    public Customer() {}

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public byte[] getprofile_picture() { // Changed return type to byte[]
        return profile_picture;
    }

    public void setprofile_picture(byte[] profileImageBytes) { // Changed parameter type to byte[]
        this.profile_picture = profileImageBytes;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", user=" + user +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", nic='" + nic + '\'' +
                ", profile_picture=" + (profile_picture != null ? "Image Data Present" : "No Image") +
                '}';
    }
}
