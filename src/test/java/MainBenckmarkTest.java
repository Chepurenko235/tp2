import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tp.Main;

public class MainBenckmarkTest {
    // кол-во чисел в файлах
    static int[] sizes = {1,100, 1000, 10000, 100000, 1000000, 5000000, 10000000};

    // генерация тестовых файлов
    @BeforeEach
    public void setUp() throws IOException {

        for(int size: sizes) {
            File testFile = new File(Integer.toString(size)+".txt");
            if (testFile.exists()) {
                        testFile.delete();
            }
            testFile.createNewFile();

            List<Integer> numbers = IntStream.range(0, size).boxed().collect(Collectors.toList());

            try (FileWriter writer = new FileWriter(size+".txt")) {
                for (Integer number : numbers) {
                    writer.write(number + System.lineSeparator());
                }
            }

        }
        
    }
    // Проводим измерения для каждой функции

    @Test
    public void benchmarkFindMin() throws IOException {
        
        for (int size : sizes) {
            long startTime, endTime;

            File file = new File(Integer.toString(size)+".txt");
            startTime = System.currentTimeMillis();

            Main.findMin(file);

            endTime = System.currentTimeMillis();

            System.out.println("findMin для " + size + " элементов выполнялась " + (endTime - startTime) + " ms");
        }
        assertEquals(1,1);
    }

    @Test
    public void benchmarkFindMax() throws IOException {

        for (int size : sizes) {
            long startTime, endTime;
            File file = new File(Integer.toString(size)+".txt");
            startTime = System.currentTimeMillis();

            Main.findMax(file);

            endTime = System.currentTimeMillis();

            System.out.println("findMax для " + size + " элементов выполнялась " + (endTime - startTime) + " ms");
        }
    }
    @Test
    public void benchmarkSum() throws IOException {
        for (int size : sizes) {
            long startTime, endTime;
            File file = new File(Integer.toString(size)+".txt");
            startTime = System.currentTimeMillis();

            Main.sum(file);

            endTime = System.currentTimeMillis();

            System.out.println("sum для " + size + " элементов выполнялась " + (endTime - startTime) + " ms");
        }
    }

    @Test
    public void benchmarkMultiply() throws IOException {
        for (int size : sizes) {
            long startTime, endTime;
            File file = new File(Integer.toString(size)+".txt");
            startTime = System.currentTimeMillis();

            Main.multiply(file);

            endTime = System.currentTimeMillis();

            System.out.println("multiply для " + size + " элементов выполнялась " + (endTime - startTime) + " ms");
        }
    }


           



}
