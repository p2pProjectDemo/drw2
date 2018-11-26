package com.drww.service.employee;

import java.util.List;
import java.util.Map;

/**
 * className:empService
 * descriptive:
 * author:万中华
 * createTime:2018-11-24 19:17
 */
public interface empService {

    /**
     * 分页查询
     * @param map
     * @return
     */
    List<Map> getList(Map map);
    /**
     * 分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);
}
