package com.pms.mapper;

import com.pms.entity.Position;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PositionMapper {
    public int addPosition(Position position);
    public int deletePosition(int positionId);
    public int updatePosition(Position positionId);
    public Position findPositionById(int positionId);
    public Position findPositionByName(String positionName);
    public List<Position> findPositionByStatus(int positionStatus);
    public List<Position> findAllPosition();
}
