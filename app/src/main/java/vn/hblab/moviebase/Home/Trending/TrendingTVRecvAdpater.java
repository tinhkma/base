package vn.hblab.moviebase.Home.Trending;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.hblab.moviebase.Model.TrendingTV;
import vn.hblab.moviebase.R;

import static vn.hblab.moviebase.Network.AppConfig.IMAGE_URL;

public class TrendingTVRecvAdpater extends RecyclerView.Adapter<TrendingTVRecvAdpater.RecyclerViewHolder> {

    private List<TrendingTV.Results> data = new ArrayList<>();

    public TrendingTVRecvAdpater(List<TrendingTV.Results> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_trending, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Picasso.get()
                .load(IMAGE_URL + data.get(position).getPoster_path())
                .resize(500, 750)
                .into(holder.backdropPath);

        holder.originalTitle.setText(data.get(position).getName());
        holder.voteAverage.setText(String.valueOf(data.get(position).getVote_average()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.backdrop_path)
        ImageView backdropPath;
        @BindView(R.id.vote_average)
        TextView voteAverage;
        @BindView(R.id.original_title)
        TextView originalTitle;

        public RecyclerViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}
