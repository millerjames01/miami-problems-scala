package problems

import java.io._

object Clobber extends App {
  sealed abstract class Color {
    def toggle: Color
  }
  case object Red extends Color {
    def toggle = White
  }
  case object White extends Color {
    def toggle = Red
  }
  case object Blank extends Color {
    def toggle = Blank
  }
  
  type Board = Vector[Vector[Color]]
  
  val initialCol = Vector(Red, White, Red, White)
  val altCol = initialCol map (_.toggle)
  val initialBoard = 
    Vector(
      initialRow,
      altRow,
      initialRow,
      altRow,
      initialRow
    )
    
  case class Move(fromCol:Int, fromRow: Int, toCol: Int, toRow: Int)
  
  def convertLocation(loc: String): (Int, Int) = {
    val col = 
      if(loc.contains('a')) 0
      else if (loc.contains('b')) 1
      else if (loc.contains('c')) 2
      else 3
    val row = 
      if(loc.contains('1')) 
  }
  def makeMove(board: Board, move: Move, player: Color) = 
  
  case class Game(board: Board, move: Color) {
    
  }
  
}