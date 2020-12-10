package sorting;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

abstract class Input<T> {

    // Instance Fields
    private final T[] data;
    private final String dataType;
    private final String sortingType;
    private final List<T> sortedData;
    private final SortedMap<T, Integer> keySortedDataMap;

    // Constructor
    Input(T[] data, String dataType, String sortingType) {
        this.data = data;
        this.dataType = dataType;
        this.sortingType = sortingType;
        this.sortedData = sortData();
        this.keySortedDataMap = createKeySortedDataMap();
    }

    // Getters
    public List<T> getSortedData() {
        return sortedData;
    }

    public SortedMap<T, Integer> getKeySortedDataMap() {
        return keySortedDataMap;
    }

    // Instance Methods
    private List<T> sortData() {
        List<T> dataList = new ArrayList<>(Arrays.asList(data));

        return dataList.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private SortedMap<T, Integer> createKeySortedDataMap() {
        TreeMap<T, Integer> treeMap = new TreeMap<>();

        for (T e : this.sortedData) {
            int eCount = treeMap.getOrDefault(e, 0) + 1;
            treeMap.put(e, eCount);
        }

        return treeMap;
    }

    private LinkedHashMap<T, Integer> createValueSortedDataMap() {
        return this.getKeySortedDataMap().entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (entry1, entry2) -> entry1,
                                LinkedHashMap::new
                        )
                );
    }

    public void printResult() {
        int sortedDataLength = sortedData.size();
        String dataTypePrint = "long".equals(dataType) ? "number" : dataType;

        System.out.printf("Total %ss: %d.%n", dataTypePrint, sortedDataLength);

        if ("natural".equals(sortingType)) {
            System.out.print("Sorted data: ");
            if ("line".equals(dataType)) {
                this.getSortedData().forEach(e -> System.out.printf("%n%s", e.toString()));
            } else {
                this.getSortedData().forEach(e -> System.out.printf("%s ", e.toString()));
            }
        } else {
            this.createValueSortedDataMap()
                    .forEach((k, v) -> System.out.printf("%s: %s time(s), %.0f%%%n",
                            k.toString(), v.toString(),
                            Double.parseDouble(v.toString()) / sortedDataLength * 100));
        }
    }

    public String resultToString() {
        int sortedDataLength = sortedData.size();
        String dataTypePrint = "long".equals(dataType) ? "number" : dataType;

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Total %ss: %d.%n", dataTypePrint, sortedDataLength));

        if ("natural".equals(sortingType)) {
            sb.append("Sorted data: ");
            if ("line".equals(dataType)) {
                this.getSortedData().forEach(e -> sb.append(String.format("%n%s", e.toString())));
            } else {
                this.getSortedData().forEach(e -> sb.append(String.format("%s ", e.toString())));
            }
        } else {
            this.createValueSortedDataMap()
                    .forEach((k, v) -> sb.append(String.format("%s: %s time(s), %.0f%%%n",
                            k.toString(), v.toString(),
                            Double.parseDouble(v.toString()) / sortedDataLength * 100)));
        }

        return sb.toString();
    }
}
