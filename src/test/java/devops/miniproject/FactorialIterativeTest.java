package devops.miniproject;

import devops.miniproject.service.ComputeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;

@ExtendWith(MockitoExtension.class)
public class FactorialIterativeTest {

    @InjectMocks
    private ComputeService computeService;

    @Test
    public void testNegativeCase() {
        Assertions.assertEquals(BigInteger.valueOf(-1), computeService.factorialIterative(-1));
    }

    @Test
    public void testZeroCase() {
        Assertions.assertEquals(BigInteger.valueOf(1), computeService.factorialIterative(0));
    }


    @Test
    public void testNormalCase() {
        Assertions.assertEquals(BigInteger.valueOf(120), computeService.factorialIterative(5));
    }

}
