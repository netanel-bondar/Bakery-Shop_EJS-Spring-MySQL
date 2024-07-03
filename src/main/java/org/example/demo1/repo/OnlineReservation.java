package org.example.demo1.repo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Positive;

import java.util.Date;

@Entity
public class OnlineReservation {

    @Id
    @GeneratedValue
    private long id;

    private boolean isOutside;

    @Positive
    private int count;

    private Date date;

    public OnlineReservation() {}

    public OnlineReservation(boolean isOutside, int count, Date date) {
        this.isOutside = isOutside;
        this.count = count;
        this.date = date;
    }

    public boolean getIsOutside() {
        return isOutside;
    }
    public void setIsOutside(boolean isOutside) {
        this.isOutside = isOutside;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
