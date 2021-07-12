package tests
import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.{BottleDeposit, Item, LoyaltySale, SalesTax}
class ApplicationObjective3 extends FunSuite {
  val chips: Item = new Item("spicy",20)
  val bedset: Item = new Item("bedset", 1000)
  val mag: Item = new Item("Maggie", 50)
  val ramen: Item = new Item("noddles", 100)
  val ST : SalesTax = new SalesTax(10)
  val ST2 : SalesTax = new SalesTax(2)
  val LT: LoyaltySale = new LoyaltySale(10)
  val DS : BottleDeposit  = new BottleDeposit(1.5)
  bedset.addModifier(DS)
  mag.addModifier(DS)
  bedset.addModifier(LT)
  mag.addModifier(LT)
  val test0 = new SelfCheckout()

  test0.addItem("98765",chips)
  test0.addItem("12345", bedset)
  test0.addItem("23456", mag)
  test0.addItem("34567", ramen)


  bedset.addModifier(ST)
  mag.addModifier(ST2)
  test("zero" ) {

    test0.numberPressed(1)
    test0.numberPressed(2)
    test0.numberPressed(3)
    test0.numberPressed(4)
    test0.numberPressed(5)


    test0.enterPressed()
    test0.cashPressed()
    test0.creditPressed()
    test0.creditPressed()
    test0.enterPressed()


    assert(test0.receiptLines()(0).description=="bedset" )
    assert(test0.receiptLines()(0).amount==1000)
  }

  test("first" ) {


    test0.cashPressed()
    test0.creditPressed()
    test0.enterPressed()

    test0.numberPressed(1)
    test0.numberPressed(2)
    test0.numberPressed(3)
    test0.numberPressed(4)
    test0.numberPressed(5)
    test0.enterPressed()
    assert(test0.receiptLines()(0).description=="bedset" )
    assert(test0.receiptLines()(0).amount==0.0)

  }
  test("Second" ) {

    test0.numberPressed(1)
    test0.numberPressed(2)
    test0.numberPressed(3)
    test0.numberPressed(4)
    test0.numberPressed(5)
    test0.enterPressed()
    test0.cashPressed()
    test0.creditPressed()
    test0.enterPressed()

    test0.numberPressed(1)
    test0.numberPressed(2)
    test0.numberPressed(3)
    test0.numberPressed(4)
    test0.numberPressed(5)

   assert(test0.receiptLines()(0).description=="bedset" )
    assert(test0.receiptLines()(0).amount==0.0)
    test0.checkoutPressed()

    assert(test0.receiptLines()(5).amount==0.0)
    assert(test0.receiptLines()(6).amount==0.0)
    assert(test0.receiptLines()(7).amount==0.0)
  }


}
