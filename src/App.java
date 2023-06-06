import java.util.Random;
import java.util.Scanner;

class body{

    public static void hra(){
        int max_hodnota = 0;
        //popis:
        System.out.println("Hra hadanie cisla. V hre hladas cislo z rozsah ktory si zadal. \n na to aby si ho uhadal zi mozes zvolit lubovony pocet pokusov nie vsak vacsich ako je polovica z rozsahu zaokruhlene nadol.");
    
        //nacitanie cisla ktore je zadane
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Zadaj rozsah: ");
            if(scanner.hasNextInt()){
                max_hodnota = scanner.nextInt();
                System.out.println("Maximalny rozsah zadany.");
                break;
            }
        }
    
        //urcenie nahodneho cisla
        Random random = new Random();
        int random_int = random.nextInt(max_hodnota);
        if (random_int == 0){
            random_int++;
        }
    
        //Nacitanie poctu hodov
        int max_pokusy = 0;
        
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Zadaj rozsah pre pocet pokusov: ");
            if(scanner.hasNextInt()){
                max_pokusy = scanner.nextInt();
                double i = (Math.floor(max_hodnota/2));
                
                //overenie ci cislo je menej ako polovica z max rozsahu
                if (max_pokusy <= i){
                    break;
                }
            }
        }
    
        System.out.println("\nVsetko pripravne. Mozes zacat hrat.\n");
    
        //urcenie nahodneho cisla
        while (true){
            if (max_pokusy > 0){
                int pokus;
    
                while (true){
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Zadaj cislo ktore si myslis ze je spravne: ");
                    if(scanner.hasNextInt()){
                        pokus = scanner.nextInt();
                        break;
                    }
                }
    
                if(pokus == random_int){
                    System.out.println("Spravna hodnota! Spravne cislo je "+random_int);
                }else{
                    System.out.println("Nespravna hodnota pre cislo!");
                    max_pokusy--;
                    System.out.print("Ostava ti este "+max_pokusy+" pokusov.");
                }
                
            }else{
                System.out.println("Koniec. Neuhadol si spravne cislo.\nspravne cislo bolo "+random_int);
                break;
            }
        }
    
        System.out.println("Koniec.\n");

        //hra znovu?
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zchces hrat znova? (ano/nie)");
        String nova_hra = scanner.next();

        //spustenie novej hry ak je o to poziadane
        if(nova_hra.equalsIgnoreCase("ano")){
            body.hra();
        }
    }


}

public class App {
    public static void main(String[] args) throws Exception {
        body.hra();
    }
}
