package com.bjpn.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Haisong Jiang
 * @Date: 2024/03/07/14:36
 * @Description:
 */
public class ResultObject {
    private Integer resultCode;
    private String resultMsg;
    private Map<String,Object> resultMap = new HashMap();
    //这是工具类  用来返回通用的异步处理器函数  返回确认信息
    //增  删  改  只需要成功与否的信息即可
    //map集合用来保存数据到时候返回给调用处
    //用做确认异步处理器函数是否操作成功
    //在某些异步处理器中 会出现成功后携带数据传递给页


    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public void setResultMap(String key,Object value) {
        this.resultMap.put(key, value);
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultObject that = (ResultObject) o;
        return Objects.equals(resultCode, that.resultCode) &&
                Objects.equals(resultMsg, that.resultMsg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultCode, resultMsg);
    }
}
