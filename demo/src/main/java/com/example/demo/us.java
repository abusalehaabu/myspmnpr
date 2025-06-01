package com.example.demo;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "us")
public class us {

    @Id
    @Indexed
    private String id;
    @UniqueElements
    private String username;
    private String password;
    public us(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Sett
    public String getid() {
        return id;
    }
    public void setid(String id) {
        this.id=id;
    }
    
    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}