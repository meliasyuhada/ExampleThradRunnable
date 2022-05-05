package id.com.diaryme.meliasepti.threadrunnable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Menggunakan kelas handler
    lateinit var mhandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // menggunakan heandler
        mhandler = object  : Handler() {
            override fun handleMessage(msg: Message) {
                textview.text = msg?.data?.getString("counter")
            }
        }

        button.setOnClickListener {
        // ini ThreadRunnable
//            val runnable = Worker()
//            val thread = Thread(runnable)
//            thread.start()

            Thread(Runnable { killSomeTime() }).start()
        }
    }
    // ini ThreadRunnable
//    inner class Worker : Runnable {
//        override fun run() {
//            killSomeTime()
//        }
//    }
    private  fun killSomeTime() {
        // ini ThreadRunnable
//        for (i in 1..10) {
//            Thread.sleep(2000)
//            println("i: $i")
//        }
        for (i in 1..20) {
            // mengubah UI menggunakan Thread
//            runOnUiThread(Runnable { textview.text = i.toString() })
//            println("i:$i")

    // menggunakan kelas Handler
        var msg = Message.obtain()
            msg.data.putString("counter", i.toString())
            mhandler.sendMessage(msg)
            Thread.sleep(2000)
        }
    }
}