package kiosk

class Cal(orderClass:Order) {
    val ord = orderClass
    var total = 0
    var pay = 0
    var eatType = ""
    var typeofEat = 0

    // class 이름 cal -> payment
    // 총합 계산을 order class로 가는것이 좋아보임  (장바구니 위치 고려 )


    fun priceCheck() {
        if (total == 0) {
            for (index in 0 until ord.priceBasket.size) {
                total += ord.priceBasket[index] }
        }
            print("선택하신 메뉴는 :")
            println(ord.shopBasket)
            print(total.toString() + "총합 가격입니다")

    }

    fun calCulation(): Int {
        while (true) {
            try {
                println("뒤로 가시려면 0을 눌러주세요")
                print("지불하실 금액을 입력해주세요 :")
                pay = readLine()!!.toInt()
            } catch (e: NumberFormatException) {
                println("숫자를 입력하세요")
                continue
            }

            if (total < pay) {
                while (true) {
                    println("HALL - 0  TAKE OUT - 1")
                    print("식사 방식을 선택해 주세요 : ")
                    try {
                        typeofEat = readLine()!!.toInt()
                    } catch (e: NumberFormatException) {
                        println("숫자를 입력하세요")
                        continue
                    }
                    if (typeofEat == 0) {
                        eatType = "매장식사"
                        break
                    }
                    else if (typeofEat == 1) {
                        eatType = "TAKE OUT"
                        break
                    }
                    else {
                        println("잘못입력하셨습니다 다시 입력해주세요")
                        continue
                    }
                }

                receipt()
                break
            }
            else if (pay == 0) {
                println("뒤로가기")
                return 0
                break
            }
            else {
                println("금액이 부족합니다")
                continue
            }
        }
        return 1
    }


        fun receipt() {
            println(" -------------영수증------------- ")
            println("|_______________________________|")
            println("|            만욱벅스             |")
            println("|_______________________________|")
            println("|주문하신 메뉴는 다음과 같습니다|")
            for (index in 0 until ord.priceBasket.size){
                print("|      ")
            print(ord.shopBasket[index]+"   :   "+ ord.priceBasket[index])
                println("     |")
            }
            println("|_______________________________|")
            print("|총금액은: ")
            print(total)
            println("                |")
            print("|지불한 금액은 : ")
            print(pay,)
            println("          |")
            print("|잔돈은 : ")
            print(pay - total)
            println("                   |")
            print("|식사 방식은 :")
            print(eatType)
            println("             |")
            println("|_______________________________|")

        }

}



