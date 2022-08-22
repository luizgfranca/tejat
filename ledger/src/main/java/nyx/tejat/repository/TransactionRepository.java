package nyx.tejat.repository;

import nyx.tejat.model.Account;
import nyx.tejat.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    Optional<Transaction> findById(UUID uuid);
    List<Transaction> findByOrigin(Account origin);
    List<Transaction> findByDestination(Account destination);
    void deleteById(UUID id);
}
