package pinguPinguEat.reservationModel;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class TimeSlot {
    private final LocalDateTime startTime;
    private final static Duration duration = Duration.ofHours(1);

    public TimeSlot(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    @Override
    //TODO does this really need to work for "Object" and not just other TimeSlots?
    public boolean equals(Object other) {
        if (other == null || other.getClass() != this.getClass()) {
            return false;
        }
        return startTime.equals(((TimeSlot)other).getStartTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime);
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
}
