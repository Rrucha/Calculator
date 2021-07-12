package store.model.items

class SaleTestingItem(var item_description: String , var item_price: Double ) {
 var sale_avail: List[Sale]= List()


  def addSale(sale: Sale): Unit = {

    sale_avail = sale_avail :+ sale

  }

  def price(): Double = {
    var basePrice: Double = this.item_price
    var answer = item_price
for (items <- sale_avail) {

  answer = items.updatePrice(basePrice)
  basePrice = answer


}

    answer
  }

}