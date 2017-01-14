object StoringFunctions {

  val strings = List(
    "where",
    "the",
    "wild",
    "things",
    "are"
  )

  def filter(input : List[String]) : List[String] = {
    input.filterNot(_.contains("a")).filterNot(_.contains("b")).filterNot(_.length % 2 == 0)
  }

  val filters : List[String => Boolean] = List(
    _.contains("a"),
    _.contains("b"),
    _.length % 2 == 0
  )

  def filter2(input : List[String]) : List[String] = {
    filters.foldLeft(input)((i,f) => i.filterNot(f))
  }

  def stringContainsA(input : String) : Boolean = input.contains("a")

  def stringContainsB(input : String) : Boolean = input.contains("b")

  def stringLengthIsEven(input : String) : Boolean = input.length % 2 == 0

  val filters2 : List[String => Boolean] = List(
    stringContainsA,
    stringContainsB,
    stringLengthIsEven
  )

  def filter3(input : List[String]) : List[String] = {
    filters2.foldLeft(input)((i, f) => i.filterNot(f))
  }

  def main(arg : Array[String]) : Unit = {
    println(filter(strings))
    println(filter2(strings))
    println(filter3(strings))
  }

}
