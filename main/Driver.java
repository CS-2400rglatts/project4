package project4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Driver {

    public void MaxHeapOutput() {

    }

    public void main() throws IOException {
        //scans data_random.txt
        int a = 0;
        Integer[] randomNumbers = new Integer[100];
        File input = new File("Downloads/data_random.txt");
        Scanner scanner = new Scanner(input);
        while(scanner.hasNextInt()) {
            randomNumbers[a] = scanner.nextInt();
            a++;
        }

        //scans data_sorted.txt
        int b = 0;
        Integer[] sortedNumbers = new Integer[100];
        File inputSorted = new File("Downloads/data_sorted.txt");
        Scanner scan = new Scanner(inputSorted);
        while(scan.hasNextInt()) {
            randomNumbers[a] = scan.nextInt();
            b++;
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.write("Heap built using sequential insertions: ");
        MaxHeap<Integer> dumbheap = new MaxHeap<>();
        MaxHeap<Integer> optimalheap = new MaxHeap<>();
        
        for (int i = 0; i < 10; i++) {
            writer.write(dumbheap.getMax() + ",");
            dumbheap.removeMax();
        }
        writer.write("...\nNumber of swaps in the heap creation: " + "\nHeap after 10 removals: ");
        for (int i = 0; i < 10; i++) {
            writer.write(dumbheap.getMax() + ",");
            dumbheap.removeMax();
        }

    }
}