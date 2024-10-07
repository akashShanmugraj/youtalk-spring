package org.example.youtalkmaven.LocalLists;

public class Routine extends LocalList {

    Routine(String id) {
        super(id);
        //TODO Auto-generated constructor stub
    }
    
    public void addRoutine(Item item) {
        this.addItem(item);
    }

    public Item removeRoutine() {
        Item item = this.items.get(this.items.size()-1);
        this.items.remove(this.items.size()-1);
        addRoutine(item);
        return item;
    }
}
