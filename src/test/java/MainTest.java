import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.tp.Main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class MainTest {

    private static final String TEST_FILE_NAME = "./123.txt";
    private File testFile;

    @BeforeEach
    public void setUp() throws IOException {
        testFile = new File(TEST_FILE_NAME);
        if (testFile.exists()) {
                    testFile.delete();
        }
        testFile.createNewFile();
    }

    private void writeTestFile(List<Integer> numbers) throws IOException {
        try (FileWriter writer = new FileWriter(testFile)) {
            for (Integer number : numbers) {
                writer.write(number + System.lineSeparator());
            }
        }
    }
    @BeforeEach
    public void setUpTestFile() throws IOException {
        writeTestFile(List.of(0, 1, 2, 3, 4));
    }

    @Test
    public void testFindMin() throws IOException {
        assertEquals(0, Main.findMin(testFile));
    }

    @Test
    public void testFindMax() throws IOException {
        assertEquals(4, Main.findMax(testFile));
    }

    @Test
    public void testSum() throws IOException {
        assertEquals(10, Main.sum(testFile));
    }

    @Test
    public void testMultiply() throws IOException {
        assertEquals(0, Main.multiply(testFile));
    }


    @Test
    public void testFindMinWithBadPath() {
        Exception exception = assertThrows(IOException.class, () -> {
            
            Main.findMin(new File("bad_path"));
        });

        assertEquals("bad_path (No such file or directory)", exception.getMessage());
    }

    @Test
    public void testFindMaxWithBadPath() {
        Exception exception = assertThrows(IOException.class, () -> {
            
            Main.findMax(new File("bad_path"));
        });

        assertEquals("bad_path (No such file or directory)", exception.getMessage());
    }

    @Test
    public void testSumWithWithBadPath() {
        Exception exception = assertThrows(IOException.class, () -> {
            
            Main.sum(new File("bad_path"));
        });

        assertEquals("bad_path (No such file or directory)", exception.getMessage());
    }

    @Test
    public void testMultiplyWithBadPath() {
        Exception exception = assertThrows(IOException.class, () -> {
            
            Main.multiply(new File("bad_path"));
        });

        assertEquals("bad_path (No such file or directory)", exception.getMessage());
    }

    @Disabled
    @Test
    public void testSumTimeoutFail() throws IOException {
        writeTestFile(IntStream.rangeClosed(1, 1000000).boxed().collect(Collectors.toList()));

        assertTimeoutPreemptively(Duration.ofMillis(10), () -> {
            Main.sum(testFile); 
        }, "Too long timeout");
    }

}
