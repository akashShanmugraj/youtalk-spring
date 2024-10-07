package org.example.youtalkmaven.Controllers;


import org.example.youtalkmaven.DTOs.ItemRequest;
import org.example.youtalkmaven.LocalLists.Item;
import org.example.youtalkmaven.LocalLists.StackList;
import org.example.youtalkmaven.Services.StackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stacks")
public class StackController {

    @Autowired
    private StackListService stackService;

    @PostMapping("/create")
    public ResponseEntity<StackList> createStack() {
        StackList stack = stackService.createStackList();
        return ResponseEntity.ok(stack);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StackList> getStack(@PathVariable Long id) {
        return stackService.getStackList(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStack(@PathVariable Long id) {
        stackService.deleteStackList(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{stackId}/push")
    public ResponseEntity<StackList> pushItem(@PathVariable Long stackId, @RequestBody ItemRequest itemRequest) {
        Item item = new Item(System.currentTimeMillis(), itemRequest.getText());
        stackService.pushItem(stackId, item);
        return stackService.getStackList(stackId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{stackId}/pop")
    public ResponseEntity<Item> popItem(@PathVariable Long stackId) {
        return stackService.popItem(stackId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<StackList>> getAllStacks() {
        return ResponseEntity.ok(stackService.getAllStackLists());
    }
}

