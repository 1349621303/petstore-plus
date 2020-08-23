package org.csu.petstoreplus.petstore.service;

import org.csu.petstoreplus.petstore.entity.Orders;
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
public interface IOrdersService extends IService<Orders> {
    //新增订单
    void insertOrder(Orders order);
    List<Orders> getOrdersByUserId(String userId);
    Orders getOrderByOrderId(int orderId);
    //获取序列表sequence中新的id序列值
    int getNextId(String name);
    //卖家条件查询orders
    List<Orders> getSupplierOrders(String suppid);
}
