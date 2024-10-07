package org.example.youtalkmaven.SharedLists;

import org.example.youtalkmaven.LocalLists.Item;

public class Collaborator extends Viewer {
    private String id;

    Collaborator(String id, Account account,SharedList list) {
        super(id,list, account);
        this.list.ChangePermissions(account, Collaborator.this);
    }

    SharedList addItem(Item item) {
        this.list.addItem(item);
        return this.list;
    }

    SharedList removeItem(Item item) {
        this.list.removeItem(item);
        return this.list;
    }
}
