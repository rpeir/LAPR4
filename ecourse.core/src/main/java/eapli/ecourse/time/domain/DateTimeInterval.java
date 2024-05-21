package eapli.ecourse.time.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.time.domain.model.TimeInterval;
import eapli.framework.validations.Preconditions;
import java.util.Calendar;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Exact same class that is in eapli.framework.time.domain.model.TimestampInterval, only difference is that corrected the end() method to return the intervalEnd instead of intervalStart
 */
@Embeddable
public class DateTimeInterval implements ValueObject {
    private static final long serialVersionUID = -4658136141745243778L;
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private final Calendar intervalStart;
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private final Calendar intervalEnd;
    @JsonProperty
    @Transient
    private final TimeInterval period;

    public DateTimeInterval(final Calendar start, final Calendar end) {
        Preconditions.noneNull(new Object[]{start, end});
        this.intervalStart = start;
        this.intervalEnd = end;
        this.period = new TimeInterval(start, end);
    }

    protected DateTimeInterval() {
        this.intervalStart = this.intervalEnd = null;
        this.period = null;
    }

    public Calendar start() {
        return this.intervalStart;
    }

    public Calendar end() {
        return this.intervalEnd;
    }

    public boolean includes(final Calendar target) {
        Preconditions.nonNull(target);
        return this.period.includes(target);
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof DateTimeInterval)) {
            return false;
        } else {
            DateTimeInterval other = (DateTimeInterval)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$intervalStart = this.intervalStart;
                    Object other$intervalStart = other.intervalStart;
                    if (this$intervalStart == null) {
                        if (other$intervalStart == null) {
                            break label47;
                        }
                    } else if (this$intervalStart.equals(other$intervalStart)) {
                        break label47;
                    }

                    return false;
                }

                Object this$intervalEnd = this.intervalEnd;
                Object other$intervalEnd = other.intervalEnd;
                if (this$intervalEnd == null) {
                    if (other$intervalEnd != null) {
                        return false;
                    }
                } else if (!this$intervalEnd.equals(other$intervalEnd)) {
                    return false;
                }

                Object this$period = this.period;
                Object other$period = other.period;
                if (this$period == null) {
                    if (other$period != null) {
                        return false;
                    }
                } else if (!this$period.equals(other$period)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof DateTimeInterval;
    }

    public int hashCode() {
        int result = 1;
        Object $intervalStart = this.intervalStart;
        result = result * 59 + ($intervalStart == null ? 43 : $intervalStart.hashCode());
        Object $intervalEnd = this.intervalEnd;
        result = result * 59 + ($intervalEnd == null ? 43 : $intervalEnd.hashCode());
        Object $period = this.period;
        result = result * 59 + ($period == null ? 43 : $period.hashCode());
        return result;
    }
}
