package nyx.tejat.service;

import java.util.List;
import java.util.Optional;

import nyx.tejat.model.Transaction;
import nyx.tejat.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> listAll() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> get(String id) {
        return transactionRepository.findById(id);
    }

    public Transaction create(Transaction transaction) {
        return this.transactionRepository.save(transaction);
    }

    public void remove(@NotNull String uuid) {
        this.transactionRepository.deleteById(uuid);
    }

}