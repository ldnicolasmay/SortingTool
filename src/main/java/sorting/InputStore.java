package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class InputStore<T> extends InputFactory<T> {

    @Override
    Input<T> createInput(String dataType,
                         String sortingType,
                         String inputFile) throws FileNotFoundException {

        Scanner scanner;

        if (inputFile != null) {
            File input = new File(inputFile);
            scanner = new Scanner(input);
        } else {
            scanner = new Scanner(System.in);
        }

        if ("long".equals(dataType)) {
            List<String> stringLongs = new ArrayList<>();
            List<Long> longs;

            while (scanner.hasNext()) {
                String stringLong = scanner.next();
                if (stringLong.matches("-?\\d+")) {
                    stringLongs.add(stringLong);
                } else {
                    System.err.printf("\"%s\" is not a long. It will be skipped.%n", stringLong);
                }
            }

            longs = stringLongs.stream()
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
            Long[] longsArray = longs.toArray(new Long[longs.size()]);
            LongInput<T> longInput = new LongInput(longsArray, dataType, sortingType);

            return longInput;

        } else if ("word".equals(dataType)) {
            List<String> words = new ArrayList<>();
            String punctToRemove = "_|\"|,|\\.|;|:|\\(|\\)|\\$|\\%|'|\\?|!|\u201c|\u201d|\u2018|\u2019|\\[|\\]";
            String punctToReplace = "\u2014";
            while (scanner.hasNext()) {
                words.add(scanner.next()
                        .replaceAll(punctToRemove, "")
                        .replaceAll(punctToReplace, " "));
            }
            String[] wordsArray = words.toArray(new String[words.size()]);
            WordInput<T> wordInput = new WordInput(wordsArray, dataType, sortingType);

            return wordInput;

        } else if ("line".equals(dataType)) {
            List<String> lines = new ArrayList<>();
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            String[] linesArray = lines.toArray(new String[lines.size()]);
            LineInput<T> lineInput = new LineInput(linesArray, dataType, sortingType);

            return lineInput;

        } else {
            return null;
        }
    }
}
