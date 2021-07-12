package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.{Item, Sale, SalesTax}
import store.model.items.BottleDeposit
class LectureTask6 extends FunSuite {

  val chips: Item = new Item("spicy", 20)
  val bedset: Item = new Item("bedset", 1000)
  val mag: Item = new Item("Maggie", 50)
  val ramen: Item = new Item("noddles", 100)
  val ST: SalesTax = new SalesTax(10)
  val ST2: SalesTax = new SalesTax(2)

  val test3 = new SelfCheckout()
  val test1 = new SelfCheckout()
  test3.addItem("98765", chips)
  test3.addItem("12345", bedset)
  test3.addItem("23456", mag)
  test3.addItem("34567", ramen)
  test1.addItem("98765", chips)
  test1.addItem("12345", bedset)
  test1.addItem("23456", mag)
  test1.addItem("34567", ramen)


  bedset.addModifier(ST)
  mag.addModifier(ST2)



  test("second") {
    assert(test1.displayString().contains("welcome"))
    test1.numberPressed(1)
    test1.numberPressed(2)
    test1.numberPressed(3)
    test1.numberPressed(4)
    test1.numberPressed(5)

    assert(test1.displayString() == "12345")
    test1.enterPressed()
    assert(test1.receiptLines()(0).description == "bedset")

    /** test2 */

    test1.numberPressed(0)
    test1.numberPressed(1)
    test1.numberPressed(2)
    test1.numberPressed(3)
    test1.numberPressed(4)
    test1.numberPressed(5)


    assert(test1.displayString() == "012345")
    test1.enterPressed()

    /** test3 */

    test1.numberPressed(2)
    test1.numberPressed(3)
    test1.numberPressed(4)
    test1.numberPressed(5)
    test1.numberPressed(6)

    assert(test1.displayString() == "23456")
    test1.enterPressed()


    /** test4 */
    test1.numberPressed(1)
    test1.numberPressed(3)
    test1.numberPressed(4)
    test1.numberPressed(5)
    test1.numberPressed(6)

    assert(test1.displayString() == "13456")
    test1.enterPressed()


    assert(test1.receiptLines()(2).description == "Maggie")
    assert(test1.receiptLines()(2).amount == 50.0)

    test1.checkoutPressed()
    assert(test1.displayString().contains("cash or credit"))


    assert(test1.receiptLines()(4).description == "subtotal")
    assert(test1.receiptLines()(4).amount == 1050.0)
    assert(test1.receiptLines()(5).description == "tax")
    assert(test1.receiptLines()(5).amount == 101.0)
    assert(test1.receiptLines()(6).description == "total")
    assert(test1.receiptLines()(6).amount == 1151.0)


    test1.numberPressed(2)
    test1.numberPressed(3)
    test1.numberPressed(4)
    test1.numberPressed(5)
    test1.numberPressed(6)
    test1.enterPressed()


    test1.cashPressed()
    assert(test1.displayString().contains("thank you"))

    test1.numberPressed(2)
    test1.numberPressed(3)
    test1.numberPressed(4)
    test1.numberPressed(5)
    test1.numberPressed(6)

    assert(test1.displayString() == "23456")
    test1.enterPressed()
  }

  test("ANything Still hoping"){

    assert(test3.displayString().contains("welcome"))
    test3.numberPressed(1)
    test3.numberPressed(2)
    test3.numberPressed(3)
    test3.numberPressed(4)
    test3.numberPressed(5)

    assert(test3.displayString() == "12345")
    test3.enterPressed()
    assert(test3.receiptLines()(0).description == "bedset")

    /** test2 */

    test3.numberPressed(0)
    test3.numberPressed(1)
    test3.numberPressed(2)
    test3.numberPressed(3)
    test3.numberPressed(4)
    test3.numberPressed(5)


    assert(test3.displayString() == "012345")
    test3.enterPressed()

    /** test3 */

    test3.numberPressed(2)
    test3.numberPressed(3)
    test3.numberPressed(4)
    test3.numberPressed(5)
    test3.numberPressed(6)

    assert(test3.displayString() == "23456")
    test3.enterPressed()


    /** test4 */
    test3.numberPressed(1)
    test3.numberPressed(3)
    test3.numberPressed(4)
    test3.numberPressed(5)
    test3.numberPressed(6)

    assert(test3.displayString() == "13456")
    test3.enterPressed()


    assert(test3.receiptLines()(2).description == "Maggie")
    assert(test3.receiptLines()(2).amount == 50.0)
    test3.checkoutPressed()
    assert(test3.displayString().contains("cash or credit"))
    test3.cashPressed()
    test3.numberPressed(1)
    test3.numberPressed(3)
    test3.numberPressed(4)
    test3.numberPressed(5)
    test3.numberPressed(6)

    assert(test3.displayString() == "13456")
    test3.enterPressed()

  }
}
