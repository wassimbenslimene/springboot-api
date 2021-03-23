package net.guides.springboot2.springboot2jpacrudexample.model;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "commands")
public class Command {

    private long id;
    private String firstName;
    private String lastName;
    private String commandName;
    private String commandNumber;
    private String date;
    private float price;
    private long amount;

    public Command() {

    }



    public Command(String firstName, String lastName, String commandNumber, String commandName, String date, float price, long amount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.commandNumber= commandNumber;
        this.commandName =commandName;
        this.date=date;
        this.price= price;
        this.amount =amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "command_number", nullable = false)
    public String getCommandNumber() {
        return commandNumber;
    }
    public void setCommandNumber(String commandNumber) {
        this.commandNumber = commandNumber;
    }

    @Column(name = "command_name", nullable = false)
    public String getCommandName() {
        return commandName;
    }
    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }


    @Column(name = "date", nullable = false)
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    @Column(name = "price", nullable = false)
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    @Column(name = "amount", nullable = false)
    public long getAmount() {
        return amount;
    }
    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Command [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", commandName=" + commandName
                + ", date=" + date + ", price=" + price+ ", amount=" + amount+ ", commandNumber=" + commandNumber+ "]";
    }

}