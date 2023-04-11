package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String expectedName;
    private final float expectedPrice;

    public BunTest(String expectedName, float expectedPrice) {
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getBunParameters() {
        return new Object[][]{
                {"black bun", 100},
                {"", 0},
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
