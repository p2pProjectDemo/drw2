package com.drww.controller.Employee;

import com.drww.service.employee.empService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * className:EmpController
 * descriptive:
 * author:万中华
 * createTime:2018-11-26 08:33
 */
@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private empService empservice;


    /**
     * 跳转查询列表
     * @param map
     * @return
     */
    @RequestMapping("/toList")
    public String toList(@RequestParam Map map){
        return "Emp/Emplist";
    }
    /**
     * 查询
     * @param map
     * @return
     */
    public Object getListEmp(@RequestParam Map map){

        List<Map> empserviceList = empservice.getList(map);

        return empserviceList;
    }
}
