object FlowOfControl {

  case class Email(name : String, domain : String)

  def myFunction(input : String) : Email = {
    if(!input.contains("@")) {
      throw new IllegalArgumentException("Does not appear to be an e-mail")
    }
    val splitInput = input.toLowerCase.split("@")
    Email(splitInput(0), splitInput(1))
  }

  case class ValidationError(message : String)

  def isEmail_?(input : String) : Option[ValidationError] = {
    if(input.contains("@")) {
      None
    } else {
      Some(ValidationError("E-Mail requires a name@domain"))
    }
  }

  val validators : List[String => Option[ValidationError]] = List(isEmail_?)

  def myFunction2(input : String) : Either[List[ValidationError], Email] = {
    //validators.map(_(input)).filter(_.isDefined).map(_.get) match {
    validators.flatMap(_(input)) match {
      case List() => {
        val splitInput = input.toLowerCase.split("@")
        Right(Email(splitInput(0), splitInput(1)))
      }
      case list => Left(list)
    }
  }

  def myFunction3(input : Option[String]) : Either[ValidationError, Email] = {
    input.map(str => {
      val splitInput = str.toLowerCase.split("@")
      Email(splitInput(0), splitInput(1))
    }).toRight(new ValidationError("input was missing"))
  }

  def main(args : Array[String]) : Unit = {
    try {
      myFunction("foo")
    } catch {
      case e : Throwable => e.printStackTrace()
    }
    println(myFunction2("foo"))
    println(myFunction2("foo@bar.com"))
    println(myFunction3(None))
    println(myFunction3(Some("foo@bar.com")))
  }

}
