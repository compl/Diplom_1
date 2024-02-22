package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private final String name = "Fish";
    private final float price = 10F;
    private final Ingredient ingredient = new Ingredient(IngredientType.FILLING, name, price);

    @Test
    public void shouldReturnGivenPrice() {
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void shouldReturnGivenName() {
        assertEquals(name, ingredient.getName());
    }
}