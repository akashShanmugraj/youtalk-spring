package org.example.youtalkmaven.LocalLists;

public class Item {
    private Long id;
    private String text;

    public Item(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
