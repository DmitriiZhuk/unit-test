import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Calculator {
    
    public double calculateDiscount(double purchaseAmount, double discountPercentage) {
        if (purchaseAmount < 0 || discountPercentage < 0 || discountPercentage > 100) {
            throw new ArithmeticException("Invalid arguments: purchaseAmount and discountPercentage must be non-negative, and discountPercentage must be between 0 and 100.");
        }
        
        double discountAmount = purchaseAmount * discountPercentage / 100;
        return purchaseAmount - discountAmount;
    }
}

class CalculatorTest {
    
    private Calculator calculator = new Calculator();
    
    @Test
    void testCalculateDiscountWithValidArguments() {
        double purchaseAmount = 100.0;
        double discountPercentage = 10.0;
        
        double expectedAmount = 90.0;
        double calculatedAmount = calculator.calculateDiscount(purchaseAmount, discountPercentage);
        
        Assertions.assertThat(calculatedAmount).isEqualTo(expectedAmount);
    }
    
    @Test
    void testCalculateDiscountWithNegativePurchaseAmount() {
        double purchaseAmount = -100.0;
        double discountPercentage = 10.0;
        
        Assertions.assertThatThrownBy(() -> calculator.calculateDiscount(purchaseAmount, discountPercentage))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("Invalid arguments");
    }
    
    @Test
    void testCalculateDiscountWithNegativeDiscountPercentage() {
        double purchaseAmount = 100.0;
        double discountPercentage = -10.0;
        
        Assertions.assertThatThrownBy(() -> calculator.calculateDiscount(purchaseAmount, discountPercentage))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("Invalid arguments");
    }
    
    @Test
    void testCalculateDiscountWithInvalidDiscountPercentage() {
        double purchaseAmount = 100.0;
        double discountPercentage = 110.0;
        
        Assertions.assertThatThrownBy(() -> calculator.calculateDiscount(purchaseAmount, discountPercentage))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("Invalid arguments");
    }
}
