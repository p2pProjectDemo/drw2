package com.drww.controller.Client;

import com.drww.service.Client.ClientService;
import com.drww.util.PageUtli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * className:ClientController
 * descriptive:
 * author:万中华
 * createTime:2018-11-26 21:27
 */
@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired //依赖注入
    private ClientService clientService;
    /**
     * 跳转列表
     * @param map
     * @return
     */
   /* @RequestMapping("/toClient")
    public String toClientList(Map map){

        return "Client/Clientlist";
    }*/

    public Object getClientList(@RequestParam Map map, Model model, HttpServletRequest request){

        map.put("pageSize",10);
        int pageNo = map.get("pageNo") == null?1 : Integer.valueOf(map.get("pageNo") + "");
        String stringPage = new PageUtli(pageNo, 10, clientService.getPageCount(map), request).getStringPage();
        model.addAttribute("stringPage",stringPage);
        model.addAttribute("clientList",clientService.getListClient(map));
        return "";
    }
}
