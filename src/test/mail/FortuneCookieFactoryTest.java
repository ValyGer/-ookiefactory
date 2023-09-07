package mail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.*;

class FortuneCookieFactoryTest {

    static FortuneCookieFactory fortuneCookie;

    @BeforeEach
    public void createCookie(){
        FortuneConfig config = new FortuneConfig(true);
        fortuneCookie = new FortuneCookieFactory(
                config,
                singletonList("positive"),
                singletonList("negative")
        );
    }

    @Test
    void shouldIncrementCountByOneAfterOneCookieBaked() {
        fortuneCookie.bakeFortuneCookie(); //печем печеньку
        Assertions.assertEquals(1, fortuneCookie.getCookiesBaked());
    }

    @Test
    void shouldIncrementCountByTwoAfterTwoCookiesBaked() {
        fortuneCookie.bakeFortuneCookie(); //печем печеньку
        fortuneCookie.bakeFortuneCookie(); //печем печеньку
        Assertions.assertEquals(2, fortuneCookie.getCookiesBaked());
    }

    @Test
    void shouldSetCounterToZeroAfterResetCookieCreatedCall() {
        fortuneCookie.bakeFortuneCookie(); //печем печеньку
        fortuneCookie.resetCookiesCreated(); //сбрасываем счетчик
        Assertions.assertEquals(0, fortuneCookie.getCookiesBaked());
    }
}