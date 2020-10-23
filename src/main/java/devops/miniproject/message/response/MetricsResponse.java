package devops.miniproject.message.response;

public class MetricsResponse {

    private String totalDiskSpace;
    private String freeDiskSpace;
    private String usableDiskSpace;

    private String initialMemory;
    private String usedHeapMemory;
    private String maxHeapMemory;
    private String committedMemory;

    public String getTotalDiskSpace() {
        return totalDiskSpace;
    }

    public void setTotalDiskSpace(String totalDiskSpace) {
        this.totalDiskSpace = totalDiskSpace;
    }

    public String getFreeDiskSpace() {
        return freeDiskSpace;
    }

    public void setFreeDiskSpace(String freeDiskSpace) {
        this.freeDiskSpace = freeDiskSpace;
    }

    public String getUsableDiskSpace() {
        return usableDiskSpace;
    }

    public void setUsableDiskSpace(String usableDiskSpace) {
        this.usableDiskSpace = usableDiskSpace;
    }

    public String getInitialMemory() {
        return initialMemory;
    }

    public void setInitialMemory(String initialMemory) {
        this.initialMemory = initialMemory;
    }

    public String getUsedHeapMemory() {
        return usedHeapMemory;
    }

    public void setUsedHeapMemory(String usedHeapMemory) {
        this.usedHeapMemory = usedHeapMemory;
    }

    public String getMaxHeapMemory() {
        return maxHeapMemory;
    }

    public void setMaxHeapMemory(String maxHeapMemory) {
        this.maxHeapMemory = maxHeapMemory;
    }

    public String getCommittedMemory() {
        return committedMemory;
    }

    public void setCommittedMemory(String commitedMemory) {
        this.committedMemory = commitedMemory;
    }
}
