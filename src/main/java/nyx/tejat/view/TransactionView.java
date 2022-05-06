package nyx.tejat.view;

import nyx.tejat.dto.TransactionDto;
import nyx.tejat.model.Transaction;
import nyx.tejat.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Component
public class TransactionView {

    Logger logger = LoggerFactory.getLogger(TransactionView.class);

    @Autowired
    private TransactionService transactionService;

    public List<Transaction> listAll() {
        return this.transactionService.listAll();
    }

    public Transaction get(String id) {
        var transactionOptional = this.transactionService.get(UUID.fromString(id));
        if(transactionOptional.isEmpty())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "not_found"
            );

        return transactionOptional.get();
    }

    public Transaction create(TransactionDto dto) {
        try {
            return this.transactionService.create(dto.toTransaction());
        } catch (Exception e) {
            logger.error("insertion_error", e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "insertion_error"
            );
        }

    }

    public void remove(String id) {
        this.transactionService.remove(UUID.fromString(id));
    }

}
