package problems

import java.io._

object Codon extends App {
  def unformatted(code: String): String = {
    val start = code.indexOf("ATG")
    if (start == -1) "No start codon"
    else cMatch(code.substring(start))
  }
  def cMatch(code: String, inBuild: String = ""): String = {
    if (code.length() < 3) inBuild
    else {
      val (first, rest) = (code.substring(0, 3), code.substring(3))
      first match {
        case "ATT" | "ATC" | "ATA" => cMatch(rest, inBuild + "I")
        case "CTT" | "CTC" | "CTA" | "CTG" | "TTA" | "TTG" => cMatch(rest, inBuild + "L")
        case "GTT" | "GTC" | "GTA" | "GTG" => cMatch(rest, inBuild + "V")
        case "TTT" | "TTC" => cMatch(rest, inBuild + "F")
        case "ATG" => cMatch(rest, inBuild + "M")
        case "TGT" | "TGC" => cMatch(rest, inBuild + "C")
        case s if s.startsWith("GC") => cMatch(rest, inBuild + "A")
        case s if s.startsWith("GG") => cMatch(rest, inBuild + "G")
        case s if s.startsWith("CC") => cMatch(rest, inBuild + "P")
        case s if s.startsWith("AC") => cMatch(rest, inBuild + "T")
        case "AGT" | "AGC" => cMatch(rest, inBuild + "S")
        case s if s.startsWith("TC") => cMatch(rest, inBuild + "S")
        case "TAT" | "TAC" => cMatch(rest, inBuild + "Y")
        case "TGG" => cMatch(rest, inBuild + "W")
        case "CAA" | "CAG" => cMatch(rest, inBuild + "Q")
        case "AAT" | "AAC" => cMatch(rest, inBuild + "N")
        case "CAT" | "CAC" => cMatch(rest, inBuild + "H")
        case "GAA" | "GAG" => cMatch(rest, inBuild + "E")
        case "GAT" | "GAC" => cMatch(rest, inBuild + "D")
        case "AAA" | "AAG" => cMatch(rest, inBuild + "K")
        case "AGA" | "AGG" => cMatch(rest, inBuild + "R")
        case s if s.startsWith("CG") => cMatch(rest, inBuild + "R")
        case "TAA" | "TAG" | "TGA" => inBuild
        case _ => inBuild
      }
    }
  }
  val reader = new BufferedReader(new FileReader("codon.in"))
  var currLine = reader.readLine()
  var count = 1
  while (currLine != "STOP") {
    println(s"#$count: ${unformatted(currLine)}")
    currLine = reader.readLine()
    count = count + 1
  }
}