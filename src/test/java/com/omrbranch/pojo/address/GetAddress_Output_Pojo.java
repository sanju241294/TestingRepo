package com.omrbranch.pojo.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAddress_Output_Pojo {

        private int status;
    private String message;
    private ArrayList<GetAddress> data;
    }

