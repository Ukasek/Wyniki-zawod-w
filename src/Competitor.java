public class Competitor implements Comparable<Competitor> {
    private String firstName;
    private String lastName;
    private int score;

    public Competitor(String firstName, String lastName, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Competitor c) {
        if (this.score == c.score) {
            return this.firstName.compareTo(c.firstName);
        } else if (this.lastName.equals(c.lastName)) {
            return this.firstName.compareTo(c.firstName);
        } else
            return Integer.compare(this.score, c.score);
    }
}
