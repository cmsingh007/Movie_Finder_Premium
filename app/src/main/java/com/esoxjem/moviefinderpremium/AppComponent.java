package com.esoxjem.moviefinderpremium;

import com.esoxjem.moviefinderpremium.details.DetailsComponent;
import com.esoxjem.moviefinderpremium.details.DetailsModule;
import com.esoxjem.moviefinderpremium.favorites.FavoritesModule;
import com.esoxjem.moviefinderpremium.listing.ListingComponent;
import com.esoxjem.moviefinderpremium.listing.ListingModule;
import com.esoxjem.moviefinderpremium.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author arunsasidharan
 * @author pulkitkumar
 */
@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        FavoritesModule.class})
public interface AppComponent {
    DetailsComponent plus(DetailsModule detailsModule);

    ListingComponent plus(ListingModule listingModule);
}
