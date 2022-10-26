package com.bjsxt.service;

import com.bjsxt.pojo.Clazz;
import com.bjsxt.pojo.PageBean;
import com.bjsxt.pojo.TongJi;

import java.util.List;

public interface ClazzService {

    List<TongJi> getTongJi();

    int updateClazz(Clazz clazz);

    PageBean<Clazz> getClazzByPage(int index);

    List<Clazz> getAll();

    int addClazz(Clazz clazz);
}
