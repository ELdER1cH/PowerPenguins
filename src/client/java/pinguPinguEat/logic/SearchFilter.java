package pinguPinguEat.logic;

import pinguPinguEat.restaurants.CuisineType;
import pinguPinguEat.restaurants.PriceCategory;

public class SearchFilter {

    private final int[] filterElements;

    public SearchFilter() {
        filterElements = new int[8];
        for (int i = 0; i < 8; i++) {
            filterElements[i] = 1;
        }
    }

    public void selectCuisine(CuisineType cuisineType) {
        switch (cuisineType) {
            case GERMAN -> filterElements[0] = 1;
            case ITALIAN -> filterElements[1] = 1;
            case CHINESE -> filterElements[2] = 1;
        }
    }

    public void selectPriceCategory(PriceCategory priceCategory) {
        switch (priceCategory) {
            case INEXPENSIVE -> filterElements[3] = 1;
            case MODERATE -> filterElements[4] = 1;
            case EXPENSIVE -> filterElements[5] = 1;
            case VERY_EXPENSIVE -> filterElements[6] = 1;
        }
    }

    public void selectRating(int rating) {
        assert (rating >= 1 && rating <= 5);
        filterElements[7] = rating;
    }

    public void resetFilter() {
        for (int i = 0; i < 8; i++) {
            filterElements[i] = 1;
        }
    }

    public void refreshFlter() {
        for (int i = 0; i < 7; i++) {
            filterElements[i] = 0;
        }
    }


    public boolean isSelectedCuisineTypeGerman() {
        return filterElements[0] == 1;
    }

    public boolean isSelectedCuisineTypeItalian() {
        return filterElements[1] == 1;
    }

    public boolean isSelectedCuisineTypeChinese() {
        return filterElements[2] == 1;
    }

    public boolean isSelectedPriceInexpensive() {
        return filterElements[3] == 1;
    }

    public boolean isSelectedPriceModerate() {
        return filterElements[4] == 1;
    }

    public boolean isSelectedPriceExpensive() {
        return filterElements[5] == 1;
    }

    public boolean isSelectedPriceVeryExpensive() {
        return filterElements[6] == 1;
    }

    public int getSelectedRating() {
        return filterElements[7];
    }
}
