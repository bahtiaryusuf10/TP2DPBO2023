package myClass;

import javax.swing.Icon;

public class BoardingHouse {
    private int boardingHouseId;
    private String name;
    private String address;
    private int price;
    private String facility;
    private Icon photo;
    private Owner owner;
    
    public BoardingHouse(int boardingHouseId, Owner owner, String name, String address, int price, String facility, Icon photo){
        this.boardingHouseId = boardingHouseId;
        this.owner = owner;
        this.name = name;
        this.address = address;
        this.price = price;
        this.facility = facility;
        this.photo = photo;
    }
    
    public BoardingHouse(){
        
    }
    
    public int getBoardingHouseId() {
        return boardingHouseId;
    }

    public void setBoardingHouseId(int boardingHouseId) {
        this.boardingHouseId = boardingHouseId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public Icon getPhoto() {
        return photo;
    }

    public void setPhoto(Icon photo) {
        this.photo = photo;
    }
    
    public Owner getOwner() {
        return owner;
    }
    
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}