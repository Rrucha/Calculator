package store.model.items

import store.model.checkout.{ReceiptLine, SelfCheckout}

class zerototals (something: SelfCheckout) extends Boss(something){
  override def displayString(): String = {

    something.ready
  }
  override  def receiptLines(): List[ReceiptLine] = {
    var amountoftheitem1: Double = 0
    var amountofthttax1: Double = 0

    for(thing <- something.Enterlist ) {
      amountoftheitem1 = amountoftheitem1 +thing.price()
      amountofthttax1 = amountofthttax1+thing.tax()
    }
    something.subtotal = something.subtotal + 0
    something.tax = something.tax + 0
    something.total = something.subtotal + 0

    val block1: ReceiptLine = new ReceiptLine("subtotal",something.subtotal)
    val block2: ReceiptLine = new ReceiptLine("tax",something.tax)
    val block3: ReceiptLine = new ReceiptLine("total",something.total)
    something.RECEIlist = something.RECEIlist :+ block1 :+ block2 :+ block3
    something.RECEIlist
  }
  override def checkoutPressed(): Unit = {
    something.state = new copy(something)

  }
  override def cashPressed(): Unit = {
    something.state = new Directpayment(something)

  }
  override def creditPressed(): Unit = {
    something.state = new Indirectpayment(something)
  }

}
