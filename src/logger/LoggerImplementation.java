package logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoggerImplementation implements LogClient{
    private final Map<String, Process> processes;

    public LoggerImplementation(List<Process> processes) {
        this.processes = new HashMap<>();
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

    }
}
