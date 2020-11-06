package devops.miniproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import devops.miniproject.service.ComputeService;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.*;

public class BenchmarkTest {

    @Test public void
    launchBenchmark() throws Exception {
        Options opt = new OptionsBuilder()
                .include(this.getClass().getName() + ".*")
                // Set the following options as needed
                .mode (Mode.AverageTime)
                .timeUnit(TimeUnit.MICROSECONDS)
                .warmupTime(TimeValue.seconds(1))
                .warmupIterations(2)
                .measurementTime(TimeValue.seconds(1))
                .measurementIterations(2)
                .threads(2)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .build();

        new Runner(opt).run();
    }

    @State(Scope.Thread)
    public static class BenchmarkState
    {
        List<Integer> list;

        @Setup(Level.Trial)
        public void initialize() {

            Random rand = new Random();
            list = new ArrayList<>();
            for (int i = 0; i < 1000; i++)
                list.add (rand.nextInt());
        }
    }

    @Benchmark
    public void benchmarkFactorialRecursive(BenchmarkState state, Blackhole bh) {
        ComputeService computeService = new ComputeService();
        for (int i = 0; i < 1000; i++)
            bh.consume(computeService.factorial(100));
    }

    @Benchmark
    public void benchmarkFactorialIterative(BenchmarkState state, Blackhole bh) {
        ComputeService computeService = new ComputeService();
        for (int i = 0; i < 1000; i++)
            bh.consume(computeService.factorialIterative(100));
    }
}
