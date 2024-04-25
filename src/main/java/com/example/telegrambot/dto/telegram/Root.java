package com.example.telegrambot.dto.telegram;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@Builder
@ToString(callSuper = true)
public class Root {
    public boolean ok;
    public ArrayList<Result> result;
}
