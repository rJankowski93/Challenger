package com.aghpk.challenger.model;

import com.aghpk.challenger.data.Challenge;
import com.aghpk.challenger.data.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class GlobalSearchResult {
    private final List<Challenge> challenges;
    private final List<User> users;
}