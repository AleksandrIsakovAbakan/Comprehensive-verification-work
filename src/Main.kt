import java.lang.RuntimeException

fun main() {
    var n = 5
    println("Найти сумму 1+1/2+1/3+…+1/n при n $n  = ${findAmount(n)}")

    val a = 2
    val b = 4
    println("Найти сумму квадратов всех целых чисел от $a до $b включительно =" +
            " ${sumOfSquaresOfAllIntegersFromAToB(a, b)}")

    val A = 5
    val B = 13
    printAllIntegersFromAToBInclusive(A, B)

    n = 29
    checksIfNumberIsPrime(n)

    mystery()
}

/*
Дано целое число n (>0).
Найти сумму 1+1/2+1/3+…+1/n (вещественное число).
*/
fun findAmount(n:Int): Double {
    if (n <= 0) throw RuntimeException("n <= 0")
    if (n == 1) return 1.0
    var temp = 1.0
    for (a in 2..n) temp += (1.0 / a)
    return temp
}

/*
Даны два целых числа a и b (a<b).
Найти сумму квадратов всех целых чисел от a до b включительно.
*/
fun sumOfSquaresOfAllIntegersFromAToB(a: Int, b: Int): Int {
    var temp = 0
    for (c in a..b) temp += c * c
    return temp
}

/*
Даны целые числа A и B (A<B).
Вывести все целые числа от A до B включительно;
при этом число A должно выводиться 1 раз, число A+1 должно выводиться 2 раза и т. д.
(допустим a = 3, b = 5 à 3,4,4,5,5,5)
*/
fun printAllIntegersFromAToBInclusive(A: Int, B: Int){
    var result = "Вывести все целые числа от $A до $B включительно: "
    if (A < B) {
        for ((count, c) in (A..B).withIndex()) for (d in 0..count) result = "$result$c,"
        println(result.substring(0,result.length - 1))
    } else if (A == B) {
        println(result + A)
    } else {
        println("Не выполняется условие A<B")
    }
}

/*
Дано число n.
Написать программу, которая проверяет, является ли оно простым.
*/
fun checksIfNumberIsPrime(n: Int) {
    var test = false
    if (n < 2) test = true else for (a in 2 until n) if (n % a == 0) test = true
    if (test) println("Число $n не является простым") else println("Число $n является простым")
}

/*
Есть загадка: "Что это такое: синий, большой, с усами и полностью набит зайцами?"
Ответ: троллейбус.
Представим, что Вы загадываете эту загадку пользователю.
Создайте программу, которая будет считывать с консоли ответ.
Условия задачи:
У пользователя есть 3 попытки. После трех ответов программа должна завершиться;
Если пользователь вводит "Троллейбус", мы выводим в консоль "Правильно!" и выходим из цикла;
Если пользователь вводит "Сдаюсь", мы выводим в консоль "Правильный ответ: троллейбус." и выходим из цикла;
Если пользователь вводит любой другой ответ, мы выводим в консоль "Подумай еще." и продолжаем цикл.
*/
fun mystery(){
    println("Загадка: Что это такое: синий, большой, с усами и полностью набит зайцами?")
    println("Введите ответ: ")
    for (a in 1..3) {
        val response = readln()
        when (response) {
            "Троллейбус" -> {
                println("Правильно!")
                return
            }
            "Сдаюсь" -> {
                println("Правильный ответ: троллейбус.")
                return
            }
            else -> println("Подумай еще.")
        }
    }
}

/*
Примечания:
- Для вывода значений на экран используйте функцию println().
*/
