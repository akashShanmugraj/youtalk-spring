package org.example.youtalkmaven.Controllers;

import org.example.youtalkmaven.DTOs.ItemRequest;
import org.example.youtalkmaven.DTOs.PermissionsRequest;
import org.example.youtalkmaven.LocalLists.Item;
import org.example.youtalkmaven.Services.AccountService;
import org.example.youtalkmaven.Services.SharedListService;
import org.example.youtalkmaven.SharedLists.SharedList;
import org.example.youtalkmaven.SharedLists.Permissions;
import org.example.youtalkmaven.SharedLists.Viewer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/shared-lists")
public class SharedListController {

    @Autowired
    private SharedListService sharedListService;
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<SharedList> createSharedList(@RequestParam Long accountId) {
        SharedList sharedList = sharedListService.createSharedList(accountId);
        return ResponseEntity.ok(sharedList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SharedList> getSharedList(@PathVariable Long id) {
        return sharedListService.getSharedList(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{listId}/add-item")
    public ResponseEntity<SharedList> addItem(@PathVariable Long listId, @RequestBody ItemRequest itemRequest) {
        Item item = new Item(System.currentTimeMillis(), itemRequest.getText());
        sharedListService.addItemToSharedList(listId, item);
        return sharedListService.getSharedList(listId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{listId}/remove-item")
    public ResponseEntity<SharedList> removeItem(@PathVariable Long listId, @RequestBody ItemRequest itemRequest) {
        Item item = new Item(System.currentTimeMillis(), itemRequest.getText());
        sharedListService.removeItemFromSharedList(listId, item);
        return sharedListService.getSharedList(listId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{listId}/add-user")
    public ResponseEntity<Void> addUser(@PathVariable Long listId, @RequestParam Long accountId) {
        sharedListService.addUserToSharedList(listId, accountId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{listId}/change-permissions")
    public ResponseEntity<Void> changePermissions(@PathVariable Long listId, @RequestParam Long accountId, @RequestBody PermissionsRequest permissionsRequest) {
        
        Permissions permissions = new Viewer(listId, sharedListService.getSharedList(listId).orElseThrow(), accountService.getAccount(accountId).orElseThrow());
        sharedListService.changePermissions(listId, accountId, permissions);
        return ResponseEntity.ok().build();
    }
}

