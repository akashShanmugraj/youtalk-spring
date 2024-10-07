package org.example.youtalkmaven.SharedLists;

import java.util.Map;

import org.example.youtalkmaven.LocalLists.Item;
import org.example.youtalkmaven.LocalLists.LocalList;

public class SharedList {
    
    private long id;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private LocalList list;
    private Map<Account, Permissions> permissions;
    private Account owner;

    public SharedList(long id, Account owner) {
        this.id = id;
        this.owner = owner;
        this.list = new LocalList(id);
    }

    public void AddUser(Account account) {
        this.permissions.put(account, new Viewer(this.id,SharedList.this, account));
    }

    void RemoveUser(Account account) {
        this.permissions.remove(account);
    }

    public void ChangePermissions(Account account, Permissions permissions2) {
        this.permissions.put(account, permissions2);
    }

    public void addItem(Item item) {
        this.list.addItem(item);
    }

    public void removeItem(Item item) {
        this.list.removeItem(item);
    }



}
