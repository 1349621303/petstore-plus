package org.csu.petstoreplus.petstore.service.impl;

import org.csu.petstoreplus.petstore.entity.Inventory;
import org.csu.petstoreplus.petstore.mapper.InventoryMapper;
import org.csu.petstoreplus.petstore.service.IInventoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 观星
 * @since 2020-07-30
 */
@Service
public class InventoryServiceImpl extends ServiceImpl<InventoryMapper, Inventory> implements IInventoryService {
    @Resource
    private InventoryMapper inventoryMapper;

    // updateInventoryQuantity？？？？？？？？？
    @Override
    public void updateInventoryQuantity(Inventory inventory) {
        inventoryMapper.updateInventoryQuantity(inventory);
    }

    @Override
    public int updateQtyBySupplier(Inventory inventory) {
        return inventoryMapper.updateById(inventory);
    }

    @Override
    public Inventory getQtyByItemId(String itemId) {
        return inventoryMapper.selectById(itemId);
    }
}
