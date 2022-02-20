package com.dubbo.wms.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.wms.api.WmsApi;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class WmsService implements WmsApi {

    @Override
    public String delivery(@PathVariable("productId") Long productId) {
        System.out.println("对商品【productId=" + productId + "】进行发货");
        return "{'msg': 'success'}";
    }

}
