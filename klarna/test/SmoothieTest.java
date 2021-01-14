import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SmoothieTest {
    @Test
    public void classicSmoothie() {
        assertEquals("banana,honey,mango,peach,pineapple,strawberry",
                Smoothie.ingredients("Classic"));
    }

    @Test
    public void classicSmoothieWithoutStrawberry() {
        assertEquals("banana,honey,mango,peach,pineapple",
                Smoothie.ingredients("Classic,-strawberry"));
    }

    @Test
    public void classicSmoothieWithoutMangoWithHoneyAndGrapeJuice() {

        try {
            Smoothie.ingredients("Classic,mango,-honey,grape juice");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Ingredient cannot be added!", e.getMessage());
        }
    }

    @Test
    public void classicSmoothieWithChocolate() {
        try {
            Smoothie.ingredients("Classic,Chocolate");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Ingredient cannot be added!", e.getMessage());
        }
    }

    @Test
    public void vitaminSmoothie() {
        try {
            Smoothie.ingredients("Vitamin smoothie");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Smoothie name vitamin smoothie is invalid", e.getMessage());
        }
    }
}