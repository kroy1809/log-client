package logger;

public interface LogClient {

//    When a process starts, it calls 'start' with processId
    void start(String processId);

//    When the process ends, it calls 'end' with processId and endTime
    void end(String processId);

    /* Polls the first log entry of a completed process sorted by the start time of the process
    Format: {processId} started at {startTime} and ended at {endTime}
     */
    void poll();

}
