package org.csu.petstoreplus.petstore.controller;


import com.alibaba.fastjson.JSONObject;
import org.csu.petstoreplus.petstore.entity.Category;
import org.csu.petstoreplus.petstore.service.impl.CategoryServiceImpl;
import org.csu.petstoreplus.petstore.utils.ReturnEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
public class CategoryController {
    @Resource
    private CategoryServiceImpl categoryService;
    @Resource
    private HttpServletRequest request;

    //映射位置
    @RequestMapping(value = "/getCategoryList",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getCategoryList(){
        HttpSession session = request.getSession();
         session.setAttribute("userId","j2ee");
        List<Category> categoryList = categoryService.getCategoryList();
        if (categoryList == null) {
            return ReturnEntity.error("获取商品列表失败");
        }
        return ReturnEntity.ok("获取商品列表成功",categoryList);
    }

    @RequestMapping(value = "/getCategoryListAll",method = RequestMethod.GET)
    @ResponseBody
    public List<Category> getCategoryListAll()
    {
        JSONObject data = new JSONObject();
        List<Category> categoryList = categoryService.getCategoryList();
        return categoryList;
    }

    @RequestMapping(value = "/getCategoryById",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getCategoryById(String categoryId)
    {
        JSONObject data = new JSONObject();
        Category category = categoryService.getCategoryById(categoryId);
        if (categoryId == null) {
            return ReturnEntity.error("获取商品类别失败");
        }
        data.put("category",category);
        return ReturnEntity.ok("获取商品类别成功",data);
    }


    @RequestMapping(value = "/insertCategory",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity insertCategory(@RequestBody Category category)
    {
        JSONObject data = new JSONObject();
        int result = categoryService.insertCategory(category);
        if (category == null) {
            return ReturnEntity.error("添加商品类别失败");
        }
        data.put("result",result);
        return ReturnEntity.ok("添加商品类别成功",data);
    }

    @RequestMapping(value = "/deleteCategory",method = RequestMethod.DELETE)
    @ResponseBody
    public ReturnEntity deleteCategory(@RequestBody Category category)
    {
        JSONObject data = new JSONObject();
        int result = categoryService.deleteCategory(category.getCatid());
        if (category == null) {
            return ReturnEntity.error("删除商品类别失败");
        }
        data.put("result",result);
        return ReturnEntity.ok("删除商品类别成功",data);
    }

    @RequestMapping(value = "/updateCategory",method = RequestMethod.PUT)
    @ResponseBody
    public ReturnEntity updateCategory(@RequestBody Category category)
    {
        JSONObject data = new JSONObject();
        int result = categoryService.updateCategory(category);
        if (category == null) {
            return ReturnEntity.error("更新商品类别失败");
        }
        data.put("result",result);
        return ReturnEntity.ok("更新商品类别成功",data);
    }

}
