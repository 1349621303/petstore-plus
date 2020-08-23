package org.csu.petstoreplus.petstore.mapper;

import org.csu.petstoreplus.petstore.entity.Inventory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 观星
 * @since 2020-07-30
 */
public interface InventoryMapper extends BaseMapper<Inventory> {
    //更新库存数量，这个方法会用在 OrderService 中
    void updateInventoryQuantity(Inventory inventory);
}
