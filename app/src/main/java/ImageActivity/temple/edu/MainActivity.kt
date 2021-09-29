package ImageActivity.temple.edu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mangaData: Array<ImageObject> = getData()
        val recycle = findViewById<RecyclerView>(R.id.rcvView) as RecyclerView
        var image = findViewById<ImageView>(R.id.mainImageView)
        var text = findViewById<TextView>(R.id.maintextView)
        var adapter =ImageAdapter(mangaData)
        recycle.adapter = adapter
        adapter.setOnItemClickListener(object : ImageAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                //Toast.makeText(this@MainActivity, "$position",Toast.LENGTH_LONG).show()
                image.setImageResource(mangaData[position].resourceId)
                text.text = mangaData[position].description
                text.textSize = 20F
            }
        })
        recycle.layoutManager = GridLayoutManager(this,3)

    }

    private fun getData(): Array<ImageObject> {
        return arrayOf(ImageObject("alaskanmalamute", R.drawable.alaskanmalamute), ImageObject("beagle",R.drawable.beagle),
            ImageObject("bulldogs", R.drawable.bulldogs), ImageObject("chihuahua",R.drawable.chihuahua),
            ImageObject("shiba inu",R.drawable.shibainu), ImageObject("german shepherds",R.drawable.germanshepherds),
            ImageObject("german shorthaired pointers",R.drawable.germanshorthairedpointers), ImageObject("golden retrievers",R.drawable.goldenretrievers),
            ImageObject("labrador retrievers", R.drawable.labradorretrievers), ImageObject("poodles",R.drawable.poodles),
            ImageObject("rottweilers",R.drawable.rottweilers),ImageObject("yorkshi reterriers",R.drawable.yorkshireterriers))

    }

}