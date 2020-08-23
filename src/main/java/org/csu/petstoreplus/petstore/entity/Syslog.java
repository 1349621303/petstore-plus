package org.csu.petstoreplus.petstore.entity;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Date;

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
public class Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String operation;

    private String method;

    private String params;

    private Date createdate;

    private String ip;

    public Syslog(String username,String operation,String method,String params,Date createdate,String ip){
        this.username = username;
        this.operation = operation;
        this.method = method;
        this.params = params;
        this.createdate = createdate;
        this.ip = ip;
    }

}
