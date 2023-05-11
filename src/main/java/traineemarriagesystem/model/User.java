package traineemarriagesystem.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;
    private String firstName;
    private String middleName;
    private String lastName;
    @Column(
            nullable = false,
            unique = true
    )
    private String username;
    private String email;
    private String address;
    private String gender;
    private String password;
    private String phoneNumber;
    private String role;
    private String[] authority;
}



