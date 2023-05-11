package traineemarriagesystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueAns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long QueAnsId;
    private String QueContent;
    private String AnsContent;
    private String Topic;
    private String Comment;
}
