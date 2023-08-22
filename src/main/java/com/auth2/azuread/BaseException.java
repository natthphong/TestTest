package com.auth2.azuread;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;


public class BaseException extends RuntimeException {
    protected HttpStatus httpStatus;
    private String errorCode;
    private String errorTitle;
    private String errorDesc;
    private String errorMessage;
    private String suffixMsg;
    private Map<String, String> placeholder = new HashMap();

    public BaseException(HttpStatus httpStatus, String errorCode, String errorDesc, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
        this.errorMessage = errorMessage;
    }

    public BaseException(HttpStatus httpStatus, String errorCode, String errorDesc, String errorMessage, String errorTitle) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
        this.errorMessage = errorMessage;
        this.errorTitle = errorTitle;
    }

    public BaseException(HttpStatus httpStatus, String errorCode) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
    }

    public BaseException(HttpStatus httpStatus, String errorCode, String suffixMsg) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorDesc = suffixMsg;
        this.errorMessage = suffixMsg;
        this.suffixMsg = suffixMsg;
    }

    public BaseException(HttpStatus httpStatus, String errorCode, Map<String, String> placeholder) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.placeholder = placeholder;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorTitle() {
        return this.errorTitle;
    }

    public String getErrorDesc() {
        return this.errorDesc;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getSuffixMsg() {
        return this.suffixMsg;
    }

    public Map<String, String> getPlaceholder() {
        return this.placeholder;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorTitle(String errorTitle) {
        this.errorTitle = errorTitle;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setSuffixMsg(String suffixMsg) {
        this.suffixMsg = suffixMsg;
    }

    public void setPlaceholder(Map<String, String> placeholder) {
        this.placeholder = placeholder;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BaseException)) {
            return false;
        } else {
            BaseException other = (BaseException)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label95: {
                    Object this$httpStatus = this.getHttpStatus();
                    Object other$httpStatus = other.getHttpStatus();
                    if (this$httpStatus == null) {
                        if (other$httpStatus == null) {
                            break label95;
                        }
                    } else if (this$httpStatus.equals(other$httpStatus)) {
                        break label95;
                    }

                    return false;
                }

                Object this$errorCode = this.getErrorCode();
                Object other$errorCode = other.getErrorCode();
                if (this$errorCode == null) {
                    if (other$errorCode != null) {
                        return false;
                    }
                } else if (!this$errorCode.equals(other$errorCode)) {
                    return false;
                }

                Object this$errorTitle = this.getErrorTitle();
                Object other$errorTitle = other.getErrorTitle();
                if (this$errorTitle == null) {
                    if (other$errorTitle != null) {
                        return false;
                    }
                } else if (!this$errorTitle.equals(other$errorTitle)) {
                    return false;
                }

                label74: {
                    Object this$errorDesc = this.getErrorDesc();
                    Object other$errorDesc = other.getErrorDesc();
                    if (this$errorDesc == null) {
                        if (other$errorDesc == null) {
                            break label74;
                        }
                    } else if (this$errorDesc.equals(other$errorDesc)) {
                        break label74;
                    }

                    return false;
                }

                label67: {
                    Object this$errorMessage = this.getErrorMessage();
                    Object other$errorMessage = other.getErrorMessage();
                    if (this$errorMessage == null) {
                        if (other$errorMessage == null) {
                            break label67;
                        }
                    } else if (this$errorMessage.equals(other$errorMessage)) {
                        break label67;
                    }

                    return false;
                }

                Object this$suffixMsg = this.getSuffixMsg();
                Object other$suffixMsg = other.getSuffixMsg();
                if (this$suffixMsg == null) {
                    if (other$suffixMsg != null) {
                        return false;
                    }
                } else if (!this$suffixMsg.equals(other$suffixMsg)) {
                    return false;
                }

                Object this$placeholder = this.getPlaceholder();
                Object other$placeholder = other.getPlaceholder();
                if (this$placeholder == null) {
                    if (other$placeholder != null) {
                        return false;
                    }
                } else if (!this$placeholder.equals(other$placeholder)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof BaseException;
    }



    public String toString() {
        String var10000 = String.valueOf(this.getHttpStatus());
        return "BaseException(httpStatus=" + var10000 + ", errorCode=" + this.getErrorCode() + ", errorTitle=" + this.getErrorTitle() + ", errorDesc=" + this.getErrorDesc() + ", errorMessage=" + this.getErrorMessage() + ", suffixMsg=" + this.getSuffixMsg() + ", placeholder=" + String.valueOf(this.getPlaceholder()) + ")";
    }
}
