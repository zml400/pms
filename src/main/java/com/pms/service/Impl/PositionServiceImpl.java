package com.pms.service.Impl;

import com.pms.entity.Position;
import com.pms.entity.Result;
import com.pms.mapper.PositionMapper;
import com.pms.service.PositionService;
import javafx.geometry.Pos;
import org.omg.PortableServer.POA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionMapper positionMapper;
    @Override
    public Result addPosition(Position position) {
        Result result = new Result();
        Position position1=positionMapper.findPositionByName(position.getPositionName());
        if(position1!=null){
            result.setCode(1);
            result.setMessage("添加失败，名字已经存在！");
        }else{
            int num=positionMapper.addPosition(position);
            if(num==0){
                result.setCode(1);
                result.setMessage("添加失败！");
            }else
            {
                result.setCode(1);
                result.setMessage("添加成功");
                result.setData(position);
            }
        }
        return result;
    }

    @Override
    public Result deletePosition(int positionId) {
        Result result = new Result();
        int num=positionMapper.deletePosition(positionId);
        if(num==0){
            result.setCode(1);
            result.setMessage("删除失败");
        }else {
            result.setCode(0);
            result.setMessage("删除成功");
        }
        return result;
    }

    @Override
    public Result updatePosition(Position position) {
        Result result = new Result();
        int num=positionMapper.updatePosition(position);
        if(num==0){
            result.setCode(1);
            result.setMessage("更新失败");
        }else{
            result.setCode(0);
            result.setMessage("更新成功");
            result.setData(position);
        }
        return result;
    }

    @Override
    public Result findPositionById(int positionId) {
        Result result = new Result();
        Position position = positionMapper.findPositionById(positionId);
        if(position==null){
            result.setCode(1);
            result.setMessage("您输入的用户名错误，请重新输入");
        }else {
            result.setCode(0);
            result.setMessage("查找成功");
            result.setData(position);
        }
        return result;
    }

    @Override
    public Result findPositionByName(String positionName) {
        Result result = new Result();
        Position position = positionMapper.findPositionByName(positionName);
        if(position==null){
            result.setCode(1);
            result.setMessage("您输入的用户名错误，请重新输入");
        }else {
            result.setCode(0);
            result.setMessage("查找成功");
            result.setData(position);
        }
        return result;
    }
    @Override
    public Result findPositionByStatus(int positionStatus){
        Result result = new Result();
        List<Position> positionList = positionMapper.findPositionByStatus(positionStatus);
        if(positionList.size()==0){
            result.setCode(1);
            result.setMessage("您输入的用户名错误，请重新输入");
        }else {
            result.setCode(0);
            result.setMessage("查找成功");
            result.setData(positionStatus);
        }
        return result;
    }
    @Override
    public Result findAllPosition() {
        Result result = new Result();
        List<Position> positionList = positionMapper.findAllPosition();
        result.setCode(0);
        result.setMessage("查找成功");
        result.setData(positionList);
        return result;
    }
}
