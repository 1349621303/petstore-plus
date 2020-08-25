package org.csu.petstoreplus.petstore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.csu.petstoreplus.petstore.entity.Lineitem;
import org.csu.petstoreplus.petstore.entity.Product;
import org.csu.petstoreplus.petstore.mapper.LineitemMapper;
import org.csu.petstoreplus.petstore.service.ILineitemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 观星
 * @since 2020-08-25
 */
@Service
public class LineitemServiceImpl extends ServiceImpl<LineitemMapper, Lineitem> implements ILineitemService {
    @Resource
    private LineitemMapper lineitemMapper;

    @Override
    public List<Lineitem> getLineitemsByOrderId(int orderId) {
        return lineitemMapper.selectList(new QueryWrapper<Lineitem>().eq("orderId",orderId));
    }
}
