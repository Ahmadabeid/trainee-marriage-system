package traineemarriagesystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@Table(name="Course")
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String courseCode;
    private String courseTitle;
    private String courseYear;
    private String courseLevel;

    @ManyToOne
    @JoinColumn(name="timeTableId")
    private TimeTable timeTable;

    @OneToMany(mappedBy = "course")
    private List<Resource> resources;



    @ManyToOne
    @JoinColumn(name="QueAnsId")
    private QueAns queAns;

    @ManyToMany(mappedBy = "courses")
    private List<Trainee> trainees;

    @ManyToMany(mappedBy = "courses")
    private List<Participant> participants;





}
