package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String name = "Fish";
    private final float price = 10F;
    private final IngredientType type;

    public IngredientTypeTest(IngredientType type) {
        this.type = type;
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Parameterized.Parameters(name = "Type: {0}")
    public static Object[][] getResult() {
        return new Object[][] {
                { IngredientType.FILLING },
                { IngredientType.SAUCE }
        };
    }

    @Test
    public void shouldReturnGivenType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }
}