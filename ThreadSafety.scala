object ThreadSafety {

  var domain : String = ""

  def setDomain(input : String) : Unit = {
    domain = input.toLowerCase
    domain = domain.split("@")(1)
  }

  def getDomain : String = domain

  def setDomain2(input : String) = synchronized {
    domain = input.toLowerCase
    domain = domain.split("@")(1)
  }

  def getDomain2 : String = synchronized { domain }

  def setDomain3(input : String) = {
    val lowerCased = input.toLowerCase
    domain = lowerCased.split("@")(1)
  }

  def getDomain3 : String = domain

  def main(args : Array[String]) : Unit = {
    setDomain("foo@Bar.com")
    println(getDomain)
    setDomain2("foo@Bar.com")
    println(getDomain2)
    setDomain3("foo@Bar.com")
    println(getDomain3)
  }

}
