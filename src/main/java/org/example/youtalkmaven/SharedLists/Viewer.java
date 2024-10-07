package org.example.youtalkmaven.SharedLists;


public class Viewer implements Permissions{
    private String id;
    protected SharedList list;


    Viewer(String id, SharedList list,Account account) {
        this.id = id;
        this.list = list;
        list.AddUser(account);
    }

    SharedList getList() {
        return this.list;
    }
}
