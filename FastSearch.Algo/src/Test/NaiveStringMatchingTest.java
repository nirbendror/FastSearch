package Test;

import com.hit.algorithm.NaiveStringMatching;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NaiveStringMatchingTest {

    @Test
    void TestSearch() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        NaiveStringMatching naive = new NaiveStringMatching();
        String str = "roman nir asd sda";
        String str1 = "roman sd nir sda sd";

        arr = naive.search(str, "nir");
        assertEquals(6, arr.toArray()[0]);
        arr = naive.search(str1, "nir");
        assertEquals(9, arr.toArray()[0]);
    }

    @Test
    void TestEdgeCases()
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        NaiveStringMatching naive = new NaiveStringMatching();
        String str1 = "roman sd nir sda sd";

        arr = naive.search(str1, "nir");
        assertEquals(1, arr.size());
        arr = naive.search(str1, "Nir");
        assertEquals(1, arr.size());
    }

    @Test
    void checkInput()
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        NaiveStringMatching naive = new NaiveStringMatching();
        String str = "roman nir asd sda";

        arr = naive.search(str, "Nir");
        assertEquals(6, arr.toArray()[0]);
    }
}