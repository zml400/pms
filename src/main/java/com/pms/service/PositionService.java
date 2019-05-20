package com.pms.service;

import com.pms.entity.Position;
import com.pms.entity.Result;

public interface PositionService {
    public Result addPosition(Position position);
    public Result deletePosition(int positionId);
    public Result updatePosition(Position position);
    public Result findPositionById(int positionId);
    public Result findPositionByName(String positionName);
    public Result findPositionByStatus(int positionStatus);
    public Result findAllPosition();
}
