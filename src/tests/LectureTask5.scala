package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.Item
import store.view.SelfCheckoutGUI

class LectureTask5 extends FunSuite {

        test("your test name") {
            var test1 = new SelfCheckout()


            val bedset: Item = new Item("bedset", 1000)
            val mag: Item = new Item("Maggie", 50)
            val ramen: Item = new Item("noddles", 100)
            test1.addItem("12345", bedset)
            test1.addItem("23456", mag)
            test1.addItem("34567", ramen)

            /** test1 */

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
            for(i <- test1.receiptLines()) {
                println(i.description)
                println(i.amount)


            }
        }

}
