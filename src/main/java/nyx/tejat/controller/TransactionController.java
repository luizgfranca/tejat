package nyx.tejat.controller;

import nyx.tejat.dto.TransactionDto;
import nyx.tejat.model.Transaction;
import nyx.tejat.service.TransactionService;
import nyx.tejat.view.TransactionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
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

    @GetMapping(name = ":id")
    public Transaction getTransactionByID(
            @NotEmpty
            @Param("id")
                    String id
    ) {
        return transactionView.get(id);
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody TransactionDto transactionDto) {
        return transactionView.create(transactionDto);
    }

    @DeleteMapping(name = ":id")
    public void removeTransaction(
            @NotEmpty
            @Param("id")
                    String id)
    {
        transactionView.remove(id);
    }
}
