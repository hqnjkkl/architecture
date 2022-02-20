package com.dubbo.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.credit.api.CreditApi;
import com.dubbo.inventory.CreditService;
import com.dubbo.inventory.inventory.api.InventoryApi;
import com.dubbo.inventory.service.InventoryService;
import com.dubbo.wms.api.WmsApi;
import com.dubbo.wms.service.WmsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderServiceController {

    @Reference
    CreditApi creditService;

    @Reference
    InventoryApi inventoryService;

    @Reference
    WmsApi wmsService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String greeting(
            @RequestParam("productId") Long productId,
            @RequestParam("userId") Long userId,
            @RequestParam("count") Long count,
            @RequestParam("totalPrice") Long totalPrice) {
        System.out.println("创建订单");
        creditService.add(userId, totalPrice);
        inventoryService.deductStock(productId, count);
        wmsService.delivery(productId);

        return "success";
    }
}
