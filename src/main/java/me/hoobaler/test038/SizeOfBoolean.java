package me.hoobaler.test038;

public class SizeOfBoolean {

    private static final int SIZE = 100000;

    public static void main(String[] args) {
        LotsOfBooleans[] first = new LotsOfBooleans[SIZE];
        LotsOfInts[] second = new LotsOfInts[SIZE];

        System.gc();
        long startMem = getMemory();

        for (int i = 0; i < SIZE; i++) {
            first[i] = new LotsOfBooleans();
        }

        System.gc();
        long endMem = getMemory();

        System.out.println("Size for LotsOfBooleans: " + (endMem - startMem));
        System.out.println("Average size: " + ((endMem - startMem) / ((double) SIZE)));

        System.gc();
        startMem = getMemory();
        for (int i = 0; i < SIZE; i++) {
            second[i] = new LotsOfInts();
        }
        System.gc();
        endMem = getMemory();

        System.out.println("Size for LotsOfInts: " + (endMem - startMem));
        System.out.println("Average size: " + ((endMem - startMem) / ((double) SIZE)));

        // Make sure nothing gets collected
        long total = 0;
        for (int i = 0; i < SIZE; i++) {
            total += (first[i].a0 ? 1 : 0) + second[i].a0;
        }
        System.out.println(total);
    }

    private static long getMemory() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
