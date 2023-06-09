package traineemarriagesystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Resource")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resId;
    private String resType;
    private String resName;
    private String resContent;
    private String resFile;
    private String resDate;

    @ManyToOne
    @JoinColumn(name="courseId")
    private  Course course;


}
