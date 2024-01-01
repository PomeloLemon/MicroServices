package microservices.project.target.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer notificationId;

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    @Column(nullable = false, length = 20)
    private String type;

    @Column(nullable = false, length = 10)
    private String status;

    @Column
    private Date sendTime;

    @Column(nullable = false)
    private Date createTime;

    // Getters and setters for all the fields
}
