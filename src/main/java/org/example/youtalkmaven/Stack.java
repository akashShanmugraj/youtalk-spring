package org.example.youtalkmaven;

public class Stack extends LocalList {

    Stack(String id) {
        super(id);
        //TODO Auto-generated constructor stub
    }
    
    public void push(Item item) {
        this.addItem(item);
    }

    public Item pop() {
        Item item = this.items.get(this.items.size()-1);
        this.items.remove(this.items.size()-1);
        return item;
    }

    
}
