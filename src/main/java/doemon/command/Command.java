package doemon.command;

import doemon.response.Response;
import doemon.storage.Storage;
import doemon.task.TaskList;

/**
 * Commands executed by user-input.
 */
public abstract class Command {
    /**
     * Executes the command.
     *
     * @param tasks The list of tasks.
     * @param response The ui helper class.
     * @param storage The storage class for updating task data.
     */
    public abstract String execute(TaskList tasks, Response response, Storage storage);

    /**
     * Returns a boolean indicating if the command is an exit command.
     *
     * @return Boolean indicating if the command is an exit command.
     */
    public abstract boolean isExit();
}
