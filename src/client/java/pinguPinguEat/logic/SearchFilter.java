package pinguPinguEat.logic;

import pinguPinguEat.restaurants.CuisineType;
import pinguPinguEat.restaurants.PriceCategory;

public class SearchFilter {

    private final boolean[] filterElements;

    public SearchFilter() {
        filterElements = new boolean[7];
        for (int i = 0; i < 7; i++) {
            filterElements[i] = true;
        }
    }

    public void selectCuisine(CuisineType cuisineType) {
        switch (cuisineType) {
            case GERMAN -> filterElements[0] = true;
            case ITALIAN -> filterElements[1] = true;
            case CHINESE -> filterElements[2] = true;
        }
    }

    public void selectPriceCategory(PriceCategory priceCategory) {
        switch (priceCategory) {
            case INEXPENSIVE -> filterElements[3] = true;
            case MODERATE -> filterElements[4] = true;
            case EXPENSIVE -> filterElements[5] = true;
            case VERY_EXPENSIVE -> filterElements[6] = true;
        }
    }

    public void resetFilter() {
        for (int i = 0; i < 7; i++) {
            filterElements[i] = true;
        }
    }


    public boolean isSelectedCuisineTypeGerman() {
        return filterElements[0];
    }

    public boolean isSelectedCuisineTypeItalian() {
        return filterElements[1];
    }

    public boolean isSelectedCuisineTypeChinese() {
        return filterElements[2];
    }

    public boolean isSelectedPriceInexpensive() {
        return filterElements[3];
    }

    public boolean isSelectedPriceModerate() {
        return filterElements[4];
    }

    public boolean isSelectedPriceExpensive() {
        return filterElements[5];
    }

    public boolean isSelectedPriceVeryExpensive() {
        return filterElements[6];
    }
}
