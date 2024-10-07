package org.example.youtalkmaven.SharedLists;


public class Viewer implements Permissions{
    private long id;
    protected SharedList list;


    public Viewer(long id, SharedList list,Account account) {
        this.id = id;
        this.list = list;
        list.AddUser(account);
    }

    SharedList getList() {
        return this.list;
    }
}
