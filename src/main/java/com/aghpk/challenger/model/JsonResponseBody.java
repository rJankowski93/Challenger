package com.aghpk.challenger.model;

import com.aghpk.challenger.data.User;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

public class JsonResponseBody {
    @JsonView(Views.Public.class)
    List<User> result;

    public List<User> getResult() {
        return result;
    }

    public void setResult(List<User> result) {
        this.result = result;
    }
}
