package com.pms.controller;

import com.pms.entity.Department;
import com.pms.entity.Position;
import com.pms.entity.Result;
import com.pms.service.Impl.DepartmentServiceImpl;
import com.pms.service.Impl.PositionServiceImpl;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Position")
public class PositionController {
    @Autowired
    private PositionServiceImpl positionService;

    /**
     * 添加职位信息
     * @param position
     * @return result
     */
    @RequestMapping("/addPosition")
    public Result addPosition(Position position){
        Result result = positionService.addPosition(position);
        return result;

    }
    /**
     * 删除部门
     * @param positionId
     * @return result
     */
    @RequestMapping("/deletePosition")
    public Result deletePosition(int positionId){
        Result result =positionService.deletePosition(positionId);
        return result;
    }

    /**
     * 更新部门
     * @param position
     * @return result
     */
    @RequestMapping("/updatePosition")
    public Result updatePosition(Position position){
        Result result = positionService.updatePosition(position);
        return result;
    }

    /**
     * 通过姓名查找部门
     * @param positionName
     * @return result
     */
    @RequestMapping("/findPositionByName")
    public Result findPositionByName(String positionName){
        Result result = positionService.findPositionByName(positionName);
        return  result;
    }
    /**
     * 通过状态查找部门
     * @param positionStatus
     * @return result
     */
    @RequestMapping("/findPositionByStatus")
    public Result findPositionByStatus(int positionStatus){
        Result result = positionService.findPositionByStatus(positionStatus);
        return  result;
    }

    /**
     * 查找所有的部门信息
     * @return result
     */
    @RequestMapping("/findAllPosition")
    public Result findAllPosition(){
        Result result = positionService.findAllPosition();
        return  result;
    }
}
