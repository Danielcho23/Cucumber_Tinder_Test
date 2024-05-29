package org.example;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Match {
    private Profile profileA;
    private Profile profileB;

    public Match(Profile profileA, Profile profileB) {
        this.profileA = profileA;
        this.profileB = profileB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return (Objects.equals(profileA, match.profileA) && Objects.equals(profileB, match.profileB)) ||
                (Objects.equals(profileA, match.profileB) && Objects.equals(profileB, match.profileA));
    }

    @Override
    public int hashCode() {
        return Objects.hash(profileA, profileB);
    }
}
