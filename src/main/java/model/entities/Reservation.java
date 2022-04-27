package model.entities;

import model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn, checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date chackIn, Date checkOut){
        if(!checkOut.after(checkIn)){
            throw new DomainException("Error in reservation: Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = chackIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getChackIn() {
        return checkIn;
    }


    public Date getCheckOut() {
        return checkOut;
    }

    public long duration(){
        //diff = diferença das datas em milisegundos
        long diff = checkOut.getTime() - checkIn.getTime();
        //TimeUnit.DAYS.convert converte valor diff que está em milisegundos para dias
        return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
    }

    public void uptadeDates(Date checkIn, Date checkOut) {


        Date now = new Date();

        if(checkIn.before(now) || checkOut.before(now)){
            throw new DomainException("Error in reservation: Reservation dates for update must be future dates");
        }
        if(!checkOut.after(checkIn)){
            throw new DomainException("Error in reservation: Check-out date must be after check-in date");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;

    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", check-In: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", "
                + duration()
                + " nights";
    }
}
