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
        System.out.println(String.format("Constructed time entry: %s", this.toString()));
    }

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
        this.id = -1;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
        System.out.println(String.format("Constructed time entry: %s", this.toString()));
    }

    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate date, int hours) {
        this.id = timeEntryId;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
        System.out.println(String.format("Constructed time entry: %s", this.toString()));
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

    @Override
    public String toString() {
        return String.format(
                "Time Entry (id: %d, user: %d, project: %d, hours: %d)",
                id,
                userId,
                projectId,
                hours
        );
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Long getId() {
        return this.id;
    }

    void setId(Long timeEntryId) {
        this.id = timeEntryId;
    }
}
