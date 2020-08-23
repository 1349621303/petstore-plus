package org.csu.petstoreplus.petstore.service;

import org.csu.petstoreplus.petstore.entity.Inventory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 观星
 * @since 2020-07-30
 */
public interface IInventoryService extends IService<Inventory> {
    //更新库存数量
    void updateInventoryQuantity(Inventory inventory);

    int updateQtyBySupplier(Inventory inventory);

    Inventory getQtyByItemId(String itemId);
}
