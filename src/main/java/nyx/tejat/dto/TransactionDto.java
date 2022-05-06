package nyx.tejat.dto;

import lombok.Data;
import nyx.tejat.model.Account;
import nyx.tejat.model.Transaction;

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
    Long origin;

    @NotEmpty
    Long destination;

    String createdAt;

    public Transaction toTransaction() {
        var transaction = new Transaction();
        transaction.setDescription(this.description);
        transaction.setValue(new BigDecimal(value));
        transaction.setOrigin(Account.builder().id(origin).build());
        transaction.setDestination(A ccount.builder().id(destination).build());
        return transaction;
    }

}
