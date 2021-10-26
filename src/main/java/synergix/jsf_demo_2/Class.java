
package synergix.jsf_demo_2;


import java.util.Date;

public class Class {
    private int id ;
    private String name;
    private int monitorid ;
    private Date start_date ;
    private Date end_date ;

    public Class()
    {
        id = -1;
        name = "Ten cua lop";
        monitorid = 155;
        start_date = new Date() ;
        end_date = new Date() ;
    }

    public Class(int id, String name, int monitor , Date a , Date b) {
        this.id = id;
        this.name = name;
        this.monitorid = monitor;
        this.start_date = a ;
        this.end_date = b ;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
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

    public int getMonitorid() {
        return monitorid;
    }

    public void setMonitorid(int monitorid) {
        this.monitorid = monitorid;
    }
}
