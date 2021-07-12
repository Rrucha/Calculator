package tests

import org.scalatest.FunSuite
import store.model.items.Item
import store.model.items.Sale
import store.model.items.SaleTestingItem

class LectureTask2 extends FunSuite {
  val just_work = new SaleTestingItem("lamp", 100)
  val test2 = new SaleTestingItem("maggie",50)
  val EPSILON: Double = 0.0000001

  def compareDoubles(d1: Double, d2: Double): Boolean = {
    Math.abs(d1 - d2) < EPSILON
  }
  test("your test name") {
    val test_discount = new Sale(20)
    var test_discount2: Sale = new Sale(10)
    test_discount.updatePrice(100)


assert(compareDoubles(just_work.price(),100))

  just_work.addSale(new Sale(70))

    assert(compareDoubles(just_work.price(), 30.0))

   just_work.addSale(new Sale(30))

    assert(compareDoubles(just_work.price(), 21.0))


    var off: Sale = new Sale(10)
   test2.addSale(off)

    off.percentOff = 20
     test2.addSale(off)

 assert(compareDoubles(test2.price(),32))


  }
}
