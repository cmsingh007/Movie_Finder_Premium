package com.esoxjem.moviefinderpremium.listing.sorting;

/**
 * @author arun
 */
public interface SortingDialogView {
    void setPopularChecked();

    void setNewestChecked();

    void setHighestRatedChecked();

    void setFavoritesChecked();

    void dismissDialog();

}
