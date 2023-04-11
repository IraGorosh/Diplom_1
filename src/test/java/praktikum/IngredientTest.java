package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;

    public IngredientTest(IngredientType expectedType, String expectedName, float expectedPrice) {
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientParameters() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.FILLING, "sausage", 300},
                {null, "", 0},
        };
    }

    @Test
    public void getPriceIngredientReturnsCorrectValue() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);

        float actualPrice = ingredient.getPrice();

        assertEquals(expectedPrice, actualPrice, 0.5F);
    }

    @Test
    public void getNameIngredientReturnsCorrectValue() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);

        String actualName = ingredient.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void getTypeIngredientReturnsCorrectValue() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);

        IngredientType actualType = ingredient.getType();

        assertEquals(expectedType, actualType);
    }
}
