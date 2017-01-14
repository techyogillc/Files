object VarInLoopContext {

  def myFunction(input : List[Int]) : Int = {
    var total = 0
    for(i <- input) {
      if(i%2 == 0) {
        total = total + i
      }
    }
    total
  }

  def myFunction2(input : List[Int]) : Int = {
    input.filter(i => i%2 == 0).sum
  }

  case class Foo(i : Int)

  def myFunction3(input : List[Foo]) : Int = {
    var total = 0
    for(i <- input) {
      if(i.i%2 == 0) {
        total = total + i.i
      }
    }
    total
  }

  def myFunction4(input : List[Foo]) : Int = {
    input.map(i => i.i).filter(i => i%2 == 0).sum
  }

  def main(args : Array[String]) : Unit = {
    val list = List(1,2,3,4,5,6,7,8,9,10)
    println(myFunction(list))
    println(myFunction2(list))
    val listOfFoo = list.map(Foo)
    println(myFunction3(listOfFoo))
    println(myFunction4(listOfFoo))
  }

}
