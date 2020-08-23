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
public class Sequence implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String name;

    private Integer nextid;

    public Sequence(String name,int nextid)
    {
        this.name = name;
        this.nextid = nextid;
    }
    public Sequence() {
    }

}
