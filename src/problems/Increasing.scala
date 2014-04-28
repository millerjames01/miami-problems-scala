package problems

import java.io._
import java.util.Scanner

object Increasing extends App {
	val reader = new BufferedReader(new FileReader("increasing.in"))
	for(i <- 1 to 10) {
	  val sc = new Scanner(reader.readLine())
	  val (x, y, z) = (sc.nextInt, sc.nextInt(), sc.nextInt())
	  if(x < y & y < z) println(s"$x $y $z STRICTLY INCREASING")
	  else if (x <= y & y <= z) println(s"$x $y $z INCREASING")
	  else println(s"$x $y $z NEITHER")
	}
}