package stockmanager.task.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author ali
 */
@Entity
public class UserStockPortfolio implements Serializable {

    private static final long serialVersionUID = 8835750059432138533L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String symbol;
    private BigDecimal price;

    @ManyToOne
    private User user;

    public UserStockPortfolio() {}
    public UserStockPortfolio(String symbol, BigDecimal balance) {
        this.symbol = symbol;
        this.price = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserStockPortfolio that = (UserStockPortfolio) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(price, that.price) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, symbol, price, user);
    }
}
