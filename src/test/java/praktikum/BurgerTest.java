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
    Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient secondIngredient;

    @Test
    public void setBunsSetsCorrectly() {
        burger = new Burger();
        float bunPrice = RandomUtils.nextFloat(1F, 500F);
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        float expectedPrice = bunPrice * 2;

        float actualPrice = burger.getPrice();

        assertEquals(expectedPrice, actualPrice, 0.0001F);
    }

    @Test
    public void removeIngredientRemovesIngredientFromReceipt() {
        burger = new Burger();
        String bunName = RandomStringUtils.randomAlphabetic(20);
        String ingredientName = RandomStringUtils.randomAlphabetic(20);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        String expectedReceipt = "(==== " + bunName + " ====)\n" +
                "= filling " + ingredientName + " =\n" +
                "(==== " + bunName + " ====)\n" +
                "\n" +
                "Price: 0,000000\n";

        String actualReceipt = burger.getReceipt();

        assertEquals(expectedReceipt, actualReceipt);
    }

    @Test
    public void moveIngredientChangesPositionInReceipt() {
        burger = new Burger();
        String bunName = RandomStringUtils.randomAlphabetic(20);
        String firstIngredientName = RandomStringUtils.randomAlphabetic(20);
        String secondIngredientName = RandomStringUtils.randomAlphabetic(20);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(1, 0);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(firstIngredientName);
        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(secondIngredient.getName()).thenReturn(secondIngredientName);
        String expectedReceipt = "(==== " + bunName + " ====)\n" +
                "= filling " + secondIngredientName + " =\n" +
                "= sauce " + firstIngredientName + " =\n" +
                "(==== " + bunName + " ====)\n" +
                "\n" +
                "Price: 0,000000\n";

        String actualReceipt = burger.getReceipt();

        assertEquals(expectedReceipt, actualReceipt);
    }

    @Test
    public void getPriceReturnsTotalCostOfBunsAndAllIngredients() {
        burger = new Burger();
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
    public void getReceiptReturnsCorrectReceipt() {
        burger = new Burger();
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
