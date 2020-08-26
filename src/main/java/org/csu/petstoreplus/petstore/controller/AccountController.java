package org.csu.petstoreplus.petstore.controller;


import com.alibaba.fastjson.JSONObject;
import org.csu.petstoreplus.petstore.entity.Account;
import org.csu.petstoreplus.petstore.entity.Signon;
import org.csu.petstoreplus.petstore.service.impl.AccountServiceImpl;
import org.csu.petstoreplus.petstore.service.impl.SignonServiceImpl;
import org.csu.petstoreplus.petstore.utils.ReturnEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 观星
 * @since 2020-08-26
 */
@RestController
public class AccountController {
    @Resource
    private AccountServiceImpl accountService;
    @Resource
    private SignonServiceImpl signonService;
    @Resource
    private HttpServletRequest request;

    @RequestMapping(value = "/signIn",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity signIn(@RequestBody Map<String,String> map)
    {
        JSONObject data = new JSONObject();
        // map.put("userId", usernmae);
        // map.put("password", password);
        Account result = accountService.getAccountByUserIdAndPassword(map.get("userId"),map.get("password"));

        if (result != null)
        {
            HttpSession session = request.getSession();
            session.setAttribute("account",result);
            session.setAttribute("userId",result.getUserid());
            // data.put("result",result);
            return ReturnEntity.ok("用户登录成功",result);
        }
        else {
            return ReturnEntity.error("用户名或密码错误");
        }
    }

    @RequestMapping(value = "signOut",method = RequestMethod.DELETE)
    @ResponseBody
    public ReturnEntity signOut()
    {
        JSONObject data = new JSONObject();
        HttpSession session = request.getSession();
        session.removeAttribute("userId");
        data.put("account",null);
        return ReturnEntity.ok("用户已登出",data);
    }


    //用户注册
    @RequestMapping(value = "signUp",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity signUp(@RequestBody Account account)
    {
        JSONObject data = new JSONObject();
        String username = account.getUserid();

        Signon signon = signonService.checkUsername(username);

        if(signon != null)
        {
            return ReturnEntity.error("注册失败，用户名已存在");
        }
        else {
            accountService.insertAccount(account);
            data.put("userid",account.getUserid());
            return ReturnEntity.ok("",data);
        }
    }


    @RequestMapping(value = "/getAccountByName",method = RequestMethod.POST)
    @ResponseBody
    public  ReturnEntity getAccountByName(String usernmae){
        System.out.println(usernmae);
        Account result = accountService.getAccountByUserId(usernmae);
        JSONObject data = new JSONObject();

        if (result != null)
        {
//            HttpSession session = request.getSession();
//            session.setAttribute("account",result);
            data.put("result",result);
            return ReturnEntity.ok("获取用户成功",data);
        }
        else {
            return ReturnEntity.error("用户名或密码错误");
        }

    }

    //用来检查用户名
    @RequestMapping(value = "/checkUsername",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity checkUsername(String userId)
    {
        Signon signon = signonService.checkUsername(userId);
        if (signon != null){
            return ReturnEntity.ok("用户名合法",true);
        }else {
            return ReturnEntity.error("用户名已存在");
        }
    }

    @RequestMapping(value = "updateUserInfo",method = RequestMethod.PUT)
    @ResponseBody
    public ReturnEntity updateUserInfo(@RequestBody Account account)
    {
        JSONObject data = new JSONObject();
        HttpSession session = request.getSession();
        Account accountSession=(Account) session.getAttribute("account");
        //是否登录判断
        if (accountSession==null ){
            return ReturnEntity.error("请登录后访问");
        }
        accountService.updateAccount(account);
        session.setAttribute("account",account);

        data.put("account",account);

        return ReturnEntity.ok("用户信息已更新",data);
    }

    @RequestMapping(value = "getUserInfo",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getUserInfo(@RequestBody Account account)
    {
        JSONObject data = new JSONObject();

        HttpSession session = request.getSession();
        Account accountSession=(Account) session.getAttribute("account");
        //是否登录判断
        if (accountSession ==null ){
            return ReturnEntity.error("请登录后访问");
        }

        Account result = accountService.getAccountByUserId(account.getUserid());


        data.put("account",result);
        return ReturnEntity.ok("用户个人信息初始化成功",data);
    }


}
