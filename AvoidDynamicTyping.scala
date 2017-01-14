import scala.language.dynamics

object AvoidDynamicTyping {

  case class URLCall(url : String, arguments : List[String])

  class Resourcer(val methodMapping : Map[Symbol, URLCall]) extends Dynamic {
    def applyDynamicNamed(name : String)(args : (String, Any)*) = methodMapping.get(Symbol(name)) match {
      case Some(URLCall(url, arguments)) => {
        if(!arguments.equals(args.map(_._1))) {
          throw new IllegalArgumentException(s"Invalid arguments, expected $arguments")
        }
        println(
          args.foldLeft(url)((acc, next) => acc.replaceAll(s":${next._1}", next._2.toString))
        )
      }
      case _ => throw new UnsupportedOperationException(s"Invalid method $name")
    }
  }

  def myFunction() : Unit = {
    val r = new Resourcer(Map(
      'queryGoogle -> URLCall("http://www.google.com/?q=:query", List("query")),
      'getUserById -> URLCall("http://www.foo.bar/user/:id", List("id"))
    ))
    r.queryGoogle(query = "foo")
    r.getUserById(id = 1234)
  }

  def myFunction2() : Unit = {
    val r = new Resourcer(Map(
      'getUserById -> URLCall("http://www.foo.bar/user/:id", List("id"))
    ))
    try {
      r.queryGoogle(query = "foo")
    } catch {
      case ex : UnsupportedOperationException => ex.printStackTrace()
    }
    try {
      r.getUserById(ID = 1234)
    } catch {
      case ex : IllegalArgumentException => ex.printStackTrace()
    }
  }

  def main(args : Array[String]) : Unit = {
    //myFunction()
    myFunction2()
  }

}
