package tests
import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.{BottleDeposit, Item, LoyaltySale, SalesTax}
class ApplicationObjective1 extends FunSuite {

  val LT: LoyaltySale = new LoyaltySale(10)
  val chips: Item = new Item("spicy", 20)
  val bedset: Item = new Item("bedset", 1000)
  val mag: Item = new Item("Maggie", 50)
  val ramen: Item = new Item("noddles", 100)
  val ST: SalesTax = new SalesTax(10)
  val ST2: SalesTax = new SalesTax(2)
  val DS: BottleDeposit = new BottleDeposit(1.5)

  bedset.addModifier(LT)
  mag.addModifier(LT)
  bedset.addModifier(DS)
  mag.addModifier(DS)
  val test0 = new SelfCheckout()
  val test1 = new SelfCheckout()
  val test2 = new SelfCheckout()
  val test3 = new SelfCheckout()
  test0.addItem("98765", chips)
  test0.addItem("12345", bedset)
  test0.addItem("23456", mag)
  test0.addItem("34567", ramen)

  test1.addItem("12345", bedset)
  test1.addItem("23456", mag)

  test2.addItem("12345", bedset)
  test2.addItem("23456", mag)

  test3.addItem("12345", bedset)
  test3.addItem("23456", mag)

  bedset.addModifier(ST)
  mag.addModifier(ST2)

  test("first") {

    test0.numberPressed(1)
    test0.numberPressed(2)
    test0.numberPressed(3)
    test0.numberPressed(4)
    test0.numberPressed(5)

    assert(test0.displayString() == "12345")
    test0.enterPressed()
    assert(test0.receiptLines()(0).description == "bedset")
    assert(test0.receiptLines()(0).amount == 1000)


  }
  test("extra"){
    test0.loyaltyCardPressed()
    assert(test0.receiptLines()(0).description=="bedset")
    assert(test0.receiptLines()(0).amount==900)
  }
  test("Second") {

    test1.numberPressed(1)
    test1.numberPressed(2)
    test1.numberPressed(3)
    test1.numberPressed(4)
    test1.numberPressed(5)
    test1.enterPressed()
    test1.enterPressed()
    test1.checkoutPressed()
    test1.loyaltyCardPressed()

    assert(test1.receiptLines()(0).amount == 900.0)
    assert(test1.receiptLines()(1).description == "bedset")
    assert(test1.receiptLines()(1).amount == 900.0)
    assert(test1.receiptLines()(2).description == "subtotal")
    assert(test1.receiptLines()(2).amount == 1800.0)


  }


  test("third") {

    test2.numberPressed(1)
    test2.numberPressed(2)
    test2.numberPressed(3)
    test2.numberPressed(4)
    test2.numberPressed(5)
    test2.enterPressed()
    test2.enterPressed()
    test2.checkoutPressed()
    test2.loyaltyCardPressed()
    assert(test2.receiptLines()(0).amount == 900.0)
    assert(test2.receiptLines()(1).description == "bedset")
    assert(test2.receiptLines()(1).amount == 900.0)

    test2.cashPressed()




  }

test("end"){
  test2.numberPressed(2)
  test2.numberPressed(3)
  test2.numberPressed(4)
  test2.numberPressed(5)
  test2.numberPressed(6)
  test2.enterPressed()
  test2.enterPressed()
  test2.checkoutPressed()
  test2.loyaltyCardPressed()


  assert(test2.receiptLines()(0).amount == 45.0)
  assert(test2.receiptLines()(1).description == "Maggie")
  assert(test2.receiptLines()(1).amount == 45.0)
  assert(test2.receiptLines()(2).description == "subtotal")
  assert(test2.receiptLines()(2).amount == 90.0)

}

}