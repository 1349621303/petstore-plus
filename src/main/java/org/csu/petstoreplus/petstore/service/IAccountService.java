package org.csu.petstoreplus.petstore.service;

import org.csu.petstoreplus.petstore.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 观星
 * @since 2020-07-30
 */
public interface IAccountService extends IService<Account> {
    //查找:通过账号返回个人的全部信息【买家】
    Account getAccountByUserId(String userId);
    //查找:通过账号和密码来返回account的全部信息【买家】
    Account getAccountByUserIdAndPassword(String userId,String password);
    //新增:用户注册的时候对个人基本信息的填写【买家】
    void insertAccount(Account account);
    //更新:用户登录后在个人主页中对于自己修改后信息的保存【买家】
    void updateAccount(Account account);

}
