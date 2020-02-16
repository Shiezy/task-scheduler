package com.holdings.taskscheduler.service.dto;

import com.holdings.taskscheduler.model.enumeration.GenderEnum;
import com.holdings.taskscheduler.model.enumeration.StatusEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TaskDTO {
    private String customerFirstName;
    private  String customerLastName;
    private String customerPhone;
    private String personnelFirstName;
    private String personnelLastName;
    private String assgigned;
    private String inProgress;
    private String completed;
    private String deferred;
    private StatusEnum status;
    private String location;
    private GenderEnum gender;
    private Integer age;
    private Integer accessCode;
    private Integer splashPage;
    private Boolean mpesa;
    private Boolean autoplay;
    private String comments;
    private String registration;

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getPersonnelFirstName() {
        return personnelFirstName;
    }

    public void setPersonnelFirstName(String personnelFirstName) {
        this.personnelFirstName = personnelFirstName;
    }

    public String getPersonnelLastName() {
        return personnelLastName;
    }

    public void setPersonnelLastName(String personnelLastName) {
        this.personnelLastName = personnelLastName;
    }

    public String getAssgigned() {
        return assgigned;
    }

    public void setAssgigned(String assgigned) {
        this.assgigned = assgigned;
    }

    public String getInProgress() {
        return inProgress;
    }

    public void setInProgress(String inProgress) {
        this.inProgress = inProgress;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public String getDeferred() {
        return deferred;
    }

    public void setDeferred(String deferred) {
        this.deferred = deferred;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(Integer accessCode) {
        this.accessCode = accessCode;
    }

    public Integer getSplashPage() {
        return splashPage;
    }

    public void setSplashPage(Integer splashPage) {
        this.splashPage = splashPage;
    }

    public Boolean getMpesa() {
        return mpesa;
    }

    public void setMpesa(Boolean mpesa) {
        this.mpesa = mpesa;
    }

    public Boolean getAutoplay() {
        return autoplay;
    }

    public void setAutoplay(Boolean autoplay) {
        this.autoplay = autoplay;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }
}
