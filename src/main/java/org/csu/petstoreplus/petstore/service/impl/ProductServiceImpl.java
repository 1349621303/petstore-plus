package org.csu.petstoreplus.petstore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.csu.petstoreplus.petstore.entity.Product;
import org.csu.petstoreplus.petstore.mapper.ProductMapper;
import org.csu.petstoreplus.petstore.service.IProductService;
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
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> getProductListByCategory(String categoryId)
    {
        return productMapper.selectList(new QueryWrapper<Product>().eq("category",categoryId));
    }

    @Override
    public Product getProductById(String productId) {
        return productMapper.selectById(productId);
    }

    @Override
    public List<Product> searchProductList(String name) {
        return productMapper.selectList(new QueryWrapper<Product>().like("name",name));
    }


    @Override
    public int insertProduct(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public int deleteProduct(String productId) {
        Map<String,Object> columnMap = new HashMap<>();
        columnMap.put("productid",productId);
        return productMapper.deleteByMap(columnMap);
    }

    @Override
    public int updateProduct(Product product) {
        return productMapper.update(product,new QueryWrapper<Product>().eq("productid",product.getProductid()));
    }

}
