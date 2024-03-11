package coml.amen.electronicgadgets

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter(
    private val products: List<Product>,
    private val onItemClicked: (Product) -> Unit
) : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view, onItemClicked)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount(): Int = products.size

    class ProductViewHolder(itemView: View, private val onItemClicked: (Product) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val productNameTextView: TextView = itemView.findViewById(R.id.productName)
        private val productDescriptionTextView: TextView = itemView.findViewById(R.id.productDescription)
        private val productCostTextView: TextView = itemView.findViewById(R.id.productCost)
        private val productLogoImageView: ImageView = itemView.findViewById(R.id.productLogo)
        private val productImageView: ImageView = itemView.findViewById(R.id.productImage)

        @SuppressLint("SetTextI18n")
        fun bind(product: Product) {
            productNameTextView.text = product.productName
            productDescriptionTextView.text = product.productDescription
            productCostTextView.text = " $${product.cost}"
            productImageView.setImageResource(product.imageResId)
            productLogoImageView.setImageResource(product.logoResId)

            itemView.setOnClickListener {
                //onItemClicked(product)

                val context = it.context
                val detailIntent = Intent(context, ProductDetailActivity::class.java).apply {
                    putExtra("productName", product.productName)
                    putExtra("productDescription", product.productDescription)
                    putExtra("productCost", product.cost)
                    putExtra("imageResId", product.imageResId)
                    putExtra("logoResId", product.logoResId)
                }
                context.startActivity(detailIntent)
            }
        }
    }
}
