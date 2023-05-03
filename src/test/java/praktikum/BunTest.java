package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    static float randomPrice = RandomUtils.nextFloat(1F, 500F);
    static String randomString = RandomStringUtils.randomAlphabetic(20);
    private final String expectedName;
    private final float expectedPrice;

    public BunTest(String expectedName, float expectedPrice) {
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getBunParameters() {
        return new Object[][]{
                {"black bun", randomPrice},
                {"", randomPrice},
                {null, randomPrice},
                {RandomStringUtils.randomAlphabetic(200), randomPrice},
                {"0123456789$&@?<>~!%#", randomPrice},
                {randomString, -randomPrice},
                {randomString, 0F},
                {randomString, Float.MIN_VALUE},
                {randomString, Float.MAX_VALUE},
        };
    }

    @Test
    public void getNameReturnsCorrectNameBun() {
        Bun bun = new Bun(expectedName, expectedPrice);

        String actualGetName = bun.getName();

        assertEquals(expectedName, actualGetName);
    }

    @Test
    public void getPriceReturnsCorrectPriceBun() {
        Bun bun = new Bun(expectedName, expectedPrice);

        float actualGetPrice = bun.getPrice();

        assertEquals(expectedPrice, actualGetPrice, 0.001F);
    }
}
