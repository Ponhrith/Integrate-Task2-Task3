package screen
import model.Options
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

class UserScreen {

    fun menu(){
        val option = Options()
        println("1. Click (1) to operate data from file.")
        println("2. Click (2) to operate data from the database.")
        option.userChoice = readLine() ?: "1"
        when (option.userChoice){
            "1" -> {
                operateFromFile()
                quitOrBackToMainMenu()
            }
            "2" -> {
                operateFromDatabase()
                quitOrBackToMainMenu()
            }
        }
    }

    private fun operateFromFile(){
        val processBuilder = ProcessBuilder("java", "-jar", "/Users/ponhrith/Documents/Task3-Database/Database/build/libs/Database-1.0-SNAPSHOT.jar")
        processBuilder.directory(File("/Users/ponhrith/Documents/Task3-Database/Database/build/libs/Database-1.0-SNAPSHOT.jar").parentFile)
        val process = processBuilder.start()
        val `in` = BufferedReader(InputStreamReader(process.inputStream))
        var s: String? = ""
        while (`in`.readLine().also { s = it } != null) {
            println(s)
        }
        val status = process.waitFor()
        println(status.toString())

    }

    private fun operateFromDatabase(){
        val processBuilder = ProcessBuilder("java", "-jar", "ID-1.0-SNAPSHOT.jar")
        val process = processBuilder.start()
        process.waitFor()


    }

    private fun quitOrBackToMainMenu() {
        print("Put 'q' to quit and put any keys to go back to main menu: ")
        when (readLine() ?: "y") {
            "q" -> {
                return
            }

            else -> {
                menu()
            }
        }
    }
}