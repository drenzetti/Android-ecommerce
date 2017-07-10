package com.example.archimede.ecommerce2.data;

/**
 * Created by archimede on 05/07/17.
 */

public class User {
    private int id;
    private String firstname;
    private String email;
    private String password;
    private Boolean superuser;
    private String status;
    private String uuid;

    public User(int id, String firstname, String email, String password, Boolean superuser, String status, String uuid) {
        this.id = id;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.superuser = superuser;
        this.status = status;
        this.uuid = uuid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getSuperuser() {
        return superuser;
    }

    public void setSuperuser(Boolean superuser) {
        this.superuser = superuser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", superuser=" + superuser +
                ", status='" + status + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}

