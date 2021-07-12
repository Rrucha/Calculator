package store.model.items

import store.model.checkout.SelfCheckout

class BuySecond (something: SelfCheckout) extends Boss(something){
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
}
