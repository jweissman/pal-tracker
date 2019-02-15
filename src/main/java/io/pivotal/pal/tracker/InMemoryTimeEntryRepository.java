package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository {
    private List<TimeEntry> entries;
    private long lastUsedId = 0;

    public InMemoryTimeEntryRepository() {
        this.entries = new ArrayList<>();
    }

    public TimeEntry create(TimeEntry timeEntry) {
        if (timeEntry.getId() == -1) {
            Long newId = this.getNextId(); // entries.size() + 1L;
            timeEntry.setId(newId);
        }
        System.out.println(String.format("Adding time entry with ID %d", timeEntry.getId()));
        this.entries.add(timeEntry);

        return timeEntry;

    }

    public TimeEntry find(long id) {
        for (TimeEntry entry : this.entries) {
            if (entry.getId().equals(id)) {
                System.out.println(
                        String.format("Found time entry with ID %d", entry.getId())
                );
                return entry;
            }
        }
        return null; // null obj?
    }

    public List<TimeEntry> list() {
        return this.entries; //new ArrayList<>();
    }

    public TimeEntry update(Long id, TimeEntry timeEntry) {
        TimeEntry entryForUpdate = this.find(id);
        if (entryForUpdate != null) {
//            entryForUpdate.setUserId(timeEntry.getUserId());
        }
        return entryForUpdate; //new TimeEntry();
    }

    public void delete(Long id) {
        List<TimeEntry> entriesToPurge = new ArrayList<>();

        // gather matching entries
        for (TimeEntry entry : this.entries) {
            if (entry.getId().equals(id)) {
                entriesToPurge.add(entry);
            }
        }

        // purge!
        for (TimeEntry entryToPurge : entriesToPurge) {
            this.entries.remove(entryToPurge);
        }
    }

    private Long getNextId() {
        this.lastUsedId += 1;
        return this.lastUsedId;
    }
}
