package com.esoxjem.moviefinderpremium.details;

import com.esoxjem.moviefinderpremium.Movie;
import com.esoxjem.moviefinderpremium.Review;
import com.esoxjem.moviefinderpremium.Video;

import java.util.List;

/**
 * @author arun
 */
interface MovieDetailsView {
    void showDetails(Movie movie);

    void showTrailers(List<Video> trailers);

    void showReviews(List<Review> reviews);

    void showFavorited();

    void showUnFavorited();
}
