package stockmanager.task.util;

import org.apache.commons.beanutils.BeanUtils;
import stockmanager.task.dto.UserDto;
import stockmanager.task.entity.User;
import stockmanager.task.exception.StockManagerException;

import javax.validation.constraints.NotNull;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/**
 * A simple converter for transforming db entities to data transfer objects.
 *
 * @author ali
 */
public class ConverterUtil {

    public static UserDto getUserDto(@NotNull User dbo) throws StockManagerException {

        UserDto dto = new UserDto();
        try {
            BeanUtils.copyProperties(dto, dbo);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new StockManagerException("Cannot convert db object to dto.", e);
        }
        return dto;
    }

    public static User getUserDbo(@NotNull UserDto dto) throws StockManagerException {

        User dbo = new User();
        try {
            BeanUtils.copyProperties(dbo, dto);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new StockManagerException("Cannot convert dto db object.", e);
        }
        return dbo;
    }
}
