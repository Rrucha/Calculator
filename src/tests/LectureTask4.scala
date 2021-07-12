package tests
import org.scalatest.FunSuite
import store.model.items.{BottleDeposit, Item, Modifier, SalesTax,Sale}

class LectureTask4 extends FunSuite {
  val EPSILON: Double = 0.0000001

  def compareDoubles(d1: Double, d2: Double): Boolean = {
    Math.abs(d1 - d2) < EPSILON
  }

  test("your test name") {

    val variable = new Item("Mobile", 1000)
    val variable2 = new Item("maggie", 100)
    val variable3 = new Item("tv", 100000)
    val vt: Modifier = new Sale (10)
    val vt2: Modifier =  new Sale (5)
    val vent: Modifier = new SalesTax(10)
    val vent2: Modifier = new SalesTax(20)

    assert(variable.price()==1000.0)

      variable.addModifier(vent)
    variable.addModifier(vt)
    variable.addModifier(vt2)
    assert(variable.price()==855.0)
    variable2.addModifier(vent2)

 assert(variable.tax()==85.5)
    assert(variable2.tax()==20)






  }

}
