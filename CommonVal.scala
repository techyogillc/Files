object CommonVal {

  def myFunction(input : String) : String = {
    input + " (" + input.length + ")"
  }

  def myFunction2(input : String) : String = {
    input.filter(c => !List('a', 'e', 'i', 'o', 'u').contains(c.toLower)) +
      " (" + input.filter(c => !List('a', 'e', 'i', 'o', 'u').contains(c.toLower)).length + ")"
  }

  def myFunction3(input : String) : String = {
    val consonantOnly = input.filter(c => !List('a', 'e', 'i', 'o', 'u').contains(c.toLower))
    consonantOnly + " (" + consonantOnly.length + ")"
  }

  val vowels = List('a', 'e', 'i', 'o', 'u')

  def myFunction4(input : String) : String = {
    val consonantOnly = input.filter(c => !vowels.contains(c.toLower))
    consonantOnly + " (" + consonantOnly.length + ")"
  }

  def main(args : Array[String]) : Unit = {
    println(myFunction("Testing function"))
    println(myFunction2("Testing function"))
    println(myFunction3("Testing function"))
    println(myFunction4("Testing function"))
  }

}