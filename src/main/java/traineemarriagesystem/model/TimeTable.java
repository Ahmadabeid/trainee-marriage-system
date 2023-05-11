package traineemarriagesystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Entity
@Data
@Table(name="timeTable")
@AllArgsConstructor
@NoArgsConstructor
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timeTableId;
    private Date ttDate;
    private Time ttTime;
    private String ttTitle;
    private String Venue;

}
