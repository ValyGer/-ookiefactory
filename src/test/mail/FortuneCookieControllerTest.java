package mail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;

public class FortuneCookieControllerTest {

   static FortuneCookieController goodFactoryController;
   static FortuneCookieController badFactoryController;
    public static FortuneCookieController create(boolean isPositive){
        FortuneConfig config = new FortuneConfig(isPositive);
        FortuneCookieFactory fortuneCookieFactory = new FortuneCookieFactory(
                config,
                singletonList("positive"),
                singletonList("negative")
                );
        return new FortuneCookieController(fortuneCookieFactory);
    }
    @BeforeAll
    public static void createCookieController() {
         goodFactoryController = create(true);
         badFactoryController = create(false);
    }

    @Test
    public void shouldReturnPositiveFortune(){
        String cookieText = goodFactoryController.tellFortune().getFortuneText();
        Assertions.assertEquals("positive", cookieText);
    }
    @Test
    public void shouldReturnNegativeFortune(){
        String cookieText = badFactoryController.tellFortune().getFortuneText();
        Assertions.assertEquals("negative", cookieText);
    }
}