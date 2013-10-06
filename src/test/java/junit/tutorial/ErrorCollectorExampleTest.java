package junit.tutorial;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class ErrorCollectorExampleTest {

    @Rule
    public ErrorCollector ec = new ErrorCollector();
    
    @Test
    public void collect() throws Exception {
        // 途中で検証エラーになっても、最後まで実行する
        ec.checkThat("hoge", is("piyo"));
        ec.checkThat("hoge", is("hoge"));
        ec.checkThat("hoge", is("hog"));
        ec.checkThat("hoge", is("poge"));
    }
}