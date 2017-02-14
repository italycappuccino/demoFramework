package org.stone.entity;

import java.io.Serializable;

/**
 * Created by liulei on 2017-02-08.
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -3543897801510330657L;
    private boolean           success;
    private int               errorCode;
    private String            errorMsg;
    private T                 value;
    private String            extraInfo;

    public Result() {
        super();
    }

    public Result(T value) {
        super();
        this.success = true;
        this.value = value;
    }

    public Result(int errorCode, String errorMsg) {
        super();
        this.success = false;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Result(boolean success, int errorCode, String errorMsg, T value) {
        super();
        this.success = success;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.value = value;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

}
