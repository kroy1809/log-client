package logger;

import java.util.*;

public class LoggerImplementation implements LogClient{
    private final TreeMap<String, Process> processes;

    public LoggerImplementation(List<Process> processes) {
        this.processes = new TreeMap<>();
    }

    @Override
    public void start(String processId) {
        processes.put(processId, new Process(processId, System.currentTimeMillis()));
    }

    @Override
    public void end(String processId) {
        processes.get(processId).setEndTime(System.currentTimeMillis());
    }

    @Override
    public void poll() {
        final Process process = processes.firstEntry().getValue();
        if (process.getEndTime()!=-1) {
            System.out.println(process.getId()+" started at "+process.getStartTime()+" and ended at "+process.getEndTime());
            processes.remove(process.getId());
        }
    }
}
