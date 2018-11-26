package com.drww.service.bid;

import java.util.List;
import java.util.Map;

/**
 * className:BidService
 * discriptoin:
 * author:WangPJ
 * createTime:2018-11-23 20:08
 */
public interface BidService {
    /**
     *分页数量
     * @param map
     * @return
     */
    List<Map> getPage(Map map);

    /**
     *总条数
     * @param map
     * @return
     */
    int getPageCount(Map map);
    /**
     * 添加
     * @param map
     * @return
     */
    int add(Map map);
}
