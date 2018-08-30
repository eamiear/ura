/**
 * @author eamiear
 * @date 2018/7/30 16:31
 */

package com.ura.common.exception;

public class URAException extends RuntimeException{
    private String msg;
    private int code = 500;

    public URAException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public URAException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public URAException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public URAException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
