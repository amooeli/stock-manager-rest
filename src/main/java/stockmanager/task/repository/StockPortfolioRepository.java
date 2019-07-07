package stockmanager.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stockmanager.task.entity.UserStockPortfolio;

/**
 * @author ali
 */
@Repository
public interface StockPortfolioRepository extends JpaRepository<UserStockPortfolio, Integer> {}