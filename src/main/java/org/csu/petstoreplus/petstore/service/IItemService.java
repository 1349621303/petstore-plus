package org.csu.petstoreplus.petstore.service;

import org.csu.petstoreplus.petstore.entity.Item;
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
public interface IItemService extends IService<Item> {
    //用于查找Item的所有变量值的方法接口
    List<Item> getItemListByProduct(String productId);
    //通过id来查询Item的方法接口
    Item getItemById(String itemId);
    //【卖家部分】对Item类别进行增加操作的方法接口
    int insertItem(Item item);
    //【卖家部分】对Item类别进行删除操作的方法接口
    int deleteItem(String itemId);
    //【卖家部分】对Item类别进行修改操作的方法接口
    int updateItem(Item item);

    //卖家的查询部分，即通过supplierId来看到对应的Item
    List<Item> getItemListBySupplierId(String supplierId);
}
