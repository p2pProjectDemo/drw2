package com.drww.service.customer;

import com.drww.entity.Customer;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * className:InformationService
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-24 14:44
 */
public interface InformationService {
    /**
     * 查询用户手机号是否绑定
     * @param userName
     * @return
     */
    Customer getTelephoneByUserName(String userName);
    /**
     * 根据用户id查询实名认证
     * @param userId
     * @return
     */
    List<Map> getRealNameByUserId(Integer userId);


    /**
     * 查询认证状态
     * @param audutorId
     * @return
     */
    List<Map> getAuditorStatus(Integer audutorId);
    /**
     * 从数据库获取学历
     * @return
     */
    List<Map> getEducation();

    /**
     * 从数据库获取婚姻状态
     * @return
     */
    List<Map> getMarriage();
    /**
     * 从数据库获取现住址
     * @return
     */
    List<Map> getAddress();
    /**
     * 从数据库获取收入级别
     * @return
     */
    List<Map> getIncome();

    /**
     * 提交认证信息
     * @param map
     * @return
     */
    int SubmissionRealName(Map map, HttpSession session);
}
