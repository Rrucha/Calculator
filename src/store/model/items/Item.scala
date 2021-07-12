package store.model.items

import store.model.items.Modifier
import store.model.items.SalesTax

class Item( var item_description: String, var item_price:Double) {

  // TODO
  //var numberTimeScanned: Int = 0
  var numberTime: Int = 0
  var my_list : List[Modifier] = List()



  def addModifier(mod: Modifier): Unit ={
   my_list = my_list :+ mod
  }

  def price(): Double ={
    var END: Double =  this.item_price
    for (things <- my_list){

 END = things.updatePrice(END)
    }

 END
   }


  def ApplyLoyalty(): Double={

    var END: Double =  this.item_price
    for (things <- my_list){

      END = things.LoyaltyPrice(END)
    }

    END

    }

  def description():String={
   val answer1: String = this.item_description
    answer1

  }

  def scanned(): Unit={
    this.numberTime = numberTime + 1

  }
  def timesScanned():Int ={
    this.numberTime
  }

 def tax(): Double= {
   var resultTax: Double = 0.0
   val TAX_there_on_the_price: Double = this.price()
   for (items <- my_list){
   resultTax = resultTax + items.computeTax(TAX_there_on_the_price)
 }
resultTax
 }




}

