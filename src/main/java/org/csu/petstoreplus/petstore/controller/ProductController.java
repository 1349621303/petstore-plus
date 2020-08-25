package org.csu.petstoreplus.petstore.controller;


import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.csu.petstoreplus.petstore.entity.Product;
import org.csu.petstoreplus.petstore.service.impl.ProductServiceImpl;
import org.csu.petstoreplus.petstore.utils.ReturnEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 观星
 * @since 2020-07-30
 */
@RestController
public class ProductController {
    @Resource
    private ProductServiceImpl productService;
    //映射位置
    @RequestMapping(value = "/getProductListByCategory/{categoryId}",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getProductListByCategory(@PathVariable String categoryId)
    {
        //1.定义JSON
        //JSONObject data = new JSONObject();
        //2.调用Service
        List<Product> productList = productService.getProductListByCategory(categoryId);
        //3.压入数据
        // data.put("productList",productList);
        //4.返回数据
        if (productList == null) {
            return ReturnEntity.error("获取Product列表失败");
        }
        return ReturnEntity.ok("获取 Product 列表成功",productList);
    }

    @RequestMapping(value = "/getProductById",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getProductById(String productId)
    {
        JSONObject data = new JSONObject();
        Product product = productService.getProductById(productId);
        data.put("product",product);
        return ReturnEntity.ok("获取该 product 成功",data);
    }

    @RequestMapping(value = "/searchProductList",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity searchProductList(String name){
        JSONObject data = new JSONObject();
        List<Product> productList = productService.searchProductList(name);
        data.put("productList",productList);
        return ReturnEntity.ok("查询成功",data);
    }

    @RequestMapping(value = "/insertProduct",method = RequestMethod.POST)
    @ResponseBody
    //参数中的@RequestBody注解，主要用来接收前端传递给后端的json字符串中的数据，并按字段名称装配给 product 实体类
    public ReturnEntity insertProduct(@RequestBody Product product)
    {
        JSONObject data = new JSONObject();
        int result = productService.insertProduct(product);
        data.put("result",result);
        return ReturnEntity.ok("插入 Product 数据成功",data);
    }

    @RequestMapping(value = "/deleteProduct",method = RequestMethod.DELETE)
    @ResponseBody
    public ReturnEntity deleteProduct(@RequestBody Product product)
    {
        JSONObject data = new JSONObject();
        int result = productService.deleteProduct(product.getProductid());
        data.put("result",result);
        return ReturnEntity.ok("删除 product 成功",data);
    }

    @RequestMapping(value = "/updateProduct",method = RequestMethod.PUT)
    @ResponseBody
    public ReturnEntity updateProduct(@RequestBody Product product)
    {
        JSONObject data = new JSONObject();
        int result = productService.updateProduct(product);
        data.put("result",result);
        return ReturnEntity.ok("更新 product 成功",data);
    }

}
