module pinguPinguEat {
    requires spring.data.jpa;
    requires java.persistence;
    exports pinguPinguEat.restaurants;
    exports pinguPinguEat.reservationModel;
    exports pinguPinguEat.user;
}