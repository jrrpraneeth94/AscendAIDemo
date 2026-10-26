package com.ascendaidemo.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeRequest {
    
    // Valid: String is an object, not a primitive
    @JsonProperty("employeeName")
    private String employeeName;
    
    // VULNERABLE: Primitive type without required=true
    @JsonProperty("age")
    private int age;
    
    // VULNERABLE: Primitive type without required=true
    @JsonProperty("isContractor")
    private boolean isContractor;
    
    // VULNERABLE: Primitive type without required=true
    @JsonProperty("hourlyRate")
    private double hourlyRate;
    
    public EmployeeRequest() {}
    
    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public boolean isContractor() { return isContractor; }
    public void setContractor(boolean contractor) { this.isContractor = contractor; }

    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }
}
