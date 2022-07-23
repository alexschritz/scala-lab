object NewtonSQRTRefactored {

    def sqrt(x: Double) : Double = {
        def improve(guess: Double) = 
            (guess + x / guess) / 2

        def isGoodEnough(guess: Double) = 
            Math.abs(guess * guess - x) < 0.001
            
        def sqrtIter(guess: Double): Double = 
            if isGoodEnough(guess) then guess
            else sqrtIter(improve(guess))

        sqrtIter(1);
    }

    def printResult(x: Double) = {
        println("sqrt(" + x.toString + ") result: " + sqrt(x).toString)
        println("-----------------------------------------")
    }

    def main(args: Array[String]) = {
        println("Hello Newton SQRT!")
        
        printResult(9)
        printResult(900)
        printResult(2)
        printResult(0.001)
        printResult(0.1e-20)
        printResult(0.1e20)
        //printResult(0.1e50, "sqrt(0.1e50) result: " + sqrt(0.1e50).toString); <-- THIS LOOPS ENDLESS
    }
}