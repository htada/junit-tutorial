package junit.tutorial;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExpectedExceptionExampleTest {

    @Rule
    public ExpectedException ex = ExpectedException.none();
    
    @Test
    public void 例外の発生とメッセージを検証するテスト() throws Exception {
        ex.expect(IllegalArgumentException.class);
        ex.expectMessage("hoge");
        throw new IllegalArgumentException("hoge");
    }
}
