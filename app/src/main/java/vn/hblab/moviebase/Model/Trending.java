package vn.hblab.moviebase.Model;


import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Trending {

    @Expose
    @SerializedName("total_results")
    private int total_results;
    @Expose
    @SerializedName("total_pages")
    private int total_pages;
    @Expose
    @SerializedName("results")
    private List<Results> results;
    @Expose
    @SerializedName("page")
    private int page;

    public int getTotal_results() {
        return total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public List<Results> getResults() {
        return results;
    }

    public int getPage() {
        return page;
    }

    public static class Results {
        @Expose
        @SerializedName("media_type")
        private String media_type;
        @Expose
        @SerializedName("popularity")
        private double popularity;
        @Expose
        @SerializedName("poster_path")
        private String poster_path;
        @Expose
        @SerializedName("overview")
        private String overview;
        @Expose
        @SerializedName("adult")
        private boolean adult;
        @Expose
        @SerializedName("backdrop_path")
        private String backdrop_path;
        @Expose
        @SerializedName("genre_ids")
        private List<Integer> genre_ids;
        @Expose
        @SerializedName("original_title")
        private String original_title;
        @Expose
        @SerializedName("original_language")
        private String original_language;
        @Expose
        @SerializedName("release_date")
        private String release_date;
        @Expose
        @SerializedName("title")
        private String title;
        @Expose
        @SerializedName("vote_average")
        private double vote_average;
        @Expose
        @SerializedName("vote_count")
        private int vote_count;
        @Expose
        @SerializedName("video")
        private boolean video;
        @Expose
        @SerializedName("id")
        private int id;

        public String getMedia_type() {
            return media_type;
        }

        public double getPopularity() {
            return popularity;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public String getOverview() {
            return overview;
        }

        public boolean getAdult() {
            return adult;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public List<Integer> getGenre_ids() {
            return genre_ids;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public String getRelease_date() {
            return release_date;
        }

        public String getTitle() {
            return title;
        }

        public double getVote_average() {
            return vote_average;
        }

        public int getVote_count() {
            return vote_count;
        }

        public boolean getVideo() {
            return video;
        }

        public int getId() {
            return id;
        }
        @NonNull
        @Override
        public String toString() {
            String str = title + " " + vote_average;
            return str;
        }
    }
}
