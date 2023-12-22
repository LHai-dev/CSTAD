package co.hai.microservices.core.user.api;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 266)
    private String name;
    private String password;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_delete" )
    private Boolean isDelete;

    @Column(name = "is_student")
    private Boolean isStudent;

    /*@GeneratedValue(generator = "uuid2", strategy = GenerationType.UUID)
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")*/
    @Column(name = "uuid", columnDefinition = "VARCHAR(255)")
    private String uuid;


    @Column(name = "is_verified")
    private Boolean isVerified;

}
