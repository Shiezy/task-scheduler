package com.holdings.taskscheduler.model;

import com.holdings.taskscheduler.model.enumeration.GenderEnum;
import com.holdings.taskscheduler.model.enumeration.RoleEnum;
import com.holdings.taskscheduler.model.enumeration.StatusEnum;

import javax.persistence.*;

@Entity
@Table(	name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_first_name")
    private String customerFirstName;
    @Column(name = "customer_last_name")
    private  String customerLastName;
    @Column(name = "customer_phone")
    private String customerPhone;
    @Column(name = "personnel_first_name")
    private String personnelFirstName;
    @Column(name = "personnel_other_name")
    private String personnelLastName;
    @Column(name = "assigned")
    private String assgigned;
    @Column(name = "in_progress")
    private String inProgress;
    @Column(name = "completed")
    private String completed;
    @Column(name = "deferred")
    private String deferred;


    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status;

    @Column(name = "location")
    private String location;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private GenderEnum gender;
    @Column(name = "age")
    private Integer age;
    @Column(name = "access_code")
    private Integer accessCode;
    @Column(name = "splash_page")
    private Integer splashPage;
    @Column(name = "mpesa")
    private Boolean mpesa;
    @Column(name = "autoplay")
    private Boolean autoplay;
    @Column(name = "comments")
    private String comments;
    @Column(name = "registation")
    private String registration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", personnelFirstName='" + personnelFirstName + '\'' +
                ", personnelLastName='" + personnelLastName + '\'' +
                ", assgigned='" + assgigned + '\'' +
                ", inProgress='" + inProgress + '\'' +
                ", completed='" + completed + '\'' +
                ", deferred='" + deferred + '\'' +
                ", status=" + status +
                ", location='" + location + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", accessCode=" + accessCode +
                ", splashPage=" + splashPage +
                ", mpesa=" + mpesa +
                ", autoplay=" + autoplay +
                ", comments='" + comments + '\'' +
                ", registration='" + registration + '\'' +
                '}';
    }
}
