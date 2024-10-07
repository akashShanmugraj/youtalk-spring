package org.example.youtalkmaven.Services;

import org.example.youtalkmaven.LocalLists.Item;
import org.example.youtalkmaven.LocalLists.StackList;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StackListService {
    private Map<Long, StackList> StackLists = new HashMap<>();
    private long currentId = 1L;

    public StackList createStackList() {
        StackList newStackList = new StackList(currentId++);
        StackLists.put(newStackList.getId(), newStackList);
        return newStackList;
    }

    public Optional<StackList> getStackList(Long id) {
        return Optional.ofNullable(StackLists.get(id));
    }

    public List<StackList> getAllStackLists() {
        return new ArrayList<>(StackLists.values());
    }

    public void deleteStackList(Long id) {
        StackLists.remove(id);
    }

    public void pushItem(Long StackListId, Item item) {
        StackList StackList = StackLists.get(StackListId);
        if (StackList != null) {
            StackList.push(item);
        }
    }

    public Optional<Item> popItem(Long StackListId) {
        StackList StackList = StackLists.get(StackListId);
        if (StackList != null && !StackList.getItems().isEmpty()) {
            return Optional.of(StackList.pop());
        }
        return Optional.empty();
    }
}
