package com.omrbranch.pojo.changeprofile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeProfilePic_Output_Pojo {
    private int status;
    private String message;
    private ProfileData data;
    private int cart_count;
}
