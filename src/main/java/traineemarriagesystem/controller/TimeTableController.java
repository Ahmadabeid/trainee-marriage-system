package traineemarriagesystem.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traineemarriagesystem.model.TimeTable;
import traineemarriagesystem.model.User;
import traineemarriagesystem.service.TimeTableService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/TimeTable")
public class TimeTableController {
    private final TimeTableService timeTableService;

    @PostMapping("/addTimeTable")
    public ResponseEntity<TimeTable> addTimeTable(@RequestBody TimeTable timeTable)
    {
        TimeTable newTimeTable = timeTableService.addTimeTable(timeTable.getTtDate(),
                timeTable.getTtTime(), timeTable.getTtTitle(), timeTable.getVenue());
        return new ResponseEntity<>(newTimeTable, CREATED);
    }

    @DeleteMapping("delete/timeTableId")
    public void deleteTimeTableById(@PathVariable Long timeTableId){
        timeTableService.deleteTimeTableById(timeTableId);
    }

//    get all timetable
    @GetMapping("/getTimetables")
    public ResponseEntity<List<TimeTable>> getAllTimeTable(){
        List<TimeTable> newList= timeTableService.getAllTimeTable();
        return new ResponseEntity<>(newList,OK);
    }

//    get Timetable by id

    @GetMapping("/getTimeTableById/{timeTableId}")
    public ResponseEntity<TimeTable> getTimeTableById(@PathVariable Long timeTableId){
        TimeTable timeTable=timeTableService.getTimeTableById(timeTableId);
        return new ResponseEntity<>(timeTable,OK);
    }
}
