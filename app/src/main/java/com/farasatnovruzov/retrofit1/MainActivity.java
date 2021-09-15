package com.farasatnovruzov.retrofit1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.farasatnovruzov.retrofit1.databinding.ActivityMainBinding;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;


public class MainActivity extends AppCompatActivity {
//    https://www.cbar.az/currencies/13.09.2021.xml
//    static final String URL = "https://www.cbar.az/currencies/13.09.2021.xml"


    private ActivityMainBinding binding;
    RecyclerViewAdapter recyclerViewAdapter;
    RestInterface restInterface;
    CompositeDisposable compositeDisposable;
    ArrayList<String> repos;
    Retrofit retrofit;
    Retrofit retrofit1;
//    Response<Repo> response;
//    Repo repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        repos = new ArrayList<String>();


//        retrofit1 = new Retrofit.Builder()
//                .baseUrl("https://www.cbar.az/")
//                .addConverterFactory(SimpleXmlConverterFactory.create())
//                .build();
////                .create(RestInterface.class).getXml("This is a value that will be sent as authorization header");
//        restInterface = retrofit.create(RestInterface.class);
//        try {
//            Response<Repo> response = restInterface.getXml().execute();
//            System.out.println("Request Done");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//




//        Gson gson = new GsonBuilder().setLenient().create();
        String Base_Url = "https://len.az/";

        retrofit = new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();


        loadData();
    }

    private void loadData() {

        RestInterface restInterface = retrofit.create(RestInterface.class);

        compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(restInterface.getRepo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse)
        );
    }

    private void handleResponse(Repo repo) {
//        repos = new ArrayList<>(repos);
//        repo = response.body();
        for (int i = 0; i < repo.valType.get(1).valute.size(); i++) {
            repos.add(i, repo.valType.get(1).valute.get(i).name + " : " + repo.valType.get(1).valute.get(i).value);
        }

//        RecyclerView
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerViewAdapter = new RecyclerViewAdapter(repos);
        binding.recyclerView.setAdapter(recyclerViewAdapter);
        binding.textView.setText(repo.attributes1.name + " : " + repo.attributes1.date);

    }


//        restInterface = retrofit.create(RestInterface.class);
//
//        Call<Repo> call = restInterface.getRepo();
//
//        call.enqueue(new Callback<Repo>() {
//            @Override
//            public void onResponse(Call<Repo> call, Response<Repo> response) {
//                Repo repo = new Repo();
//                repo = response.body();
//                if (!response.isSuccessful()) {
//                    System.out.println(response.code());
//                } else {
//                    System.out.println("" + repo.attributes1.name + "\n");
//                    System.out.println("" + repo.attributes1.date + "\n");
//
//                    for (int i = 0; i < repo.valType.get(1).valute.size(); i++) {
//                        System.out.println("" + repo.valType.get(1).valute.get(i).name + " : " + repo.valType.get(1).valute.get(i).value);
//
////                        System.out.println("" + repo.valType.get(1).valute.get(i).value+ "\n");
//                        repos.add(i, repo.valType.get(1).valute.get(i).name + " : " + repo.valType.get(1).valute.get(i).value);
//
//                        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(repos);
//                        binding.recyclerView.setAdapter(recyclerViewAdapter);
//                        binding.textView.setText(repo.attributes1.name + " : " + repo.attributes1.date);
//                    }
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<Repo> call, Throwable t) {
//            }
//        });


    @Override
    protected void onDestroy() {
        super.onDestroy();

        compositeDisposable.clear();
    }
}


//    private void readXmlFeed() {
//        try {
//
//            // base url - url of web site
//            Retrofit retrofit = new Retrofit.Builder()
//                    .baseUrl(http://www.google.com/)
//                    .client(new OkHttpClient())
//                    .addConverterFactory(SimpleXmlConverterFactory.create())
//                    .build();
//
//            ApiDataInterface apiService = retrofit.create(ApiDataInterface.class);
//
//            Call<Rss> call = apiService.getData();
//            call.enqueue(new Callback<Rss>() {
//
//                @Override
//                public void onResponse(Call<Rss> call, Response<Rss> response) {
//
//                    Log.e("Response success", response.message());
//
//                }
//
//                @Override
//                public void onFailure(Call<Rss> call, Throwable t) {
//                    Log.e("Response fail", t.getMessage());
//                }
//            });
//
//        } catch (Exception e) {
//            Log.e("Exception", e.getMessage());
//        }


    
