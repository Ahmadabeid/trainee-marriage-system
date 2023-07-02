package traineemarriagesystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Data
@Table(name="Document")
@AllArgsConstructor
@NoArgsConstructor

public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long docId;
    private String docType;
    private String docName;
    private String docSize;
    @ManyToOne
    @JoinColumn(name="userID")
    private  Trainee trainee;
}
