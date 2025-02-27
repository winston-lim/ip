package command;

import java.io.IOException;
import exception.InsufficientArgumentsException;
import exception.TaskNotFoundException;
import task.TaskManager;

public class DeleteTaskCommand extends Command {
    // Properties
    private final String[] args;
    private final TaskManager taskManager;

    /**
     * Default constructor method.
     * 
     * @param taskManager used for delegating any task related operations
     * @param args arguments supplied for this command
     * @throws InsufficientArgumentsException thrown when no arguments where supplied for this
     *         command
     */
    public DeleteTaskCommand(TaskManager taskManager, String[] args)
            throws InsufficientArgumentsException {
        if (args.length == EMPTY_ARRAY_SIZE) {
            throw new InsufficientArgumentsException();
        }
        this.taskManager = taskManager;
        this.args = args;
    }



    /**
     * Deletes a task of specified id, or throws an error if it does not exist.
     * 
     * @return boolean whether this action exists.
     * @throws IOException thrown when saving to local storage fails
     * @throws TaskNotFoundException thrown when specified task does not exist
     */
    public boolean executeCommand() throws IOException, TaskNotFoundException {
        this.taskManager.deleteTask(Integer.parseInt(args[DEFAULT_FIRST_INDEX]));
        return false;
    }
}
