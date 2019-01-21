package com.rongyue.efix.controller.utility.response;

public class UniversalResponse {

    private Integer state;  // state 表示可枚举的状态；status 表示不可确定的状态
    private String message;
    private Object data;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public UniversalResponse(Integer state, String message, Object data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public UniversalResponse() {
    }
}
