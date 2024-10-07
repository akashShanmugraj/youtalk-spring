package org.example.youtalkmaven.SharedLists;

public class Account {

    
    private long id;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String username;
    private String password;

    public Account(long id,String username,String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
