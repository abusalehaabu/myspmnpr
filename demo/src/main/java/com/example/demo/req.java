package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "job")
public class req {

    @Id
    @Indexed
    private String id;
    private String sub;
    private String clgn;
    private String ppa;
    
    public req() {}

    // Constructor
    public req(String id,String sub, String clgn, String ppa) {
        this.id=id;
        this.sub = sub;
        this.clgn = clgn;
        this.ppa = ppa;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSub() {  // Fixed to camelCase
        return sub;
    }

    public void setSub(String sub) {  // Fixed to camelCase
        this.sub = sub;
    }

    public String getClgn() {  // Fixed to camelCase
        return clgn;
    }

    public void setClgn(String clgn) {  // Fixed to camelCase
        this.clgn = clgn;
    }

    public String getPpa() {  // Fixed to camelCase
        return ppa;
    }

    public void setPpa(String ppa) {  // Fixed to camelCase
        this.ppa = ppa;
    }

}
