package com.example.demo.dto;

public class UserProfileResponse {
    private String status;
    private int processedId;
    private String displayName;
    private boolean accountStatus;

    public UserProfileResponse() {
    }

    public UserProfileResponse(String status, int processedId, String displayName, boolean accountStatus) {
        this.status = status;
        this.processedId = processedId;
        this.displayName = displayName;
        this.accountStatus = accountStatus;
    }

    public String getStatus() {
        return status;
    }

    public int getProcessedId() {
        return processedId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isAccountStatus() {
        return accountStatus;
    }
}