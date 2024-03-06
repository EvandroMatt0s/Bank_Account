package Bank.model.entities;

import ExceptionSoluxan.model.exeception.DomainException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withDrawLimit;

    public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withDrawLimit = withDrawLimit;
    }

    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public String getHolder() {
        return holder;
    }
    public void setHolder(String holder) {
        this.holder = holder;
    }
    public Double getBalance() {
        return balance;
    }
    public Double getWithDrawLimit() {
        return withDrawLimit;
    }
    public void deposit(Double amount){
        this.balance += amount;
    }
    public void withDraw(Double amount){
        this.balance -= amount;
    }
    public void validateWithDraw(double amount){
        if (amount > getWithDrawLimit()) {
           throw new DomainException("Error de saque: A quantia excede o limite de saque");
        }
        if (amount > getBalance()) {
            throw new DomainException("Error de saque: Saldo insulficiente");
        }

    }

}
