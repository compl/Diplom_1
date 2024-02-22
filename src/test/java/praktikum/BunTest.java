package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private final String name = "Black";
    private final float price = 10.0F;
    private final Bun bun = new Bun(name, price);

    @Test
    public void shouldReturnGivenName() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void shouldReturnGivenPrice() {
        assertEquals(price, bun.getPrice(), 0);
    }
}