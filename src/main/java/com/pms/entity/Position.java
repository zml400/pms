package com.pms.entity;

import lombok.Data;

@Data
public class Position {
    private int positionID;
    private String positionName;
    private int positionLevel;
    private int positionStatus;
}
