package com.imooc.controller;

import com.imooc.pojo.bo.ShopcartBO;
import com.imooc.pojo.vo.ShopcartVO;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("shopcart")
@Api(value = "购物车接口controller", tags = {"购物车接口相关的api"})
public class ShopCartController {

    @ApiOperation(value = "添加商品到购物车", notes = "添加商品到购物车", httpMethod = "POST")
    @GetMapping("/add")
    public IMOOCJSONResult add(
            @RequestParam String userId,
            @RequestBody ShopcartBO shopcartBO,
            HttpServletRequest request,
            HttpServletResponse response
            ) {
        if (StringUtils.isBlank(userId)) {
            return IMOOCJSONResult.errorMsg("");
        }

        System.out.println(shopcartBO);

        // TODO  前端用户在登录的情况下，添加商品到购物车，会同时在后端同步到redis缓存


        return IMOOCJSONResult.ok();
    }


    @ApiOperation(value = "从购物车中删除商品", notes = "从购物车中删除商品", httpMethod = "POST")
    @GetMapping("/del")
    public IMOOCJSONResult del(
            @RequestParam String userId,
            @RequestParam String itemSpecId
    ) {
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(itemSpecId)) {
            return IMOOCJSONResult.errorMsg("参数不能为空");
        }


        // TODO  用户在页面删除购物车的商品数据，如果此时用户已登录，则需要同步删除后端购物车的商品


        return IMOOCJSONResult.ok();
    }

}
