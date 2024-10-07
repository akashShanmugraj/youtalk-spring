package org.example.youtalkmaven.LocalLists;
import java.util.ArrayList;


public class LocalList{
    private String id;
    protected ArrayList<Item> items;


    public LocalList(String id){
        this.id = id;
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

}

