object UsingCaseClasses {

  case class User(name : String, email : String)

  def myFunction(user : User) : String = user match {
    case User(name, email) => s"$name <$email>"
    case _ => "Undefined"
  }

  class User2(val name : String, val email : String)

  def myFunction2(user : User2) : String = {
    s"${user.name} <${user.email}>"
  }

  def main(args : Array[String]) : Unit = {
    println(myFunction(User("Foo", "foo@bar.com")))
    println(myFunction2(new User2("Foo", "foo@bar.com")))
  }

}
