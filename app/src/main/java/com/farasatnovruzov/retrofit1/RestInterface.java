package com.farasatnovruzov.retrofit1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface RestInterface {



//
//    @GET("v1/timingsByCity?city=Baku&country=Azerbaijan&method=3")
//    Call<Repo> getRepo();



    @GET("api/valute.json")
    Observable<Repo> getRepo();
//    Call<Repo> getRepo();

//    @GET("currencies/13.09.2021.xml")
//    Call<Repo> getXml();

//    @Headers({"Accept: application/json"})
//    @GET("/webservice/xml")
//    Observable<Repo> getXml(@Header("Authorization") String authorization);

}
