package com.esoxjem.moviefinderpremium.details;

import com.esoxjem.moviefinderpremium.Review;
import com.esoxjem.moviefinderpremium.Video;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author arun
 */
public interface MovieDetailsInteractor {
    Observable<List<Video>> getTrailers(String id);

    Observable<List<Review>> getReviews(String id);
}
