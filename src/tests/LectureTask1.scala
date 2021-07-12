package tests

import org.scalatest.FunSuite
import store.model.items.Item

class LectureTask1 extends FunSuite {

  val EPSILON: Double = 0.001

  def compareDoubles(d1: Double, d2: Double): Boolean = {
    Math.abs(d1 - d2) < EPSILON
  }
  test("your test name") {

    // TODO
    val test_pls_work = new Item("work", 100)
    val test_u_have_to_work = new Item("work", 800)

    /** testing */
    assert( test_pls_work.description() == "work")
assert(test_u_have_to_work.price()==800)


    /** commands to change the output */
  test_pls_work.timesScanned()
     test_pls_work.description()

    /** testing */
    assert(test_pls_work.timesScanned()==0, "My code is not freaking working ")

    /** commands to change the output */
    test_pls_work.scanned()
    test_pls_work.scanned()
     test_pls_work.scanned()
     test_pls_work.timesScanned()

    /** testing */
    assert(test_pls_work.timesScanned()==3, "something is wrong with you")


  }

}
