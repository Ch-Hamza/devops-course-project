package devops.miniproject.service;

import devops.miniproject.message.response.FactorialResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class ComputeService {

    public ResponseEntity<FactorialResponse>  computeFactorial(String n) {
        FactorialResponse factorialResponse = new FactorialResponse();
        BigInteger res = factorial(Integer.parseInt(n));
        factorialResponse.setResult(String.valueOf(res));
        return new ResponseEntity<>(factorialResponse, HttpStatus.OK);
    }

    public BigInteger factorial(int n) {
        return n > 2 ? new BigInteger(n+"").multiply(factorial(n-1)) : new BigInteger(n+"");
    }
}
