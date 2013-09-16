package junit.tutorial;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.number.OrderingComparison.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestTest {

    @Test
    public void matchers() throws Exception {
        List<String> sut = new ArrayList<String>();
        sut.add("hoge");
        sut.add("piyo");
        sut.add("fuga");
        assertThat(sut, hasItem("piyo"));
        assertThat(sut, hasItems("piyo", "hoge"));
        
        assertThat(3, greaterThan(2));
    }
    
}
