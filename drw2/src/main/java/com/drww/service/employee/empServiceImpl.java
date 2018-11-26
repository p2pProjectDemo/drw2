package com.drww.service.employee;
import com.drww.dao.employee.empDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:empServiceImpl
 * descriptive:
 * author:万中华
 * createTime:2018-11-24 19:17
 */
@Service
@SuppressWarnings("all")
public class empServiceImpl implements empService {

    @Autowired  //依赖注入
    private empDao empdao;


    /**
     * 查询分页
     * @param map
     * @return
     */
    @Override
    public List<Map> getList(Map map) {
        int pageNo=map.get("pageNo")==null?1:Integer.valueOf(map.get("pageNo")+"");
        int pageSize=map.get("pageSize")==null?10:Integer.valueOf(map.get("pageSize")+"");
        //计算分页的开始值和结束值
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        List<Map> list = empdao.getList(map);
        return list;
    }

    /**
     * 分页总数量
     * @param map
     * @return
     */
    @Override
    public int getPageCount(Map map) {
        return empdao.getPageCount(map);
    }
}
