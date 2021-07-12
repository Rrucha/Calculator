package store.model.checkout

import store.model.items.{Boss, Don1, Item, Sale, SalesTax, LoyaltySale}

class SelfCheckout {
  var itemsScan: Map[Int, Item] = Map()
  var itemsScan2: Map[String, Item] = Map()

  var PressedNumber: List[Int] = List()
  var Enterlist: List[Item] = List()
  var Enterlist2: List[Item] = List()

  var newEnterlist: List[Item] = List()
  var devnewEnterlist: List[Item] = List()

  var PressedString: String = ""
  var PressedString2: String = ""

  var acc: String = ""
  var bar: String = ""
  var accn: String = ""

  var RECEIlist : List[ReceiptLine] = List()
  var devRECEIlist : List[ReceiptLine] = List()
  var RECEIlist2 : List[ReceiptLine] = List()
  var devRECEIlist2 : List[ReceiptLine] = List()
  var welcome = "Hello and welcome"
 var ready = "cash or credit"
  var thank = "thank you"

  /** State pattern*/

  var state: Boss = new Don1(this)

  /** checkout variables*/
  var subtotal: Double = 0.0
  var tax: Double =0.0
  var total: Double = 0.0

  var subtotal2: Double = 0
  var tax2:Double =0
  var total2:Double = 0
  var amountoftheitem1: Double = 0
  var amountoftheitem2: Double = 0
  var amountofthttax: Double = 0

  def addItem(barcode: String, item: Item): Unit = {

    this.state.addItem(barcode: String, item: Item)
  }


  def numberPressed(number: Int): Unit = {
    // TODO

    this.state.numberPressed(number: Int)


  }

  def clearPressed(): Unit = {
    // TODO

    this.state.clearPressed()


  }

  def enterPressed(): Unit = {

    this.state.enterPressed()

  }

  def loyaltyCardPressed(): Unit ={
    this.state.loyaltyCardPressed()
  }

  def checkoutPressed(): Unit = {
    // TODO
    this.state.checkoutPressed()
  }

  def cashPressed(): Unit = {
    // TODO
    this.state.cashPressed()
  }

  def creditPressed(): Unit = {
    // TODO
    this.state.creditPressed()
  }


  def displayString(): String = {
    // TODO
    this.state.displayString()


  }

  def receiptLines(): List[ReceiptLine] = {

    this.state.receiptLines()
  }



  def prepareStore(): Unit = {
    // Similar to openMap in the Pale Blue Dot assignment, this method is not required and is
    // meant to help you run manual tests.
    //
    // This method is called by the GUI during setup. Use this method to prepare your
    // items and call addItem to add their barcodes. Also add any sales/tax/etc to your
    // items.
    //
    // This method will not be called during testing and you should not call it in your tests.
    // Each test must setup its own items to ensure compatibility in AutoLab. However, you can
    // write a similar method in your Test Suite classes.



    val bedset : Item = new Item("bedset", 1000)
    val mag: Item = new Item("Maggie",50)
    val ramen:Item = new Item("noddles",100)

    val chips: Item = new Item("spicy",20)
      addItem("98765",chips)
      addItem("12345",bedset)
      addItem("23456",mag)
      addItem("34567",ramen)
    val ST : SalesTax = new SalesTax(10)
    val ST2 : SalesTax = new SalesTax(2)
    val LS: LoyaltySale =  new LoyaltySale(10)
    val LS2: LoyaltySale =  new LoyaltySale(5)
    bedset.addModifier(ST)
    mag.addModifier(ST2)
    bedset.addModifier(LS)
    mag.addModifier(LS2)


  }

}
