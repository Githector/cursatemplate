import functions.MyLib;

import java.util.Scanner;

public class Ppal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final int NUM_ATLETES = 100;

        String[][] llistaAtletes = new String[NUM_ATLETES][4];
        int[] llistaDorsals = new int[NUM_ATLETES];
        int[][] llistaArribada = new int[NUM_ATLETES][2];
        int numAtletes=0;
        int numDorsal=1;

        long tempsIniciCursa;

        boolean bucle = true;
        while (bucle) {

            MyLib.mostraMenu();
            //Menu
            // 0 - Sortir
            // 1 - Inscriure Participant
            // 2 - Mostra Participants
            // 3 - Comença Cursa
            // 4 - Mostra Resultats.
            int opcio = sc.nextInt();
            sc.nextLine();
            switch (opcio){
                case 0:
                    bucle=false;
                    break;
                case 1:
                    String[] dadesAtleta = new String[4];
                    System.out.print("Escriu el teu nom: ");
                    dadesAtleta[0]=sc.nextLine();
                    System.out.print("Escriu els cognoms");
                    dadesAtleta[1]=sc.nextLine();
                    System.out.print("Escriu la data de naixament: ");
                    dadesAtleta[2]=sc.nextLine();
                    System.out.print("Escriu el teu gènere (M/F): ");
                    dadesAtleta[3]=sc.nextLine();


                    System.out.print("Estàs segur de inscriure a l'atleta?? (S/N)");
                    String respostaInsc = sc.next();
                    if(respostaInsc.charAt(0)=='S'){
                        llistaAtletes[numAtletes][0] = dadesAtleta[0];
                        llistaAtletes[numAtletes][1] = dadesAtleta[1];
                        llistaAtletes[numAtletes][2] = dadesAtleta[2];
                        llistaAtletes[numAtletes][3] = MyLib.calculaCategoria(dadesAtleta);
                        llistaDorsals[numAtletes]=numDorsal;
                        numDorsal++;
                        numAtletes++;
                        System.out.println("L'atleta ha estat registrat correctament");
                    }else{
                        System.out.println("Operació cancel·lada");
                    }
                    break;
                case 2:
                    System.out.print("Introdueix la categoria a mostrar (Intro per veure-les totes) ");
                    String respostaListCat = sc.nextLine();
                    if(respostaListCat.isEmpty()){
                        MyLib.mostraTotsElsParticipants(llistaAtletes);
                    }else{
                        char categoriaIntroduida = respostaListCat.charAt(0);
                        MyLib.mostraParticipantsPerCat(llistaAtletes,categoriaIntroduida);
                    }

                    break;

                case 3:
                    System.out.println("Intro per començar la cursa (0 per sortir)");
                    if(!sc.nextLine().equals("0")){
                        tempsIniciCursa = System.currentTimeMillis();

                        for(int i=0; i<numAtletes; i++){
                            System.out.print("Introdueix el dorsal de l'atleta que arriba (0 per finalitzar): ");
                            int dorsalArribat = sc.nextInt();
                            sc.nextLine();
                            if(dorsalArribat==0){
                                break;
                            }else{
                                llistaArribada[i][0] = dorsalArribat;
                                llistaArribada[i][1] = MyLib.calculaTempsEnSegons(tempsIniciCursa);
                            }

                        }


                    }

                    break;

                case 4:


                    break;



            }


        }

    }

}


//Nom - Cognoms - Data Naixament - Categoria


//                   Femení     -        Masculí
//Fins 18 anys          A                   B
//De 19 a 40            C                   D
//De 41 a 60            E                   F
//Més de 61             G                   H


