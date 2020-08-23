package org.csu.petstoreplus.petstore.mapper;

import org.csu.petstoreplus.petstore.entity.Syslog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 观星
 * @since 2020-07-30
 */
public interface SyslogMapper extends BaseMapper<Syslog> {
    //对日志信息进行插入操作
    void insertSyslog(Syslog syslog);
}
