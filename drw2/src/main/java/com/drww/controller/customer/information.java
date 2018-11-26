package com.drww.controller.customer;

import com.drww.entity.Customer;
import com.drww.service.customer.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:information
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-24 14:44
 */
@Controller
@RequestMapping(value = "customer")
public class information {
    @Autowired
    private InformationService informationService;

    /**
     * 查询手机号邮箱
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getTelephoneByUserName")
    public Object getTelephoneByUserName(HttpSession session){
        Map map = new HashMap();
        Object customerName = session.getAttribute("CustomerName");
        if (customerName != null&&customerName!=""){
            Customer customer = informationService.getTelephoneByUserName(customerName.toString());
            if (customer != null) {
                map.put("customer", customer);
            } else {
                map.put("customer", "-1");
            }
        }else{
            map.put("customer", "-1");
        }
        return map;
    }

    /**
     * 查询认证状态
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "realName")
    public Object getRealName(HttpSession session){
        Map map = new HashMap();
        Object customerName = session.getAttribute("CustomerName");
        if (customerName!=null){
            Customer customer = informationService.getTelephoneByUserName(customerName.toString());
            List<Map> realNameList = informationService.getRealNameByUserId(customer.getUserId());
            System.out.println(realNameList);
            if(realNameList!=null&&realNameList.size()>0){
                Integer auditorid = Integer.valueOf(realNameList.get(0).get("AUDITORID").toString());
                List<Map> realNameByUserId = informationService.getRealNameByUserId(auditorid);
                Object item = realNameByUserId.get(0).get("ITEM");
                System.out.println(item);
                return   map.put("msg",item);
            }else{
                map.put("msg","-1");
            }
        }
        return  map;

    }

}
