package org.csu.petstoreplus.petstore.controller;


import com.alibaba.fastjson.JSONObject;
import org.csu.petstoreplus.petstore.entity.Account;
import org.csu.petstoreplus.petstore.entity.Cart;
import org.csu.petstoreplus.petstore.entity.Item;
import org.csu.petstoreplus.petstore.entity.Syslog;
import org.csu.petstoreplus.petstore.service.impl.*;
import org.csu.petstoreplus.petstore.utils.ReturnEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 观星
 * @since 2020-07-30
 */
@RestController
public class CartController {
    @Resource
    CartServiceImpl cartService;
    @Resource
    private HttpServletRequest request;
    /**
     * itemService的引入主要是cart中需要用到这里面的一些方法：
     * boolean isItemInStock(String itemId); 来判断购物车中是够还有item商品，如果没有就插入
     */

//    @Resource
//    ItemServiceImpl itemService;
//    @Resource
//    AccountServiceImpl accountService;

    @RequestMapping(value = "/getCartList",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getCartList()
    {
        // JSONObject data = new JSONObject();
        HttpSession session = request.getSession();
        session.setAttribute("userId","j2ee");
        String userId=(String) session.getAttribute("userId");
        List<Cart> cartList = cartService.getCartList(userId);
        // data.put("result",result);
        return ReturnEntity.ok("成功获取我的购物车列表",cartList);

        //是否登录判断
//        if (accountSession!=null ){
//            return ReturnEntity.error("请登录后访问");
//        }else {
//            List<Cart> result = cartService.getCartList(userId);
//            data.put("result",result);
//            return ReturnEntity.ok("成功获取我的购物车列表",data);
//        }
    }

    @RequestMapping(value = "/getCartByItemId/{itemId}",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getCartByItemId(@PathVariable String itemId)
    {
 //       JSONObject data = new JSONObject();
//        HttpSession session = request.getSession();

//        Account accountSession=(Account) session.getAttribute("account");
        //是否登录判断
//        if (accountSession!=null ){
//            return ReturnEntity.error("请登录后访问");
//        }else {
//            List<Cart> result = cartService.getCartList(userId);
//            data.put("result",result);
//            return ReturnEntity.ok("成功获取我的购物车列表",data);
//        }
        HttpSession session = request.getSession();
        String  userId = (String) session.getAttribute("userId");

        Cart cartItem = cartService.getCartItem(userId,itemId);

        return ReturnEntity.ok("通过某 itemId 成功获取购物车列表信息",cartItem);
    }

    @RequestMapping(value = "/deleteTheItemOutCart",method = RequestMethod.DELETE)
    @ResponseBody
    //多参数需要使用map
    public ReturnEntity deleteTheItemOutCart(@RequestBody Map<String,String> map) throws Exception
    {
        JSONObject data = new JSONObject();

        HttpSession session = request.getSession();
        String  userId = (String) session.getAttribute("userId");

        int result = cartService.deleteTheItemOutCart(userId, map.get("itemid"));
        List<Cart> cartList = cartService.getCartList(userId);
        data.put("result",result);
        data.put("cartList",cartList);

        return ReturnEntity.ok("从我的购物车中移除",data);


        // HttpSession session = request.getSession();

        // Account accountSession=(Account) session.getAttribute("account");
        //是否登录判断
//        if (accountSession!=null ){
//            return ReturnEntity.error("请登录后访问");
//        }else {
//            int result = cartService.deleteTheItemOutCart(map.get("userid"), map.get("itemid"));
//            List<Cart> cartList = cartService.getCartList(map.get("userid"));
//            data.put("result",result);
//            data.put("cartList",cartList);
//
//            return ReturnEntity.ok("从我的购物车中移除",data);
//        }
    }


    @RequestMapping(value = "/insertTheItemToCart",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity insertTheItemToCart(@RequestBody Cart cart) throws Exception {
        JSONObject data = new JSONObject();
        // HttpSession session = request.getSession();

        // Account accountSession=(Account) session.getAttribute("account");
        //是否登录判断
//        if (accountSession!=null ){
//            return ReturnEntity.error("请登录后访问");
//        }else {
//            //新增购物车，判断是否有库存在service中实现
//            String result = cartService.insertTheItemToCart(cart);
//            List<Cart> cartList = cartService.getCartList(cart.getUserid());
//            data.put("result",result);
//            data.put("cartList",cartList);
//
//            return ReturnEntity.ok("成功将商品添加到我的购物车",data);
//        }
        //            //新增购物车，判断是否有库存在service中实现
        String result = cartService.insertTheItemToCart(cart);
        List<Cart> cartList = cartService.getCartList(cart.getUserid());
        data.put("result",result);
        data.put("cartList",cartList);

        return ReturnEntity.ok("成功将商品添加到我的购物车",data);
    }

    /**InetAddress.getLocalHost().getHostAddress()
     * 最开始定义JSON
     * 首先通过session验证用户身份，通过用户名来返回购物车中的item
     * 然后判断购物车中是否已经含有itemId为xxx的item商品，如果没有就先判断库存中有没有商品的存量（库存inventory可以被卖家所修改）
     * 如果库存存量不够，那么新增商品无效，如果有库存，那么新增商品
     * 如果购物车原来就含有itemId为xxx的item商品，那么该item的数量增加
     * 新增后调用计算总金额的方法
     * 最后返回json数据
     */
    @RequestMapping(value = "/updateCart",method = RequestMethod.PUT)
    @ResponseBody
    public ReturnEntity updateCart(@RequestBody Cart cart) throws Exception
    {
        JSONObject data = new JSONObject();
        HttpSession session = request.getSession();

        Account accountSession=(Account) session.getAttribute("account");

        //是否登录判断
        if (accountSession!=null ) {
            return ReturnEntity.error("请登录后访问");
        }
        else {
            String result ;
            int quantity = cart.getQuantity();
            //判断当数量小于1的时候，若是，则执行删除的方法
            if(quantity < 1){
                result = String.valueOf(cartService.deleteTheItemOutCart(cart.getUserid(),cart.getItemid()));
            }else {
                //若数量大于1，数据库中若有则数量更新；若无则新增cart
                Cart cartItem = cartService.getCartItem(cart.getUserid(),cart.getItemid());
                if (cartItem != null){
                    result = cartService.insertTheItemToCart(cart);
                }else {
                    result = String.valueOf(cartService.updateItemNumberInCart(cart));
                }
            }
            data.put("result",result);
            return ReturnEntity.ok("成功更新购物车",data);
        }
    }
}
