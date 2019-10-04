public class Sten_Saks_Papir {

//metode til at slå med
    //Hvis hånd a vinder, returnres 1
    //Hvis hånd b vinder,returneres 2
    //Hvis spillet er uafgjirt, returneres 0
    //Hvis der er fejl returnerer den -1

    int slaa(Haand a, Haand b){     //variabler er bare a og b, for at de er generelle og kan bruges.

        int resultat = -1;
        //man kunne også skrive if-sætningerne således:
        // if( a == Haand.STEN && b == Haand.STEN) { resultat = 0;}
        // if( a == Haand.STEN && b == Haand.SAKS) { resultat = 1;}
        // if( a == Haand.STEN && b == Haand.PAPIR) { resultat = 2;}

        // hånd a slår sten
        //3 if-sætningsblokke i en overordnet if-sætnings-blok
        if(a == Haand.STEN) {
            //anden hånd b være Sten
            if (b == Haand.STEN) { resultat = 0; }
            //anden hånd b være papir
            if (b == Haand.SAKS) { resultat = 1; }
            //anden hånd b være saks
            if (b == Haand.PAPIR) { resultat = 2; }
        }

        if(a == Haand.SAKS) {
            //anden hånd b være Sten
            if (b == Haand.STEN) { resultat = 2; }
            //anden hånd b være papir
            if (b == Haand.SAKS) { resultat = 0; }
            //anden hånd b være saks
            if (b == Haand.PAPIR) { resultat = 1; }
        }

        if(a == Haand.PAPIR) {
            //anden hånd b være Sten
            if (b == Haand.STEN) { resultat = 1; }
            //anden hånd b være papir
            if (b == Haand.SAKS) { resultat = 2; }
            //anden hånd b være saks
            if (b == Haand.PAPIR) { resultat = 0; }
        }

        return resultat;
    }
}
