package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient firstIngredient;
    @Mock
    private Ingredient secondIngredient;

    @Before
    public void setUp() throws Exception {
        burger = new Burger();
    }

    @Test
    public void shouldSetGivenBun() {
        Burger burger = Mockito.mock(Burger.class);
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
        float expectedPrice = 70.0F;
        float bunPrice = 10.0F;
        float firstIngredientPrice = 20.0F;
        float secondIngredientPrice = 30.0F;
        burger.setBuns(bun);
        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(firstIngredient.getPrice()).thenReturn(firstIngredientPrice);
        Mockito.when(secondIngredient.getPrice()).thenReturn(secondIngredientPrice);
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceipt() {
    }
}