package com.example.kioskcoffe.Codes

import com.example.kioskcoffe.Codes.Cal

class kiosck
{
    val menu=Menu()
    val ord=Order(menu)
    val cal= Cal(ord)
    var orderCheck =""
    var calCheck=""

    fun start() {
        while (true) {
            calCheck = ""
            orderCheck = ""

            menuPage()
            for (indx in 0 until 20) { println() }

            orderPage()

            for (indx in 0 until 20) { println() }

            if (orderCheck=="0")
            {continue}

            if (calCheck == "0") { continue }
            else { calPage() }
        }
    }

    fun menuPage()
    {
        var insertOrDelete = ""
        println("메뉴 정돈 페이지")
        println("현재 메뉴는 다음과 같습니다")
        println()
        menu.printMenu()
        while (true)
        {
            print("메뉴를 추가하려면 1 삭제하려면 2 나가려면 아무 키나 눌러주세요 :")
            insertOrDelete= readLine()!!
            if (insertOrDelete=="1")
            { menu.insertMenu() }
            else if (insertOrDelete=="2")
            { menu.deleteMenu() }
            else { break }
        }
    }
    fun orderPage()
    {
        orderCheck=""
        println("현재 메뉴는 다음과 같습니다")
        menu.printMenu()
        while (true)
        {
            println("메뉴를 주문하시려면 1 메뉴를 주문목록에서 삭제하시려면 2")
            print("뒤로 돌아가려면 0 주문하시려면 아무 숫자나 눌러 주세요 :")
            orderCheck= readln()!!
            if (orderCheck=="1")
            { ord.insertOrder() }
            else if(orderCheck=="2")
            { ord.deleteOrder() }
            else if (orderCheck=="0")
            { println("뒤로 가기 ")
                break }
            else{ break }
        }
    }
    fun calPage()
    {
        cal.priceCheck()
        if (cal.calCulation()==0)
        { calCheck = "0" }
}
}
fun main()
{
    val sta=kiosck()
    sta.start()
}