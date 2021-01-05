# SortingTool


## About

This project sorts long, string, or long data by natural order or by occurrence count.

For example, given an input file:

```
2 6 4 3 5 44
1 11
2 7 4
2 7 4
```

This can sort the data along two dimensions: data type (long, word, line) and sort type (natural, by occurrence count).

1. Data type = Long, Sort type = Natural. Output:
   ```
   Total numbers: 14.
   Sorted data: 1 2 2 2 3 4 4 4 5 6 7 7 11 44 
   ```
2. Data type = Word, Sort type = Natural
   ``` 
   Total words: 14.
   Sorted data: 1 11 2 2 2 3 4 4 4 44 5 6 7 7 
   ```
3. Data type = Line, Sort type = Natural
   ``` 
   Total lines: 4.
   Sorted data:
   1 11
   2 6 4 3 5 44
   2 7 4
   2 7 4
   ```
4. Data type = Long, Sort type = By Count
   ``` 
   Total numbers: 14.
   1: 1 time(s), 7%
   3: 1 time(s), 7%
   5: 1 time(s), 7%
   6: 1 time(s), 7%
   11: 1 time(s), 7%
   44: 1 time(s), 7%
   7: 2 time(s), 14%
   2: 3 time(s), 21%
   4: 3 time(s), 21%
   ```
5. Data type = Word, Sort type = By Count
   ``` 
   Total words: 14.
   1: 1 time(s), 7%
   11: 1 time(s), 7%
   3: 1 time(s), 7%
   44: 1 time(s), 7%
   5: 1 time(s), 7%
   6: 1 time(s), 7%
   7: 2 time(s), 14%
   2: 3 time(s), 21%
   4: 3 time(s), 21%
   ```
6. Data type = Line, Sort type = By Count
   ``` 
   Total lines: 4.
   1 11: 1 time(s), 25%
   2 6 4 3 5 44: 1 time(s), 25%
   2 7 4: 2 time(s), 50%
   ```


## Getting Started

### Prerequisites

* Java 11 JDK
* Apache Maven (for building with included `pom.xml`)

### Installing

To create a fat JAR with Maven Assembly, follow these steps:

1. Use Maven Assembly to create a fat JAR:

```shell
mvn clean package assembly:single
```


## Usage

From the project directory, run the fat JAR passing arguments to the 4 parameters:

1. `-dataType`: `long`, `word`, or `line`
2. `-sortingType`: `natural` (default) or `byCount`
3. `-inputFile` (optional): Path to input text file from project directory. If the `-inputFile` arg is not set, the app will read user input from STDIN.
4. `-outputFile` (optional): Path to output text file from project directory. This output file will contain app results. If the `-outputFile` arg is not set, the app will print to STDOUT.

### Example Runs

1. Data type = Long, Sort type = Natural. Output:
   ```shell
   java -jar target/sortingTool-jar-with-dependencies.jar \
     -dataType long -sortingType natural \ 
     -inputFile src/main/resources/data/input.txt \ 
     -outputfile src/main/resources/data/output.txt
   ```
2. Data type = Word, Sort type = Natural
   ```shell
   java -jar target/sortingTool-jar-with-dependencies.jar \
     -dataType word -sortingType natural \ 
     -inputFile src/main/resources/data/input.txt \ 
     -outputfile src/main/resources/data/output.txt
   ```
3. Data type = Line, Sort type = Natural
   ```shell
   java -jar target/sortingTool-jar-with-dependencies.jar \
     -dataType line -sortingType natural \ 
     -inputFile src/main/resources/data/input.txt \ 
     -outputfile src/main/resources/data/output.txt
   ```
4. Data type = Long, Sort type = By Count
   ```shell
   java -jar target/sortingTool-jar-with-dependencies.jar \
     -dataType long -sortingType byCount \ 
     -inputFile src/main/resources/data/input.txt \ 
     -outputfile src/main/resources/data/output.txt
   ```
5. Data type = Word, Sort type = By Count
   ```shell
   java -jar target/sortingTool-jar-with-dependencies.jar \
     -dataType word -sortingType byCount \ 
     -inputFile src/main/resources/data/input.txt \ 
     -outputfile src/main/resources/data/output.txt
   ```
6. Data type = Line, Sort type = By Count
   ```shell
   java -jar target/sortingTool-jar-with-dependencies.jar \
     -dataType line -sortingType byCount \ 
     -inputFile src/main/resources/data/input.txt \ 
     -outputfile src/main/resources/data/output.txt
   ```

This tool is also good at providing word counts for large text files such as books:

```shell
java -jar target/sortingTool-jar-with-dependencies.jar \
  -dataType word -sortingType byCount \ 
  -inputFile src/main/resources/data/alice_in_wonderland.txt \ 
  -outputfile src/main/resources/data/output.txt
```

## Built Using

* [Java 11](https://openjdk.java.net/projects/jdk/11/)
* [Apache Maven](https://maven.apache.org/)


## Author

[@LDNicolasMay](https://github.com/ldnicolasmay) - Work

## Acknowledgets

Thanks to [JetBrains Academy](https://www.jetbrains.com/academy/) for the project!