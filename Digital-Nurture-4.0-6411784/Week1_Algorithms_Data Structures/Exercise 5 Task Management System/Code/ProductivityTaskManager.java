public class ProductivityTaskManager {
    class WorkTask {
        int taskId;
        String taskName;
        String status;
        WorkTask next;

        public WorkTask(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
            this.next = null;
        }
    }

    private WorkTask head;
    private int size;

    public ProductivityTaskManager() {
        head = null;
        size = 0;
    }

    public void addTask(int taskId, String taskName, String status) {
        WorkTask newTask = new WorkTask(taskId, taskName, status);
        if (head == null) {
            head = newTask;
        } else {
            WorkTask current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
        size++;
    }

    public WorkTask searchTask(int taskId) {
        WorkTask current = head;
        while (current != null) {
            if (current.taskId == taskId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        WorkTask current = head;
        while (current != null) {
            System.out.println(current.taskId + ": " + current.taskName + " - " + current.status);
            current = current.next;
        }
    }

    public void deleteTask(int taskId) {
        if (head == null)
            return;

        if (head.taskId == taskId) {
            head = head.next;
            size--;
            return;
        }

        WorkTask current = head;
        while (current.next != null) {
            if (current.next.taskId == taskId) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        ProductivityTaskManager taskManager = new ProductivityTaskManager();

        
        taskManager.addTask(1, "Complete project", "Pending");
        taskManager.addTask(2, "Review code", "In Progress");
        taskManager.addTask(3, "Write documentation", "Not Started");

    
        System.out.println("All Tasks:");
        taskManager.traverseTasks();

    
        ProductivityTaskManager.WorkTask task = taskManager.searchTask(2);
        if (task != null) {
            System.out.println("\nFound task: " + task.taskName);
        }

        
        taskManager.deleteTask(1);
        System.out.println("\nAfter deletion:");
        taskManager.traverseTasks();
    }
}