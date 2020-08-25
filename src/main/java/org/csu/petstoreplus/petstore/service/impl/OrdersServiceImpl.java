package org.csu.petstoreplus.petstore.service.impl;

import org.csu.petstoreplus.petstore.entity.*;
import org.csu.petstoreplus.petstore.mapper.*;
import org.csu.petstoreplus.petstore.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 观星
 * @since 2020-08-22
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private OrderstatusMapper orderstatusMapper;
    @Resource
    private CartMapper cartMapper;
    @Resource
    private SequenceMapper sequenceMapper;
    @Resource
    private CartServiceImpl cartService;
    @Resource
    private LineitemMapper lineitemMapper;
    @Resource
    private InventoryMapper inventoryMapper;
    @Resource
    private AccountMapper accountMapper;

    @Override
    public void insertOrder(Orders order)
    {
        int orderId = getNextId("ordernum");
        order.setOrderid(orderId);

        order.setOrderdate(new Date());

        order.setTotalprice(cartMapper.getSubTotal(order.getUserid()));
        List<Cart> cartList = cartService.getCartList(order.getUserid());

        for (int i = 0;i < cartList.size();i++) {
            //插入LineItem
            Lineitem lineitem = new Lineitem();
            lineitem.setOrderid(orderId);
            lineitem.setLinenum(i+1);
            lineitem.setItemid(cartList.get(i).getItemid());
            lineitem.setQuantity(cartList.get(i).getQuantity());
            lineitem.setUnitprice(cartList.get(i).getListprice());
            lineitemMapper.insert(lineitem);
            //更新库存数量
            Inventory inventory = new Inventory();
            inventory.setItemid(cartList.get(i).getItemid());
            inventory.setQty(cartList.get(i).getQuantity());
            inventoryMapper.updateInventoryQuantity(inventory);
        }
        //insertOrderStatus 方法
        Orderstatus orderstatus = new Orderstatus();
        orderstatus.setOrderid(orderId);
        orderstatus.setLinenum(orderId);
        orderstatus.setStatus("P"); //写死的
        orderstatus.setTimestamp(LocalDate.now());

        //orderstatus.setStatus(accountMapper.getAccountByUserId(order.getUserid()).getStatus());

        orderstatusMapper.insert(orderstatus);

        ordersMapper.insert(order);

        cartService.deleteAllItemOutCart(order.getUserid());

    }

    @Override
    public Orders getOrderByOrderId(int orderId) {
        return ordersMapper.getOrderByOrderId(orderId);
    }

    @Override
    public List<Orders> getOrdersByUserId(String userId) {
        return ordersMapper.getOrdersByUserId(userId);
    }

    @Override
    public int getNextId(String name) {

        Sequence sequence = sequenceMapper.selectById(name);
        if (sequence == null){
            Sequence insertSequence = new Sequence(name,1);
            sequenceMapper.insert(insertSequence);
            return 1;
        }else {
            Sequence updateSequence = new Sequence();
            updateSequence.setName(name);
            int nextId = sequence.getNextid()+1;
            updateSequence.setNextid(nextId);
            sequenceMapper.updateById(updateSequence);
            return nextId;
        }
    }

    @Override
    public List<Orders> getSupplierOrders(String suppid) {
        return ordersMapper.getSupplierOrders(suppid);
    }

}
