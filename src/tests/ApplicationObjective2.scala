package tests
import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.{BottleDeposit, BuyOneGetOne, Item, LoyaltySale, SalesTax}
class ApplicationObjective2 extends FunSuite {

  val chips: Item = new Item("spicy",20)
  val bedset: Item = new Item("bedset", 1000)
  val mag: Item = new Item("Maggie", 50)
  val ramen: Item = new Item("noddles", 100)
  val ST : SalesTax = new SalesTax(10)
  val ST2 : SalesTax = new SalesTax(2)
  val LT: LoyaltySale = new LoyaltySale(10)
  val DS : BottleDeposit  = new BottleDeposit(1.5)
  val BG: BuyOneGetOne = new BuyOneGetOne()
  bedset.addModifier(DS)
  mag.addModifier(DS)
  bedset.addModifier(LT)
  mag.addModifier(LT)

  bedset.addModifier(BG)
  mag.addModifier(BG)
  val test1 = new SelfCheckout()


  test1.addItem("12345", bedset)
  test1.addItem("23456", mag)


  test("one"){
    test1.numberPressed(1)
    test1.numberPressed(2)
    test1.numberPressed(3)
    test1.numberPressed(4)
    test1.numberPressed(5)
    test1.enterPressed()
    test1.enterPressed()


    println(test1.receiptLines()(0).description)
    println(test1.receiptLines()(0).amount)
    println(test1.receiptLines()(1).description)
    println(test1.receiptLines()(1).amount)

  }
}