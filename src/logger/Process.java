package logger;

public class Process {
    private final String id;
    private final long startTime;
    private long endTime;

    public Process(final String id, final long startTime) {
        this.id = id;
        this.startTime = startTime;
        endTime = -1;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public String getId() {
        return id;
    }

    public long getEndTime() {
        return endTime;
    }

}
