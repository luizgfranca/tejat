package nyx.tejat.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import nyx.tejat.model.Account;
import nyx.tejat.model.Transaction;
import nyx.tejat.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> listAll() {
        return transactionRepository.findAll();
    }

    public List<Transaction> listByOriginAccount(Long accountId) {
        return this.transactionRepository.findByOrigin(Account.builder().id(accountId).build());
    }

    public List<Transaction> listByDestinationAccount(Long accountId) {
        return this.transactionRepository.findByDestination(Account.builder().id(accountId).build());
    }

    public Optional<Transaction> get(UUID id) {
        return transactionRepository.findById(id);
    }

    public Transaction create(Transaction transaction) {
        return this.transactionRepository.save(transaction);
    }

    @Transactional
    public void remove(@NotNull UUID id) {
        this.transactionRepository.deleteById(id);
    }

}