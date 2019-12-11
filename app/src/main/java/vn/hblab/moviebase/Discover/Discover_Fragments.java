package vn.hblab.moviebase.Discover;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import vn.hblab.moviebase.Network.ApiService;
import vn.hblab.moviebase.R;
import vn.hblab.moviebase.Home.MainActivity;

public class Discover_Fragments extends Fragment {

    private MainActivity activity;
    private ApiService apiService;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public static Discover_Fragments newInstance(MainActivity activity) {
        Bundle args = new Bundle();
        Discover_Fragments fragments = new Discover_Fragments();
        fragments.activity = activity;
        fragments.setArguments(args);
        return fragments;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.discover_fragments, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }


}
