import java.io.File
//import java.io.FileWriter
import okhttp3.*
import okio.IOException

class Question(year: Int, day: Int) {
    private val fileName = "src/main/kotlin/year${year}/year${year}day${day}.txt"
    private val file = File(fileName)
    private val client = OkHttpClient()
    private val session = File(".env").bufferedReader().use { it.readLine() }
    private val headers = Headers.Builder()
        .set("Cookie", "session=$session")
        .build()
    var questionInput = ""

    init {
        if (file.exists()) {
            questionInput = file.bufferedReader().use { it.readText() }
        } else {

            val request = Request.Builder()
                .url("https://adventofcode.com/$year/day/$day/input")
                .headers(headers)
                .build()

            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

//            for ((name, value) in response.headers) {
//                println("$name: $value")
//            }
//            println(response.body!!.string())
                val content = response.body!!.string()
//                println(file.absolutePath)
//                val writer = FileWriter(file)
//                writer.write(content)
//                writer.close()
                file.writeText(content)
            }
            questionInput = file.bufferedReader().use { it.readText() }
        }
    }

}