package com.dubbo.inventory.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.inventory.inventory.api.InventoryApi;

@Service
public class InventoryService implements InventoryApi {
    @Override
    public String deductStock(Long productId,
                              Long stock) {
        System.out.println("对商品【productId=" + productId + "】扣减库存：" + stock);
        return "{'msg': 'success'}";
    }
}
