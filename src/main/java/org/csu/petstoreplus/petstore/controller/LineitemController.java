package org.csu.petstoreplus.petstore.controller;

import org.csu.petstoreplus.petstore.entity.Lineitem;
import org.csu.petstoreplus.petstore.service.impl.LineitemServiceImpl;
import org.csu.petstoreplus.petstore.utils.ReturnEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 观星
 * @since 2020-07-30
 */
@RestController
public class LineitemController {
    @Resource
    private LineitemServiceImpl lineitemService;

    @RequestMapping(value = "/getLineitemsByOrderId/{orderId}",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getLineitemsByOrderId(@PathVariable int orderId)
    {
        List<Lineitem> lineitemList = lineitemService.getLineitemsByOrderId(orderId);

        if (lineitemList == null) {
            return ReturnEntity.error("获取Product列表失败");
        }
        return ReturnEntity.ok("获取 Product 列表成功",lineitemList);
    }
}
