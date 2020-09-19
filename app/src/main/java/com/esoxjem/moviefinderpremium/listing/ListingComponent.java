package com.esoxjem.moviefinderpremium.listing;

import com.esoxjem.moviefinderpremium.listing.sorting.SortingDialogFragment;
import com.esoxjem.moviefinderpremium.listing.sorting.SortingModule;

import dagger.Subcomponent;

/**
 * @author arunsasidharan
 */
@ListingScope
@Subcomponent(modules = {ListingModule.class, SortingModule.class})
public interface ListingComponent {
    MoviesListingFragment inject(MoviesListingFragment fragment);

    SortingDialogFragment inject(SortingDialogFragment fragment);
}
