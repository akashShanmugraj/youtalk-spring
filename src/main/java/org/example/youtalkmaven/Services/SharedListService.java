package org.example.youtalkmaven.Services;


import org.example.youtalkmaven.LocalLists.Item;
import org.example.youtalkmaven.SharedLists.Account;
import org.example.youtalkmaven.SharedLists.SharedList;
import org.springframework.stereotype.Service;

import org.example.youtalkmaven.SharedLists.Permissions;
import java.util.*;

@Service
public class SharedListService {
    private Map<Long, SharedList> sharedLists = new HashMap<>();
    private long currentId = 1L;

    public SharedList createSharedList(Long accountId) {
        Account owner = getAccountById(accountId);
        SharedList sharedList = new SharedList(currentId++, owner);
        sharedLists.put(sharedList.getId(), sharedList);
        return sharedList;
    }

    public Optional<SharedList> getSharedList(Long id) {
        return Optional.ofNullable(sharedLists.get(id));
    }

    public void addItemToSharedList(Long listId, Item item) {
        SharedList sharedList = sharedLists.get(listId);
        if (sharedList != null) {
            sharedList.addItem(item);
        }
    }

    public void removeItemFromSharedList(Long listId, Item item) {
        SharedList sharedList = sharedLists.get(listId);
        if (sharedList != null) {
            sharedList.removeItem(item);
        }
    }

    public void addUserToSharedList(Long listId, Long accountId) {
        SharedList sharedList = sharedLists.get(listId);
        Account account = getAccountById(accountId);
        if (sharedList != null && account != null) {
            sharedList.AddUser(account);
        }
    }

    public void changePermissions(Long listId, Long accountId, Permissions permissions) {
        SharedList sharedList = sharedLists.get(listId);
        Account account = getAccountById(accountId);
        if (sharedList != null && account != null) {
            sharedList.ChangePermissions(account, permissions);
        }
    }

    private Account getAccountById(Long accountId) {
        // Simulate fetching from account service
        return new AccountService().getAccount(accountId).orElse(null);
    }
}

