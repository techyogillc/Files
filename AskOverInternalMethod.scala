import java.util.concurrent.{LinkedBlockingQueue, TimeUnit, ThreadPoolExecutor}

import akka.actor.{Props, ActorSystem, Actor}
import akka.util.Timeout
import akka.pattern.ask
import scala.concurrent.duration._

object AskOverInternalMethod {

  def internalMethod() : Unit = {
    val message = "HellO WorlD"
    val tpe = new ThreadPoolExecutor(1, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue[Runnable]())
    val runnable = new Runnable {
      var result : String = ""
      override def run(): Unit = {
        Thread.sleep(1000)
        result = message.toLowerCase
      }
    }
    val r = tpe.submit(runnable)
    r.get(2, TimeUnit.SECONDS)
    println(s"[${runnable.result}]")
  }

  class Test1 extends Actor {
    def receive = {
      case in : String => {
        Thread.sleep(1000)
        sender() ! in.toLowerCase
      }
    }
  }

  def askMethod() : Unit = {
    val system = ActorSystem("Test-System")
    val t1 = system.actorOf(Props[Test1])
    import system.dispatcher
    implicit val timeout = Timeout(2.second)

    (t1 ? "HellO WorlD").foreach(println)
  }

  def main(args : Array[String]) : Unit = {
    //internalMethod()
    askMethod()
  }

}
