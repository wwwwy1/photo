package cn.wwwwy.photo.handler;

import lombok.Data;

/**
 * @author wwwwy
 */
@Data
public class ErrorParamException extends Exception{
    private String msg;

    public ErrorParamException(String msg) {
        this.msg = msg;
    }

    public ErrorParamException() {
    }

}
