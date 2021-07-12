package store.model.items

import store.model.checkout.{ReceiptLine, SelfCheckout}

class LoyaltyCheckout (something: SelfCheckout) extends Boss(something){
  override def displayString(): String ={
    something.PressedString
  }

  override def numberPressed(number: Int): Unit = {

    something.PressedString = something.PressedString + number.toString
    something.PressedString2 = ""



  }

  override def addItem(barcode: String, item: Item): Unit = {
    var zero:Double= item.price()
    zero = 0.0
    val Itemedited : Item = new Item(item.item_description,zero)
    something.itemsScan = something.itemsScan + (barcode.toInt -> Itemedited)
    something.itemsScan2 = something.itemsScan2 + (barcode  -> Itemedited)
  }


  override def clearPressed(): Unit = {
    // TODO

    something.PressedString = ""
    something.PressedString2 = ""


  }




  /** removes welcome ans jumps to FirstClenout */

  override def enterPressed(): Unit={

    val error: Item= new Item("error",0)
    something.PressedString2 = something.PressedString2 + something.PressedString

    val name: Item = something.itemsScan2.getOrElse(something.PressedString2,error)
    something.Enterlist =  something.Enterlist :+ name
    something.PressedString = ""

  }


  override  def receiptLines(): List[ReceiptLine] = {
    var subtotal: Double = 0
    var tax:Double =0
    var total:Double = 0
    var RECEIlist2 : List[ReceiptLine] = List()

    for (i<- something.Enterlist){
      var zero :Double= i.ApplyLoyalty()

      RECEIlist2 = RECEIlist2 :+ new ReceiptLine (i.item_description,zero)
    }

    something.RECEIlist = RECEIlist2


    var amountoftheitem1: Double = 0
    var amountofthttax1: Double = 0

    for(thing <- something.Enterlist ) {
      amountoftheitem1 = amountoftheitem1 +thing.ApplyLoyalty()
      amountofthttax1 = amountofthttax1+thing.tax()
    }
    subtotal =  subtotal + amountoftheitem1
     tax =  tax + amountofthttax1
     total =  subtotal + tax

    val block1: ReceiptLine = new ReceiptLine("subtotal",subtotal)
    val block2: ReceiptLine = new ReceiptLine("tax",tax)
    val block3: ReceiptLine = new ReceiptLine("total",total)
    something.RECEIlist = something.RECEIlist :+ block1 :+ block2 :+ block3
    something.RECEIlist
  }

  override def checkoutPressed(): Unit = {
    something.state = new Loyaltycopy(something)

  }
  override def cashPressed(): Unit = {
    something.state = new Directpayment(something)

  }
  override def creditPressed(): Unit = {
    something.state = new Indirectpayment(something)
  }

}
