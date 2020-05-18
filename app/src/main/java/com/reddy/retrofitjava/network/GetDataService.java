package com.reddy.retrofitjava.network;

import com.reddy.retrofitjava.model.CovidReport;


import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Reddy Tintaya on 5/17/20.
 */
public interface GetDataService {

    @GET("/wp-content/json/api.php#")
    Call<CovidReport> getCovidStats();
}