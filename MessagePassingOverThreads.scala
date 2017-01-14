import java.util.concurrent.{LinkedBlockingQueue, TimeUnit, ThreadPoolExecutor}

import akka.actor.{Props, ActorSystem, Actor}

object MessagePassingOverThreads {

  val message1 = "HeLLo WORld"

  val message2 = "hEllo worLD"

  class Test(obj : String) extends Thread {
    override def run() : Unit = {
      Thread.sleep(1000)
      println(s"${Thread.currentThread().getName} ${obj.toLowerCase}")
    }
  }

  def threadInvocations() : Unit = {
    val t1 = new Test(message1)
    t1.start()

    val t2 = new Test(message2)
    t2.start()
  }

  def threadPooling() : Unit = {
    val tp = new ThreadPoolExecutor(1, 5, 500, TimeUnit.MILLISECONDS, new LinkedBlockingQueue[Runnable]())
    tp.submit(new Runnable {
      override def run(): Unit = {
        Thread.sleep(1000)
        println(s"${Thread.currentThread().getName} ${message1.toLowerCase}")
      }
    })
    println(s"${Thread.currentThread().getName} Sent message to ThreadPool")
    tp.submit(new Runnable {
      override def run(): Unit = {
        Thread.sleep(1000)
        println(s"${Thread.currentThread().getName} ${message2.toLowerCase}")
      }
    })

  }

  class Test2 extends Actor {
    def receive = {
      case str : String => {
        Thread.sleep(1000)
        println(s"${Thread.currentThread().getName} ${str.toLowerCase}")
      }
    }
  }

  def actors() = {
    val system = ActorSystem("Actors")
    val t2 = system.actorOf(Props[Test2])
    t2 ! message1
    println(s"${Thread.currentThread().getName} Sent message to actor")
    t2 ! message2
  }

  def main(args : Array[String]) : Unit = {
    //threadInvocations()
    //threadPooling()
    actors()
  }

}
