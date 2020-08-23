package org.csu.petstoreplus.petstore.service.impl;

import org.csu.petstoreplus.petstore.entity.Syslog;
import org.csu.petstoreplus.petstore.mapper.SyslogMapper;
import org.csu.petstoreplus.petstore.service.ISyslogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 观星
 * @since 2020-07-30
 */
@Service
public class SyslogServiceImpl extends ServiceImpl<SyslogMapper, Syslog> implements ISyslogService {
    @Resource
    private SyslogMapper syslogMapper;

    @Override
    public void insertSyslog(Syslog syslog) {
        syslogMapper.insertSyslog(syslog);
    }

}
