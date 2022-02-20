package com.dubbo.inventory;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.credit.api.CreditApi;

@Service
public class CreditService implements CreditApi {

    @Override
    public String add(Long userId,Long credit) {
        System.out.println("对用户【userId=" + userId + "】增加积分：" + credit);
        return "{'msg': 'success'}";
    }
}
