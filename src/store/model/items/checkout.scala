package store.model.items

import store.model.checkout.{ReceiptLine, SelfCheckout}

class checkout (something: SelfCheckout) extends Boss(something){

  override def clearPressed(): Unit = {

  }

  override def enterPressed(): Unit = {
  }


/**override def loyaltyCardPressed(): Unit = {
    something.state = new Loyaltycheckoutcopy(something)
  }*/

  override def displayString(): String = {

  something.ready
  }

  override  def receiptLines(): List[ReceiptLine] = {

    something.subtotal = something.subtotal + something.amountoftheitem2
    something.tax = something.tax + something.amountofthttax
    something.total = something.subtotal + something.tax

    val block1: ReceiptLine = new ReceiptLine("subtotal",something.subtotal)
    val block2: ReceiptLine = new ReceiptLine("tax",something.tax)
    val block3: ReceiptLine = new ReceiptLine("total",something.total)
    something.RECEIlist = something.RECEIlist :+ block1 :+ block2 :+ block3
    something.RECEIlist
  }
  override def cashPressed(): Unit = {
something.state = new Directpayment(something)

  }
 override def creditPressed(): Unit = {
   something.state = new Indirectpayment(something)
 }

  override def loyaltyCardPressed(): Unit = {
    something.state = new LoyaltyCheckout(something)
  }



}
