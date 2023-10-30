package seedu.address.model.tutorial;

import java.util.Objects;

import seedu.address.model.module.Module;

/**
 * Represents a Tutorial in the address book.
 */
public class Tutorial {
    /* Fields */
    private Module module;
    private String tutName;
    private String time;

    /* Constructors */

    /**
     * Constructs a {@code Tutorial}.
     * @param module Module tutorial belongs to.
     * @param tutName Name of tutorial.
     * @param time Time of tutorial.
     */
    public Tutorial(Module module, String tutName, String time) {
        this.module = module;
        this.tutName = tutName;
        this.time = time;
    }

    /**
     * Constructs a {@code Tutorial}.
     * This constructor only create a tutorial model
     * to find the actual tutorial in tutorial list.
     * @param module Module tutorial belongs to.
     * @param tutorialName Name of tutorial.
     */
    public Tutorial(Module module, String tutorialName) {
        this.module = module;
        this.tutName = tutorialName;
    }

    /* Methods */

    public String getModuleName() {
        return module.getModuleCode();
    }

    public String getTutName() {
        return tutName;
    }

    public String getTime() {
        return time;
    }

    /**
     * the equals function of Tutorial
     * @param o the object to compare
     * @throws NullPointerException when Tutorial is created
     * using the constructor with 2 arguments
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tutorial tutorial = (Tutorial) o;

        requireNonNull(this.time);
        requireNonNull(tutorial.time);

        return Objects.equals(module, tutorial.module) && Objects.equals(tutName, tutorial.tutName)
                && Objects.equals(time, tutorial.time);
    }

    @Override
    public String toString() {
        requireNonNull(time);

        StringBuffer res = new StringBuffer("");
        res.append(module.getModuleCode() + " ");
        res.append(this.getTutName() + " ");
        res.append(this.getTime() + " ");

        return res.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(module, tutName, time);
    }
}
