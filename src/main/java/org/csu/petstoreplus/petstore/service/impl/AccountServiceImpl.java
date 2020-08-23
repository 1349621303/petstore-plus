package org.csu.petstoreplus.petstore.service.impl;

import org.csu.petstoreplus.petstore.entity.Account;
import org.csu.petstoreplus.petstore.mapper.AccountMapper;
import org.csu.petstoreplus.petstore.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 观星
 * @since 2020-07-30
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

}
