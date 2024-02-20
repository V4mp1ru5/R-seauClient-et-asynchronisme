package com.example.myapplication;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.myapplication.http.RetrofitUtil;
import com.example.myapplication.http.Service;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void testSimple() throws IOException {
        Service service = RetrofitUtil.get();
        Call<String> call = service.listRepos("4");
        Response<String> response = call.execute();
        String resultat = response.body();
        Log.i("RETROFIT", String.valueOf(resultat));
    }
}