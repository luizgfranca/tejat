package nyx.tejat.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.temporal.Temporal;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TRANSACTIONS")
public class Transaction {

    @Id
    @Generated
    private String uuid;

    private String description;

    @Column(name = "transaction_value")
    private BigDecimal value;

    @Column(name = "transaction_direction")
    private TransactionDirection transactionDirection;

    @Column(name = "created_at")
    private Timestamp createdAt;

}
