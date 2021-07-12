package store.model.items

class BottleDeposit( var totalAmountDeposit: Double) extends Modifier {
  override def updatePrice(Price: Double): Double =  {
    Price
  }
  override def computeTax(Tax: Double): Double =  {
    totalAmountDeposit
  }
}
