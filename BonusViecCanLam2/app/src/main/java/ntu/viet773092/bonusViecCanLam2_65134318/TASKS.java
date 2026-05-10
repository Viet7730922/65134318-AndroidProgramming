package ntu.viet773092.bonusViecCanLam2_65134318;

import java.io.Serializable;
import java.util.HashMap;

public class TASKS implements Serializable {
    String name, date, message, priority;

    public TASKS() {
    }

    public TASKS(String name, String date, String message, String priority) {
        this.name = name;
        this.date = date;
        this.message = message;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    //
    public HashMap<String, String> toFirebaseObject() {
        HashMap<String, String> task0bject = new HashMap<String, String>();
        task0bject.put("name", name);
        task0bject.put("date", date);
        task0bject.put("message", message);
        task0bject.put("priority", priority);
        return task0bject;
    }
}
