package stockmanager.task.service;

import stockmanager.task.exception.StockManagerException;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Supports finding a user, adding and removing cash from their balance.
 *
 * @author ali
 */
public interface UserService<T> {

    /**
     * Find a user by id.
     *
     * @param id
     * @return A user
     * @throws StockManagerException
     */
    T getUser(@NotNull Integer id) throws StockManagerException;

    T saveUser(@NotNull T user) throws StockManagerException;

    /**
     * Add amount to user's cash balance.
     *
     * @param user
     * @param amount
     * @return An updated User entity
     * @throws StockManagerException
     */
    T addToBalance(@NotNull T user, @NotNull BigDecimal amount) throws StockManagerException;

    /**
     * Remove amount from user's cash balance.
     *
     * @param user
     * @param amount
     * @return An updated User entity
     * @throws StockManagerException
     */
    T removeFromBalance(@NotNull T user, @NotNull BigDecimal amount) throws StockManagerException;
}
