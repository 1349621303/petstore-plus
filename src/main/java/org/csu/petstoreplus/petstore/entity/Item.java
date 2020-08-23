package org.csu.petstoreplus.petstore.entity;

import java.math.BigDecimal;
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
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String itemid;

    private String productid;

    private BigDecimal listprice;

    private BigDecimal unitcost;

    private Integer supplier;

    private String status;

    private String attr1;

    private String attr2;

    private String attr3;

    private String attr4;

    private String attr5;

    @TableField(exist = false)
    private String productname;

    @TableField(exist = false)
    private String suppname;
}
