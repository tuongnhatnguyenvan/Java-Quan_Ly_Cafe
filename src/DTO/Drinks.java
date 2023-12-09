
package DTO;

import java.util.Date;

public class Drinks {

    private int id;
    private String name;
    private int price;
    private Date startDate;
    private Date endDate;

    public Drinks() {
    }

    public Drinks(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Drinks(int id, String name, int price, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    

    @Override
    public String toString() {
        return name;
    }

}
