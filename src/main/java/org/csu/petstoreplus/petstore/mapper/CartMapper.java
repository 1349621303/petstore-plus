package org.csu.petstoreplus.petstore.mapper;

import org.apache.ibatis.annotations.Param;
import org.csu.petstoreplus.petstore.entity.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 观星
 * @since 2020-07-30
 */
public interface CartMapper extends BaseMapper<Cart> {
    //计算整个购物车的总金额
    public Double getSubTotal(String userId);
    //对某一用户的购物车进行数量和总金额的更新 @Param("userId")是指在xml配置文件中不用指定该变量的类型
    public int updateCart(@Param("userId") String userId, @Param("itemId") String itemId, @Param("quantity") int quantity);

}
