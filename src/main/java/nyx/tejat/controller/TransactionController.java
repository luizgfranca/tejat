package nyx.tejat.controller;

import nyx.tejat.dto.TransactionDto;
import nyx.tejat.model.Transaction;
import nyx.tejat.service.TransactionService;
import nyx.tejat.view.TransactionView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

    @Autowired
    private TransactionView transactionView;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return this.transactionView.listAll();
    }

    Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @GetMapping(value = "/{id}")
    public Transaction getTransactionByID(
            @NotEmpty @PathVariable("id") String id
    ) {
        return transactionView.get(id);
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody TransactionDto transactionDto) {
        return transactionView.create(transactionDto);
    }

    @DeleteMapping(value = "/{id}")
    public void removeTransaction(
            @NotEmpty @PathVariable("id") String id
    ) {
        logger.info(id);
        transactionView.remove(id);
    }
}
