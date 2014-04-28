package problems

import java.io._

object Credits extends App {
	val border = 1 to 41 map (i => "*") mkString
	def space(i: Int) = 1 to i map (j => " ") mkString
	
	val reader = new BufferedReader(new FileReader("credits.in"))
	println(border)
	for(i <- 1 to 5) {
	  val (one, two) = (reader.readLine, reader.readLine)
	  println(s"*${space(18 - one.length)}$one   $two${space(18 - two.length)}*")
	}
	println(border)
}