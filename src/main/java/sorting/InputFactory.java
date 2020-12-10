package sorting;

import java.io.FileNotFoundException;

abstract class InputFactory<T> {

    abstract Input<T> createInput(String dataType,
                                  String sortingType,
                                  String inputFile) throws FileNotFoundException;

    Input<T> orderInput(String dataType,
                        String sortingType,
                        String inputFile) throws FileNotFoundException {
        Input<T> input = createInput(dataType, sortingType, inputFile);
        if (input == null) {
            return null;
        }

        return input;
    }
}
