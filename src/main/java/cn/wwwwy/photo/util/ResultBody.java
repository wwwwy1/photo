package cn.wwwwy.photo.util;

import lombok.Data;

/**
 * @author wwwwy
 */
@Data
public class ResultBody {
    private int code;
    private String msg;
    private Object data;

    public ResultBody(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultBody(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultBody(int code) {
        this.code = code;
    }

    public static ResultBody error(String msg){
        return new ResultBody(500,msg);
    }

    public static ResultBody error(int code){
        return new ResultBody(code);
    }

    public static ResultBody error(){
        return new ResultBody(500);
    }

    public static ResultBody success(){
        return new ResultBody(200);
    }

    public static ResultBody success(String msg,Object data){
        return new ResultBody(200,msg,data);
    }

    public static ResultBody success(Object data){
        return new ResultBody(200,"success",data);
    }
}
