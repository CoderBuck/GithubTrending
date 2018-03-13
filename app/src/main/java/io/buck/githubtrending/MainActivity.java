package io.buck.githubtrending;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.orhanobut.logger.Logger;

import io.buck.githubtrending.data.api.GithubApi;
import io.buck.githubtrending.data.model.Repo;
import io.buck.githubtrending.data.model.TrendingPage;
import pl.droidsonroids.retrofit2.JspoonConverterFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://github.com/trending/")
                .addConverterFactory(JspoonConverterFactory.create())
                .build();

        GithubApi githubApi = retrofit.create(GithubApi.class);

        Call<TrendingPage> trending = githubApi.getTrending();
        trending.enqueue(new Callback<TrendingPage>() {
            @Override
            public void onResponse(Call<TrendingPage> call, Response<TrendingPage> response) {
                TrendingPage body = response.body();
                Log.d(TAG, "onResponse: body size = " + body.mRepos.size());

                int i = 0;
                for (Repo repo : body.mRepos) {
                    Log.e(TAG, "onResponse: " + i++ );
                    Log.e(TAG, "onResponse: " + repo.toString() );
                    Logger.json(repo.toString());
                }
            }

            @Override
            public void onFailure(Call<TrendingPage> call, Throwable t) {
                Logger.e(t.getMessage());
            }
        });

//        Call<String> trending = githubApi.getTrending();
//        trending.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                String html = response.body();
//                Jspoon jspoon = Jspoon.create();
//                HtmlAdapter<TrendingPage> adapter = jspoon.adapter(TrendingPage.class);
//                TrendingPage trendingPage = adapter.fromHtml(html);
//                int size = trendingPage.mRepos.size();
//                Log.d(TAG, "onResponse: size = " + size);
//                Logger.d("打印 Repo 对象");
//                for (Repo repo : trendingPage.mRepos) {
//                    Logger.json(repo.toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                Logger.d("onFailure: ");
//                Logger.e(t.getMessage());
//            }
//        });
    }
}
