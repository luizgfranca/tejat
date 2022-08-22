package nyx.tejat.dto;

import lombok.Data;
import nyx.tejat.model.Account;

import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

@Data
public class AccountDto {

    Long id;

    @NotEmpty
    String name;

    String createdAt;

    String updatedAt;

    public Account toAccount() {
        var account = Account.builder()
                .id(id)
                .name(name)
                .build();
        return account;
    }

}
