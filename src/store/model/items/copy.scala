package store.model.items

import store.model.checkout.SelfCheckout

class copy (something: SelfCheckout) extends Boss(something){

  override def displayString(): String = {
    something.thank
  }

  override def numberPressed(number: Int): Unit = {
    something.state = new heck(something)
    something.Enterlist= List()
    something.numberPressed(number)

  }
}
