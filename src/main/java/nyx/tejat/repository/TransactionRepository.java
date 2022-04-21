package nyx.tejat.repository;

import nyx.tejat.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    public List<Transaction> findByUUID(@Param("uuid") String uuid);

}
