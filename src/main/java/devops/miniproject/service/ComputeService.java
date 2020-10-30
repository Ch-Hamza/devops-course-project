package devops.miniproject.service;

import devops.miniproject.message.response.FactorialResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ComputeService {

    public ResponseEntity<FactorialResponse>  computeFactorial(String n) {
        FactorialResponse factorialResponse = new FactorialResponse();
        int res = factorial(Integer.parseInt(n));
        factorialResponse.setResult(String.valueOf(res));
        return new ResponseEntity<>(factorialResponse, HttpStatus.OK);
    }

    public int factorial(int n) {
        return n == 0 ? 1 : n * factorial(n-1);
    }
}
