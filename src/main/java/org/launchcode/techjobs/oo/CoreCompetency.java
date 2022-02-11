package org.launchcode.techjobs.oo;

import java.util.Objects;

public class CoreCompetency extends JobField{

    // Custom toString, equals, and hashCode methods:
    public CoreCompetency(String value) {
        super(value);
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoreCompetency)) return false;
        CoreCompetency that = (CoreCompetency) o;
        return this.getId() == that.getId();
    }
}
