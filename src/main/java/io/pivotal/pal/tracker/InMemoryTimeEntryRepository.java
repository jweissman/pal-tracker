package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private List<TimeEntry> entries;
    private long lastUsedId = 0L;

    public InMemoryTimeEntryRepository() {
        this.entries = new ArrayList<>();
    }

    public TimeEntry create(TimeEntry timeEntry) {
        if (timeEntry.getId() == -1) {
            Long newId = this.getNextId();
            timeEntry.setId(newId);
        }
        System.out.println(
                String.format("Adding entry: %s", timeEntry.toString())
        );
        this.entries.add(timeEntry);
        return timeEntry;
    }

    public TimeEntry find(long id) {
        for (TimeEntry entry : this.entries) {
            if (entry.getId().equals(id)) {
                System.out.println(
                        String.format("Found time entry: %s", entry.toString())
                );
                return entry;
            }
        }
        return null;
    }

    public List<TimeEntry> list() {
        return this.entries;
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry entryForUpdate = this.find(id);
        if (entryForUpdate != null) {
            entryForUpdate.setProjectId(timeEntry.getProjectId());
            entryForUpdate.setUserId(timeEntry.getUserId());
            entryForUpdate.setDate(timeEntry.getDate());
            entryForUpdate.setHours(timeEntry.getHours());
        }
        return entryForUpdate;
    }

    public void delete(long id) {
        List<TimeEntry> entriesToPurge = new ArrayList<>();
        for (TimeEntry entry : this.entries) {
            if (entry.getId().equals(id)) {
                entriesToPurge.add(entry);
            }
        }
        for (TimeEntry entryToPurge : entriesToPurge) {
            this.entries.remove(entryToPurge);
        }
    }

    private long getNextId() {
        this.lastUsedId += 1;
        return this.lastUsedId;
    }
}
