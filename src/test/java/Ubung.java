import java.util.Scanner;

public class Ubung {

    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.println("Hallo Welt");


        System.out.println("Bir sayi giriniz");
        String satz = scan.nextLine();

        int summe = 0;

        do {
            System.out.println("Bir sayi daha giriniz");
            int a = scan.nextInt();
            if (a < 2) {
                summe = summe + a;
                System.out.println("Summe= " + summe);
            } else {
                summe = summe - 1;
                System.out.println("Summe=" + summe);
            }
        }while (true);
    }
}
