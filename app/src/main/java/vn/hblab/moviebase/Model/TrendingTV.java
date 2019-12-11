package vn.hblab.moviebase.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrendingTV {

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
        @SerializedName("origin_country")
        private List<String> origin_country;
        @Expose
        @SerializedName("overview")
        private String overview;
        @Expose
        @SerializedName("backdrop_path")
        private String backdrop_path;
        @Expose
        @SerializedName("original_language")
        private String original_language;
        @Expose
        @SerializedName("genre_ids")
        private List<Integer> genre_ids;
        @Expose
        @SerializedName("poster_path")
        private String poster_path;
        @Expose
        @SerializedName("first_air_date")
        private String first_air_date;
        @Expose
        @SerializedName("vote_average")
        private double vote_average;
        @Expose
        @SerializedName("vote_count")
        private int vote_count;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("id")
        private int id;
        @Expose
        @SerializedName("original_name")
        private String original_name;

        public String getMedia_type() {
            return media_type;
        }

        public double getPopularity() {
            return popularity;
        }

        public List<String> getOrigin_country() {
            return origin_country;
        }

        public String getOverview() {
            return overview;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public List<Integer> getGenre_ids() {
            return genre_ids;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public String getFirst_air_date() {
            return first_air_date;
        }

        public double getVote_average() {
            return vote_average;
        }

        public int getVote_count() {
            return vote_count;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public String getOriginal_name() {
            return original_name;
        }
    }
}
