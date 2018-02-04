package ru.shaldnikita.forms.backend.models.entity;

/**
 * @author Nikita Shaldenkov on 04.02.2018
 */


public class UserAndHisState {

    private String userId;

    private String state;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
