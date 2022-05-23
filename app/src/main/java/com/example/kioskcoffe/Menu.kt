package kiosk

import java.lang.NullPointerException

class Menu() {
    val coffeEsp = arrayOf(
        "아메리카노",
        "카페라떼",
        "카푸치노",
        "오트밀 라떼",
        "카페모카",
        "리스트레토 비안코",
        "만욱벅스 돌체 라뗴",
        "화이트 초콜릿 모카",
        "에스프레소"
    )
    val priceEsp=arrayOf(3600,4100,4100,4400,4600,4700,5100,5100,3600)
    val coffeCbr = arrayOf("콜드브루")
    val priceCbr=arrayOf(4500)

    val coffePrp =
        arrayOf("자바 칩 프라푸치노", "초콜릿 모카 프라푸치노", "카라멜 프라푸치노", "모카 프라푸치노", "에스프레소 프라푸치노", "커피 프라푸치노")
    val pricePrp=arrayOf(6100,5700,5600,5600,5100,4800)

    val coffeBld = arrayOf("딸기 요거트 블렌디드", "청포도 블랙 티 블렌디드", "망고 바나나 블렌디드", "초콜릿 바나나 블렌디드")
    val priceBld=arrayOf(6100,6300,6300,6300)

    val coffeType = arrayOf("에스프레소", "콜드브루", "프라푸치노", "블렌디드")
    val coffeMenu = arrayOf(coffeEsp, coffeCbr, coffePrp, coffeBld)
    val coffePrice= arrayOf(priceEsp,priceCbr,pricePrp,priceBld)

//    arrayOf 로 2차원 배열하고 만약 값이 추가되면 추가된 부분에 덮어서 새 배열 생성하는 방식 쓸것

    fun printMenu() {
        for (index in 0 until 4) {
            print(coffeType[index] + " : ")
            for (index2 in 0 until coffeMenu[index].size) {
                print((index2 + 1)!!.toString() + "." + coffeMenu[index][index2] +" : "+coffePrice[index][index2] + "  ")
            }
            println()
        }
    }

    fun insertMenu() {
        var insertCoffeType = 0
        lateinit var insertCoffeName :String
        var insertCoffePrice :Int
        while (true) {
            try {
                print("!추가!\n1.에스프레소 2. 콜드브루 3. 프라푸치노 4. 블렌디드 \n추가할 커피의 종류를 숫자로 입력하세요 : ")
                insertCoffeType = readLine()!!.toInt()
            }
            catch (e: NumberFormatException) {
                print("숫자를 입력하세요")
                continue
            }

                if (insertCoffeType > 4 || insertCoffeType < 0) {
                println("1~4사이의 숫자를 입력해주세요")
            } else {
                break
            }
        }
        while(true) {
            print("추가할 커피의 이름을 입력하세요 : ")
            insertCoffeName = readLine()!!
            val repeatChcek=menuCheck(insertCoffeName)
            if (repeatChcek[0]>4){
                print("추가할 커피의 가격을 입력하세요 : ")
                insertCoffePrice = readLine()!!.toInt()
                break}
            else{println("증복된 이름")}
        }
        val newCoffe = coffeMenu[insertCoffeType - 1].plus(insertCoffeName)
        val newCoffePrice=coffePrice[insertCoffeType-1].plus(insertCoffePrice)
        coffeMenu[insertCoffeType - 1] = newCoffe
        coffePrice[insertCoffeType - 1] = newCoffePrice

        println("커피의 종류는 " + coffeType[insertCoffeType - 1] + " 커피의 이름은 : " + insertCoffeName + "커피의 가격은 : " + insertCoffePrice + " 으로 추가되었습니다")
    }
    fun deleteMenu() {
        lateinit var location : Array<Int>
        while (true) {
            print("삭제할 커피의 이름을 정확히 입력해주세요 : ")
            var deleteCoffe = readLine()!!
            location = menuCheck(deleteCoffe)
            if (location[0]>4){println("잘못 입력하셨습니다 ")}
            else(break)
        }
        val type=location[0]
        val kind=location[1]
            var sequance = 0
            val afterDeleteCoffe: Array<String> =Array(coffeMenu[location[0]].size - 1) { index -> "" }
            val afterDeletePrice: Array<Int> =Array(coffeMenu[location[0]].size - 1) { index -> index }
        coffeMenu[type][kind] = ""
        for (index in 0 until coffeMenu[location[0]].size) {
            if (coffeMenu[type][index] != "") {
                afterDeleteCoffe[sequance] = coffeMenu[type][index]
                afterDeletePrice[sequance] = coffePrice[type][index]
                sequance++
            }
        }
        coffeMenu[type] = afterDeleteCoffe
        coffePrice[type] = afterDeletePrice

    }
    fun menuCheck(checkMenu: String): Array<Int>
    {
        for (index in 0 until 4)
        {
            for (index2 in 0 until coffeMenu[index].size)
            {
                if (coffeMenu[index][index2].replace(" ","") == checkMenu.replace(" ",""))
                {
                    val location = arrayOf(index, index2)
                    return location
                }
            }
        }
        return arrayOf(5)
    }
}


// 1차원 리스트로 생성후 클래스를 통해 접근하는방식 쓸것 -> 인덱스를 기억할 필요가 없어짐
// 멤버변수만 있는 클래스를 만듬 -> 메뉴를 다적어줌
// 메뉴에만 제공해주는 클래스를 만들어 멤버변수를 정리하는 방법
// 다른 클래스 멤버변수 수정 삽입을 할 때는 함수를 통해서 진행할것 -> 출력만 하는 경우는 괜찮음
// 꼭 수정이 요할때는 set -> 수정  get -> return  함수를 이용할것
// 파이썬 - 속도향상 방법 print(self.class.manwook) *5 ->empty = self. class.manwook print(empty)*5
// true false => bool type사용 할것
