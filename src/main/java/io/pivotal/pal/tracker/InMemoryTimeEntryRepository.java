package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository {
    public TimeEntry create(TimeEntry timeEntry) {
        return new TimeEntry();
    }

    public TimeEntry find(Long id) {
        return new TimeEntry();
    }

    public List<TimeEntry> list() {
        return new ArrayList<>();
    }

    public TimeEntry update(Long id, TimeEntry timeEntry) {
        return new TimeEntry();
    }

    public void delete(Long id) {
    }
}
