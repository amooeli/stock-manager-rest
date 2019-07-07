package stockmanager.task.dto;

import stockmanager.task.entity.UserStockPortfolio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author ali
 */
public class UserDto implements Serializable {

    private Integer id;
    private String userId;
    private String firstName;
    private String lastName;
    private BigDecimal cashBalance;
    private Integer numberOfShares;
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
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) &&
                Objects.equals(userId, userDto.userId) &&
                Objects.equals(firstName, userDto.firstName) &&
                Objects.equals(lastName, userDto.lastName) &&
                Objects.equals(cashBalance, userDto.cashBalance) &&
                Objects.equals(numberOfShares, userDto.numberOfShares) &&
                Objects.equals(portfolios, userDto.portfolios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, firstName, lastName, cashBalance, numberOfShares, portfolios);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDto{");
        sb.append("id=").append(id);
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", cashBalance=").append(cashBalance);
        sb.append(", numberOfShares=").append(numberOfShares);
        sb.append(", portfolios=").append(portfolios);
        sb.append('}');
        return sb.toString();
    }
}
