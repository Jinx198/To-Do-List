data class Task(val id: Int, val description: String, var isDone: Boolean = false)


fun main() {
    val tasks = mutableListOf<Task>()
    var nextId = 1

    while (true) {
        println("\n1. Add Task")
        println("2. List Tasks")
        println("3. Mark Task as Done")
        println("4. Delete Task")
        println("5. Exit")
        print("Choose an option: ")
        when (readLine()?.trim()) {
            "1" -> {
                print("Enter task description: ")
                val desc = readLine() ?: ""
                tasks.add(Task(nextId++, desc))
                println("Task added.")
            }
            "2" -> {
                if (tasks.isEmpty()) println("No tasks.")
                else tasks.forEach { t ->
                    println("${t.id}. [${if (t.isDone) "x" else " "}] ${t.description}")
                }
            }
            "3" -> {
                print("Enter task id to mark as done: ")
                val id = readLine()?.toIntOrNull()
                val task = tasks.find { it.id == id }
                if (task != null) {
                    task.isDone = true
                    println("Task marked as done.")
                } else println("Task not found.")
            }
            "4" -> {
                print("Enter task id to delete: ")
                val id = readLine()?.toIntOrNull()
                if (tasks.removeIf { it.id == id }) println("Task deleted.")
                else println("Task not found.")
            }
            "5" -> return
            else -> println("Invalid option.")
        }
    }
}
