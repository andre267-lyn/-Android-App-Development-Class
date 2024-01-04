import java.util.*

fun main() {
    val jobManager = JobManager()
    val scanner = Scanner(System.`in`)


    while (true) {
        println("============================DIGIJOBS===========================")
        println("Welcome to DIGIJOBS! Please enter initial job details:")
        println("Please choose following command:")
        println("1. Add new job")
        println("2. Print all jobs")
        println("3. Delete job")
        println("4. Exit")

        when (val choice = readInt(scanner)) {
            1 -> {
                println("=== Add New Job ===")
                scanner.nextLine()
                addNewJob(scanner, jobManager)
            }
            2 -> {
                jobManager.printAllJobs()
            }
            3 -> {
                println("Enter Job ID to delete:")
                scanner.nextLine()
                val jobIdToDelete = scanner.nextLine()
                jobManager.deleteJob(jobIdToDelete)
            }
            4 -> {
                println("Exiting DIGIJOBS. Goodbye!")
                return
            }
            else -> println("Invalid choice. Please enter a number between 1 and 4.")
        }
    }
}

fun addInitialJob(scanner: Scanner, jobManager: JobManager) {
    println("Enter Job ID:")
    val jobId = scanner.nextLine()
    println("Enter Job Address:")
    val jobAddress = scanner.nextLine()
    println("Enter Job Position ID:")
    val positionId = scanner.nextLine()
    println("Enter Job Position Name:")
    val positionName = scanner.nextLine()

    val initialJobPosition = JobPosition(positionId, positionName)
    val initialJob = Job(jobId, jobAddress, initialJobPosition)
    jobManager.addJob(initialJob)

    println("Initial job added successfully.")
}

fun addNewJob(scanner: Scanner, jobManager: JobManager) {
    println("Enter Job ID:")
    val jobId = scanner.nextLine()
    println("Enter Job Address:")
    val jobAddress = scanner.nextLine()
    println("Enter Job Position ID:")
    val positionId = scanner.nextLine()
    println("Enter Job Position Name:")
    val positionName = scanner.nextLine()

    val jobPosition = JobPosition(positionId, positionName)
    val job = Job(jobId, jobAddress, jobPosition)
    jobManager.addJob(job)
}

fun readInt(scanner: Scanner): Int {
    while (true) {
        try {
            return scanner.nextInt()
        } catch (e: InputMismatchException) {
            println("Invalid input. Please enter a number.")
            scanner.nextLine()
        }
    }
}