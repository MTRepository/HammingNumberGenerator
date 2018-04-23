import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HammingNumberGen {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Which Hamming number (from 1 to 5000) would you like to generate?");
        int orderNum = scanner.nextInt();
        System.out.println(hamming(orderNum));

    }

    public static long hamming(int n) {

        List<Integer> listOfPrimes = getPrime(10000);

        List<Integer> listOfCompletedPrimes = new LinkedList<>();

        List<Integer> listOfHammings = new LinkedList<>();

        for (int i = 0; i < listOfPrimes.size(); i++) {

            listOfCompletedPrimes.add(listOfPrimes.get(i));

            int maxOccuranceNumber = 1 + (int)(listOfPrimes.size()/listOfPrimes.get(i));

            for (int j = 2; j < maxOccuranceNumber; j++) {

                listOfCompletedPrimes.add(j * listOfPrimes.get(i));

            }

        }

        Collections.sort(listOfCompletedPrimes);

        for (int i = 1; i <= 5000; i++) {

            if(!listOfCompletedPrimes.contains(i)){
                listOfHammings.add(i);
            }
        }

        return listOfHammings.get(n-1);
    }

    public static List<Integer> getPrime(int maxPrimeNumber) {

        List<Integer> primes = new LinkedList<>();

        if (maxPrimeNumber <= 1) System.out.println("No prime numbers in the given range!");

        primes.add(2);

        for (int i = 2; i <= maxPrimeNumber; i++) {

            boolean isPrime = false;

            for (Integer prime : primes) {
                if (i % prime == 0) {
                    isPrime = false;
                    break;
                } else {
                    isPrime = true;
                }
            }
            if (isPrime) primes.add(i);
        }

        // removes 2
        primes.remove(0);
        // removes 3
        primes.remove(0);
        // removes 5
        primes.remove(0);

        return primes;
    }

}
