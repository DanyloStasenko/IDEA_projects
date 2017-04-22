import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    // http://codeforces.com/problemset/problem/599/A
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());

        int toFirstShop = scanner.nextInt();
        int toSecondShop = scanner.nextInt();
        int betweenShops = scanner.nextInt();


        if (betweenShops < toFirstShop && betweenShops < toSecondShop){
            System.out.println(Integer.min(toFirstShop, toSecondShop) + betweenShops * 2);
            System.exit(0);
        }


        if (toFirstShop * 2 + toSecondShop * 2 < toFirstShop + toSecondShop + betweenShops){
            System.out.println(toFirstShop * 2 + toSecondShop * 2);
        } else {
            System.out.println(toFirstShop + toSecondShop + betweenShops);
        }


    }
}
