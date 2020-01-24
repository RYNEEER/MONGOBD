package facci.juliointriago.mongobd.rest.service;

import java.util.List;

import facci.juliointriago.mongobd.rest.constants.ApiConstants;
import facci.juliointriago.mongobd.rest.model.Post;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MarketService {
    @POST(ApiConstants.MARKET_POST_ENDPOINT)
    Call<Post> InsertPost(@Body Post post);

    @GET(ApiConstants.MARKET_POST_ENDPOINT)
    Call<List<Post>> getPost();
}



