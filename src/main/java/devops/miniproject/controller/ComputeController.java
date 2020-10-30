package devops.miniproject.controller;

import devops.miniproject.message.response.FactorialResponse;
import devops.miniproject.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/compute")
public class ComputeController {

    @Autowired
    ComputeService computeService;

    @GetMapping(value = "")
    public ResponseEntity<FactorialResponse> computeFactorial(@RequestParam("n") String n) {
        return computeService.computeFactorial(n);
    }
}
