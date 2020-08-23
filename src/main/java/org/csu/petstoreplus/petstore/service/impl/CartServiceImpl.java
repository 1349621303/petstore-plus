package org.csu.petstoreplus.petstore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.csu.petstoreplus.petstore.entity.Cart;
import org.csu.petstoreplus.petstore.entity.Inventory;
import org.csu.petstoreplus.petstore.mapper.CartMapper;
import org.csu.petstoreplus.petstore.mapper.InventoryMapper;
import org.csu.petstoreplus.petstore.service.ICartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 观星
 * @since 2020-07-30
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {
    //在Service中引入Mapper
    @Resource
    private CartMapper cartMapper;
    @Resource
    private InventoryMapper inventoryMapper;

    //用于返回该用户的购物车中的所有商品
    @Override
    public List<Cart> getCartList(String userId)
    {
        Map<String,Object> columnMap = new HashMap<>();
        columnMap.put("userid",userId);
        return cartMapper.selectByMap(columnMap);
    }


    @Override
    public Cart getCartItem(String userId, String itemId) {
        return cartMapper.selectOne(new QueryWrapper<Cart>()
                .eq("userId",userId)
                .eq("itemId",itemId)
        );
    }


    //买家删除购物车中的一条商品记录
    @Override
    public int deleteTheItemOutCart(String userId,String itemId)
    {
        //首先定义一个Map，实例化HashMap
        Map<String,Object> columnMap = new HashMap<>();
        //在这里因为我们需要针对一个买家的购物车中的一条商品(item)进行删除(delete)操作，所以仍然限定两个条件
        columnMap.put("userid",userId);
        columnMap.put("itemid",itemId);
        //指定调用deleteByMap这一方法，用于指定条件的删除
        return cartMapper.deleteByMap(columnMap);
    }

    //买家向自己的购物车中新增一种商品(item)
    @Override
    public String insertTheItemToCart(Cart cart)
    {
        //自动调用MyBatis-Plus的新增方法(insert)
        //注意:这里不用条件构造器，因为insert对应的SQL语句不需要条件(where)

        //判断是否有库存
        Inventory inventory=  inventoryMapper.selectById(cart.getItemid()) ;
        if (inventory==null){
            return "库存不存在";
        }
        if (inventory.getQty() < 1){
            return "库存不足";
        }else {
            //有库存则新增购物车
            int result= cartMapper.insert(cart);
            return String.valueOf(result) ;
        }
    }

    //买家修改购物车原有商品的数量(原则上不能改为0，而且修改数量有上限)
    @Override
    public int updateItemNumberInCart(Cart cart)
    {
        //指定调用MyBatis-Plus的更新方法(update)，该方法只适用于entity(实体)，因为update语句是需要条件和传值的
        return cartMapper.update
                (
                        //userid和itemid联合主键
                        //注意:QueryWrapper是AbstractWrapper的子类，为MyBatis-Plus 3.0 中的写法
                        cart,new QueryWrapper<Cart>()
                                //需要调用两次MyBatis-Plus条件构造器中的eq方法
                                .eq("userid",cart.getUserid())
                                .eq("itemid",cart.getItemid())
                );
    }

    //买家清空购物车中的一条商品记录
    //注意:清空是指删除所有商品，具体情境在用户批量删除购物车中所有商品，或者是用户对所有商品结算后购物车的清空
    @Override
    public int deleteAllItemOutCart(String userId) {
        //首先定义一个Map，实例化HashMap
        Map<String,Object> columnMap = new HashMap<>();
        //在这里因为我们需要针对一个买家的购物车中的所有商品(item)进行删除(delete)操作，所以只限定用户名(userid)这一个条件
        columnMap.put("userid",userId);
        //指定调用deleteByMap这一方法，用于指定条件的删除
        return cartMapper.deleteByMap(columnMap);
    }

}
