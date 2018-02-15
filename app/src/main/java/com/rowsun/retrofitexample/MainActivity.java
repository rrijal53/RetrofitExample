package com.rowsun.retrofitexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.rowsun.retrofitexample.datamanager.ApiClient;
import com.rowsun.retrofitexample.datamanager.ApiInterface;
import com.rowsun.retrofitexample.model.Student;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Call;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.hello)
    TextView hello;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        Log.d("", "onCreate: " + new Student("1", "rsds", "FDfd"));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<Student>> c = apiService.getStudentsList();

        c.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                List<Student> s = response.body();
                hello.setText("Response = " + s);
                Log.d("RESPONSE", "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                Log.d("dfdfd", "onFailure: " + t.getCause());
                t.printStackTrace();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
