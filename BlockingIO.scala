import akka.actor.{ActorRef, Props, ActorSystem, Actor}
import akka.util.Timeout
import akka.pattern.ask

import scala.concurrent.duration._

object BlockingIO {

  class Test1 extends Actor {
    def receive = {
      case str : String => {
        Thread.sleep(1000)
        sender() ! str.toLowerCase
      }
    }
  }

  def blockingOnMainThreadPool() : Unit = {
    val system = ActorSystem("Test-Actors")
    val actor1 = system.actorOf(Props[Test1])
    implicit val timeout = Timeout(5.second)
    import system.dispatcher

    (actor1 ? "FOo").foreach(println)
    (actor1 ? "BaR").foreach(println)
  }

  class Upstream(downstream : ActorRef) extends Actor {
    def receive = {
      case str : String => {
        Thread.sleep(1000)
        downstream ! str.toLowerCase
      }
    }
  }

  class Downstream extends Actor {
    def receive = {
      case str : String => println(str)
    }
  }

  def blockingOnMainThreadPool2() : Unit = {
    val system = ActorSystem("Test-Actors")
    val ds = system.actorOf(Props[Downstream])
    val us = system.actorOf(Props(classOf[Upstream], ds))
    us ! "FoO"
    us ! "BaR"
  }

  class Upstream2(processor : ActorRef, downstream : ActorRef) extends Actor {
    def receive = {
      case str : String => {
        println("Got Message")
        import this.context.dispatcher
        implicit val timeout = Timeout(5.second)
        (processor ? str).foreach(downstream ! _)
      }
    }
  }

  class Processor extends Actor {
    def receive = {
      case str : String => {
        Thread.sleep(1000)
        sender() ! str.toLowerCase
      }
    }
  }

  def blockingOnSeparateThreadPool() : Unit = {
    val system1 = ActorSystem("Test1")
    val system2 = ActorSystem("Test2")
    val proc = system2.actorOf(Props[Processor])
    val ds = system1.actorOf(Props[Downstream])
    val us = system1.actorOf(Props(classOf[Upstream2], proc, ds))
    us ! "FoO"
    us ! "BaR"
  }

  def main(args : Array[String]) : Unit = {
    //blockingOnMainThreadPool()
    //blockingOnMainThreadPool2()
    blockingOnSeparateThreadPool()
  }

}