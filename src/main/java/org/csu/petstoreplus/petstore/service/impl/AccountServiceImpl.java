package org.csu.petstoreplus.petstore.service.impl;

import org.csu.petstoreplus.petstore.entity.Account;
import org.csu.petstoreplus.petstore.mapper.AccountMapper;
import org.csu.petstoreplus.petstore.service.IAccountService;
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
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {
    //引入Mapper
    @Resource
    private AccountMapper accountMapper;

    @Override
    public Account getAccountByUserId(String userId)
    {
        return accountMapper.getAccountByUserId(userId);
    }

    @Override
    public Account getAccountByUserIdAndPassword(String userId,String password)
    {
        Account account = new Account();
        account.setUserid(userId);
        account.setPassword(password);
        return accountMapper.getAccountByUserIdAndPassword(account);
    }

    @Override
    public void insertAccount(Account account) {
        accountMapper.insertAccount(account);
        accountMapper.insertProfile(account);
        accountMapper.insertSignon(account);
    }

    @Override
    public void updateAccount(Account account)
    {
        accountMapper.updateAccount(account);
        accountMapper.updateProfile(account);
        accountMapper.updateSignon(account);
    }

}
