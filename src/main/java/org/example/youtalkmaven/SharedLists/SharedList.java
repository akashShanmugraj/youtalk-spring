package org.example.youtalkmaven.SharedLists;

import java.util.Map;

import org.example.youtalkmaven.LocalLists.Item;
import org.example.youtalkmaven.LocalLists.LocalList;

public class SharedList {
    
    private String id;
    private LocalList list;
    private Map<Account, Permissions> permissions;
    private Account owner;

    SharedList(String id, Account owner) {
        this.id = id;
        this.owner = owner;
        this.list = new LocalList(id);
    }

    void AddUser(Account account) {
        this.permissions.put(account, new Viewer(this.id,SharedList.this, account));
    }

    void RemoveUser(Account account) {
        this.permissions.remove(account);
    }

    void ChangePermissions(Account account, Permissions permissions) {
        this.permissions.put(account, permissions);
    }

    void addItem(Item item) {
        this.list.addItem(item);
    }

    void removeItem(Item item) {
        this.list.removeItem(item);
    }

}
