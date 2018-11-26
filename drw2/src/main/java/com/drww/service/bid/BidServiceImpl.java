package com.drww.service.bid;

import com.drww.dao.bid.BidDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:BidServiceImpl
 * discriptoin:
 * author:WangPJ
 * createTime:2018-11-23 20:09
 */
@Service
public class BidServiceImpl implements BidService {

    @Autowired
    private BidDao bidDao;

    @Override
    public List<Map> getPage(Map map) {
        int pageNo = map.get("pageNo") ==null?1:Integer.valueOf(map.get("pageNo")+"");
        int pageSize = map.get("pageSize") ==null?10:Integer.valueOf(map.get("pageSize")+"");
        //计算分页的开始值和结束值
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        return bidDao.getPage(map);
    }

    @Override
    public int getPageCount(Map map) {
        return bidDao.getPageCount(map);
    }

    @Override
    public int add(Map map) {
        return bidDao.add(map);
    }
}
