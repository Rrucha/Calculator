package store.model.items

class LoyaltySale (percentage_of_the_sale: Double) extends Modifier {


  override def computeTax(price: Double): Double ={
    0
  }
  override def LoyaltyPrice(price: Double): Double = {
    val percent: Double = this.percentage_of_the_sale/100
    val new_price: Double =  price - (percent * price )
    new_price
  }

}
