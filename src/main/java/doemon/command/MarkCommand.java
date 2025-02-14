package doemon.command;

import doemon.response.Response;
import doemon.storage.Storage;
import doemon.task.Task;
import doemon.task.TaskList;

/**
 * Command to mark a task given a specified index.
 */
public class MarkCommand extends Command {
    /** Index of the task to be marked. */
    private int taskIndex;

    /**
     * Constructor for MarkCommand.
     *
     * @param taskIndex Index of task to be marked.
     */
    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String execute(TaskList tasks, Response response, Storage storage) {
        Task task = tasks.markTask(taskIndex);
        storage.markTaskData(taskIndex);
        return response.markTaskString(task);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
