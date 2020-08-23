package org.csu.petstoreplus.petstore.service;

import org.csu.petstoreplus.petstore.entity.Category;
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
public interface ICategoryService extends IService<Category> {    //用于查找Category的所有变量值的方法接口
    List<Category> getCategoryList();
    //通过id来查询Category的方法接口
    Category getCategoryById(String categoryId);
    //【卖家部分】对Category类别进行增加操作的方法接口
    int insertCategory(Category category);
    //【卖家部分】对Category类别进行删除操作的方法接口
    int deleteCategory(String categoryId);
    //【卖家部分】对Category类别进行修改操作的方法接口
    int updateCategory(Category category);
}
