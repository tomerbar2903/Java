import java.util.Scanner;

public class main {

    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        System.out.print("Enter Amount Of Threads: ");
        int amount = reader.nextInt();
        System.out.println("\n *** Let's Begin Shall We? ***\n\n");
        System.out.println(">>> Enter Any Key To Stop!\n ");
        ThreadCollection threadCollection = new ThreadCollection(amount);
        threadCollection.start();  // starts all threads + randomizes messages
        Thread.sleep(1000);
        reader.nextInt();  // waits for input
        threadCollection.stopThreadCollection();  // after input - end
    }
}
