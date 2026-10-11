package lt.techin.oop;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void formatUsesStoredValues() { Product p = new Product("Banana", 1.1, 13); assertEquals("Banana, price 1.1, 13 pcs\n", output(p::printProduct)); assertEquals("Tea, price 2.5, 0 pcs\n", output(new Product("Tea", 2.5, 0)::printProduct)); }
    @Test void fieldsAndSilentConstruction() throws Exception { fields(Product.class, "name", "price", "quantity"); assertEquals("", output(() -> new Product("Book", 9.99, 2))); }
}
