package store.model.items

import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.Boss

class Don1(something: SelfCheckout) extends Boss(something) {
var receiptlist : List[ReceiptLine] = List()

  /** Jump to Don2 after displaying welcome*/
var error: Item = new Item("error",0.0)

  override def addItem(barcode: String, item: Item): Unit = {
    something.itemsScan = something.itemsScan + (barcode.toInt -> item)
    something.itemsScan2 = something.itemsScan2 + (barcode  -> item)

  }


  override def displayString(): String ={
     something.welcome
  }

  override def numberPressed(number: Int): Unit =  {
    something.PressedNumber = something.PressedNumber :+ number
    something.PressedString = something.PressedString + number.toString
    something.state = new Don2(something)
  }

  override def enterPressed(): Unit = {

    val name: Item = something.itemsScan2.getOrElse(something.PressedString,error)

    something.Enterlist =  something.Enterlist :+ name
    something.PressedString = ""
    something.welcome= ""
    something.state = new Don2(something)


  }

  override def checkoutPressed():Unit={
    something.state = new checkout(something)
  }


  override  def receiptLines(): List[ReceiptLine] = {

    var RECEIlist5 : List[ReceiptLine] = List()

    for(thing <- something.Enterlist ) {
      val amountoftheitem: Double = thing.price()
      val amountofdesp: String = thing.description()

      val block: ReceiptLine = new ReceiptLine(amountofdesp,amountoftheitem)

      RECEIlist5 =   RECEIlist5:+ block
    }

    RECEIlist5
  }


  override def cashPressed(): Unit = {
    something.welcome = ""
    something.state = new creditbutton(something)
  }

 override def loyaltyCardPressed(): Unit = {
      something.state = new LoyaltyMode(something)
  }



}
