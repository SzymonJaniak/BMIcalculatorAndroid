package com.example.kalkulatorbmi;

public class Obliczenia {
    public double ObliczBMI(double wzrost, double waga){

     if(wzrost <= 0 || waga <= 0){
         return 0;
     }
     else {
         return waga / ((wzrost / 100) * (wzrost / 100));
     }
     }

    public String InterpretujBMI(double bmi){
        if (bmi == 0) {
            return "Błąd nieprawidłowe dane";
        }
        else if(bmi < 18.5){
            return "Niedowaga";
        } else if ( 18.5 <= bmi && bmi <24.9) {
            return "Waga prawidłowa";
        } else if (25 <= bmi && bmi < 29.9) {
            return "Nadwaga";
        }  else{
            return "Otyłość";
        }
    }

}
