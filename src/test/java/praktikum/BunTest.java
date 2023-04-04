package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
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
        Bun bun = new Bun(name, price);
        String actualGetName = bun.getName();
        assertEquals(name, actualGetName);
    }

    @Test
    public void getPriceReturnsCorrectPriceBun() {
        Bun bun = new Bun(name, price);
        float actualGetPrice = bun.getPrice();
        assertEquals(price, actualGetPrice, 0.001F);
    }
}
