package nyx.tejat.dto;

import com.fasterxml.jackson.databind.util.EnumValues;
import lombok.Data;
import nyx.tejat.model.Transaction;
import nyx.tejat.model.TransactionDirection;
import org.springframework.validation.annotation.Validated;

import javax.validation.Constraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
public class TransactionDto {

    String uuid;

    @Size(max = 255)
    @NotEmpty
    String description;

    @PositiveOrZero
    @NotEmpty
    String value;

    @NotEmpty
    String direction;

    String createdAt;

    public Transaction toTransaction() {
        var transaction = new Transaction();
        transaction.setDescription(this.description);
        transaction.setValue(new BigDecimal(value));
        transaction.setTransactionDirection(TransactionDirection.valueOf(direction));
        return transaction;
    }

}
