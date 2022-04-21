package nyx.tejat.view;

import nyx.tejat.dto.TransactionDto;
import nyx.tejat.model.Transaction;
import nyx.tejat.service.TransactionService;
import nyx.tejat.validator.TransactionDirectionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
public class TransactionView {

    @Autowired
    private TransactionDirectionValidator transactionDirectionValidator;

    @Autowired
    private TransactionService transactionService;

    public List<Transaction> listAll() {
        return this.transactionService.listAll();
    }

    public Transaction get(String id) {
        var transactionOptional = this.transactionService.get(id);
        if(transactionOptional.isEmpty())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "not_found"
            );

        return transactionOptional.get();
    }

    public Transaction create(TransactionDto dto) {
        if(!transactionDirectionValidator.validate(dto.getDirection()))
            throw new ResponseStatusException(
                    HttpStatus.UNPROCESSABLE_ENTITY,
                    "invalid_value (direction)"
            );

        try {
            return this.transactionService.create(dto.toTransaction());
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "insertion_error"
            );
        }

    }

    public void remove(String id) {
        this.transactionService.remove(id);
    }

}
