package org.csu.petstoreplus.petstore.utils;

public class ReturnEntity {
    private Integer status;
    private String msg;
    private Object obj;

    public static ReturnEntity build() {
        return new ReturnEntity();
    }

    public static ReturnEntity ok(String msg) {
        return new ReturnEntity(200, msg, null);
    }

    public static ReturnEntity ok(String msg, Object obj) {
        return new ReturnEntity(200, msg, obj);
    }

    public static ReturnEntity error(String msg) {
        return new ReturnEntity(500, msg, null);
    }

    public static ReturnEntity error(String msg, Object obj) {
        return new ReturnEntity(500, msg, obj);
    }

    private ReturnEntity() {
    }

    private ReturnEntity(Integer status, String msg, Object obj) {
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

    public Integer getStatus() {
        return status;
    }

    public ReturnEntity setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ReturnEntity setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getObj() {
        return obj;
    }

    public ReturnEntity setObj(Object obj) {
        this.obj = obj;
        return this;
    }
}
