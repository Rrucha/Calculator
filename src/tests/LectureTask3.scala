package tests
import org.scalatest.FunSuite
import store.model.items.Sale
import store.model.items.{BottleDeposit, SalesTax}

class LectureTask3 extends FunSuite {

  val EPSILON: Double = 0.0000001

  def compareDoubles(d1: Double, d2: Double): Boolean = {
    Math.abs(d1 - d2) < EPSILON
  }


  test("your test name") {
    val saleTAX = new SalesTax(10)
    val depo = new BottleDeposit(18)
    val saxle = new Sale(10)

    assert(compareDoubles(saleTAX.updatePrice(100),100))
    assert(compareDoubles(saleTAX.computeTax(100),10))

    assert(compareDoubles(depo.computeTax(100),18))
    assert(compareDoubles(depo.updatePrice(100),100))

 println(saxle.computeTax(10))
   assert( compareDoubles(saxle.computeTax(10),0))
    assert(compareDoubles(saxle.updatePrice(100),90))
  }

}
