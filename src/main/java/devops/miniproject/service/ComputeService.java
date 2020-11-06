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

    public ResponseEntity<FactorialResponse>  computeFactorialIterative(String n) {
        FactorialResponse factorialResponse = new FactorialResponse();
        BigInteger res = factorialIterative(Integer.parseInt(n));
        factorialResponse.setResult(String.valueOf(res));
        return new ResponseEntity<>(factorialResponse, HttpStatus.OK);
    }

    public BigInteger factorial(int n) {
        if(n < 0)
            return new BigInteger(n+"");
        return n == 0 ? new BigInteger(1+"") : new BigInteger(n+"").multiply(factorial(n-1));
    }

    public BigInteger factorialIterative(int n) {
        if(n < 0) {
            return new BigInteger(n+"");
        }
        else {
            BigInteger res = new BigInteger(String.valueOf(1));
            while(n > 0) {
                res = res.multiply(new BigInteger(n+""));
                n--;
            }
        }
        return n == 0 ? new BigInteger(1+"") : new BigInteger(n+"").multiply(factorial(n-1));
    }
}
