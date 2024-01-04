class JobManager {
    private val jobs = mutableListOf<Job>()

    fun addJob(job: Job) {
        if (isJobIdExists(job.jobId)) {
            println("Job ID already exists. Please use a different ID.")
        } else {
            jobs.add(job)
            println("Job added successfully.")
        }
    }

    fun printAllJobs() {
        if (jobs.isEmpty()) {
            println("No jobs available.")
        } else {
            println("List of Jobs:")
            jobs.forEachIndexed { index, job ->
                println("${index + 1}. Job ID: ${job.jobId}, Job Address: ${job.jobAddress}, " +
                        "Position ID: ${job.jobPosition.positionId}, Position Name: ${job.jobPosition.positionName}")
            }
        }
    }

    fun deleteJob(jobId: String) {
        val jobToRemove = jobs.find { it.jobId == jobId }
        if (jobToRemove != null) {
            jobs.remove(jobToRemove)
            println("Job with ID $jobId deleted successfully.")
        } else {
            println("Job with ID $jobId not found.")
        }
    }

    private fun isJobIdExists(jobId: String): Boolean {
        return jobs.any { it.jobId == jobId }
    }
}