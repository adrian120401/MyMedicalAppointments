package model;

public abstract class User {
    static int id=0;//autoincrement
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public User(String name, String email) {
        this.name=name;
        this.email=email;
        id++;
    }


    @Override
    public String toString(){
        return "Name:"+ name + " Email:"+email+" ID:"+id;
    }

    //Get y Set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        User.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public abstract void showDataUser();



}
