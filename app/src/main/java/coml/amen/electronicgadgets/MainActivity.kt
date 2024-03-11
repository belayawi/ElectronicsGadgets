package coml.amen.electronicgadgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var productsRecyclerView: RecyclerView
    private var cart: ArrayList<Product> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val products = ArrayList<Product>()
        products.add(Product("iPad", "iPad Pro 11-inch", 400.0, R.drawable.ipad, R.drawable.app_logo))
        products.add(Product("MacBook M3 Pro", "12-core CPU\n18-core GPU", 2500.00, R.drawable.mac_book_pro, R.drawable.app_logo))
        products.add(Product("Dell Inspiron", "13th Gen Intel® Core™ i7", 1499.00, R.drawable.dell_inspiron, R.drawable.dell_logo))
        products.add(
            Product(
                "Logitech Keyboard",
                "Logitech - PRO X\nTKL LIGHTSPEED Wireless",
                199.00,
                R.drawable.logiteck_keyboard, R.drawable.logiteck_logo
            )
        )
        products.add(Product("MacBook M3 Max", "14-core CPU\n30-core GPU", 3499.00, R.drawable.mac_book_pro, R.drawable.app_logo))
        productsRecyclerView = findViewById(R.id.productsRecyclerView)
        productsRecyclerView.layoutManager = LinearLayoutManager(this)
        productsRecyclerView.adapter = ProductsAdapter(products) { product ->
            // This lambda function is called when an item is clicked
            cart.add(product)
            Toast.makeText(this, "${product.productName} added to cart", Toast.LENGTH_SHORT).show()

        }
        val viewCartButton: Button = findViewById(R.id.viewCartButton)
        viewCartButton.setOnClickListener {
            viewCart()
        }
    }
        fun viewCart() {
            // Create a string from the cart contents
            val cartContents = cart.joinToString(separator = "\n") { it.productName }
            Toast.makeText(this, "Cart:\n$cartContents", Toast.LENGTH_LONG).show()
        }

}