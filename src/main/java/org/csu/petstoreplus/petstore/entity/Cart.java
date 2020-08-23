package org.csu.petstoreplus.petstore.entity;

import java.math.BigDecimal;
import java.io.Serializable;
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
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userid;

    private String itemid;

    private String productid;

    private String name;

    private Boolean instock;

    private int quantity;

    private Double listprice;

    private Double total;
}
