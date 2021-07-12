package store.model.items

import store.model.checkout.{ReceiptLine, SelfCheckout}

abstract class Boss(something: SelfCheckout) {

  def addItem(barcode: String, item: Item): Unit={

  }

  def numberPressed(number: Int): Unit={

  }

  def clearPressed():Unit={

  }

  def enterPressed():Unit={

  }

  def checkoutPressed():Unit={

  }

  def cashPressed():Unit={

  }

  def creditPressed():Unit={

  }

  def loyaltyCardPressed():Unit={

  }

  def displayString(): String={
  ""
  }

  def receiptLines(): List[ReceiptLine]={
    List()

  }

  def prepareStore(): Unit={

  }
}
