package com.pms.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pms.VO.ResultPage;
import com.pms.entity.Position;
import com.pms.VO.Result;
import com.pms.mapper.PositionMapper;
import com.pms.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionMapper positionMapper;
    @Override
    public Result addPosition(Position position) {
        Position position1=positionMapper.findPositionByName(position.getPositionName());
        if(position1!=null){
            return Result.failed("添加失败，名字已经存在！");
        }else{
            int num=positionMapper.addPosition(position);
            if(num==0){
                return Result.failed("添加失败！");
            }else
            {
                return Result.success("添加成功",position);
            }
        }
    }

    @Override
    public Result deletePosition(int positionId) {
        int num=positionMapper.deletePosition(positionId);
        if(num==0){
            return Result.failed("删除失败");
        }else {
            return Result.success("删除成功");
        }
    }

    @Override
    public Result updatePosition(Position position) {
        int num=positionMapper.updatePosition(position);
        if(num==0){
            return Result.failed("更新失败");
        }else {
            return Result.success("更新成功");
        }
    }

    @Override
    public Result findPositionById(int positionId) {
        Position position = positionMapper.findPositionById(positionId);
        if(position==null){
            return Result.failed("您输入的用户id错误，请重新输入");
        }else {
            return Result.success("查找成功",position);
        }
    }

    @Override
    public Result findPositionByName(String positionName) {
        Position position = positionMapper.findPositionByName(positionName);
        if(position==null){
            return Result.failed("您输入的用户名错误，请重新输入");
        }else {
            return Result.success("查找成功",position);
        }
    }
    @Override
    public ResultPage findPositionByStatus(int positionStatus,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Position> positionList = positionMapper.findPositionByStatus(positionStatus);
        PageInfo<Position> pageInfo = new PageInfo<>(positionList);
        if(positionList.size()==0){
            return ResultPage.failed("您输入的用户状态错误，请重新输入");
        }else {
            return ResultPage.success("查找成功",pageInfo.getTotal(),positionList);
        }
    }
    @Override
    public ResultPage findAllPosition(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Position> positionList = positionMapper.findAllPosition();
        PageInfo<Position> pageInfo = new PageInfo<>(positionList);
        if(positionList.size()==0){
            return ResultPage.failed("没有记录");
        }else{
            return ResultPage.success("查找成功",pageInfo.getTotal(),positionList);
        }
    }
}
