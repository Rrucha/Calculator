package store.model.items
import store.model.items.Boss
import store.model.checkout.{ReceiptLine, SelfCheckout}

class Don2 (something: SelfCheckout) extends Boss(something) {
  /** State pattern jumped from Don2 display numbers*/

  var receiptlist : List[ReceiptLine] = List()
  override def addItem(barcode: String, item: Item): Unit = {
    something.itemsScan = something.itemsScan + (barcode.toInt-> item)
    something.itemsScan2 = something.itemsScan2 + (barcode  -> item)
  }

  override def numberPressed(number: Int): Unit = {
    something.PressedString = something.PressedString + number.toString
    something.PressedString2 = ""


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

     val name: Item = something.itemsScan2.getOrElse(something.PressedString2,error)

    something.Enterlist =  something.Enterlist :+ name
    something.amountoftheitem1 = something.amountoftheitem1 + name.ApplyLoyalty()
    something.amountoftheitem2 = something.amountoftheitem2 + name.price()
    something.amountofthttax = something.amountofthttax+ name.tax()
    something.PressedString = ""


  }


  override  def receiptLines(): List[ReceiptLine] = {
    var RECEIlist2 : List[ReceiptLine] = List()
    for(thing <- something.Enterlist ) {
      val amountoftheitem: Double = thing.price()
      val amountofdesp: String = thing.description()

      val block: ReceiptLine = new ReceiptLine(amountofdesp,amountoftheitem)

      RECEIlist2 =   RECEIlist2:+ block
    }
  something.RECEIlist =   RECEIlist2
   RECEIlist2
  }

  override def checkoutPressed():Unit={
something.state = new checkout(something)
  }

  override def cashPressed(): Unit = {

    something.state = new creditbutton(something)

  }

  override def loyaltyCardPressed(): Unit = {

    for (i <- something.Enterlist) {
     var block: Double =  i.price()
      block = 0
      something.newEnterlist = something.newEnterlist :+ new Item(i.description() ,block)
    }
    something.state = new LoyaltyMode(something)
  }


  }
