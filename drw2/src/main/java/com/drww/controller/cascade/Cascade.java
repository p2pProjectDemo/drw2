package com.drww.controller.cascade;

import com.drww.service.cascade.CascadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * className:Cascade
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-27 09:13
 */
@Controller
@RequestMapping(value = "customer")
public class Cascade {
    @Autowired
    private CascadeService cascadeService;

    /**
     * 得到省份
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getProvince")
    public Object getProvince(){

        List<Map> province = cascadeService.getProvince();
        return province;
    }

    /**
     * 得到市级
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getCity")
    public Object getCity(Integer Pid){
        List<Map> city = cascadeService.getCity(Pid);
        return city;
    }
    /**
     * 得到市级
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getArea")
    public Object getArea(Integer Pid){
        List<Map> area = cascadeService.getArea(Pid);
        return area;
    }





}
