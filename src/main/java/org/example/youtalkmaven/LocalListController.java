package org.example.youtalkmaven;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class LocalListController {

    @RequestMapping("/create/stack/{userId}")
    public String createStack(@PathVariable String userId) {
        String listId = "list_" + userId; // Example logic
        return listId;
    }
}

