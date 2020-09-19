package com.esoxjem.moviefinderpremium.details;

import com.esoxjem.moviefinderpremium.Review;
import com.esoxjem.moviefinderpremium.ReviewsWrapper;
import com.esoxjem.moviefinderpremium.Video;
import com.esoxjem.moviefinderpremium.VideoWrapper;
import com.esoxjem.moviefinderpremium.network.TmdbWebService;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author arun
 */
class MovieDetailsInteractorImpl implements MovieDetailsInteractor {

    private TmdbWebService tmdbWebService;

    MovieDetailsInteractorImpl(TmdbWebService tmdbWebService) {
        this.tmdbWebService = tmdbWebService;
    }

    @Override
    public Observable<List<Video>> getTrailers(final String id) {
        return tmdbWebService.trailers(id).map(VideoWrapper::getVideos);
    }

    @Override
    public Observable<List<Review>> getReviews(final String id) {
        return tmdbWebService.reviews(id).map(ReviewsWrapper::getReviews);
    }

}
