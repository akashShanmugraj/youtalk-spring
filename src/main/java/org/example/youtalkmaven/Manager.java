package org.example.youtalkmaven;

public class Manager extends Collaborator{

    Manager(String id,SharedList list, Account account) {
        super(id,account,list);
        this.list.ChangePermissions(account, Manager.this);
    }

    void ChangePermissions(Account account, Permissions permissions) {
        this.list.ChangePermissions(account, permissions);
    }

    void AddUser(Account account) {
        this.list.AddUser(account);
    }

    void RemoveUser(Account account) {
        this.list.RemoveUser(account);
    }
}
