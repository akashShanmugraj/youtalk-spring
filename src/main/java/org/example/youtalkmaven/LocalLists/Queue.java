package org.example.youtalkmaven.LocalLists;

public class Queue extends LocalList {

    Queue(String id) {
        super(id);
        //TODO Auto-generated constructor stub
    }
 
    
    public void enqueue(Item item) {
        this.addItem(item);
    }

    public Item dequeue() {
        Item item = this.items.get(0);
        this.items.remove(0);
        return item;
    }
}
