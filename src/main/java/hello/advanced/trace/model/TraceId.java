package hello.advanced.trace.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class TraceId {

    private final String id; // uid
    private final int level; // depth

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    private String createId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public TraceId createNextTraceId() {
        return new TraceId(id, level + 1);
    }

    public TraceId createPreviousTraceId() {
        return new TraceId(id, level - 1);
    }

    public boolean isFirstLevel() {
        return level == 0;
    }
}
