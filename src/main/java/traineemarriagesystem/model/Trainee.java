package traineemarriagesystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Trainee")
@EqualsAndHashCode(callSuper = true)
public class Trainee extends User{
    private String regNo;
    private String pLaceOfBirth;
    private String dateOfBirth;
    private String nationality;
    private String district;
    private String ward;
    private String employmentStatus;
    private String maritalStatus;
    private String disability;
    private String disabilityTitle;
    private String educationalStatus;
    @OneToMany(mappedBy = "trainee")
    private List<Document> documents;

    @ManyToMany
    @JoinTable(name="trainee_course",
    joinColumns = @JoinColumn(name="userID"),
    inverseJoinColumns = @JoinColumn(name="courseId"))
    private List<Course> courses;


}
