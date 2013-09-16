package junit.tutorial;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class JankenTest {
    
    @DataPoints
    public static Fixture[] PARAMs = {
        new Fixture(Janken.Hand.GU, Janken.Hand.GU, Janken.Result.DRAW),
        new Fixture(Janken.Hand.GU, Janken.Hand.TYOKI, Janken.Result.WIN),
        new Fixture(Janken.Hand.GU, Janken.Hand.PA, Janken.Result.LOSE),
        new Fixture(Janken.Hand.TYOKI, Janken.Hand.GU, Janken.Result.LOSE),
        new Fixture(Janken.Hand.TYOKI, Janken.Hand.TYOKI, Janken.Result.DRAW),
        new Fixture(Janken.Hand.TYOKI, Janken.Hand.PA, Janken.Result.WIN),
        new Fixture(Janken.Hand.PA, Janken.Hand.GU, Janken.Result.WIN),
        new Fixture(Janken.Hand.PA, Janken.Hand.TYOKI, Janken.Result.LOSE),
        new Fixture(Janken.Hand.PA, Janken.Hand.PA, Janken.Result.DRAW)
    };
    
    @Theory
    public void janken(Fixture f) {
        assertThat(Janken.judge(f.h1, f.h2), is(f.expected));
    }
    
    static class Fixture {
        Janken.Hand h1;
        Janken.Hand h2;
        Janken.Result expected;
        
        Fixture(Janken.Hand h1, Janken.Hand h2, Janken.Result expected) {
            this.h1 = h1;
            this.h2 = h2;
            this.expected = expected;
        }
    }
    
    static class Janken {
        enum Hand {
            GU, TYOKI, PA
        }
        
        enum Result {
            WIN, LOSE, DRAW
        }
        
        public static Result judge(Hand h1, Hand h2) {
            if (h1 == h2) return Result.DRAW;
            switch (h1) {
                case GU:
                    return h2 == Hand.TYOKI ? Result.WIN : Result.LOSE;
                case PA:
                    return h2 == Hand.GU ? Result.WIN : Result.LOSE;
                default:
                    return h2 == Hand.PA ? Result.WIN : Result.LOSE;
            }
        }
    }
}
