package coml.amen.electronicgadgets

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val productName = intent.getStringExtra("productName")
        val productDescription = intent.getStringExtra("productDescription")
        val productCost = intent.getDoubleExtra("productCost", 0.0)
        val imageResId = intent.getIntExtra("imageResId", 0)
        val logoResId = intent.getIntExtra("logoResId", 0)

        findViewById<TextView>(R.id.productNameDetail).text = productName
        findViewById<TextView>(R.id.productDescriptionDetail).text = productDescription
        findViewById<TextView>(R.id.productCostDetail).text = "$"+productCost.toString()
        findViewById<ImageView>(R.id.productImageDetail).setImageResource(imageResId)
        findViewById<ImageView>(R.id.productLogoDetail).setImageResource(logoResId)

        findViewById<Button>(R.id.homeButton).setOnClickListener {
            finish()
        }
    }
}
