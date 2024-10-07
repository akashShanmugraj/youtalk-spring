package org.example.youtalkmaven.LocalLists;
import java.util.ArrayList;


public class LocalList{
    private long id;
    protected ArrayList<Item> items;


    public LocalList(long id){
        this.id = id;
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

    public Long getId() {
        // TODO Auto-generated method stub
        return this.id;
    }

}

