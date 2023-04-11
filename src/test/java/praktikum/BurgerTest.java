package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void getPriceReturnsCorrectValue() {
        Burger burger = new Burger();
        float bunPrice = RandomUtils.nextFloat(1F, 500F);
        float ingredientPrice = RandomUtils.nextFloat(1F, 500F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        float expectedPrice = bunPrice * 2 + ingredientPrice;

        float actualPrice = burger.getPrice();

        assertEquals(expectedPrice, actualPrice, 0.0001F);
    }

    @Test
    public void getReceiptReturnsCorrectValue() {
        Burger burger = new Burger();
        String bunName = RandomStringUtils.randomAlphabetic(20);
        String ingredientName = RandomStringUtils.randomAlphabetic(20);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        String expectedReceipt = "(==== " + bunName + " ====)\n" +
                "= sauce " + ingredientName + " =\n" +
                "(==== " + bunName + " ====)\n" +
                "\n" +
                "Price: 0,000000\n";

        String actualReceipt = burger.getReceipt();

        assertEquals(expectedReceipt, actualReceipt);
    }
}
