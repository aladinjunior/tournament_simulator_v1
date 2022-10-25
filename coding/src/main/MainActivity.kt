package co.aladinjunior.tournamentsimulator

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.aladinjunior.tournamentsimulator.Item
import co.aladinjunior.tournamentsimulator.BasketActivity
import com.example.tournamentsimulator.R

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val item = mutableListOf<Item>()
        item.add(
            Item(1,
                R.string.basket_appname,
                R.drawable.ic_baseline_sports_basketball_24,
                Color.WHITE)
        )
        item.add(
            Item(2,
            R.string.soccer_appname,
            R.drawable.ic_baseline_sports_soccer_24,
            Color.WHITE)
        )


        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.adapter = MainAdapter(item) {
            when(it){
                  1 ->{
                    startActivity(Intent(this,BasketActivity::class.java))
                }
                2 ->{
                    startActivity(Intent(this,SoccerActivity::class.java))
                }
            }
        }
        recyclerView.layoutManager = GridLayoutManager(this,2)



    }



    private inner class MainAdapter(private val item: List<Item>,
    private val onItemClickListener: (Int) -> Unit): RecyclerView.Adapter<MainAdapter.MainViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = layoutInflater.inflate(R.layout.item,parent,false)
            return MainViewHolder(view)
        }

        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            val currentItem = item[position]
            holder.bind(currentItem)
        }

        override fun getItemCount(): Int {
           return item.size
        }

        private inner class MainViewHolder(view: View): RecyclerView.ViewHolder(view) {
            fun bind(currentItem: Item) {
                val iconName = itemView.findViewById<TextView>(R.id.item_name)
                val iconImg = itemView.findViewById<ImageView>(R.id.item_img)
                val container = itemView.findViewById(R.id.layout) as LinearLayout

                iconName.setText(currentItem.itemName)
                iconImg.setImageResource(currentItem.itemIcon)
                container.setBackgroundColor(currentItem.color)

                container.setOnClickListener {
                    onItemClickListener.invoke(currentItem.id)

                }

            }
        }

    }




}