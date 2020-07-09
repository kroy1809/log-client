package logger;

import java.util.*;

public class LoggerImplementation implements LogClient{
    private final TreeMap<Long, Process> queue;
    private final Map<String, Process> processes;


    public LoggerImplementation() {
        this.processes = new HashMap<>();
        this.queue = new TreeMap<>(Comparator.comparingLong(startTime -> startTime));
    }

    @Override
    public void start(String processId) {
        final long now = System.currentTimeMillis();
        final Process process =  new Process(processId, now);
        processes.put(processId, process);
        queue.put(now, process);
    }

    @Override
    public void end(String processId) {
        final long now = System.currentTimeMillis();
        processes.get(processId).setEndTime(now);
    }

    @Override
    public void poll() {
        if (queue.isEmpty()) {
            System.out.println("No task in queue.");
            return;
        }
        final Process process = queue.firstEntry().getValue();
        if (process.getEndTime()!=-1) {
            System.out.println(process.getId()+" started at "+process.getStartTime()+" and ended at "+process.getEndTime());
            processes.remove(process.getId());
            queue.pollFirstEntry();
        } else {
            System.out.println("No completed tasks in queue");
        }
    }
}
