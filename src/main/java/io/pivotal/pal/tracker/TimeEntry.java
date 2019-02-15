package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {
    private long id;
    private long userId;
    private long projectId;
    private LocalDate date;
    private int hours;

    public TimeEntry() {
        this.id = -1;
    }

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
        this.id = -1;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate date, int hours) {
        this.id = timeEntryId;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public Long getId() {
        return this.id;
    }

    void setId(Long timeEntryId) {
        this.id = timeEntryId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TimeEntry) {
            TimeEntry testEntry = (TimeEntry) obj;
            System.out.println(
                    String.format(
                            "Comparing time entries with IDs %s and %s...",
                            testEntry.getId(),
                            this.getId()
                    )
            );
            return testEntry.getId().equals(this.getId());
        } else {
            return false;
        }
    }

    long getUserId() {
        return this.userId;
    }

    void setUserId(long newUserId) {
        this.userId = newUserId;
    }


}
