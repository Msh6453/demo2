package com.iotek.dao;

import com.iotek.model.T_Emp;
import com.iotek.model.T_Train;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/2.
 */
public interface T_TrainMapper {
    //新增培训，但是未发布的
    int  saveTrain(T_Train t_train);


    //查看所有培训
    List<T_Train> getT_Trains();
    //分页查看所有培训
    List<T_Train> getT_TrainsCurrentPage(Map<String,Object> data);
    //查看未发布培训和已经发布培训
    List<T_Train> getT_TrainsByState(T_Train t_train);
    //分页查看未发布和已发布的培训
    List<T_Train> getT_TrainsByStateCurrentPage(Map<String,Object> data);
    //发布培训和撤销培训
    boolean updateTrainsState(T_Train t_train);
    //通过tra_id查对象，这里用于返回时间
    T_Train getT_Train(T_Train t_train);

}
