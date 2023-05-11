package traineemarriagesystem.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import traineemarriagesystem.model.TimeTable;
import traineemarriagesystem.model.User;
import traineemarriagesystem.repository.TimeTableRepository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TimeTableService {

    private final TimeTableRepository timeTableRepository;

    public TimeTable addTimeTable(Date ttDate, Time ttTime, String ttTitle, String Venue){
        TimeTable timeTable = new TimeTable();
        timeTable.setTtDate(ttDate);
        timeTable.setTtTime(ttTime);
        timeTable.setTtTitle(ttTitle);
        timeTable.setVenue(Venue);

        return timeTableRepository.save(timeTable);


    }
//    delete by id
    public void deleteTimeTableById( Long timeTableId){ timeTableRepository.deleteById( timeTableId);}

//    delete timetable by all
    public List<TimeTable> getAllTimeTable(){
        return  timeTableRepository.findAll();
    }
//    delete timetable by id
    public TimeTable getTimeTableById(Long userID){
        return timeTableRepository.findById(userID).get();
    }


}
