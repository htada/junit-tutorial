package junit.tutorial;

import junit.tutorial.rule.PostCondition;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CustomeRuleTest {
    
    private String condition = "NG";
    
    @Rule
    public ExpectedException ex = ExpectedException.none(); 

    @Rule
    public PostCondition preCondition = new PostCondition() {
        @Override
        protected void verify() throws Throwable {
            if (!condition.equals("OK")) {
                throw new Exception("Condition NG");
            };
        }
    };

    @Test
    public void conditionOK() throws Exception {
        condition = "OK";
    }
    
}
