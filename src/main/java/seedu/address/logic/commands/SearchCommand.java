package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MODULE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIAL_NAME;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.model.Model;
import seedu.address.model.module.Module;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.tutorial.Tutorial;

/**
 * Searches for all persons in the address book that fit the given parameters.
 */
public class SearchCommand extends Command {

    public static final String COMMAND_WORD = "search";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds people with the given conditions "
            + "Parameters: CONDITION1, CONDITION2, ..."
            + String.format("[%sNAME] OR [%sMODULE] OR [%sTUTORIAL]", PREFIX_NAME, PREFIX_MODULE, PREFIX_TUTORIAL_NAME)
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_MODULE + "CS1000 ";

    public static final String MESSAGE_SUCCESS = "Found the following people.";
    public static final String MESSAGE_TOO_MANY_MODULES = "Too many modules given.";

    private final List<Name> personNameToSearch;
    private final List<Module> modulesToSearch;
    public final List<Tutorial> tutorialsToSearch;

    /**
     * Creates an SearchByModuleCommand to add the specified {@code Person}
     */
    public SearchCommand(List<Name> personName, List<Module> module, List<Tutorial> tutorials) {
        personNameToSearch = personName;
        modulesToSearch = module;
        tutorialsToSearch = tutorials;
    }

    private Predicate<Person> getPersonPredicateFromModule() {
        return (person -> personNameToSearch.stream()
                .allMatch(name -> person.getName().equals(name))
                && person.getModules().containsAll(modulesToSearch)
                && person.getTutorials().containsAll(tutorialsToSearch));
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(getPersonPredicateFromModule());
        return new CommandResult(MESSAGE_SUCCESS);
    }
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof SearchCommand)) {
            return false;
        }

        List<Name> otherPersonNameToSearch = ((SearchCommand) other).personNameToSearch;
        List<Module> otherModulesToSearch = ((SearchCommand) other).modulesToSearch;
        List<Tutorial> otherTutorialsToSearch = ((SearchCommand) other).tutorialsToSearch;
        return this.personNameToSearch.equals(otherPersonNameToSearch)
                && this.modulesToSearch.equals(otherModulesToSearch)
                && this.tutorialsToSearch.equals(otherTutorialsToSearch);
    }
}
