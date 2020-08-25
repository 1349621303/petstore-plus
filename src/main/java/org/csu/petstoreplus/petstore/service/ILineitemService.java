package org.csu.petstoreplus.petstore.service;

import org.csu.petstoreplus.petstore.entity.Lineitem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 观星
 * @since 2020-08-25
 */
public interface ILineitemService extends IService<Lineitem> {
    List<Lineitem> getLineitemsByOrderId(int orderId);

}
