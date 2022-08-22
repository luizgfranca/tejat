package nyx.tejat.view;

import nyx.tejat.dto.AccountDto;
import nyx.tejat.model.Account;
import nyx.tejat.model.Transaction;
import nyx.tejat.service.AccountService;
import nyx.tejat.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Component
public class AccountView {

    Logger logger = LoggerFactory.getLogger(AccountView.class);

    @Autowired
    private AccountService accountService;

    public Account createAccount(AccountDto dto) {
        var account = dto.toAccount();
        if(account.getId() != null){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "resource_already_exists"
            );
        }



        try {
            return this.accountService.create(dto.toAccount());
        } catch (Exception e) {
            logger.error("error: " + e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "persistence_error"
            );
        }
    }

    public List<Account> getAllAccounts() {
        try {
            return this.accountService.list();
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "reading_error"
            );
        }
    }

    public Account getAccount(Long id) {
        Optional<Account> maybeAccount;

        try {
            maybeAccount = this.accountService.get(id);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "reading_error"
            );
        }

        if(maybeAccount.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "not_found"
            );
        }

        return maybeAccount.get();
    }

    public Account updateAccountInformation(AccountDto dto) {
        var account = dto.toAccount();
        if(account.getId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "id_required"
            );
        }

        Optional<Account> maybeUpdatedAccountData;
        try {
            maybeUpdatedAccountData = this.accountService.update(account);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "update_error"
            );
        }

        if(maybeUpdatedAccountData.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "not_found"
            );
        }

        return maybeUpdatedAccountData.get();
    }

    public void deleteAccount(Long id) {
        try {
            this.accountService.delete(id);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "delete_error"
            );
        }
    }
}
