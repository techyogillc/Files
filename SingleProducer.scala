import java.util.concurrent.atomic.AtomicInteger

import akka.actor.{Props, Actor, ActorSystem}

object SingleProducer {

  val actorSystem = ActorSystem("Test-System")

  class StringPersister extends Actor {
    def receive = {
      case str : String => println(str)
    }
  }

  val persister = actorSystem.actorOf(Props[StringPersister])

  val list = List("foo", "bar", "sha", "baz")

  /*class StringToUpperProducer extends Actor {
    def receive = {
      case 'GO => list.foreach(persister ! _.toUpperCase)
    }
  }*/
  object StringToUpperProducer {
    var index : AtomicInteger = new AtomicInteger(0)
  }
  class StringToUpperProducer extends Actor {
    def receive = {
      case 'GO => {
        var index = StringToUpperProducer.index.getAndIncrement()
        while(index < list.length) {
          persister ! list(index).toUpperCase
          index = StringToUpperProducer.index.getAndIncrement()
        }
      }
    }
  }

  def multipleProducers() : Unit = {
    val toUpperProducer1 = actorSystem.actorOf(Props[StringToUpperProducer])
    val toUpperProducer2 = actorSystem.actorOf(Props[StringToUpperProducer])
    toUpperProducer1 ! 'GO
    toUpperProducer2 ! 'GO
  }

  def singleProducer() : Unit = {
    list.foreach(persister ! _.toUpperCase)
  }

  def main(args : Array[String]) : Unit = {
    //multipleProducers()
    singleProducer()
  }

}
