package org.example.youtalkmaven.LocalLists;

import java.util.List;

public class StackList extends LocalList {

    public StackList(long id) {
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
  
    public List<Item> getItems() {
        return this.items;
    }
}
