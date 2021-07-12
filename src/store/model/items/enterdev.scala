package store.model.items

import store.model.checkout.{ReceiptLine, SelfCheckout}

class enterdev (something: SelfCheckout) extends Boss(something) {
  override def displayString(): String ={
    something.PressedString
  }
  override def enterPressed(): Unit = {
    something.state = new Developermode(something)
  }

  override def creditPressed(): Unit = {
    something.state = new Don1(something)
  }

  override def cashPressed(): Unit = {
    something.state = new Don1(something)
  }

  override  def receiptLines(): List[ReceiptLine] = {
    something.RECEIlist
  }


}