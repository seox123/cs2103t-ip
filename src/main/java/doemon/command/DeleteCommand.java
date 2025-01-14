package doemon.command;

import doemon.response.Response;
import doemon.storage.Storage;
import doemon.task.Task;
import doemon.task.TaskList;

/**
 * Delete Command
 */
public class DeleteCommand extends Command {
    /** Index of the task to be deleted. */
    private int taskIndex;

    /**
     * Constructor for DeleteCommand.
     *
     * @param taskIndex Index of task to be deleted.
     */
    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String execute(TaskList tasks, Response response, Storage storage) {
        Task task = tasks.deleteTask(taskIndex);
        storage.deleteTaskData(taskIndex);
        return response.deleteTaskString(task, tasks.getSize());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
