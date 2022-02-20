package com.dubbo.wms.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/credit")
public interface WmsApi {
    @RequestMapping(value = "/delivery/{productId}", method = RequestMethod.PUT)
    String delivery(@PathVariable("productId") Long productId);
}
