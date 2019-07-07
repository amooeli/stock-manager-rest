package stockmanager.task.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author ali
 */
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = -2677519699293241114L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String userId;
    private String firstName;
    private String lastName;
    private BigDecimal cashBalance;
    private Integer numberOfShares;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserStockPortfolio> portfolios = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<UserStockPortfolio> getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(List<UserStockPortfolio> portfolios) {
        this.portfolios = portfolios;
    }

    public BigDecimal getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(BigDecimal cashBalance) {
        this.cashBalance = cashBalance;
    }

    public Integer getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(Integer numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(userId, user.userId) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(cashBalance, user.cashBalance) &&
                Objects.equals(numberOfShares, user.numberOfShares) &&
                Objects.equals(portfolios, user.portfolios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, firstName, lastName, cashBalance, numberOfShares, portfolios);
    }
}
