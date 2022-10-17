import screen.UserScreen


class Main{
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val userScreen = UserScreen()
            userScreen.menu()
            println("===> Application has shut down")

        }
    }
}

