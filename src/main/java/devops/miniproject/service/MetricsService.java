package devops.miniproject.service;

import devops.miniproject.message.response.MetricsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

@Service
public class MetricsService {


    public ResponseEntity<MetricsResponse> findMetrics() {

        MetricsResponse metricsResponse = new MetricsResponse();

        // windows file system
        File cDrive = new File("C:");
        metricsResponse.setTotalDiskSpace(String.format("%.2f GB", (double)cDrive.getTotalSpace() /1073741824));
        metricsResponse.setFreeDiskSpace(String.format("%.2f GB", (double)cDrive.getFreeSpace() /1073741824));
        metricsResponse.setUsableDiskSpace(String.format("%.2f GB", (double)cDrive.getUsableSpace() /1073741824));

        // linux file system
        /*File root = new File("/");
        metricsResponse.setTotalDiskSpace(String.format("Total space: %.2f GB", (double)root.getTotalSpace() /1073741824));
        metricsResponse.setFreeDiskSpace(String.format("Free space: %.2f GB", (double)root.getFreeSpace() /1073741824));
        metricsResponse.setUsableDiskSpace(String.format("Usable space: %.2f GB", (double)root.getUsableSpace() /1073741824));*/

        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        metricsResponse.setInitialMemory(String.format("%.2f GB", (double)memoryMXBean.getHeapMemoryUsage().getInit() /1073741824));
        metricsResponse.setUsedHeapMemory(String.format("%.2f GB", (double)memoryMXBean.getHeapMemoryUsage().getUsed() /1073741824));
        metricsResponse.setMaxHeapMemory(String.format("%.2f GB", (double)memoryMXBean.getHeapMemoryUsage().getMax() /1073741824));
        metricsResponse.setCommittedMemory(String.format("%.2f GB", (double)memoryMXBean.getHeapMemoryUsage().getCommitted() /1073741824));

        return new ResponseEntity<>(metricsResponse, HttpStatus.OK);
    }
}
