package org.csu.petstoreplus.petstore.controller;


import org.csu.petstoreplus.petstore.entity.Category;
import org.csu.petstoreplus.petstore.service.impl.CategoryServiceImpl;
import org.csu.petstoreplus.petstore.utils.ReturnEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
public class SignonController {
    //@Resource
    // private Category category;
    @Resource
    private CategoryServiceImpl categoryService;

    //@PostMapping("/doLogin")
    @RequestMapping(value = "/doLogin")
    public ReturnEntity login() {
        //return ReturnEntity.error("尚未登录，请登录aaaaaasaaaaaaaaaa！");

        return ReturnEntity.ok("okok",categoryService.getCategoryList());
    }

}
