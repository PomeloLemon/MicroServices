package microservices.project.target.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "FinancialGoals")
public class FinancialGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer goalId;

    @Column(nullable = false)
    private Integer userId;

    @Column(length = 255)
    private String description;

    @Column(nullable = false)
    private BigDecimal targetAmount;

    @Column(nullable = false)
    private BigDecimal currentAmount;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column(nullable = false)
    private String status;

    // Getters and setters for all the fields
}
