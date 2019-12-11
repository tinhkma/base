package vn.hblab.moviebase.Network;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import vn.hblab.moviebase.Model.NowPlaying;
import vn.hblab.moviebase.Model.Trending;
import vn.hblab.moviebase.Model.TrendingPersion;
import vn.hblab.moviebase.Model.TrendingTV;

import static vn.hblab.moviebase.Network.ApiEndPoint.TRENDING_MOVIE;
import static vn.hblab.moviebase.Network.ApiEndPoint.TRENDING_NOWPLAYING;
import static vn.hblab.moviebase.Network.ApiEndPoint.TRENDING_PERSION;
import static vn.hblab.moviebase.Network.ApiEndPoint.TRENDING_TV;

public interface ApiService {

    @Headers("Accept: application/json; charset=utf-8")
    @GET(TRENDING_MOVIE)
    Single<Trending> results (@Query("api_key") String api_key);

    @Headers("Accept: application/json; charset=utf-8")
    @GET(TRENDING_TV)
    Single<TrendingTV> results_TV (@Query("api_key") String api_key);

    @Headers("Accept: application/json; charset=utf-8")
    @GET(TRENDING_PERSION)
    Single<TrendingPersion> results_Persion (@Query("api_key") String api_key);

    @Headers("Accept: application/json; charset=utf-8")
    @GET(TRENDING_NOWPLAYING)
    Single<NowPlaying> now_playing (@Query("api_key") String api_key);
}
