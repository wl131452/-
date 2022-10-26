package com.bjsxt.dao;

import com.bjsxt.pojo.Clazz;
import com.bjsxt.pojo.TongJi;

import java.util.List;

public interface ClazzDao {

    List<TongJi> getTongJi();

    int updateClazz(Clazz clazz);

    //分页查询数据   参数1：从哪开始  参数2：要多少条
    List<Clazz> getClazzByPage(int start,int size);

    //查询总条数
    int getTotalCount();

    List<Clazz> getAll();

    int addClazz(Clazz clazz);
}
