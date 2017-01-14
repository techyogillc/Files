object CommonVar {

  val vowels = List('a, 'e', 'i', 'o', 'u')

  def myFunction(input : String) : Int = {
    var counter = 0
    for(c <- input) {
      if(vowels.contains(c.toLower)) {
        counter = counter + 1
      }
    }
    counter
  }

  var counter : Int = 0

  def myFunction2(input : String) : Int = {
    val count = input.count(c => vowels.contains(c.toLower))
    counter = counter + count
    count
  }

  class MyUserModel(var id : Long, var username : String)

  def main(args : Array[String]) : Unit = {
    println(myFunction("Test Function"))
    println(myFunction2("Test Function"))
    println(counter)
    println(myFunction2("Another Test Function"))
    println(counter)
  }

}
