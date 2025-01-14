package doemon.command;

import doemon.response.Response;
import doemon.storage.Storage;
import doemon.task.Task;
import doemon.task.TaskList;

/**
 * Command to unmark a task given a specified index.
 */
public class UnmarkCommand extends Command {
    /** Index of the task to be unmarked. */
    private int taskIndex;

    /**
     * Constructor for UnmarkCommand.
     *
     * @param taskIndex Index of the task to be unmarked.
     */
    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String execute(TaskList tasks, Response response, Storage storage) {
        Task task = tasks.unmarkTask(taskIndex);
        storage.unmarkTaskData(taskIndex);
        return response.unmarkTaskString(task);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
