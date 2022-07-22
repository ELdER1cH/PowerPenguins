package pinguPinguEat.logic;

import pinguPinguEat.reservationElement.ReservationSystem;
import pinguPinguEat.restaurantElement.CuisineType;
import pinguPinguEat.restaurantElement.PriceCategory;
import pinguPinguEat.restaurantElement.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantFactory {
    public static List<Restaurant> create() {
        List<Restaurant> list = new ArrayList<>();
        list.add(new Restaurant("Steinheil 16", "Steinheilstraße 16",  CuisineType.GERMAN, PriceCategory.INEXPENSIVE, "Casual restaurant specializing in schnitzel plates & fried sides, plus beer, wine & cocktails.", new ReservationSystem(4, 6), "11am-1am", "https://www.steinheil16.de/", 1));
        list.add(new Restaurant("HeimWerk Schwabing", "Friedrichstraße 27 Ecke, Hohenzollernstraße", CuisineType.GERMAN, PriceCategory.MODERATE, "", new ReservationSystem(4, 6), "11:30am-12pm", "http://www.heimwerk-restaurant.de/", 2));
        list.add(new Restaurant("Augustiner am Platzl", "Orlandostraße 5 · Near the Hofbräuhaus am Platzl", CuisineType.GERMAN, PriceCategory.MODERATE, "", new ReservationSystem(4, 6), "11am-11pm", "http://www.augustiner-am-platzl.de/", 3));
        list.add(new Restaurant("Andy's Krablergarten", "Thalkirchner Str. 2", CuisineType.GERMAN, PriceCategory.INEXPENSIVE, "Relaxed restaurant & beer garden serving hearty Bavarian sides, grills & schnitzels.", new ReservationSystem(4, 6), "12am-10pm", "http://www.andyskrablergarten.de/", 4));
        list.add(new Restaurant("Bratwurstherzl", "Dreifaltigkeitspl. 1 · Near the Viktualienmarkt", CuisineType.GERMAN, PriceCategory.MODERATE, "Bavarian-Franconian restaurant in 17th-century brick vault, with rich, hearty fare & beer garden.", new ReservationSystem(4, 6), "10am-11pm", "http://www.bratwurstherzl.de/", 5));
        list.add(new Restaurant("Spezlwirtschaft Altstadt", "Ledererstraße 3 · Near the Hofbräuhaus am Platzl", CuisineType.GERMAN, PriceCategory.MODERATE, "", new ReservationSystem(4, 6), "", "", 6));
        list.add(new Restaurant("Ristorante", "Leopoldstraße 87", CuisineType.ITALIAN, PriceCategory.MODERATE, "Standard antipasti, pasta dishes & pizza are offered at this old-fashioned Italian eatery.", new ReservationSystem(4, 6), "11:30am-11pm", "", 7));
        list.add(new Restaurant("Restaurant Italy", "Leopoldstraße 108", CuisineType.ITALIAN, PriceCategory.MODERATE, "Stylish space for classic pasta dishes, pizzas & Italian main courses, w12ith a covered terrace.", new ReservationSystem(4, 6), "11:30am-11pm", "https://restaurant-italy.de/", 8));
        list.add(new Restaurant("Trattoria La Piazza", "Kölner Pl. 7", CuisineType.ITALIAN, PriceCategory.MODERATE, "Antipasti, pasta, pizza & classic Italian mains at a rustic trattoria with a leafy terrace.", new ReservationSystem(4, 6), "12am-11:30pm", "https://trattoria-la-piazza.de/", 9));
        list.add(new Restaurant("Trattoria Donna Maria", "Marktstraße 2", CuisineType.ITALIAN, PriceCategory.MODERATE, "", new ReservationSystem(4, 6), "5pm-10pm", "http://www.trattoria-donna-maria.de/", 10));
        list.add(new Restaurant("Ristorante Pizzeria Al Dente", "Karl-Theodor-Straße 45", CuisineType.ITALIAN, PriceCategory.MODERATE, "", new ReservationSystem(4, 6), "11:30am-10pm", "http://www.aldente-muenchen.de/", 11));
        list.add(new Restaurant("Da Larosa", "Karl-Theodor-Straße 31a", CuisineType.ITALIAN, PriceCategory.MODERATE, "", new ReservationSystem(4, 6), "12am-10:30pm", "https://www.da-larosa.de/", 12));
        list.add(new Restaurant("Restaurant Da Angelo", "Franz-Joseph-Straße 48", CuisineType.ITALIAN, PriceCategory.MODERATE, "Traditional Italian cuisine & wine served in a homey, rustic space with a sun terrace.", new ReservationSystem(4, 6), "12am-11pm", "https://www.italiener-muenchen-schwabing.de/", 13));
        list.add(new Restaurant("RÒ e BUNÌ | Kaiserstrasse", "Kaiserstraße 55", CuisineType.ITALIAN, PriceCategory.MODERATE, "", new ReservationSystem(4, 6), "6pm-11pm", "https://www.roebuni.de/", 14));
        list.add(new Restaurant("Il Gattopardo - Cucina e Vini", "Nordendstraße 58", CuisineType.ITALIAN, PriceCategory.EXPENSIVE, "Classic Italian fare, like homemade pasta, in a family-run venue with an open kitchen & a patio.", new ReservationSystem(4, 6), "6pm-11pm", "http://www.il-gattopardo.de/", 15));
        list.add(new Restaurant("Passaparola Schwabing", "Kaiserstraße 47", CuisineType.ITALIAN, PriceCategory.MODERATE, "", new ReservationSystem(4, 6), "6pm-10pm", "http://www.passaparola-muenchen.de/", 16));
        list.add(new Restaurant("Cenone", "Occamstraße 11", CuisineType.ITALIAN, PriceCategory.MODERATE, "", new ReservationSystem(4, 6), "", "", 17));
        list.add(new Restaurant("Vini e Cibi da Antonio", "Viktoriastraße 25", CuisineType.ITALIAN, PriceCategory.MODERATE, "", new ReservationSystem(4, 6), "9:30am-10pm", "http://www.viniecibi.de/", 18));
        list.add(new Restaurant("Osteria Italiana", "Schellingstraße 62", CuisineType.ITALIAN, PriceCategory.EXPENSIVE, "", new ReservationSystem(4, 6), "12am-11pm", "http://www.osteria.de/", 19));
        list.add(new Restaurant("Il Grappolo", "Adalbertstraße 28", CuisineType.ITALIAN, PriceCategory.MODERATE, "", new ReservationSystem(4, 6), "11:30am-11:30pm", "http://www.il-grappolo.de/", 20));
        list.add(new Restaurant("ROSSINI", "Türkenstraße 76", CuisineType.ITALIAN, PriceCategory.MODERATE, "", new ReservationSystem(4, 6), "12am-11pm", "http://www.rossinifilm.de/", 21));
        list.add(new Restaurant("Pizzeria Ristorante Lachoni", "Leopoldstraße 173", CuisineType.ITALIAN, PriceCategory.MODERATE, "Italian kitchen fare & signature pizzas in a simply decorated dining room with brick walls & art.", new ReservationSystem(4, 6), "11:30am-10:30pm", "http://pizza-lachoni.de/", 22));
        list.add(new Restaurant("Il Tenore", "Falkenturmstraße 10 · Near the Hofbräuhaus am Platzl", CuisineType.ITALIAN, PriceCategory.MODERATE, "Pizza, pasta & Mediterranean dishes, plus Italian wines, in an understated dining room.", new ReservationSystem(4, 6), "12am-10pm", "http://www.osteriailtenore.de/", 23));
        list.add(new Restaurant("Il Borgo", "Georgenstraße 144", CuisineType.ITALIAN, PriceCategory.EXPENSIVE, "Elevated antipasti, pasta, meat & fish, plus Italian wines, in a stylish, white-tablecloth setting.", new ReservationSystem(4, 6), "12am-11pm", "http://www.il-borgo.de/", 24));
        list.add(new Restaurant("Il Sogno", "Kapellenstraße 1 · In Neuhauser Straße", CuisineType.ITALIAN, PriceCategory.MODERATE, "", new ReservationSystem(4, 6), "11am-10pm", "http://www.ilsogno-muenchen.de/", 25));
        list.add(new Restaurant("Fuji Sushi & Noodles Kurfürstenplatz", "Kurfürstenpl. 1A", CuisineType.JAPANESE, PriceCategory.MODERATE, "", new ReservationSystem(4, 6), "11am-10pm", "https://www.fujimunich.de/", 26));
        list.add(new Restaurant("Little Tokyo", "Steinheilstraße 21", CuisineType.JAPANESE, PriceCategory.INEXPENSIVE, "", new ReservationSystem(4, 6), "11am-10pm", "https://www.facebook.com/Little-Tokyo-159757387563516/", 27));
        list.add(new Restaurant("Shoya Izakaya", "Platzl 3 · Near the Hofbräuhaus am Platzl", CuisineType.JAPANESE, PriceCategory.EXPENSIVE, "Classic Japanese dishes like ramen bowls, sushi & meat grills paired with sake in a relaxed space.", new ReservationSystem(4, 6), "12am-9pm", "http://www.shoya.eu/", 28));
        list.add(new Restaurant("Sushi Teno", "Georgenstraße 35", CuisineType.JAPANESE, PriceCategory.MODERATE, "Sushi & Asian specialties are offered at this compact, unassuming restaurant with takeout.", new ReservationSystem(4, 6), "11:30am-9:30pm", "https://sushiteno.de/", 29));
        list.add(new Restaurant("Kaito", "Gabelsbergerstraße 85", CuisineType.JAPANESE, PriceCategory.EXPENSIVE, "Relaxed Japanese eatery serving sushi, noodles & beer in a rustic, brick-and-wood ambiance.", new ReservationSystem(4, 6), "6pm-11pm", "https://kaito-restaurant.com/", 30));
        list.add(new Restaurant("BENTO BOX - München", "Leopoldstraße 42", CuisineType.JAPANESE, PriceCategory.MODERATE, "", new ReservationSystem(4, 6), "11:30am-10pm", "https://www.bentobox.de/sushi-restaurants/muenchen/", 31));
        list.add(new Restaurant("Miyu Sushi Schwabing", "GALERIA (Karstadt, Leopoldstraße 82/1. UG)", CuisineType.JAPANESE, PriceCategory.MODERATE, "", new ReservationSystem(4, 6), "10:30am-8pm", "https://sushi-miyu.de/", 32));
        list.add(new Restaurant("Campanula", "Gabelsbergerstraße 46", CuisineType.JAPANESE, PriceCategory.MODERATE, "Modern venue for typical Japanese dishes like okonomiyaki pancakes & katsu curry, plus cakes.", new ReservationSystem(4, 6), "6pm-10pm", "", 33));
        list.add(new Restaurant("BENTO YA", "Augustenstraße 4", CuisineType.JAPANESE, PriceCategory.MODERATE, "Ramen noodles, sushi & snacks, plus lunch sets & Japanese beer, in a compact, casual setup.", new ReservationSystem(4, 6), "11am-10pm", "http://www.bentoya-muenchen.de/", 34));
        list.add(new Restaurant("Asaka", "Amalienstraße 39", CuisineType.JAPANESE, PriceCategory.MODERATE, "", new ReservationSystem(4, 6), "11:30am-11pm", "http://www.asaka-sushi.de/", 35));
        list.add(new Restaurant("Fujikaiten", "Münchner Freiheit, Münchener Freiheit 4", CuisineType.JAPANESE, PriceCategory.MODERATE, "Sushi, with an all-you-can-eat option, plus pan-Asian dishes, in a dramatic, red-hued space.", new ReservationSystem(4, 6), "11:30am-11:30pm", "http://fujikaiten-sushi.de/", 36));
        list.add(new Restaurant("Kushi-Tei", "Arcisstraße 39", CuisineType.JAPANESE, PriceCategory.MODERATE, "Casual Japanese restaurant offering grilled skewers of meat, vegetables & fish, plus rice dishes.", new ReservationSystem(4, 6), "12am-10pm", "http://kushitei-muenchen.unaux.com/", 37));
        list.add(new Restaurant("Tokami", "Theresienstraße 54 · Near the Pinakothek der Moderne", CuisineType.JAPANESE, PriceCategory.EXPENSIVE, "Classic Japanese eel dishes, BBQ grills & sushi in a contemporary venue with bar & table seating.", new ReservationSystem(4, 6), "12am-10:30pm", "https://tokami-muenchen.eu/", 38));
        list.add(new Restaurant("JaVi - Japanese & Vietnamese", "Schleißheimer Str. 182", CuisineType.JAPANESE, PriceCategory.MODERATE, "Sushi, noodle bowls & coconut curries in a strikingly designed venue with East Asian art & foliage.", new ReservationSystem(4, 6), "11am-11pm", "https://www.javi-restaurant.de/", 39));
        list.add(new Restaurant("Japan Sushi Gourmet", "Karlstraße 56", CuisineType.JAPANESE, PriceCategory.INEXPENSIVE, "Sushi, ramen soups, udon noodles & rice dishes in a straightforward dining room.", new ReservationSystem(4, 6), "11am-9:30pm", "http://www.japan-sushi-gourmet.de/", 40));
        list.add(new Restaurant("UKIYO Sushi & Wine", "Rumfordstraße 6 · Near the Viktualienmarkt", CuisineType.JAPANESE, PriceCategory.MODERATE, "", new ReservationSystem(4, 6), "11:30am-10pm", "http://www.ukiyogermany.com/", 41));
        list.add(new Restaurant("SUSHIYA sansaro", "Amalienstraße 89 · In Amalienpassage", CuisineType.JAPANESE, PriceCategory.EXPENSIVE, "Japanese cuisine with a focus on sushi, with sleekly minimalist decor & a large summer terrace.", new ReservationSystem(4, 6), "6pm-11pm", "https://www.sushiya.de/", 42));
        list.add(new Restaurant("Antep Kebap Döner", "Belgradstraße 78", CuisineType.TURKISH, PriceCategory.INEXPENSIVE, "", new ReservationSystem(4, 6), "10am-9pm", "http://antepkebap-restaurant.business.site/", 43));
        list.add(new Restaurant("Ali Bey Restaurant", "Schraudolphstraße 44", CuisineType.TURKISH, PriceCategory.MODERATE, "", new ReservationSystem(4, 6), "5pm-12am", "alibey-restaurant.de", 44));
        list.add(new Restaurant("TÜRKITCH Köfte & Kebap 4", "Feilitzschstraße 2", CuisineType.TURKISH, PriceCategory.MODERATE, "", new ReservationSystem(4, 6), "11am-12am", "", 45));
        list.add(new Restaurant("Dilan Meze Bar & Restaurant", "Gebsattelstraße 15", CuisineType.TURKISH, PriceCategory.MODERATE, "Contemporary Turkish eatery with a terrace, offering traditional meze & grilled meats & vegetables.", new ReservationSystem(4, 6), "5pm-12am", "", 46));
        list.add(new Restaurant("Döner Öz Urfa", "Theresienstraße 56 · Near the Pinakothek der Moderne", CuisineType.TURKISH, PriceCategory.INEXPENSIVE, "Unpretentious nook offering doner kebabs & house-made baked goods to eat in or take out.", new ReservationSystem(4, 6), "10am-9pm", "doener-oezurfa.de", 47));
        list.add(new Restaurant("Altın Dilim", "Goethestraße 17", CuisineType.TURKISH, PriceCategory.INEXPENSIVE, "Easygoing Turkish locale for doner kebabs, soups & rice dishes, plus desserts like baklava.", new ReservationSystem(4, 6), "6am-1am", "altindilim.de", 48));
        list.add(new Restaurant("Marmaris Restaurant", "Hermann-Lingg-Straße 12", CuisineType.TURKISH, PriceCategory.MODERATE, "Meze appetizer platters, salads, grills & delicate baklava at a stylish Turkish restaurant.", new ReservationSystem(4, 6), "11am-11pm", "", 49));
        list.add(new Restaurant("Ali Baba Restaurant", "Schillerstraße 6", CuisineType.TURKISH, PriceCategory.INEXPENSIVE, "Kebabs, lahmacun pizza, meatballs & other Turkish standards at a simple, family-run restaurant.", new ReservationSystem(4, 6), "8am-10pm", "", 50));
        return list;

    }
}
