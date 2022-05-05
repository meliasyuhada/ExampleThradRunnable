package id.com.diaryme.meliasepti.threadrunnable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
            runOnUiThread(Runnable { textview.text = i.toString() })
            println("i:$i")
            Thread.sleep(2000)
        }
    }
}