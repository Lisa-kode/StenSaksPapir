import java.util.Scanner;
import java.util.logging.Handler;

public class Main {

    public static void main(String[] args) {
        System.out.println("Nu skal vi spille Sten, Saks, Papir!");


        // Når man deklarer en variabel ved hjælp af en klasse, deklares et objekt med klassens egenskaber og metoder
        // Så kan man sætte spillere mod hinanden.
        Haand lisa = Haand.SAKS;
        Haand henrik = Haand.PAPIR;
        Haand benjamin = Haand.SAKS;
        Haand anders = Haand.STEN;


        //hER STARTER SPILLET
        //obejekt baseret på sten/saks/papir-klassen
        Sten_Saks_Papir runde1 = new Sten_Saks_Papir(); //her oprettes et objektet runde1 baseret på klassen sten,saks,papir
        System.out.println(runde1.slaa(Haand.PAPIR, Haand.SAKS)); //( her kunne lisa variabel også være kaldt.)
        System.out.println(runde1.slaa(Haand.PAPIR, Haand.PAPIR));
        System.out.println(runde1.slaa(Haand.PAPIR, Haand.STEN));
        System.out.println(runde1.slaa(benjamin, anders)); //her brugt variabler fra linje 13-16.

//____________________________________________________________________________________________

        //HVIS VI SKAL SPILLE MED COMPUTEREN, RÆKKEFØLGE:
        //1) Indlæse spillerens hånd
        //2) Computer skal genere en hånd
        //3) sammenligne de to hænder med slaa() metoden
        //4) udråber en vinder

        //vinder-statistik - deklareres uden for og før loopen, da den skal følge med undervejs
        int vinderStatistik = 0;
        int uafgjort = 0;


        //løkke, som gentager spillet 3 gange
        for (int runde = 1; runde < 4; runde++) {
            System.out.println("Runde " + runde + ":");

            //1) Indlæse spillerens hånd
            Scanner scanner = new Scanner(System.in);
            Haand spillerensHaand = null; //compiler foretrækker bare vi sætter den til et eller andet
            String spillerenString = scanner.next(); //bruger skal skrive, hvad denne slår
            //Note: her anvendes 'equalsIgnoreCase' så bruger kan indtaste sten, saks, papir uden rette syntax.
            //med andre ord er det ligegyldigt om brugeren indtaster papir, Papir, PAPIR.
            if (spillerenString.equalsIgnoreCase("sten")) {
                spillerensHaand = Haand.STEN;
            }
            if (spillerenString.equalsIgnoreCase("saks")) {     //equalsIgnoreCase  = String kan skrives, som man synes.
                spillerensHaand = Haand.SAKS;
            }
            if (spillerenString.equalsIgnoreCase("papir")) {
                spillerensHaand = Haand.PAPIR;
            }
            System.out.println("Spiller slår " + spillerensHaand);

            //2) Computer skal genere en hånd
            Haand computersHaand = null; //kompleks variabel, som i det her tilfælde er et objekt, fordi den kalder på en klasse - eller her en simpel enum
            int haandInt = (int) (Math.random() * 3);

            if (haandInt == 0) {
                computersHaand = Haand.STEN;
            }
            if (haandInt == 1) {
                computersHaand = Haand.SAKS;
            }
            if (haandInt == 2) {
                computersHaand = Haand.PAPIR;
            }

            System.out.println("Computer slår " + computersHaand);


            //3) sammenligne de to hænder med slaa() metoden
            int resultat = runde1.slaa(spillerensHaand, computersHaand);
            // int resultat = Sten_Saks_Papir.slaa(spillerensHaand, computersHaand);   //denne skrivemåde kan også bruges, hvis metoden er deklareret som static i sten/saks/papir

            //4) udråber en vinder
            System.out.println("Resultat er " + resultat);
            if (resultat == 0) {
                System.out.println("Dvs. spillet er uafgjort.");
            }
            if (resultat == 1) {
                System.out.println("Dvs.Spiller har vundet");
            }
            if (resultat == 2) {
                System.out.println("Dvs.Computeren har vundet");
            }
            if (resultat == -1) {
                System.out.println("Der er sket en fejl");
            }

            //metode hvor brugerens vindertal eller uafgjort regnes sammen
            if(resultat == 1) {
                vinderStatistik ++;
            }
            else if (resultat == 0) {
                uafgjort ++;
            }

        }

        System.out.println("Bruger har vundet " + vinderStatistik + " gange.");
        System.out.println("Computer har vundet " + (3-uafgjort-vinderStatistik) + " gange.");
        System.out.println("Resultatet er uafgjort " + uafgjort + " gange.");

    }
}
