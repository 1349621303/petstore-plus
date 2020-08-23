package org.csu.petstoreplus.petstore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.csu.petstoreplus.petstore.entity.Category;
import org.csu.petstoreplus.petstore.mapper.CategoryMapper;
import org.csu.petstoreplus.petstore.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 观星
 * @since 2020-07-30
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    //用于查找Category的所有变量值的方法接口实现
    @Override
    public List<Category> getCategoryList(){
        //返回一个mapper映射
        return categoryMapper.selectList(null);
    }

    //通过id来查询Category的方法接口的实现
    @Override
    public Category getCategoryById(String categoryId)
    {
        return categoryMapper.selectById(categoryId);
    }

    //【卖家部分】对Category类别进行增加操作
    @Override
    public int insertCategory(Category category)
    {
        return categoryMapper.insert(category);
    }

    @Override
    public int deleteCategory(String categoryId)
    {
        Map<String,Object> columnMap = new HashMap<>();
        columnMap.put("catid",categoryId);
        return categoryMapper.deleteByMap(columnMap);
    }

    @Override
    public int updateCategory(Category category)
    {
        //此方法修改category下面的所有有数据的列
        return categoryMapper.update(category, new QueryWrapper<Category>()
                .eq("catid",category.getCatid()));
    }
}