package com.pms.controller;

import com.pms.VO.ResultPage;
import com.pms.entity.Position;
import com.pms.VO.Result;
import com.pms.service.Impl.PositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping("/findPositionByStatus/{pageNum},{pageSize}")
    public ResultPage findPositionByStatus(@PathVariable("pageNum")int pageNum,
                                         @PathVariable("pageSize")int pageSize,
                                         int positionStatus){
        return positionService.findPositionByStatus(positionStatus,pageNum,pageSize);
    }
    @RequestMapping("/findAllPosition/{pageNum},{pageSize}")
    public ResultPage findAllPosition(@PathVariable("pageNum")int pageNum,
                                    @PathVariable("pageSize")int pageSize){
        return positionService.findAllPosition(pageNum,pageSize);
    }
}
