package com.drww.controller.Employee;

import com.drww.service.employee.empService;
import com.drww.util.PageUtli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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
  /*  @RequestMapping("/toList")
    public String toList(@RequestParam Map map){
        return "Emp/Emplist";
    }*/
    /**
     * 查询员工列表
     * @param map
     * @return
     */
    @RequestMapping("/getList")
    public Object getListEmp(@RequestParam Map map, Model model, HttpServletRequest request){

        map.put("pageSize",10);
        int pageNo = map.get("pageNo") == null?1 : Integer.valueOf(map.get("pageNo") + "");
        String stringPage = new PageUtli(pageNo, 10, empservice.getPageCount(map), request).getStringPage();
        model.addAttribute("stringPage",stringPage);
        model.addAttribute("empList",empservice.getList(map));

        return "Emp/Emplist";
    }
}
