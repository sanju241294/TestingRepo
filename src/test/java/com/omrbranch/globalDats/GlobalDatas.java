package com.omrbranch.globalDats;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalDatas {

    private int statusCode;
    private int stateId;
    private String logtoken;
    private int cityId;
    private String addrId;
}
