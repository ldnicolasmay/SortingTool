package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

    public static <T> void main(String[] args) throws Exception {

        boolean runFlag = true;

        String dataType = null;
        String sortingType = null;
        String inputFile = null;
        String outputFile = null;

        for (int i = 0; i < args.length; i++) {
            if ("-dataType".equals(args[i])) {
                if (i + 1 == args.length) {
                    runFlag = false;
                    System.err.println("No sorting type defined!");
                } else {
                    dataType = args[i + 1];
                    i++;
                }
            } else if ("-sortingType".equals(args[i])) {
                if (i + 1 == args.length) {
                    runFlag = false;
                    System.err.println("No data type defined!");
                } else {
                    sortingType = args[i + 1];
                    i++;
                }
            } else if ("-inputFile".equals(args[i])) {
                if (i + 1 == args.length) {
                    runFlag = false;
                } else {
                    inputFile = args[i + 1];
                    i++;
                }
            } else if ("-outputFile".equals(args[i])) {
                if (i + 1 == args.length) {
                    runFlag = false;
                } else {
                    outputFile = args[i + 1];
                    i++;
                }
            } else {
                System.err.printf("\"%s\" is not a valid parameter. It will be skipped.%n", args[i]);
            }
        }

        if (sortingType == null) {
            sortingType = "natural";
        }

        if (dataType == null) {
            dataType = "word";
        }

        // Create Input and print result
        if (runFlag) {
            InputStore<T> inputStore = new InputStore<>();
            Input<T> input = inputStore.orderInput(dataType, sortingType, inputFile);
            if (outputFile == null) {
                input.printResult();
            } else {
                File output = new File(outputFile);
                try (PrintWriter printWriter = new PrintWriter(output)) {
                    printWriter.print(input.resultToString());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
