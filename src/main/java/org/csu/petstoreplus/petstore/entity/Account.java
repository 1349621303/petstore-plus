package org.csu.petstoreplus.petstore.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 
 * </p>
 *
 * @author 观星
 * @since 2020-07-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String userid;

    private String email;

    private String firstname;

    private String lastname;

    private String status;

    private String addr1;

    private String addr2;

    private String city;

    private String state;

    private String zip;

    private String country;

    private String phone;

    //接下来我们引入表signon和profile到AccountService中，相当于三表合一
    //这样做很有必要，因为可以将代码的封装性做得更好，也便于我们在控制器中的方法调用

    //signon表的列
    //注意:@TableField(exist = false)注解加载bean属性上，表示当前属性不是数据库的字段，
    //但是在项目中必须使用，这样在新增等使用bean的时候，mybatis-plus就会忽略这个，不会报错
    //比如在这里，我们将signon和profile表中有而在account表中没有的变量引入(@TableField属于MyBatis-Plus中的注解)
    @TableField(exist = false)
    private String password;

    //profile表的列
    @TableField(exist = false)
    private String langpref;
    @TableField(exist = false)
    private String favcategory;
    @TableField(exist = false)
    private Integer mylistopt;
    @TableField(exist = false)
    private Integer banneropt;

//    // 这个集合里面返回角色，暂时制为空
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    // 账号是否没有过期【true代表没有】
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    // 账号是否没有被锁定【true代表没有】
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    // 密码是否没有过期【true代表没有】
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    //isEnabled方法用于判断用户是否可用
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
