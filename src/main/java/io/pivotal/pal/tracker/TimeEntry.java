package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {
    private long id;
    private long projectId;
    private LocalDate date;
    private int hours;

    public TimeEntry() {
    }

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
//        this.projectId = projectId
    }

    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate date, int hours) {
    }

    public Long getId() {
        return this.id;
    }
}
