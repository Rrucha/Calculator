package store.model.items

class SalesTax (percent: Double) extends Modifier{


  override def updatePrice(price: Double): Double =  {
price
  }

  override def computeTax(price: Double): Double =  {
var myTax: Double = price*percent/100
    myTax
  }


}
