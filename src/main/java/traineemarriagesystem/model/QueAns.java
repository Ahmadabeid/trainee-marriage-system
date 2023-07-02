package traineemarriagesystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="QueAns")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueAns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long queAnsId;
    private String queContent;
    private String ansContent;
    private String topic;
    private String comment;

    @OneToMany(mappedBy = "queAns")
    private List<Course> courses;


}
