package wordsearch;

import com.rauloliva.wordsearch.Board;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class TestWordSearch {

    char[][] matrix;

    @BeforeEach
    void setUp() {
        matrix = new char[][]{
            new char[]{'R', 'A', 'K', 'X'},
            new char[]{'B', 'U', 'L', 'Z'},
            new char[]{'I', 'O', 'P', 'Y'}
        };
    }

    @Test
    void testMatrix() {

        Board b = new Board(matrix, "RAUL");
        b.start();
        List<String> coords = b.getLettersCoords();

        List<String> expected = new ArrayList<>();
        expected.add("0:0");
        expected.add("0:1");
        expected.add("1:1");
        expected.add("1:2");

        assertIterableEquals(expected, coords, "The word has been found!!!");
    }

}
