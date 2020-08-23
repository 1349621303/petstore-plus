package org.csu.petstoreplus.petstore.mapper;

import org.csu.petstoreplus.petstore.entity.Item;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 观星
 * @since 2020-07-30
 */
public interface ItemMapper extends BaseMapper<Item> {
    //通过productId获取item列表
    List<Item> getItemListByProduct(String productId);
    //通过具体的一个itemId来获取到某一个对应的item
    Item getItem(String itemId);

    //卖家查询他自己的item
    List<Item> getItemListBySupplierId(String supplierId);
}
