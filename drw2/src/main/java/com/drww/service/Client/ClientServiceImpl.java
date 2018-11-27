package com.drww.service.Client;

import com.drww.dao.Client.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:ClientServiceImpl
 * descriptive:
 * author:万中华
 * createTime:2018-11-26 21:22
 */
@Service
@SuppressWarnings("all")
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;
    /**
     * 查询分页
     * @param map
     * @return
     */
    @Override
    public List<Map> getListClient(Map map) {
        int pageNo=map.get("pageNo")==null?1:Integer.valueOf(map.get("pageNo")+"");
        int pageSize=map.get("pageSize")==null?10:Integer.valueOf(map.get("pageSize")+"");
        //计算分页的开始值和结束值
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        List<Map> list = clientDao.getListClient(map);
        return list;
    }

    /**
     * 分页总数量
     * @param map
     * @return
     */
    @Override
    public int getPageCount(Map map) {
        return clientDao.getPageCount(map);
    }
}
