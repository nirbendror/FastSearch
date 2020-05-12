package Test;

import com.hit.algorithm.RabinKarpStringMatching;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class RabinKarpStringMatchingTest {
    RabinKarpStringMatchingTest() {
    }
    @Test
    void TestSearch() {
        new ArrayList();
        RabinKarpStringMatching rc = new RabinKarpStringMatching();
        String str = "roman nir asd sda";
        String str1 = "roman sd nir sda sd";
        ArrayList<Integer> arr = rc.search(str, "nir");
        Assertions.assertEquals(6, arr.toArray()[0]);
        arr = rc.search(str1, "nir");
        Assertions.assertEquals(9, arr.toArray()[0]);
    }

    @Test
    void TestEdgeCases() {
        new ArrayList();
        RabinKarpStringMatching rc = new RabinKarpStringMatching();
        String str1 = "roman sd sda sd";
        ArrayList<Integer> arr = rc.search(str1, "nir");
        Assertions.assertEquals(0, arr.size());
        arr = rc.search(str1, "Nir");
        Assertions.assertEquals(0, arr.size());
    }

    @Test
    void checkInput() {
        new ArrayList();
        RabinKarpStringMatching rc = new RabinKarpStringMatching();
        String str = "roman nir asd sda";
        ArrayList<Integer> arr = rc.search(str, "Nir");
        Assertions.assertEquals(6, arr.toArray()[0]);
    }

}
