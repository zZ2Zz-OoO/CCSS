package com.zz.pojo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R<T> {
    private Integer CODE;//1为成功其他为失败
    private String msg;
    private T data;
    private Map map = new HashMap();

    public static <T> R<T> success(T obj) {
        R<T> tr = new R<>();
        tr.data = obj;
        tr.CODE = 1;
        return tr;
    }

    public static <T> R<T> error(String msg) {
        R<T> tr = new R<>();
        tr.CODE = -1;
        tr.msg = msg;
        return tr;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }
}
