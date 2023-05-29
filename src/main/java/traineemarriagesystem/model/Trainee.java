package traineemarriagesystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Trainee")
@EqualsAndHashCode(callSuper = true)
public class Trainee extends User{
    private String regNo;
}
