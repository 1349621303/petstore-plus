package org.csu.petstoreplus.petstore.controller;


import com.alibaba.fastjson.JSONObject;
import org.csu.petstoreplus.petstore.entity.Inventory;
import org.csu.petstoreplus.petstore.service.impl.InventoryServiceImpl;
import org.csu.petstoreplus.petstore.utils.ReturnEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 观星
 * @since 2020-07-30
 */
@RestController
public class InventoryController {
    @Resource
    private InventoryServiceImpl inventoryService;

    @RequestMapping(value = "/getQtyByItemId/{itemId}",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getQtyByItemId(@PathVariable String itemId)
    {
        // JSONObject data = new JSONObject();
        Inventory inventory = inventoryService.getQtyByItemId(itemId);
        // data.put("inventory",inventory);
        return ReturnEntity.ok("获取某一个 item 的库存成功",inventory);
    }

    @RequestMapping(value = "/updateQtyBySupplier",method = RequestMethod.PUT)
    @ResponseBody
    public ReturnEntity updateQtyBySupplier(@RequestBody Inventory inventory)
    {
        JSONObject data = new JSONObject();
        int result = inventoryService.updateQtyBySupplier(inventory);
        data.put("result",result);
        return ReturnEntity.ok("卖家更新某一个 item 的库存成功",data);
    }

}
