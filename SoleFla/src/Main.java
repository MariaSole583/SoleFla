import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        String[] parole = {"sole", "piatti", "flavia", "mangia", "luna"};

        String parola = parole[random.nextInt(parole.length)];

        char[] nascosta = new char[parola.length()];

        for (int i = 0; i < parola.length(); i++)
        {
            nascosta[i] = '_';
        }

        int errori = 0;

        char[] lettereSbagliate = new char[6];
        int numeroSbagliate = 0;

        System.out.println("Ciao, benvenuto nel gioco dell'impiccato, indovina la parola nascosta per vincere un biscottino!");

        while (errori < 6)
        {
            for (int i = 0; i < nascosta.length; i++)
            {
                System.out.print(nascosta[i] + " ");
            }

            System.out.println();

            boolean completata = true;

            for (int i = 0; i < nascosta.length; i++) {
                if (nascosta[i] == '_') {
                    completata = false;
                }
            }

            if (completata) {
                break;
            }

            System.out.print("Inserisci un carattere: ");
            char carattere = input.next().charAt(0);

            boolean presente = false;

            for (int i = 0; i < parola.length(); i++) {

                if (parola.charAt(i) == carattere) {
                    nascosta[i] = carattere;
                    presente = true;
                }
            }


            if (!presente) {

                boolean giaInserita = false;

                for (int i = 0; i < numeroSbagliate; i++) {
                    if (lettereSbagliate[i] == carattere) {
                        giaInserita = true;
                    }
                }

                if (!giaInserita) {
                    lettereSbagliate[numeroSbagliate] = carattere;
                    numeroSbagliate++;
                    errori++;

                    System.out.println("Errore! Errori: " + errori + "/6");
                } else {
                    System.out.println("Hai già inserito questa lettera!");
                }
            }
        }

        boolean vinta = true;

        for (int i = 0; i < nascosta.length; i++) {
            if (nascosta[i] == '_') {
                vinta = false;
            }
        }

        if (vinta) {
            System.out.println("Hai indovinato!");
        } else {
            System.out.println("Hai perso!");
        }

        System.out.println("La parola era: " + parola);
    }
}