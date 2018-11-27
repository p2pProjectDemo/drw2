package com.drww.service.cascade;

import com.drww.dao.cascade.CascadeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:CascadeServiceImpl
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-27 09:11
 */
@Service
public class CascadeServiceImpl implements  CascadeService {
    @Autowired
    private CascadeDao cascadeDao;



    @Override
    public List<Map> getProvince() {
        List<Map> provinceList = cascadeDao.getProvince();
        System.out.println("---------------"+provinceList);
        return provinceList;
    }

    @Override
    public List<Map> getCity(Integer Pid) {
        List<Map> cityList = cascadeDao.getCity(Pid);
        return cityList;
    }

    @Override
    public List<Map> getArea(Integer Pid) {
        List<Map> areaList = cascadeDao.getArea(Pid);
        return areaList;
    }

    @Override
    public List<Map> getProvinceById(Integer id) {
        List<Map> province = cascadeDao.getProvinceById(id);
        return province;
    }

    @Override
    public List<Map> getCityById(Integer id) {
        List<Map> city = cascadeDao.getCityById(id);
        return city;
    }

    @Override
    public List<Map> getAreaById(Integer id) {
        List<Map> area = cascadeDao.getAreaById(id);
        return area;
    }
}
