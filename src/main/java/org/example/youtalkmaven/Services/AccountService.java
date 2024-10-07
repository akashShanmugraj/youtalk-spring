package org.example.youtalkmaven.Services;


import org.example.youtalkmaven.SharedLists.Account;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AccountService {
    private Map<Long, Account> accounts = new HashMap<>();
    private long currentId = 1L;

    public Account createAccount(String username, String password) {
        Account account = new Account(currentId++, username, password);
        accounts.put(account.getId(), account);
        return account;
    }

    public Optional<Account> getAccount(Long id) {
        return Optional.ofNullable(accounts.get(id));
    }

    public List<Account> getAllAccounts() {
        return new ArrayList<>(accounts.values());
    }
}
