package kiosk

class Order(menuClass:Menu)
{
    val menu=menuClass
    val shopBasket = mutableListOf<String>()
    val priceBasket = mutableListOf<Int>()

    fun insertOrder()
    {
        while (true)
        {
            println()
            print("장바구니에 추가할 메뉴를 입력하세요 : ")
            val insertMenu= readLine()!!
            val menuRepeat= menu.menuCheck(insertMenu)
            if (menuRepeat[0]>4){println("잘못된 입력 ")}
            else {shopBasket.add(insertMenu)
                priceBasket.add(menu.coffePrice[menuRepeat[0]][menuRepeat[1]])
                println("추가되었습니다")
            break}
        }

    }
    fun deleteOrder()
    {
        println("현재 장바구니는 ... ")
        shopBasket.forEach{print(it+" ")}
        println()
        print("장바구니에서 삭제할 메뉴를 입력하세요 : ")
        val deleteMenu= readLine()!!
        for (index in 0 until shopBasket.size){
        if (shopBasket[index].replace(" ","")==deleteMenu.replace(" ","")){
            shopBasket.removeAt(index)
            priceBasket.removeAt(index)

            break
        }
        }
    }
}

