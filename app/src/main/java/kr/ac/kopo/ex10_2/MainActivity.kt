package kr.ac.kopo.ex10_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var voteCount = IntArray(9)

        for(i in 0..8)
            voteCount[i] = 0

        var image = arrayOfNulls<ImageView>(9)

        var imageId = arrayOf(R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5, R.id.img6, R.id.img7, R.id.img8, R.id.img9)

        var imgName = arrayOf("프렌치 불독 여왕", "산양 음악가", "진주 귀걸이를 한 고양이", "나들이 드레스를 입은 페럿", "생쥐 총리", "수탉 장군", "돼지 부인", "이구아나 여왕", "앵두를 든 고슴도치")

        for (i in imageId.indices) {
            // ImageView 객체의 참조값을 배열에 저장
            image[i] = findViewById<ImageView>(imageId[i])
            image[i]!!.setOnClickListener {
                voteCount[i]++
                Toast.makeText(applicationContext, imgName[i] + ": 총" + voteCount[i] + "표", Toast.LENGTH_SHORT).show()
            }
        }

        var btnDone = findViewById<Button>(R.id.btnDone)
        btnDone.setOnClickListener {
            var intent = Intent(applicationContext, ResultActivity::class.java)
            intent.putExtra("imgName", imgName)
            intent.putExtra("voteCount", voteCount)
            startActivity(intent)
        }
    }
}