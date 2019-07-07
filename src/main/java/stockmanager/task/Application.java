package stockmanager.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import stockmanager.task.dto.UserDto;
import stockmanager.task.entity.UserStockPortfolio;
import stockmanager.task.exception.StockManagerException;
import stockmanager.task.repository.StockPortfolioRepository;
import stockmanager.task.service.UserService;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

/**
 * @author ali
 */
@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    UserService userService;

    @Autowired
    StockPortfolioRepository stockRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void insertDummyData() throws StockManagerException {
        log.info("Inserting some data.");

        UserStockPortfolio portfolio = new UserStockPortfolio("GOOG", new BigDecimal(100));
        UserDto u = new UserDto();
        u.setUserId("demoUser@abc.com");
        u.setFirstName("demo");
        u.setLastName("user");
        u.setCashBalance(new BigDecimal(1000));
        u.setNumberOfShares(100);
        u.getPortfolios().add(portfolio);
        userService.saveUser(u);
    }
}
