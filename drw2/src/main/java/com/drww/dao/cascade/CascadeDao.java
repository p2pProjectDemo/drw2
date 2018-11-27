package com.drww.dao.cascade;

import java.util.List;
import java.util.Map;

/**
 * className:province
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-27 09:03
 */
public interface CascadeDao {


    /**
     * 得到省份
     * @return
     */
    List<Map> getProvince();

    /**
     * 根据父id查询市级
     * @param Pid
     * @return
     */
    List<Map> getCity(Integer Pid);
    /**
     * 根据父id查询区级
     * @param Pid
     * @return
     */
    List<Map> getArea(Integer Pid);




   //根据id查询名称
    /**
     * 得到省份
     * @return
     */
    List<Map> getProvinceById(Integer id);

    /**
     * 根据父id查询市级
     * @param id
     * @return
     */
    List<Map> getCityById(Integer id);
    /**
     * 根据父id查询区级
     * @param id
     * @return
     */
    List<Map> getAreaById(Integer id);





}
