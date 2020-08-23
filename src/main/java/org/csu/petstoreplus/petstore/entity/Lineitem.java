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
public class Lineitem implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer orderid;

    private Integer linenum;

    private String itemid;

    private Integer quantity;

    private double unitprice;


}
