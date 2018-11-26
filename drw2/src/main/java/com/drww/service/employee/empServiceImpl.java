package com.drww.service.employee;
import com.drww.dao.customer.employee.empDao;
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
     * 查询
     * @param map
     * @return
     */
    @Override
    public List<Map> getList(Map map) {
        List<Map> list = empdao.getList(map);
        return list;
    }
}
