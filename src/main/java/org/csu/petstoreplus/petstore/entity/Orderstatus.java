package org.csu.petstoreplus.petstore.entity;

import java.time.LocalDate;
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
public class Orderstatus implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer orderid;

    private Integer linenum;

    private LocalDate timestamp;

    private String status;


}
