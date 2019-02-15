package io.pivotal.pal.tracker;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/time-entries")
public class TimeEntryController {
    private final TimeEntryRepository timeEntryRepository;

    public TimeEntryController(
            @Autowired
            TimeEntryRepository timeEntryRepository
    ) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        return new ResponseEntity<>(
                this.timeEntryRepository.create(timeEntryToCreate),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/time-entries/{timeEntryId}")
    public ResponseEntity read(@PathVariable("timeEntryId") Long timeEntryId) {
//        Long id = Long.valueOf(timeEntryId);
        System.out.println(String.format("READ looking up entry with id %d", timeEntryId));
        TimeEntry entry = this.timeEntryRepository.find(timeEntryId);
        if (entry == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            System.out.println(String.format("READ found entry: %s", entry.toString()));
            return new ResponseEntity<>(
                    entry,
                    HttpStatus.OK
            );
        }
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        System.out.println("LIST looking up all time entries");
        List<TimeEntry> entries = this.timeEntryRepository.list();
        System.out.println(String.format("Found %d entries", entries.size()));
        return new ResponseEntity<>(
                entries,
                HttpStatus.OK
        );
    }

    @PutMapping("/time-entries/{timeEntryId}")
    public ResponseEntity update(@PathVariable Long timeEntryId, @RequestBody TimeEntry timeEntry) {
        TimeEntry updated =
                this.timeEntryRepository.update(timeEntryId, timeEntry);
        return new ResponseEntity<>(
                updated,
                updated == null ? HttpStatus.NOT_FOUND : HttpStatus.OK
        );
    }

    @DeleteMapping("/time-entries/{timeEntryId}")
    public ResponseEntity delete(@PathVariable Long timeEntryId) {
        this.timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity(
                HttpStatus.NO_CONTENT
        );
    }
}
