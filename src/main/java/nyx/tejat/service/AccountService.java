package nyx.tejat.service;

import nyx.tejat.model.Account;
import nyx.tejat.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account create(Account account) {
        return this.accountRepository.save(account);
    }

    public List<Account> list() {
        return this.accountRepository.findAll();
    }

    public Optional<Account> get(Long id) {
        return this.accountRepository.findById(id);
    }

    public Optional<Account> update(Account account) {
        var maybeAccountRegister = this.accountRepository.findById(account.getId());
        if(maybeAccountRegister.isEmpty()) {
            return Optional.empty();
        }

        var accounDataToUpdate = maybeAccountRegister.get();
        accounDataToUpdate.setName(account.getName());
        accounDataToUpdate.setUpdatedAt(Timestamp.from(Instant.now()));

        var savedAccount = this.accountRepository.save(accounDataToUpdate);
        return Optional.of(savedAccount);
    }

    public void delete(Long id) {
        this.accountRepository.deleteById(id);
    }
}
