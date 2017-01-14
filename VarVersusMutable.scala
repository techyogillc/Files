import scala.collection.mutable

object VarVersusMutable {

  val mutableList = mutable.ListBuffer[String]()

  var immutableList = List[String]()

  def appendFunction1(input : String) : Unit = {
    mutableList += input
  }

  def appendFunction2(input : String) : Unit = {
    immutableList = immutableList :+ input
  }

  def removeFunction1(input : String) : Unit = {
    mutableList -= input
  }

  def removeFunction2(input : String) : Unit = {
    immutableList = immutableList.filterNot(_ == input)
  }

  def createString(f : String => Unit) : Unit = {
    f("This")
    f("is")
    f("Scala")
    f("with")
    f("mutability")
  }

  def main(args : Array[String]) : Unit = {
    createString(appendFunction1)
    println(mutableList)
    createString(appendFunction2)
    println(immutableList)
    removeFunction1("mutability")
    println(mutableList)
    removeFunction2("mutability")
    println(immutableList)
  }

}