package org.example.youtalkmaven.LocalLists;
import java.util.ArrayList;

import org.example.youtalkmaven.SharedLists.Account;


public class User{
    private long id;
    private Account Account;
    private ArrayList<LocalList> Lists;

    User(long id){
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


