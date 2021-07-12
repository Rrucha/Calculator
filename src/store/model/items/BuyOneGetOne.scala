package store.model.items

class BuyOneGetOne extends Modifier{

  override def updatePrice(price: Double): Double ={
    price
  }
  override def computeTax(price: Double): Double ={
    0
  }
  override def LoyaltyPrice(price: Double): Double = {
    price
  }
  override def BOGO(price: Double): Double={
    price
  }

}
