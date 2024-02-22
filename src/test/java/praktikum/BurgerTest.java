package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;
    @Mock
    private Ingredient firstIngredient;
    @Mock
    private Ingredient secondIngredient;
    private final float firstIngredientPrice = 20F;
    private final float secondIngredientPrice = 30F;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void shouldSetGivenBun() {
        Burger burger = mock(Burger.class);
        burger.setBuns(bun);

        verify(burger).setBuns(bun);
    }

    @Test
    public void shouldAddIngredient() {
        burger.addIngredient(firstIngredient);

        assertThat(burger.ingredients, hasSize(1));
        assertThat(burger.ingredients, hasItem(firstIngredient));
    }

    @Test
    public void shouldRemoveIngredient() {
        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);
        burger.removeIngredient(1);

        assertThat(burger.ingredients, hasSize(1));
        assertEquals(burger.ingredients.get(0), firstIngredient);
    }

    @Test
    public void shouldMoveIngredient() {
        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);
        burger.moveIngredient(0, 1);

        assertThat(burger.ingredients, hasSize(2));
        assertEquals(burger.ingredients.get(0), secondIngredient);
    }

    @Test
    public void shouldReturnBurgerPrice() {
        float bunPrice = 10F;
        float expectedPrice = 70F;

        burger.setBuns(bun);
        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);

        when(bun.getPrice()).thenReturn(bunPrice);
        when(firstIngredient.getPrice()).thenReturn(firstIngredientPrice);
        when(secondIngredient.getPrice()).thenReturn(secondIngredientPrice);

        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void shouldReturnReceipt() {
        String bunName = "Black bun";
        String firstIngredientName = "Cheese";
        String secondIngredientName = "Ketchup";
        String expectedReceipt = "(==== Black bun ====)\n" +
                "= filling Cheese =\n" +
                "= sauce Ketchup =\n" +
                "(==== Black bun ====)\n" +
                "\n" +
                "Price: 50.000000\n";

        burger.setBuns(bun);
        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);

        when(bun.getName()).thenReturn(bunName);
        when(firstIngredient.getPrice()).thenReturn(firstIngredientPrice);
        when(firstIngredient.getName()).thenReturn(firstIngredientName);
        when(firstIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(secondIngredient.getPrice()).thenReturn(secondIngredientPrice);
        when(secondIngredient.getName()).thenReturn(secondIngredientName);
        when(secondIngredient.getType()).thenReturn(IngredientType.SAUCE);

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}