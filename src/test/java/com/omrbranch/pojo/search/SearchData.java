package com.omrbranch.pojo.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchData {
    private String image;
    private String type;
    private String text;
    private int id;
    private int category_id;
}
