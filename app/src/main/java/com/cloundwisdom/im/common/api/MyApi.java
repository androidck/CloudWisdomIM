package com.cloundwisdom.im.common.api;


import com.cloundwisdom.im.common.base.BaseResponse;
import com.cloundwisdom.im.modules.entry.NewsEntry;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @创建者 CSDN_LQR
 * @描述 server端api
 */

public interface MyApi {


/*    //登录
    @POST("user/login")
    Observable<LoginResponse> login(@Body RequestBody body);*/

    @GET("?key=45b9e6a580d942b96e034bb207093193")
    Observable<BaseResponse<List<NewsEntry>>> getNewsList(@Query("num") int num, @Query("page") int page);
}
