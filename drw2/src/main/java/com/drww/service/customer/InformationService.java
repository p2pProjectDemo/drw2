package com.drww.service.customer;

import com.drww.entity.Customer;

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
    List<Map> getAuditorStatus(String audutorId);
}
