package id.com.diaryme.meliasepti.threadrunnable

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Menggunakan kelas handler
//    lateinit var mhandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // menggunakan heandler
//        mhandler = object  : Handler() {
//            override fun handleMessage(msg: Message) {
//                textview.text = msg?.data?.getString("counter")
//            }
//        }

        button.setOnClickListener {
        // ini ThreadRunnable
//            val runnable = Worker()
//            val thread = Thread(runnable)
//            thread.start()

//            Thread(Runnable { killSomeTime() }).start()
            // menggunakaan AsyncTask
            button.setOnClickListener { Worker().execute() }
        }
    }
    // ini ThreadRunnable
//    inner class Worker : Runnable {
//        override fun run() {
//            killSomeTime()
//        }
//    }

    // menggunakan AsyncTask
    inner class Worker : AsyncTask<Void, String, Boolean>() {
        override fun doInBackground(vararg p0: Void?): Boolean {
            for (i in 1..20) {
                publishProgress(i.toString())
                Thread.sleep(2000)
            }
            return true
        }

        override fun onProgressUpdate(vararg values: String?) {
            textview.text = values[0]
        }

        override fun onPostExecute(result: Boolean?) {
            println(result)
        }
    }
//    private  fun killSomeTime() {
        // ini ThreadRunnable
//        for (i in 1..10) {
//            Thread.sleep(2000)
//            println("i: $i")
//        }
//        for (i in 1..20) {
            // mengubah UI menggunakan Thread
//            runOnUiThread(Runnable { textview.text = i.toString() })
//            println("i:$i")

    // menggunakan kelas Handler
//        var msg = Message.obtain()
//            msg.data.putString("counter", i.toString())
//            mhandler.sendMessage(msg)
//            Thread.sleep(2000)
//        }
 }