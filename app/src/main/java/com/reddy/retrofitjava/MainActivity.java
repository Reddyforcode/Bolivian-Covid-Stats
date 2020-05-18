package com.reddy.retrofitjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.reddy.retrofitjava.model.CovidReport;
import com.reddy.retrofitjava.model.RetroPhoto;
import com.reddy.retrofitjava.network.GetDataService;
import com.reddy.retrofitjava.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        responseText = (TextView) findViewById(R.id.responseText);


        getCountryCovidStats();
    }

    public void getCountryCovidStats() {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<CovidReport> call = service.getCovidStats();

        call.enqueue(new Callback<CovidReport>() {
            @Override
            public void onResponse(Call<CovidReport> call, Response<CovidReport> response) {
                responseText.setText(response.body().getTotal().toString());
            }

            @Override
            public void onFailure(Call<CovidReport> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                responseText.setText("Error");
            }
        });

    }
}
