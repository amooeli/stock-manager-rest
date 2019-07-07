package stockmanager.task.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import stockmanager.task.dto.UserDto;
import stockmanager.task.entity.User;
import stockmanager.task.exception.StockManagerException;
import stockmanager.task.repository.UserRepository;

import java.math.BigDecimal;

/**
 * @author ali
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    UserRepository repository;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testSaveUser() throws StockManagerException {
        when(repository.save(any(User.class))).thenAnswer(new Answer<User>() {
            @Override
            public User answer(InvocationOnMock invocation) {
                Object[] arguments = invocation.getArguments();
                if (arguments != null && arguments.length > 0 && arguments[0] != null){
                    User user = (User) arguments[0];
                    user.setId(1);
                    user.setUserId("test.user@abc.com");
                    user.setFirstName("test");
                    user.setLastName("user");
                    user.setCashBalance(new BigDecimal(1000));
                    user.setNumberOfShares(100);
                    return user;
                }
                return null;
            }
        });
        UserDto user = new UserDto();
        user.setCashBalance(new BigDecimal(1000));
        user = userService.saveUser(user);
        assertThat(user, is(notNullValue()));
    }

// todo (ali)
// @Test
//    public void testSaveUser() {
//    }
//
//    @Test
//    public void testAddToBalance() {
//    }
//
//    @Test
//    public void testRemoveFromBalance() {
//    }
}