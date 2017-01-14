object CostOfLazyVals {

  def myFunction() = {
    lazy val variable = {
      Thread.sleep(1000)
      "foo"
    }
    println(System.currentTimeMillis())
    println(variable)
    println(System.currentTimeMillis())
    println(variable)
    println(System.currentTimeMillis())
  }

  val threadName = {
    val tn = new ThreadLocal[String]()
    tn.set(Thread.currentThread().getName)
    tn
  }

  def myFunction2() = {
    lazy val variable = {
      Thread.sleep(1000)
      "foo"
    }
    println(s"${threadName.get()}: ${System.currentTimeMillis()}")
    new Thread() {
      override def run() : Unit = {
        println(s"${threadName.get()}: ${System.currentTimeMillis()}")
        println(s"${threadName.get()}: $variable")
        println(s"${threadName.get()}: ${System.currentTimeMillis()}")
      }
    }.start()
    println(s"${threadName.get()}: $variable")
    println(s"${threadName.get()}: ${System.currentTimeMillis()}")
  }

  def main(args : Array[String]) : Unit = {
    myFunction()
    separator()
    myFunction2()
  }

  def separator(): Unit = {
    for(i <- 0 until 10) print("-")
    println()
  }

}
