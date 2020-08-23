package org.csu.petstoreplus.petstore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.csu.petstoreplus.petstore.entity.Inventory;
import org.csu.petstoreplus.petstore.entity.Item;
import org.csu.petstoreplus.petstore.mapper.InventoryMapper;
import org.csu.petstoreplus.petstore.mapper.ItemMapper;
import org.csu.petstoreplus.petstore.service.IItemService;
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
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {
    @Resource
    private ItemMapper itemMapper;
    @Resource
    private InventoryMapper inventoryMapper;

    @Override
    public List<Item> getItemListByProduct(String productId) {
        return itemMapper.getItemListByProduct(productId);
    }

    @Override
    public Item getItemById(String itemId) {
        return itemMapper.selectById(itemId);
    }

    @Override
    public int insertItem(Item item)
    {
        //在inventoryMapper层调用insert方法将itemid和qty赋值，其中qty赋值为0，
        //在inventory的service层调用mapper的时候，此时的qty就为0了
        Inventory inventory = new Inventory();
        inventory.setItemid(item.getItemid());
        inventory.setQty(0);
        inventoryMapper.insert(inventory);
        return itemMapper.insert(item);
    }

    @Override
    public int deleteItem(String itemId) {
        Map<String,Object> columnMap = new HashMap<>();
        columnMap.put("itemid",itemId);
        return itemMapper.deleteByMap(columnMap);
    }

    @Override
    public int updateItem(Item item) {
        return itemMapper.update(item,new QueryWrapper<Item>().eq("itemid",item.getItemid()));
    }

    //卖家的查询部分，即通过supplierId来看到对应的Item
    @Override
    public List<Item> getItemListBySupplierId(String supplierId)
    {
        return itemMapper.getItemListBySupplierId(supplierId);
    }

}
