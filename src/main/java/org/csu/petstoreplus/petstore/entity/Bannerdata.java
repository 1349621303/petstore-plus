package org.csu.petstoreplus.petstore.entity;

import java.io.Serializable;

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
public class Bannerdata implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String favcategory;

    private String bannername;


}
