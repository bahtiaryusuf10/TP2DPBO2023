package myClass;

import javax.swing.Icon;

public class User {
    private int userId;
    private String name;
    private String username;
    private String password;
    private String gender;
     private Icon photo;
    
    public User(int userId, String name, String username, String password, String gender, Icon photo){
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.photo = photo;
    }
    
    public User(){
        
    }
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public Icon getPhoto() {
        return photo;
    }

    public void setPhoto(Icon photo) {
        this.photo = photo;
    }
}