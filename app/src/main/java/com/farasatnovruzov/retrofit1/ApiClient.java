package com.farasatnovruzov.retrofit1;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    CompositeDisposable compositeDisposable;

    private static Retrofit retrofit=null;
    private static String Base_Url= "https://len.az/";
    public static Retrofit getClient(){
        if(retrofit== null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Base_Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient())
                    .build();
            return retrofit;
        }
        return retrofit;
    }

//    private void loadData() {
//        RestInterface repoAPI = retrofit.create(RestInterface.class);
//
//        compositeDisposable = new CompositeDisposable();
//        compositeDisposable.add(repoAPI.getRepo()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(this::handleResponse)
//        );
//    }
//
//    private void handleResponse(Repo repo) {
////        cryptoModels = new ArrayList<>(cryptoModelList);
//
//        //RecyclerView
////        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
////        recyclerViewAdapter = new RecyclerViewAdapter(cryptoModels);
////        recyclerView.setAdapter(recyclerViewAdapter);
//        return;
//    }


//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//        compositeDisposable.clear();
//    }
//
//    //ApiClient.class
}
