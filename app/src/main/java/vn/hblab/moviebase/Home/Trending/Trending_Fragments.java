package vn.hblab.moviebase.Home.Trending;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import vn.hblab.moviebase.Home.MainActivity;
import vn.hblab.moviebase.Model.NowPlaying;
import vn.hblab.moviebase.Model.Trending;
import vn.hblab.moviebase.Model.TrendingTV;
import vn.hblab.moviebase.Network.ApiClient;
import vn.hblab.moviebase.Network.ApiService;
import vn.hblab.moviebase.R;

public class Trending_Fragments extends Fragment {

    @BindView(R.id.rcv_trending)
    RecyclerView rcvTrending;
    @BindView(R.id.rcv_trending_tv)
    RecyclerView rcvTrendingTv;
    @BindView(R.id.rcv_trending_persion)
    RecyclerView rcvTrendingPersion;
    TrendingRecvAdpater adpater;
    TrendingTVRecvAdpater adpaterTV;
    private MainActivity activity;
    private ApiService apiService;
    private NowplayRecvAdpater nowplayRecvAdpater;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public static Trending_Fragments newInstance(MainActivity activity) {
        Bundle args = new Bundle();
        Trending_Fragments fragments = new Trending_Fragments();
        fragments.activity = activity;
        fragments.setArguments(args);
        return fragments;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.trending_fragments, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getTrendingMovie();
        getTrendingTV();
        getNowplaying();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void getTrendingMovie() {
        apiService = ApiClient.getClient(activity.getApplicationContext()).create(ApiService.class);
        String api_key = "2fdb78c6f07fa089423ee3df09491a41";
        compositeDisposable.add(apiService
                .results(api_key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Trending>() {
                    @Override
                    public void onSuccess(Trending trending) {
                        adpater = new TrendingRecvAdpater(trending.getResults());
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false);
                        rcvTrending.setLayoutManager(linearLayoutManager);
                        rcvTrending.setAdapter(adpater);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(activity, "Loi", Toast.LENGTH_SHORT).show();
                    }
                }));
    }

    private void getNowplaying() {
        apiService = ApiClient.getClient(activity.getApplicationContext()).create(ApiService.class);
        String api_key = "2fdb78c6f07fa089423ee3df09491a41";
        compositeDisposable
                .add(apiService
                .now_playing(api_key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<NowPlaying>() {
                    @Override
                    public void onSuccess(NowPlaying nowPlaying) {
                        nowplayRecvAdpater = new NowplayRecvAdpater(nowPlaying.getResults());
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false);
                        rcvTrendingPersion.setLayoutManager(linearLayoutManager);
                        rcvTrendingPersion.setAdapter(nowplayRecvAdpater);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(activity, "Loi", Toast.LENGTH_SHORT).show();
                    }
                }));
    }

    private void getTrendingTV() {
        apiService = ApiClient.getClient(activity.getApplicationContext()).create(ApiService.class);
        String api_key = "2fdb78c6f07fa089423ee3df09491a41";
        compositeDisposable.add(apiService
                .results_TV(api_key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<TrendingTV>() {
                    @Override
                    public void onSuccess(TrendingTV trending) {
                        adpaterTV = new TrendingTVRecvAdpater(trending.getResults());
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false);
                        rcvTrendingTv.setLayoutManager(linearLayoutManager);
                        rcvTrendingTv.setAdapter(adpaterTV);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(activity, "Loi", Toast.LENGTH_SHORT).show();
                    }
                }));
    }
}
