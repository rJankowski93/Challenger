package com.aghpk.challenger.model;

import com.aghpk.challenger.data.User;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JsonResponseBody {

    @JsonView(Views.Public.class)
    List<User> result;

}
