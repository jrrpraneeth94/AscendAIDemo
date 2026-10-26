package com.example.demo.dto;

public class UserProfileRequest {
    // Primitive types (FAIL_ON_NULL_FOR_PRIMITIVES defaults to true in Jackson 3.0)
    private int id;
    private boolean active;
    private double balance;

    // Non-primitive types (Nullable)
    private String name;
    private Integer departmentCode;

    public UserProfileRequest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(Integer departmentCode) {
        this.departmentCode = departmentCode;
    }
}