package logger;

import java.util.ArrayList;
import java.util.List;

public class LoggerImplementation implements LogClient{
    private final List<Process> processes;

    public LoggerImplementation(List<Process> processes) {
        this.processes = new ArrayList<>();
    }

    @Override
    public void start(String processId) {
        processes.add(new Process(processId, System.currentTimeMillis()));
    }

    @Override
    public void end(String processId) {

    }

    @Override
    public void poll() {

    }
}
