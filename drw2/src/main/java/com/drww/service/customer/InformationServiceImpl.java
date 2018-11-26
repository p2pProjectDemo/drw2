package com.drww.service.customer;

import com.drww.dao.customer.InformationDao;
import com.drww.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:InformationServiceImpl
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-24 14:44
 */
@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationDao informationDao;

    @Override
    public Customer getTelephoneByUserName(String userName) {
        Customer customer  = informationDao.getTelephoneByUserName(userName);
        return customer;
    }



    @Override
    public List<Map> getRealNameByUserId(Integer userId) {
        List<Map> realNameList = informationDao.getRealNameByUserId(userId);
        return realNameList;
    }
    @Override
    public List<Map> getAuditorStatus(String audutorId) {
        List<Map> auditorStatus = informationDao.getAuditorStatus(audutorId);
        return auditorStatus;
    }
}
