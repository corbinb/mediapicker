package mediapicker.domain;

import java.io.Serializable;

public class Media implements Serializable {

    private String name;
    private int id;

    public void setId(int i) {
        id = i;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Id: " + id + ";");
        buffer.append("Name: " + name + ";");
        return buffer.toString();
    }
}