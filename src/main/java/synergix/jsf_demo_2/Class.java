
package synergix.jsf_demo_2;


public class Class {
    private int id ;
    private String name;
    private int monitorid ;
    public Class()
    {
        id = 0;
        name = "Lop";
        this.monitorid = 1;

    }

    public Class(int id, String name, int monitor) {
        this.id = id;
        this.name = name;
        this.monitorid = monitor;
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
