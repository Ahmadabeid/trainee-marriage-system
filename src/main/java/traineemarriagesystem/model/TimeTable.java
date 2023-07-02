package traineemarriagesystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@Table(name="timeTable")
@AllArgsConstructor
@NoArgsConstructor
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timeTableId;
    private String ttDate;
    private String ttTime;
    private String ttTitle;
    private String ttVenue;
    @OneToMany(mappedBy = "timeTable")
    private List<Course> courses;

}
