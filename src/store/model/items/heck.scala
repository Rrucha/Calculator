package store.model.items

import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.Boss
class heck (something: SelfCheckout) extends Boss(something){


  var receiptlist : List[ReceiptLine] = List()
  override def addItem(barcode: String, item: Item): Unit = {
    something.itemsScan = something.itemsScan + (barcode.toInt-> item)
  }

  override def numberPressed(number: Int): Unit = {
    something.PressedString2 = ""
    something.PressedString = something.PressedString + number.toString

  }



  override def clearPressed(): Unit = {
    // TODO

    something.PressedString = ""
    something.PressedString2 = ""


  }


  override def displayString(): String ={
    something.PressedString
  }

  /** removes welcome ans jumps to FirstClenout */

  override def enterPressed(): Unit={

    val error: Item= new Item("error",0)

    something.PressedString2 = something.PressedString2 + something.PressedString

    val name: Item = something.itemsScan.getOrElse(something.PressedString2.toInt,error)

    something.Enterlist =  something.Enterlist :+ name

    something.PressedString = ""


  }


  override  def receiptLines(): List[ReceiptLine] = {

    var RECEIlist5 : List[ReceiptLine] = List()

    for(thing <- something.Enterlist ) {
      val amountoftheitem: Double = thing.price()
      val amountofdesp: String = thing.description()

      val block: ReceiptLine = new ReceiptLine(amountofdesp,amountoftheitem)

      RECEIlist5 =   RECEIlist5:+ block
    }
 something.RECEIlist = RECEIlist5
    RECEIlist5
  }

  override def checkoutPressed():Unit={
    something.state = new checkout(something)
  }
  override def cashPressed(): Unit = {

    something.state = new creditbutton(something)
  }

  override def loyaltyCardPressed(): Unit = {
    something.state = new LoyaltyMode(something)
  }
}
