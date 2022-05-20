package ReservationSystem;

import java.sql.Date;
import java.util.Objects;

public class TimeSlot {
    private Date startTime;

    public TimeSlot(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeSlot timeSlot = (TimeSlot) o;
        return Objects.equals(startTime, timeSlot.startTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime);
    }
}
