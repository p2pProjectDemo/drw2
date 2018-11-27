package com.drww.service.customer;

import com.drww.dao.cascade.CascadeDao;
import com.drww.dao.customer.InformationDao;
import com.drww.dao.customer.LoginDao;
import com.drww.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
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
    @Autowired
    private CascadeDao cascadeDao;

    @Autowired
    private LoginDao loginDao;


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
    public List<Map> getAuditorStatus(Integer audutorId) {
        List<Map> auditorStatus = informationDao.getAuditorStatus(audutorId);
        return auditorStatus;
    }

    @Override
    public List<Map> getEducation() {
        List<Map> education = informationDao.getEducation();
        return education;
    }

    @Override
    public List<Map> getMarriage() {
        List<Map> marriage = informationDao.getMarriage();
        return marriage;
    }

    @Override
    public List<Map> getAddress() {
        List<Map> address = informationDao.getAddress();
        return address;
    }

    @Override
    public List<Map> getIncome() {
        List<Map> income = informationDao.getIncome();
        return income;
    }

    @Override
    public int SubmissionRealName(Map map, HttpSession session) {

        Object province1 = map.get("province");
        Object city1 = map.get("city");
        Object area1 = map.get("area");
        Object position1 = map.get("position");
        List<Map> provinceById = cascadeDao.getProvinceById(Integer.valueOf(province1.toString()));
        String province2 = provinceById.get(0).get("PROVINCE").toString();

        List<Map> cityById= cascadeDao.getCityById(Integer.valueOf(city1.toString()));
        String city2 = cityById.get(0).get("CITY").toString();

        List<Map> areaById = cascadeDao.getAreaById(Integer.valueOf(area1.toString()));
        String area2 = areaById.get(0).get("AREA").toString();

        String address =province2+","+city2+","+area2+","+position1.toString();

        map.put("address",address);
        Customer customer = loginDao.getByName(session.getAttribute("CustomerName").toString());
        Integer userId = customer.getUserId();
        map.put("userId",userId);
        System.out.println(map);
        int i = informationDao.SubmissionRealName(map);

        return i;
    }
}
