package pro.sky.telegrambot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;


@Entity(name = "Volunteers")
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long chartId;
    private String name;

    public Volunteer(long id, long chartId, String name) {
        this.id = id;
        this.chartId = chartId;
        this.name = name;
    }

    public Volunteer() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getChartId() {
        return chartId;
    }

    public void setChartId(long chartId) {
        this.chartId = chartId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Volunteer volunteer = (Volunteer) o;

        if (id != volunteer.id) return false;
        if (chartId != volunteer.chartId) return false;
        return Objects.equals(name, volunteer.name);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (chartId ^ (chartId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
