package com.pms.service;

import com.pms.VO.ResultPage;
import com.pms.entity.Position;
import com.pms.VO.Result;

public interface PositionService {
    public Result addPosition(Position position);
    public Result deletePosition(int positionId);
    public Result updatePosition(Position position);
    public Result findPositionById(int positionId);
    public Result findPositionByName(String positionName);
    public ResultPage findPositionByStatus(int positionStatus, int pageNum, int pageSize);
    public ResultPage findAllPosition(int pageNum,int pageSize);
}
