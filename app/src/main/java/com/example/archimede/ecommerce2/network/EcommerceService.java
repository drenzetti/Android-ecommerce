package com.example.archimede.ecommerce2.network;

import com.example.archimede.ecommerce2.data.Category;
import com.example.archimede.ecommerce2.data.Product;
import com.example.archimede.ecommerce2.data.User;
import com.example.archimede.ecommerce2.data.UserRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by archimede on 05/07/17.
 */

public interface EcommerceService {

    @Headers("Content-Type: application/json")
    @GET("product")
    Call<List<Product>> listProduct();

    @POST("login")
    Call<User> login(@Body UserRequest user);

    @Headers("Content-Type: application/json")
    @GET("categories")
    Call<List<Category>> listCategory();

}
