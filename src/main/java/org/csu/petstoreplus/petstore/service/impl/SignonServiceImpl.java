package org.csu.petstoreplus.petstore.service.impl;

import org.csu.petstoreplus.petstore.entity.Signon;
import org.csu.petstoreplus.petstore.mapper.SignonMapper;
import org.csu.petstoreplus.petstore.service.ISignonService;
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
public class SignonServiceImpl extends ServiceImpl<SignonMapper, Signon> implements ISignonService {
    @Resource
    private SignonMapper signonMapper;

    @Override
    public Signon checkUsername(String username) {
        return signonMapper.selectById(username);
    }

}
