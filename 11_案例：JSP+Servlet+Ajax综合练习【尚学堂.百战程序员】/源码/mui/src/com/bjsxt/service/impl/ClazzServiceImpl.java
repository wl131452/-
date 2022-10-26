package com.bjsxt.service.impl;

import com.bjsxt.dao.ClazzDao;
import com.bjsxt.dao.impl.ClazzDaoImpl;
import com.bjsxt.pojo.Clazz;
import com.bjsxt.pojo.PageBean;
import com.bjsxt.pojo.TongJi;
import com.bjsxt.service.ClazzService;

import java.util.List;

public class ClazzServiceImpl implements ClazzService {

    private ClazzDao clazzDao = new ClazzDaoImpl();

    @Override
    public List<TongJi> getTongJi() {
        return clazzDao.getTongJi();
    }

    @Override
    public int updateClazz(Clazz clazz) {
        return clazzDao.updateClazz(clazz);
    }

    @Override
    public PageBean<Clazz> getClazzByPage(int index) {

        PageBean<Clazz> pageBean = new PageBean<>();

        pageBean.setIndex(index);//设置当前页
        pageBean.setSize(5); //设置每页显示多少条


        //查询总条数
        int totalCount = clazzDao.getTotalCount();
        pageBean.setTotalCount(totalCount);

        //总页数不用设置，设置总条数的时候，已经自动给计算了

        List<Clazz> list = clazzDao.getClazzByPage((index - 1) * 5, 5);

        pageBean.setList(list);

        return pageBean;
    }

    @Override
    public List<Clazz> getAll() {
        return clazzDao.getAll();
    }

    @Override
    public int addClazz(Clazz clazz) {
        return clazzDao.addClazz(clazz);
    }
}
