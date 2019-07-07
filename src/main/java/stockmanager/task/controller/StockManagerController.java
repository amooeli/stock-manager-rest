package stockmanager.task.controller;

import java.io.IOException;
import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stockmanager.task.dto.UserDto;
import stockmanager.task.entity.StockEntity;
import stockmanager.task.exception.StockManagerException;
import stockmanager.task.service.UserService;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static stockmanager.task.util.Constants.*;

/**
 * @author ali
 */
@RestController
@RequestMapping("/stock")
public class StockManagerController {

    private static final Logger log = LoggerFactory.getLogger(StockManagerController.class);

    @Autowired
    UserService userService;

    /**
     * Get stock info for supplied symbol.
     *
     * @param symbol
     * @return A stock entity object containing name, price etc...
     * @throws StockManagerException
     */
    @RequestMapping(value = STOCK_SYMBOL)
    public ResponseEntity<StockEntity> getStock(@PathVariable(value="symbol") String symbol) throws StockManagerException {
        log.info("in getStock... symbol => {}", symbol);
        StockEntity stockEntity = getStockInfo(symbol);
        log.info("stock name => {}, price => {}", stockEntity.getName(), stockEntity.getPrice());
        return new ResponseEntity(stockEntity, HttpStatus.OK);
    }

    /**
     * Find a user by id.
     *
     * @param id
     * @return
     * @throws StockManagerException
     */
    @RequestMapping(value = GET_USER_BY_ID)
    public ResponseEntity<UserDto> getUser(@PathVariable(value="userId") Integer id) throws StockManagerException {
        log.info("in getUser... id => {}", id);
        return new ResponseEntity(userService.getUser(id), HttpStatus.OK);
    }

    /**
     * Add amount to user's cash balance.
     *
     * @param user
     * @param amount
     * @return An updated Userdto object
     * @throws StockManagerException
     */
    @RequestMapping(value = USER_ADD_AMOUNT, method= POST)
    public ResponseEntity<UserDto> addAmount(@RequestBody UserDto user, @PathVariable(value="amount") BigDecimal amount)
            throws StockManagerException {
        log.info("in addAmount... amount => {}", amount);
        return new ResponseEntity(userService.addToBalance(user, amount), HttpStatus.OK);
    }

    /**
     * Remove amount from user's cash balance.
     *
     * @param user
     * @param amount
     * @return An updated Userdto object
     * @throws StockManagerException
     */
    @RequestMapping(value= USER_REMOVE_AMOUNT, method= POST)
    public ResponseEntity<UserDto> removeAmount(@RequestBody UserDto user, @PathVariable(value="amount") BigDecimal amount)
            throws StockManagerException {
        log.info("in removeAmount... amount => {}", amount);
        return new ResponseEntity(userService.removeFromBalance(user, amount), HttpStatus.OK);
    }

    /**
     * Using YahooFinance API.
     *
     * @param symbol
     * @return A stock entity object containing name, price etc...
     */
    public StockEntity getStockInfo(String symbol) throws StockManagerException {

        YahooFinance yahoo = new YahooFinance();
        Stock st = null;
        try {
            st = yahoo.get(symbol);
        } catch (IOException e) {
            throw new StockManagerException("Cannot find stock symbol => " + symbol);
        }
        return new StockEntity(st.getSymbol(), st.getName(), st.getQuote().getPrice());
    }
}
