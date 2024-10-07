package org.example.youtalkmaven;
import java.util.ArrayList;


public class User{
    private String id;
    private Account Account;
    private ArrayList<LocalList> Lists;

    User(String id){
        this.id = id;
        this.Account = new Account(id,"","");
        this.Lists = new ArrayList<LocalList>();
    }

    public void addList(LocalList list){
        this.Lists.add(list);
    }

    public void removeList(LocalList list){
        this.Lists.remove(list);
    }
}


