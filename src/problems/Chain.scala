package problems

import java.io._

object Chain extends App {
  def factorial(n: Int, inBuild: Int = 1): Int =
    if (n == 0) inBuild else factorial(n - 1, inBuild * n)
  def countChain(intString: String, chain: List[Int]): Int = {
    val digits = intString.toCharArray.toList map (c => Integer.parseInt(c.toString))
    val factSum = digits map (factorial(_)) sum
    
    if(chain.contains(factSum)) chain.length
    else countChain(factSum.toString, factSum :: chain)
  }
  
  val reader = new BufferedReader(new FileReader("chain.in"))
  for(i <- 1 to 5) {
    val num = reader.readLine
    println(s"$num: ${countChain(num, List(Integer.parseInt(num)))}")
  }
}