package Test;

import com.hit.algorithm.KMPStringMatching;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class KMPStringMatchingTest {

    @Test
    void TestSearch() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        KMPStringMatching kmp = new KMPStringMatching();
        String str = "roman nir asd sda";
        String str1 = "roman sd nir sda sd";

        arr = kmp.search(str, "nir");
        assertEquals(6, arr.toArray()[0]);
        arr = kmp.search(str1, "nir");
        assertEquals(9, arr.toArray()[0]);
    }

    @Test
    void TestEdgeCases()
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        KMPStringMatching kmp = new KMPStringMatching();
        String str1 = "roman sd sda sd";

        arr = kmp.search(str1, "nir");
        assertEquals(0, arr.size());
        arr = kmp.search(str1, "Nir");
        assertEquals(0, arr.size());
    }

    @Test
    void checkInput()
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        KMPStringMatching kmp = new KMPStringMatching();
        String str = "roman nir asd sda";

        arr = kmp.search(str, "Nir");
        assertEquals(6, arr.toArray()[0]);
    }
}