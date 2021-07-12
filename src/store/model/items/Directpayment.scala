package store.model.items

import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.Boss
class Directpayment  (something: SelfCheckout) extends Boss(something) {
  override def displayString(): String = {
    something.thank
  }

  override def numberPressed(number: Int): Unit = {
    something.state = new heck(something)
    something.Enterlist= List()
    something.total = 0
    something.tax=0
    something.subtotal=0
    something.numberPressed(number)

  }
  override def cashPressed(): Unit = {

    something.state = new creditbutton(something)
  }



}
