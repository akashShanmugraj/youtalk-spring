package org.example.youtalkmaven.DTOs;


public class PermissionsRequest {
    private String type; // Example: "Viewer", "Collaborator", "Manager"

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

