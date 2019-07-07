package stockmanager.task.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stockmanager.task.dto.UserDto;
import stockmanager.task.entity.User;
import stockmanager.task.exception.StockManagerException;
import stockmanager.task.repository.UserRepository;
import stockmanager.task.util.ConverterUtil;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Optional;

/**
 * A service for managing users and their cash balance.
 * It will persist/update other changes too e.g: user id, name etc...
 *
 * @author ali
 */
@Service
public class UserServiceImpl implements UserService<UserDto> {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository repository;

    @Override
    public UserDto getUser(@NotNull Integer id) throws StockManagerException {

        log.info("in getUser. user id => {}", id);
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            return ConverterUtil.getUserDto(user.get());
        }
        throw new StockManagerException("User with id " + id + " not found.");
    }

    @Override
    public UserDto saveUser(@NotNull UserDto user) throws StockManagerException {

        log.info("in saveUser. user id => {}, amount => {}", user.getUserId());
        return ConverterUtil.getUserDto(repository.save(ConverterUtil.getUserDbo(user)));
    }

    public UserDto addToBalance(@NotNull UserDto user, @NotNull BigDecimal amount) throws StockManagerException {

        log.info("in addToBalance. user id => {}, amount => {}", user.getUserId(), amount);
        user.setCashBalance(user.getCashBalance().add(amount));
        return ConverterUtil.getUserDto(repository.save(ConverterUtil.getUserDbo(user)));
    }

    public UserDto removeFromBalance(@NotNull UserDto user, @NotNull BigDecimal amount) throws StockManagerException {

        log.info("in removeFromBalance. user id => {}, amount => {}", user.getUserId(), amount);
        user.setCashBalance(user.getCashBalance().subtract(amount));
        return ConverterUtil.getUserDto(repository.save(ConverterUtil.getUserDbo(user)));
    }
}
