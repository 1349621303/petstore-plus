package org.csu.petstoreplus.petstore.service;

import org.csu.petstoreplus.petstore.entity.Cart;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 观星
 * @since 2020-07-30
 */
public interface ICartService extends IService<Cart> {
    //查询到购物车的列表，即存放在购物车中所有的Item商品
    List<Cart> getCartList(String userId);
    //通过userId和itemId来返回一条item数据
    Cart getCartItem(String userId,String itemId);
    //删除购物车中的某一个Item商品
    int deleteTheItemOutCart(String userId,String itemId);
    //将一个Item商品插入到购物车中
    String insertTheItemToCart(Cart cart);
    //更新购物车中的某一个Item商品的数量
    int updateItemNumberInCart(Cart cart);

    //这个方法是在提交订单的时候进行的
    //清空购物车，即删除放在购物车中所有的Item商品
    int deleteAllItemOutCart(String userId);

}
