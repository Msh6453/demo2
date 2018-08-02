package com.iotek.dao;

import com.iotek.model.T_Position;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/31.
 */
public interface T_PositionMapper {
    //通过部门的d_id查找职位
    List<T_Position> getPositions(T_Position t_position);
    //查找所有的职位
    List<T_Position> getT_Positions();
    //通过p_id查找职位信息
    T_Position get_PostionByid(T_Position t_position);
    //分页查询所有职位
    List<T_Position> getT_Positionss(Map<String,Object> data);
    //修改职位表
    boolean updateT_Pos(T_Position t_position);
    //删除职位
    boolean deleteT_Pos(T_Position t_position);
    //增加职位,首先要判断添加的名字在这个部门里有没有重复
    T_Position getT_posByName(T_Position t_position);
    boolean saveT_Pos(T_Position t_position);
}
