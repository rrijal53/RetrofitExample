package com.rowsun.retrofitexample.datamanager;

import com.rowsun.retrofitexample.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by roshanrijal on 2/15/18.
 */

public interface ApiInterface {
    @GET("abc.json")
    Call<List<Student>> getStudentsList();
}
