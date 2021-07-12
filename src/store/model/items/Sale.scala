package store.model.items

import java.awt.Desktop
import java.net.URI

class Sale (var percentOff: Double) extends Modifier(){

  override def updatePrice( price: Double): Double={
    var percent: Double = this.percentOff/100
   var new_price: Double =  price - (percent * price )
    new_price
  }

  override def computeTax(price: Double): Double =  {
   0.0

  }

}
