import scala.concurrent.Future

import scala.concurrent.ExecutionContext.Implicits.global

object FuturesAreNotTheAnswer {

  def mySimpleFuture() : Unit = {
    val str = "HeLLO World"
    val future = Future {
      str.toLowerCase
    }
    future.foreach(println)
  }

  def myComplicatedFuture() : Unit = {
    val str = "HeLLO World"
    val future = Future {
      Thread.sleep(1000)
      str.toLowerCase
    }
    future.foreach(println)
    println("foo")
  }

  def main(args : Array[String]) : Unit = {
    mySimpleFuture()
    Thread.sleep(100)
    myComplicatedFuture()
    Thread.sleep(1100)
  }

}