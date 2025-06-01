package com.example.demo;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "appl")
public class appli {
    @Indexed
    private String i;
    private String name;
    private String email;
    private String quali;

    public appli() {}

    public appli(String i, String name, String email, String quali) {
        this.i = i;
        this.name = name;
        this.email = email;
        this.quali = quali;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

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

    public String getQuali() {
        return quali;
    }

    public void setQuali(String quali) {
        this.quali = quali;
    }
}
