package com.cp.helloworldx.android.architect.network.retrofit;

import java.io.Serializable;

/**
 * created by cp on 2018/10/26.
 */
public class HttpResponse<T extends Object> extends Object implements Serializable {

    public int errorCode;
    public String errorMsg;
    public T data;
}
