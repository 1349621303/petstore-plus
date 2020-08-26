package org.csu.petstoreplus.petstore.mapper;

import org.csu.petstoreplus.petstore.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 观星
 * @since 2020-07-30
 */
public interface AccountMapper extends BaseMapper<Account> {
    Account getAccountByUserId(String userId);

    Account getAccountByUserIdAndPassword(Account account);


    //新增(分别是account,profile和signon表的方法)
    void insertAccount(Account account);
    void insertProfile(Account account);
    void insertSignon(Account account);

    //更新(分别是account,profile和signon表的方法)
    void updateAccount(Account account);
    void updateProfile(Account account);
    void updateSignon(Account account);

}
