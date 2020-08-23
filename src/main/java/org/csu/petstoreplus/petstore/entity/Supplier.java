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
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer suppid;

    private String name;

    private String status;

    private String addr1;

    private String addr2;

    private String city;

    private String state;

    private String zip;

    private String phone;

    @TableField(exist = false)
    private String password;

}
