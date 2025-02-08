import com.day_06.SearchTarget;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SearchTargetTest {

    @Test
    public void linearSearchTest() {
        int [] arr={23,42,66,63,83,64,24,1,7};
        int n=83;
        int expected =4;
        int  actual = SearchTarget.linearSearch(arr, n);
        Assertions.assertEquals(expected, actual, "Test Fail!");
    }

    @Test
    public void binarySearchTest(){
        int [] arr={1,2,3,4,5,6,7};
        int n=5;
        int expected =4;
        int actual= SearchTarget.binarySearch(arr, n);
        Assertions.assertEquals(expected, actual, "Test Fail!");
    }

}
