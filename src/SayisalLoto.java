import java.util.Random;
import java.util.Scanner;

public class SayisalLoto {
    /*
Proje: Sayısal Loto Uygulaması
       bilet için rastgele n tane sayı üretilsin.
       loto sonucu rastgele n tane sayı ile üretilsin.
       sayısal lotoda tekrarlı sayılar olmamalı.

       n(hane sayısı), sayılar için min ve max değerler
       kullanıcıdan alınsın.

       sonuç ve bilet karşılaştırılsın, kaç eşleşme olduğu
       kullanıcıya bildirilsin.

*/
    public static void main(String[] args) {
        startLoto();
    }

    public static void startLoto() {
        Scanner input = new Scanner(System.in);
        System.out.println("Sayisal Lotonun Kac Haneli Olmasini Istediginizi Giriniz");
        int slots=input.nextInt();

        System.out.println("Sayilar Icin Minimium Deger Giriniz:");
        int min = input.nextInt();

        System.out.println("Sayilar Icin Maksimum Deger Giriniz:");
        int max = input.nextInt();
        //baslangicta hepsi 0
        int [] lotoArr = new int[slots];
        int [] ticketArr = new int[slots];

        Random random = new Random();
        int randomNumber1 = 0;
        int randomNumber2 = 0;
        boolean isRepeated ;

        for (int i = 0; i <slots ; i++) {
            do {
                isRepeated = false;
                randomNumber1 =  random.nextInt(max+1-min)+min;//0-11 arasinda int sayilar 10 dahil [0,10], [5-10] arasinda olsun istiyoruz
                for (int j = 0; j <i; j++) {
                    if (lotoArr[i]==randomNumber1){
                        isRepeated=true;
                        break;
                    }
                }

            }while(isRepeated);
            lotoArr[i] = randomNumber1;

            //loto Arr yi doldur


            do {
                isRepeated = false;
                randomNumber2 =  random.nextInt(max+1-min)+min;//0-11 arasinda int sayilar 10 dahil [0,10], [5-10] arasinda olsun istiyoruz
                for (int j = 0; j <i; j++) {
                    if (lotoArr[i]==randomNumber2){
                        isRepeated=true;
                        break;
                    }
                }

            }while(isRepeated);
            ticketArr[i] = randomNumber2;

        }

        System.out.println("Benim biletim : ");
        for (int i = 0; i <slots ; i++) {
            System.out.print(ticketArr[i] + " ");
        }
        System.out.println();
        System.out.println("Loto Sonucu : ");
        for (int i = 0; i <slots ; i++) {
            System.out.print(lotoArr[i] + " ");
        }
        System.out.println();

        int result=compareArr(ticketArr,lotoArr);
        if (result>0) {
            System.out.println("Tebrikler! " + result + " eşleşme var.");
        }else {
            System.out.println("Malesef hiç eşleşme yok, bir dahaki sefere.");
        }

    }
    public static int compareArr(int[] arr, int[] brr){
        int counter = 0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <brr.length ; j++) {
                if (arr[i]==brr[j]){
                    counter++;
                }
            }
        }

        return counter;


    }
}
