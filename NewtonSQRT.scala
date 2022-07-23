object NewtonSQRT {
    def improve(guess: Double, x: Double): Double = {
        val improved = (guess + x / guess) / 2
        println("Guess: " + guess.toString + " Improved: " + improved.toString)
        return improved;
    }

     /* The isGoodEnough test is not very precise for small numbers 
      and can lead to non-termination for very large numbers. Explain why. 
      Answer: Maybe the precision is the problem. When division is rounded, 
      the difference between (quer * guess) and x can be bigger than 0.001 
      for large numbers */
    def isGoodEnough(guess: Double, x: Double): Boolean = {
        Math.abs(guess * guess - x) < 0.001
    }
    
    def sqrtIter(guess: Double, x: Double): Double = {
        if isGoodEnough(guess, x) then guess
        else sqrtIter(improve(guess, x), x)
    }

    def sqrt(x: Double) : Double = {
        sqrtIter(1, x);
    }

    def printMessage(x: Double, message: String) = {
        //println("SQRT of " + x.toString)
        println(message)
        println("------------------------------------------")
    }

    def main(args: Array[String]) = {
        println("Hello Newton SQRT!")
        
        printMessage(9, "sqrt(9) result: " + sqrt(9).toString);
        printMessage(900, "sqrt(900) result: " + sqrt(900).toString);
        printMessage(2, "sqrt(2) result: " + sqrt(2).toString);
        printMessage(0.001, "sqrt(0.001) result: " + sqrt(0.001).toString);
        printMessage(0.1e-20, "sqrt(0.1e-20) result: " + sqrt(00.1e-20).toString);
        printMessage(0.1e20, "sqrt(0.1e20) result: " + sqrt(0.1e20).toString);
        //printMessage(0.1e50, "sqrt(0.1e50) result: " + sqrt(0.1e50).toString); <-- THIS LOOPS ENDLESS
    }
}