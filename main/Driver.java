package project4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Driver {

    public void MaxHeapOutput() {

    }

    public static void main(String[] args) throws IOException {
        //scans data_random.txt
        int a = 0;
        Integer[] randomNumbers = new Integer[100];
        File input = new File("C:\\Users\\Rebecca\\.vscode\\testing\\.vscode\\project_2\\.vscode\\project4\\src\\main\\java\\project4\\data_random.txt");
        Scanner scanner = new Scanner(input);
        while(scanner.hasNextInt()) {
            randomNumbers[a] = scanner.nextInt();
            a++;
        }
        scanner.close();

        //scans data_sorted.txt
        int b = 0;
        Integer[] sortedNumbers = new Integer[100];
        File inputSorted = new File("C:\\Users\\Rebecca\\.vscode\\testing\\.vscode\\project_2\\.vscode\\project4\\src\\main\\java\\project4\\data_sorted.txt");
        Scanner scan = new Scanner(inputSorted);
        while(scan.hasNextInt()) {
            sortedNumbers[b] = scan.nextInt();
            b++;
        }
        scan.close();

        //writes data_random.txt array of numbers to file using sequential insertion
        MaxHeap<Integer> sequentialheap = new MaxHeap<>();
        int sequentialCount = sequentialheap.sequentialInsertion(randomNumbers);

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Rebecca\\.vscode\\testing\\.vscode\\project_2\\.vscode\\project4\\src\\main\\java\\project4\\output.txt"));
        writer.write("data_random.txt ");
        writer.write("\nHeap built using sequential insertions: ");
        for (int i = 0; i < 10; i++) {
            writer.write(sequentialheap.getMax() + ",");
            sequentialheap.removeMax();
        }

        writer.write("...\nNumber of swaps in the heap creation: " + sequentialCount +  
        "\nHeap after 10 removals: ");
        sequentialheap.sequentialInsertion(randomNumbers);
        for (int i = 0; i < 10; i++) {
            sequentialheap.removeMax();
        }
        for (int i = 0; i < 10; i++){
            writer.write(sequentialheap.getMax() + ",");
            sequentialheap.removeMax();
        }



        //writes to file and creates optimal heap
        MaxHeap<Integer> optimalheap = new MaxHeap<>(100);
        int optimalCount = optimalheap.Optimal(randomNumbers);
        writer.write("...\n\nHeap built using optimal method: ");
        for (int i = 0; i < 10; i++) {
            writer.write(optimalheap.getMax() + ",");
            optimalheap.removeMax();
        }

        writer.write("...\nNumber of swaps in the heap creation: "  + optimalCount +
        "\nHeap after 10 removals: ");
        for (int i = 0; i < 10; i++) {
            optimalheap.removeMax();
        }
        for (int i = 0; i < 10; i++) {
            writer.write(optimalheap.getMax() + ",");
            optimalheap.removeMax();
        }
        writer.write("...\n");

       

        //writes data_sorted.txt array of numbers to file
        MaxHeap<Integer> sequentialheapSorted = new MaxHeap<>();
        int sequentialCountSorted = sequentialheapSorted.sequentialInsertion(sortedNumbers);
        
        writer.write("\ndata_sorted.txt ");
        writer.write("\nHeap built using sequential insertions: ");
        for (int i = 0; i < 10; i++) {
            writer.write(sequentialheapSorted.getMax() + ",");
            sequentialheapSorted.removeMax();
        }

        writer.write("...\nNumber of swaps in the heap creation: " + sequentialCountSorted +  
        "\nHeap after 10 removals: ");
        for (int i = 0; i < 10; i++) {
            writer.write(sequentialheapSorted.getMax() + ",");
            sequentialheapSorted.removeMax();
        }
        //writes to file and creates optimal heap
        MaxHeap<Integer> optimalheapSorted = new MaxHeap<>(100);
        int optimalheapSortedCount = optimalheapSorted.Optimal(sortedNumbers);
        writer.write("...\n\nHeap built using optimal method: ");
        for (int i = 0; i < 10; i++) {
            writer.write(optimalheapSorted.getMax() + ",");
            optimalheapSorted.removeMax();
        }

        writer.write("...\nNumber of swaps in the heap creation: " + optimalheapSortedCount +  
        "\nHeap after 10 removals: ");
        optimalheapSorted.Optimal(sortedNumbers);
        for (int i = 0; i < 10; i++) {
            
            optimalheapSorted.removeMax();
        }
        for (int i = 0; i < 10; i++) {
            writer.write(optimalheapSorted.getMax() + ",");
            optimalheapSorted.removeMax();
        }
        writer.write("...\n");

        writer.close();
        
    }
}