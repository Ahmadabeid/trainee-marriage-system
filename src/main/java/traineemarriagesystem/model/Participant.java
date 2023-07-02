package traineemarriagesystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name="Participant")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Participant  extends User{
    String qualification;
    String status;

    @ManyToMany
    @JoinTable(name="participant_course",
    joinColumns = @JoinColumn(name="userID"),
    inverseJoinColumns = @JoinColumn(name="courseId"))
    private List<Course> courses;

}
