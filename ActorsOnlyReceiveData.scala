import akka.actor.{Props, ActorSystem, Actor}
import akka.util.Timeout
import akka.pattern.ask
import scala.concurrent.duration._

object ActorsOnlyReceiveData {

  case class Message(str : String, cb : (String => Unit)) {}

  class Test1 extends Actor {
    def receive = {
      case Message(str, cb) => {
        println(s"${Thread.currentThread().getName} Start")
        Thread.sleep(1000)
        println(s"${Thread.currentThread().getName} Calling cb")
        cb(str.toLowerCase)
        println(s"${Thread.currentThread().getName} Done")
      }
    }
  }

  def sendingMethod() : Unit = {
    val system = ActorSystem("Test-System")
    val t1 = system.actorOf(Props[Test1])
    println(s"${Thread.currentThread().getName} Sending message")
    t1 ! Message("HellO WorlD", str => {
      Thread.sleep(1000)
      println(s"${Thread.currentThread().getName} $str")
    })
  }

  class Test2() extends Actor {
    def receive = {
      case str : String => {
        println(s"${Thread.currentThread().getName} Start")
        Thread.sleep(1000)
        println(s"${Thread.currentThread().getName} Done")
        sender() ! str.toLowerCase
      }
    }
  }

  def asking() : Unit = {
    val system = ActorSystem("Test-System")
    val t2 = system.actorOf(Props[Test2])
    import system.dispatcher
    implicit val timeout = Timeout(2.second)
    (t2 ? "HellO WorlD").foreach(msg => {
      println(s"${Thread.currentThread().getName} $msg")
    })
  }

  def main(args : Array[String]) : Unit = {
    //sendingMethod()
    asking()
  }

}
