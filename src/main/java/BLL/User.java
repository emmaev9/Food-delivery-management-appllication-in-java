package BLL;

import java.io.Serializable;
import java.time.Period;
import java.util.ArrayList;

public class User implements Serializable {
    public String firstName;
    public String lastName;
    public String userName;
    public String email;
    public String password;
    public String phoneNumber;
    public String role;

    public User(String firstName, String lastName, String userName, String email, String password, String phoneNumber, String role){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.phoneNumber = phoneNumber;
    }
    public User(){}

}
