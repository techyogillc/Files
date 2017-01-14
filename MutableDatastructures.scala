import scala.collection.mutable

object MutableDatastructures {

  val mutableMap = new mutable.LinkedHashMap[Int,String]()

  def myMutableMap() : Unit = {
    mutableMap.put(1, "Foo")
    mutableMap.put(2, "Bar")
    mutableMap.put(3, "Baz")
  }

  def myMutableMap2() : Unit = {
    mutableMap.remove(2)
  }

  val mutableList = new mutable.ListBuffer[String]()

  def myMutableArray() : Unit = {
    mutableList.append("Foo")
    mutableList.append("Bar")
    mutableList.append("Baz")
  }

  def myMutableArray2() : Unit = {
    mutableList.remove(mutableList.indexOf("Bar"))
  }

  def main(args : Array[String]) : Unit = {
    println(mutableMap)
    myMutableMap()
    println(mutableMap)
    myMutableMap2()
    println(mutableMap)
    println(mutableList)
    myMutableArray()
    println(mutableList)
    myMutableArray2()
    println(mutableList)
  }

}
