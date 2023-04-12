package myClass;

import javax.swing.Icon;

public class Owner {
    private int ownerId;
    private String name;
    private int age;
    private String gender;
    private int sumBoardingHouse;
    private Icon photo;
    
    public Owner(int ownerId, String name, int age, String gender, int sumBoardingHouse, Icon photo){
        this.ownerId = ownerId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.sumBoardingHouse = sumBoardingHouse;
        this.photo = photo;
    }
    
    public Owner(){
        
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSumBoardingHouse() {
        return sumBoardingHouse;
    }

    public void setSumBoardingHouse(int sumBoardingHouse) {
        this.sumBoardingHouse = sumBoardingHouse;
    }

    public Icon getPhoto() {
        return photo;
    }

    public void setPhoto(Icon photo) {
        this.photo = photo;
    }
}