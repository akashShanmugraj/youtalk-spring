package org.example.youtalkmaven.Services;

import org.example.youtalkmaven.LocalLists.LocalList;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LocalListService {
    // Map to store LocalLists, where the key is the list's ID
    private Map<Long, LocalList> localLists = new HashMap<>();
    private long currentId = 1L;

    public LocalList createLocalList() {
        LocalList newList = new LocalList(currentId++);
        localLists.put(newList.getId(), newList);
        return newList;
    }

    public Optional<LocalList> getLocalList(Long id) {
        return Optional.ofNullable(localLists.get(id));
    }

    public List<LocalList> getAllLists() {
        return new ArrayList<>(localLists.values());
    }

    public void deleteLocalList(Long id) {
        localLists.remove(id);
    }

}

