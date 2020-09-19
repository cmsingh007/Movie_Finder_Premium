package com.esoxjem.moviefinderpremium.listing;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.esoxjem.moviefinderpremium.Api;
import com.esoxjem.moviefinderpremium.Movie;
import com.esoxjem.moviefinderpremium.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author arun
 */
public class MoviesListingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Object> movies;
    private Context context;
    private MoviesListingView view;

    private static final int ITEM_TYPE_COUNTRY = 0;
    private static final int ITEM_TYPE_BANNER_AD = 1;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.movie_poster)
        ImageView poster;
        @BindView(R.id.title_background)
        View titleBackground;
        @BindView(R.id.movie_name)
        TextView name;

        public Movie movie;

        public MyViewHolder(View root) {
            super(root);
            ButterKnife.bind(this, root);
        }

        @Override
        public void onClick(View view) {
            MoviesListingAdapter.this.view.onMovieClicked(movie);
        }
    }

    public MoviesListingAdapter(List<Object> movies, MoviesListingView moviesView) {
        this.movies = movies;
        view = moviesView;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){

            case ITEM_TYPE_BANNER_AD:

                /*View bannerLayoutView = LayoutInflater.from(
                        parent.getContext()).inflate(R.layout.banner_ad_row,
                        parent, false);
                return new AdViewHolder(bannerLayoutView);*/

            case ITEM_TYPE_COUNTRY:

            default:
                context = parent.getContext();
                View rootView = LayoutInflater.from(context).inflate(R.layout.movie_grid_item, parent, false);

                return new MyViewHolder(rootView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holders, int position) {
        int viewType = getItemViewType(position);

        switch (viewType) {
            case ITEM_TYPE_BANNER_AD:

              /*  AdViewHolder bannerHolder = (AdViewHolder) holders;
                AdView adView = (AdView) movies.get(position);
                ViewGroup adCardView = (ViewGroup) bannerHolder.itemView;
                if (adCardView.getChildCount() > 0) {
                    adCardView.removeAllViews();
                }
                if (adView.getParent() != null) {
                    ((ViewGroup) adView.getParent()).removeView(adView);
                }
                adCardView.addView(adView);

                break;*/




            case ITEM_TYPE_COUNTRY:
                //fall through
            default:
                final MyViewHolder holder = (MyViewHolder) holders;
                holder.itemView.setOnClickListener(holder);
                holder.movie = (Movie) movies.get(position);
                holder.name.setText(holder.movie.getTitle());

                RequestOptions options = new RequestOptions()
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                        .priority(Priority.HIGH);

                Glide.with(context)
                        .asBitmap()
                        .load(Api.getPosterPath(holder.movie.getPosterPath()))
                        .apply(options)
                        .into(new BitmapImageViewTarget(holder.poster) {
                            @Override
                            public void onResourceReady(Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
                                super.onResourceReady(bitmap, transition);
                                Palette.from(bitmap).generate(palette -> setBackgroundColor(palette, holder));
                            }
                        });
                break;
        }
    }

    private void setBackgroundColor(Palette palette, RecyclerView.ViewHolder holders) {
        final MyViewHolder holder = (MyViewHolder) holders;
        holder.titleBackground.setBackgroundColor(palette.getVibrantColor(context
                .getResources().getColor(R.color.black_translucent_60)));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class AdViewHolder extends RecyclerView.ViewHolder {

        AdViewHolder(View view) {
            super(view);
        }
    }
}
