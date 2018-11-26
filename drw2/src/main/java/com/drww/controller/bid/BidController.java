package com.drww.controller.bid;

import com.drww.service.bid.BidService;
import com.drww.util.PageUtli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * className:BidController
 * discriptoin:
 * author:WangPJ
 * createTime:2018-11-23 20:12
 */
@Controller
@RequestMapping("/bidcon")
public class BidController {
    @Autowired
    private BidService bidService;

    @RequestMapping(value = "/list")
    public String list(@RequestParam Map map, Model model, HttpServletRequest request){
        map.put("pageSize",5);
        int pageNo = map.get("pageNo") == null?1 : Integer.valueOf(map.get("pageNo") + "");

        String stringPage = new PageUtli(pageNo, 5, bidService.getPageCount(map), request).getStringPage();
        model.addAttribute("stringPage",stringPage);
        model.addAttribute("bidList",bidService.getPage(map));


        return "bid/bid";
    }

    @RequestMapping("/add")
    public String add(@RequestParam Map map,Model model){
        int i = bidService.add(map);
        System.out.println("11111111111111111"+map);
        if (i>0){

        }

        return "redirect:/bidcon/list";
    }
}
