package doemon.task;

import doemon.exception.InvalidTaskNumberException;

import java.util.ArrayList;

public class TaskList {

    /** List of tasks. */
    private ArrayList<Task> tasks;

    /**
     * Constructor for empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructor for loaded TaskList.
     *
     * @param tasks Stored list of tasks.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Returns the task at the specified index.
     *
     * @param taskIndex Index of the task to retrieve.
     * @return The task at the specified index.
     */
    public Task getTask(int taskIndex) {
        return tasks.get(taskIndex);
    }

    /**
     * Gets the size of the list of tasks.
     *
     * @return Size of the list of tasks.
     */
    public int getSize() {
        return tasks.size();
    }

    /**
     * Adds the specified task to the list of tasks.
     *
     * @param task Task to be added.
     */
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    /**
     * Marks the task at the specified index.
     *
     * @param taskIndex Index of the task to be marked.
     * @return Task that got marked.
     * @throws InvalidTaskNumberException If the specified index is invalid.
     */
    public Task markTask(int taskIndex) throws InvalidTaskNumberException {
        if (isInvalidTaskIndex(taskIndex)) {
            throw new InvalidTaskNumberException("mark");
        }
        this.tasks.get(taskIndex).mark();
        return this.tasks.get(taskIndex);
    }

    /**
     * Unmarks the task at the specified index.
     *
     * @param taskIndex Index of the task to be unmarked.
     * @return Task that got unmarked.
     * @throws InvalidTaskNumberException If the specified index is invalid.
     */
    public Task unmarkTask(int taskIndex) throws InvalidTaskNumberException {
        if (isInvalidTaskIndex(taskIndex)) {
            throw new InvalidTaskNumberException("unmark");
        }
        this.tasks.get(taskIndex).unmark();
        return this.tasks.get(taskIndex);
    }

    /**
     * Deletes the task at the specified index.
     *
     * @param taskIndex Index of the task to be deleted.
     * @return Task that got deleted.
     * @throws InvalidTaskNumberException If the specified index is invalid.
     */
    public Task deleteTask(int taskIndex) throws InvalidTaskNumberException {
        if (isInvalidTaskIndex(taskIndex)) {
            throw new InvalidTaskNumberException("delete");
        }
        return this.tasks.remove(taskIndex);
    }

    /**
     * Checks if the specified index is invalid. A valid index is one that lies between
     * 0 and 1 less than the size of the task list, both inclusive.
     *
     * @param taskIndex Index to be checked.
     * @return Boolean indicating if the specified index is valid.
     */
    private boolean isInvalidTaskIndex(int taskIndex) {
        return taskIndex < 0 || taskIndex >= this.tasks.size();
    }
}
