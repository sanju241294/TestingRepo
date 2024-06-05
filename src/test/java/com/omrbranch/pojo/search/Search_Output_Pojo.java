package com.omrbranch.pojo.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Search_Output_Pojo {
    private int status;
    private String message;
    private ArrayList<SearchData> data;
    private String currency;
}
