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
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    // 不声明主键，那么 mp 就不会识别出这是一个主键，
    // 从而一些根据主键而调用的方法就不会生效，
    // 例如 getCategoryById 这个方法就涉及到这个
    @TableId
    private String productid;

    private String category;

    private String name;

    private String descn;


}
