package io.buck.githubtrending.data.api;

import io.buck.githubtrending.data.model.TrendingPage;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by buck on 2018/3/13
 */

public interface GithubApi {

    @GET("https://github.com/trending/")
    Call<TrendingPage> getTrending();
}
