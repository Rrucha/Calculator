package store.model.items

import store.model.checkout.{ReceiptLine, SelfCheckout}

class creditbutton (something: SelfCheckout) extends Boss(something){
  override def displayString(): String ={
    something.PressedString
  }
  override def creditPressed(): Unit = {

    something.state = new enterdev(something)
  }

  override def cashPressed(): Unit = {

    something.state = new Don1(something)
  }
  override  def receiptLines(): List[ReceiptLine] = {

    something.RECEIlist

  }
}
