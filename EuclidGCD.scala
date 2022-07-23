object EuclidGCD {
    def gcd(a: Int, b: Int): Int =
        if b == 0 then a else gcd(b, a % b)

    def factorial(n: Int): Int =
        if n == 0 then 1 else n * factorial(n - 1)

    ›def main(args: Array[String]) = {
        val g = gcd(14, 21)
        println(g)

        val f = factorial(7)
        println(f)
     }
}