package ru.shaldnikita.forms.backend.models.entity;

import java.util.ArrayList;
import java.util.List;

public class UserAndHisForms {

    private String userId;

    private List<String> forms;

    public UserAndHisForms() {
        this.forms = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getForms() {
        return forms;
    }

    public void setForms(List<String> forms) {
        this.forms = forms;
    }

    @Override
    public String toString() {
        return "UserAndHisForms{" +
                "userId='" + userId + '\'' +
                ", forms=" + forms +
                '}';
    }
}
