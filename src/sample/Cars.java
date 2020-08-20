package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Cars {
    private int id;
    private String name, description;
    private int year;

    public Cars(int id, String name, int year, String description) {
        this.id = id;
        // this if-s are here so the fields can remain empty. also, so that the
        // year and duration can be strings
        if (year != 0) {
            this.year = year;
        } else {
            this.year = 0;
        }
       
        this.name = name;
        this.description = description;

    }

     /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setName(int id) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the director
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param director
     *            the director to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * @param year
     *            the year to set
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    
    @Override
    public String toString() {
        return new String(name + "\t" + description + "\t" + year + "\n");
    }
}
