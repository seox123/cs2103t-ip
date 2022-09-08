package doemon.command;

import doemon.storage.Storage;
import doemon.task.Task;
import doemon.task.TaskList;
import doemon.ui.Ui;

public class UnmarkCommand extends Command {
    private int taskIndex;

    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = tasks.unmarkTask(this.taskIndex);
        ui.showUnmarkTask(task);
        storage.unmarkTaskData(this.taskIndex);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
