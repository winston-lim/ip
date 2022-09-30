package command;

import java.io.IOException;
import exception.InsufficentArgumentsException;
import task.TaskManager;
import task.Todo;

public class AddTodoCommand extends Command {
    private final String[] args;
    private final TaskManager taskManager;

    public AddTodoCommand(TaskManager taskManager, String[] args)
            throws InsufficentArgumentsException {
        if (args.length == EMPTY_ARRAY_SIZE) {
            throw new InsufficentArgumentsException();
        }
        this.args = args;
        this.taskManager = taskManager;
    }

    /**
     * Add a task of type todo to list of recorded tasks.
     * 
     * @return boolean whether this command exits
     * @throws IOException thrown when saving to local storage fails
     * @throws InsufficientArgumentsException thrown when given title is empty
     */
    public boolean executeCommand() throws IOException, InsufficentArgumentsException {
        String title = String.join(DEFAULT_DELIMITER, args);
        if (title.isEmpty()) {
            throw new InsufficentArgumentsException();
        }
        this.taskManager.addTask(new Todo(title));
        return false;
    }
}
