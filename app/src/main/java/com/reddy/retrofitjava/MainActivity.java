package com.reddy.retrofitjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListPopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.reddy.retrofitjava.model.CovidReport;
import com.reddy.retrofitjava.model.RetroPhoto;
import com.reddy.retrofitjava.model.covidJsonHelpers.Bn;
import com.reddy.retrofitjava.model.covidJsonHelpers.Cb;
import com.reddy.retrofitjava.model.covidJsonHelpers.Ch;
import com.reddy.retrofitjava.model.covidJsonHelpers.Departamento;
import com.reddy.retrofitjava.model.covidJsonHelpers.Lp;
import com.reddy.retrofitjava.model.covidJsonHelpers.Or;
import com.reddy.retrofitjava.model.covidJsonHelpers.Pn;
import com.reddy.retrofitjava.model.covidJsonHelpers.Pt;
import com.reddy.retrofitjava.model.covidJsonHelpers.Sc;
import com.reddy.retrofitjava.model.covidJsonHelpers.Tj;
import com.reddy.retrofitjava.network.GetDataService;
import com.reddy.retrofitjava.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView responseText;
    TextView laPazCasosTextView;

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

                CovidReport report = response.body();
                String fecha = report.getFecha();

                Departamento departamentos = response.body().getDepartamento();
                Lp laPaz = departamentos.getLp();
                Bn beni = departamentos.getBn();
                Cb cocha = departamentos.getCb();
                Ch chuquisaca = departamentos.getCh();
                Or oruro = departamentos.getOr();
                Pn pando = departamentos.getPn();
                Pt potosi = departamentos.getPt();
                Sc santaCruz = departamentos.getSc();
                Tj tarija = departamentos.getTj();

                laPazCasosTextView = findViewById(R.id.laPazCasosTextView);
                laPazCasosTextView.setText(laPaz.getTotal().toString());

                String boliviaCasos = "Casos totales en Bolivia: " + response.body().getTotal().toString();
                responseText.setText(boliviaCasos);
            }

            @Override
            public void onFailure(Call<CovidReport> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                responseText.setText("Error");
            }
        });

    }
}
