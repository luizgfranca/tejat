package nyx.tejat.controller;

import nyx.tejat.dto.AccountDto;
import nyx.tejat.model.Account;
import nyx.tejat.view.AccountView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountView accountView;

    @GetMapping
    public List<Account> getAllAccounts() {
        return this.accountView.getAllAccounts();
    }

    @GetMapping(value = "/{id}")
    public Account getAccount(@PathVariable(value = "id") @NotNull Long id) {
        return this.accountView.getAccount(id);
    }

    @PostMapping
    public Account createAccount(@RequestBody @NotNull AccountDto accountDto) {
        return this.accountView.createAccount(accountDto);
    }

    @PutMapping
    public Account updateAccount(@RequestBody @NotNull AccountDto accountDto) {
        return this.accountView.updateAccountInformation(accountDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAccount(@PathVariable("id") @NotNull Long id) {
        this.accountView.deleteAccount(id);
    }
}
