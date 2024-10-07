package org.example.youtalkmaven;
import java.util.ArrayList;


public class LocalList{
    private String id;
    protected ArrayList<Item> items;


    LocalList(String id){
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

