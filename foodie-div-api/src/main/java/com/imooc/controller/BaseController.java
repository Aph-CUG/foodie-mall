package com.imooc.controller;

import com.imooc.pojo.Orders;
import com.imooc.service.center.MyOrdersService;
import com.imooc.utils.IMOOCJSONResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.io.File;


@Controller
public class BaseController {
    public static final String FOODIE_SHOPCART = "shopcart";
    public static final Integer COMMON_PAGE_SIZE = 10;
    public static final Integer PAGE_SIZE = 20;


    @Autowired
    public MyOrdersService myOrdersService;
    //用户头像上传的位置
    public static final String IMAGE_USER_FACE_LOCATION = "D:\\Projects\\source\\images\\foodie\\faces";  //File.separator +


    public IMOOCJSONResult checkUserOrder(String orderId, String userId) {
        Orders order = myOrdersService.queryMyOrder(orderId, userId);
        if(order == null) {
            return IMOOCJSONResult.errorMsg("订单不存在！");
        }
        return IMOOCJSONResult.ok(order);
    }

}
