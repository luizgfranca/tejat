package nyx.tejat.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.temporal.Temporal;
import java.util.UUID;

import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TRANSACTIONS")
public class Transaction {

    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    private UUID id;

    private String description;

    @Column(name = "transaction_value")
    private BigDecimal value;

    @Column(name = "transaction_direction")
    private TransactionDirection transactionDirection;

    @CreationTimestamp
    @Column(name = "created_at")    
    private Timestamp createdAt;
}
