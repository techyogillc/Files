object SelfDocumentingCode {

  def myFunction1(inputList : List[String]) : List[String] = {
    def stringsWithSize2(input : String) : Boolean = input.length == 2
    def capitalize(input : String) : String = input.toUpperCase
    inputList filter stringsWithSize2 map capitalize
  }

  def myFunction2(inputList : List[String]) : String = {
    def capitalize(input : String) : String = input.toUpperCase
    def toCSV(left : String, right : String) : String = s"$left,$right"
    inputList map capitalize reduce toCSV
  }

  def myFunction3(inputList : List[String]) : String = {
    inputList map { _.toUpperCase } reduce { _ + "," + _ }
  }

  def main(args : Array[String]) : Unit = {
    val list = List("foobar", "sha", "ba")
    println(myFunction1(list))
    println(myFunction2(list))
    println(myFunction3(list))
  }

}
