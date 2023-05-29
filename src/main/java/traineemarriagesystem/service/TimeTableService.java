package traineemarriagesystem.service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traineemarriagesystem.model.TimeTable;
import traineemarriagesystem.repository.TimeTableRepository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TimeTableService {
    @Autowired
   private final TimeTableRepository timeTableRepository;


    public TimeTable addTimeTable(String ttDate, String ttTime, String ttTitle, String Venue){
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

    public TimeTable updateTimeTable(Long timeTableId,String ttDate, String ttTime,
                                     String ttTiles, String Venue){
        TimeTable timeTable= getTimeTableById(timeTableId);
        timeTable.setTtDate(ttDate);
        timeTable.setTtTime(ttTime);
        timeTable.setTtTitle(ttTiles);
        timeTable.setVenue(Venue);
        return timeTableRepository.save(timeTable);
    }



}
